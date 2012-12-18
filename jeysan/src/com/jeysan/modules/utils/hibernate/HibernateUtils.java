package com.jeysan.modules.utils.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.util.Assert;

import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.hibernate.IdEntity;
import com.jeysan.modules.utils.reflection.ReflectionUtils;

/**
 * 用于项目的Hibernate工具类.
 * 
 * @author shally
 */
public class HibernateUtils {

	/**
	 * 根据对象ID集合, 整理合并集合.
	 * 
	 * 页面发送变更后的子对象id列表时,在Hibernate中删除整个原来的子对象集合再根据页面id列表创建一个全新的集合这种看似最简单的做法是不行的.
	 * 因此采用如此的整合算法：在源集合中删除id不在目标集合中的对象,根据目标集合中的id创建对象并添加到源集合中.
	 * 因为新建对象只有ID被赋值, 因此本函数不适合于cascade-save-or-update自动持久化子对象的设置.
	 * 
	 * @param srcObjects 源集合,元素为对象.
	 * @param checkedIds  目标集合,元素为ID.
	 * @param clazz  集合中对象的类型,必须为IdEntity子类
	 */
	public static <T extends IdEntity> void mergeByCheckedIds(final Collection<T> srcObjects,
			final Collection<Integer> checkedIds, final Class<T> clazz) {

		//参数校验
		Assert.notNull(srcObjects, "scrObjects不能为空");
		Assert.notNull(clazz, "clazz不能为空");

		//目标集合为空, 删除源集合中所有对象后直接返回.
		if (checkedIds == null) {
			srcObjects.clear();
			return;
		}

		//遍历源对象集合,如果其id不在目标ID集合中的对象删除.
		//同时,在目标集合中删除已在源集合中的id,使得目标集合中剩下的id均为源集合中没有的id.
		Iterator<T> srcIterator = srcObjects.iterator();
		try {

			while (srcIterator.hasNext()) {
				T element = srcIterator.next();
				Integer id = element.getId();

				if (!checkedIds.contains(id)) {
					srcIterator.remove();
				} else {
					checkedIds.remove(id);
				}
			}

			//ID集合目前剩余的id均不在源集合中,创建对象,为id属性赋值并添加到源集合中.
			for (Integer id : checkedIds) {
				T element = clazz.newInstance();
				element.setId(id);
				srcObjects.add(element);
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
	}
	/**
	 * 当Criteria含有子查询是，自动进行外连接:针对查询条件
	 * @param criteria
	 * @param criterions
	 * @return
	 */
	public static Criteria checkCriteria4SubQuery(Criteria criteria,Criterion[] criterions){
		List<String> existsAlias = new ArrayList<String>();
		String allString = null;
		String subAlias = null;
		String[] propertyNames = null;
		for (Criterion c : criterions) {
			allString = c.toString();
			propertyNames = StringUtils.split(allString,'.');
			if(propertyNames.length > 1){//包含SubCriteria
				if(propertyNames.length == 2){//包含1个SubCriteria
					subAlias = propertyNames[0];
					if(existsAlias.contains(subAlias)){
						criteria.add(c);
					}else{
						criteria.createAlias(subAlias, subAlias).add(c);
						existsAlias.add(subAlias);
					}
				}else if(propertyNames.length == 3){//包含2个SubCriteria
					subAlias = propertyNames[0].concat(".").concat(propertyNames[1]);
					if(existsAlias.contains(subAlias)){
						criteria.add(c);
					}else{
						criteria.createAlias(subAlias, propertyNames[1]).add(c);
						existsAlias.add(subAlias);
					}
				}
			}else{
				criteria.add(c);
			}
		}
		return criteria;
	}
	/**
	 * 当Criteria含有子查询是，自动进行外连接:针对查询排序
	 * @param criteria
	 * @param criterions
	 * @return
	 */
	public static Criteria checkCriteria4SubOrder(Criteria criteria,String[] orderArray,String[] orderByArray){
		List<String> existsAlias = new ArrayList<String>();
		
		String regex = "\\[Subcriteria\\(.*?\\)\\]";
		Pattern pattern=Pattern.compile(regex); 
		Matcher m = pattern.matcher(criteria.toString());
		String target = null;
		while(m.find()){
			target = m.group();
		}
		if(StringUtils.isNotEmpty(target) && target.indexOf("(")!=-1 && target.indexOf(")")!=-1){
			String subcriteria = target.substring(target.indexOf("(")+1,target.indexOf(")"));
			if(StringUtils.isNotEmpty(subcriteria)){
				String[] subAlias = StringUtils.split(subcriteria,',');
				for(String alias : subAlias){
					existsAlias.add(StringUtils.split(alias,':')[0]);
				}
			}
		}
		
		
		
		String orderBy = null;
		String subAlias = null;
		String[] orderBys = null;
		for (int i = 0; i < orderByArray.length; i++) {
			orderBy = orderByArray[i];
			orderBys = StringUtils.split(orderBy,'.');
			if(orderBys.length > 1){//包含SubCriteria
				if(orderBys.length == 2){//包含1个SubCriteria
					subAlias = orderBys[0];
					if(!existsAlias.contains(subAlias)){
						criteria.createAlias(subAlias, subAlias);
						existsAlias.add(subAlias);
					}
				}else if(orderBys.length == 3){//包含2个SubCriteria
					subAlias = orderBys[0].concat(".").concat(orderBys[1]);
					if(!existsAlias.contains(subAlias)){
						criteria.createAlias(subAlias, orderBys[1]);
					}
				}
			}
			if (Page.ASC.equals(orderArray[i])) {
				criteria.addOrder(Order.asc(orderByArray[i]));
			} else {
				criteria.addOrder(Order.desc(orderByArray[i]));
			}
		}
		return criteria;
	}
}

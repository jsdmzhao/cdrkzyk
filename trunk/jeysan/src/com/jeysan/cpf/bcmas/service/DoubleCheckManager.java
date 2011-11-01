package com.jeysan.cpf.bcmas.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheckDao;
import com.jeysan.cpf.bcmas.entity.DoubleCheck;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.district.service.DistrictVillageManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 * 
 */
@Component
@Transactional
public class DoubleCheckManager {
	private static Logger logger = LoggerFactory
			.getLogger(DoubleCheckManager.class);

	private DoubleCheckDao doubleCheckDao;
	private DistrictVillageManager districtVillageManager;
	/**
	 * 增加
	 * 
	 * @param entity
	 */
	public void saveDoubleCheck(DoubleCheck entity) {
		doubleCheckDao.save(entity);
	}

	/**
	 * 增加Collection
	 * 
	 * @param entites
	 */
	public void saveDoubleChecks(List<DoubleCheck> entites) {
		for (DoubleCheck entity : entites)
			doubleCheckDao.save(entity);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteDoubleCheck(Long id) {
		doubleCheckDao.delete(id);
	}

	/**
	 * 用于无关联实体的批量删除
	 * 
	 * @param ids
	 */
	public void deleteDoubleChecks(Long id) {
		doubleCheckDao.batchExecute("delete DoubleCheck where id = ? ", id);
	}

	/**
	 * 批量删除
	 * 
	 * @param id
	 */
	public void deleteDoubleChecks(String ids) {
		String[] ids_array = StringUtils.split(ids, ",");
		if (ids_array != null && ids_array.length > 0) {
			for (String id : ids_array) {
				deleteDoubleChecks(Long.parseLong(id));
			}
		}
	}

	/**
	 * 主键查找
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheck getDoubleCheck(Long id) {
		return doubleCheckDao.get(id);
	}

	@Transactional(readOnly = true)
	public List<DoubleCheck> getDoubleChecksByYear(Integer year) {
		return doubleCheckDao.find(
				"from DoubleCheck where year = ? order by seq ", year);
	}

	@Transactional(readOnly = true)
	public DoubleCheck getDoubleCheckByYear(Integer year, Integer seq) {
		List<DoubleCheck> dcs = doubleCheckDao.find(
				"from DoubleCheck where year = ? and seq = ? ", year, seq);
		if (dcs != null && dcs.size() > 0)
			return dcs.get(0);
		return null;
	}

	/**
	 * 分页查找
	 * 
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheck> searchDoubleCheck(final Page<DoubleCheck> page,
			final List<PropertyFilter> filter) {
		return doubleCheckDao.findPage(page, filter);
	}

	@Autowired
	public void setDoubleCheckDao(DoubleCheckDao doubleCheckDao) {
		this.doubleCheckDao = doubleCheckDao;
	}
	
	@Autowired
	public void setDistrictVillageManager(DistrictVillageManager districtVillageManager) {
		this.districtVillageManager = districtVillageManager;
	}
	@Transactional(readOnly = true)
	public Map searchDoubleCheck4Stat(String status,String year,String seq,String start,String end) {
		if(StringUtils.isEmpty(status))
			return null;
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder();
		sql
		.append(" select dcsv.AREA as area,ifnull(count(dcsv.AREA),0) as areaCount,dcsv.dcobjtype as dcObjType,ifnull(count(dcsv.dcobjtype),0) as dcObjTypeCount,0 as type ")
		.append(" from double_check_stat_view as dcsv,FHP_DOUBLE_CHECK_OBJECT as dco ")
		.append(" where dcsv.ID = dco.WOMAN_ID ");
		if(StringUtils.equals(status, "0")){
			sql.append(" and dco.year = ? and dco.seq = ? ");
			params.add(year);
			params.add(seq);
		}else if(StringUtils.equals(status, "1")){
			sql.append(" and dco.START >= ? and dco.END <= ? ");
			params.add(start);
			params.add(end);
		}
		sql
		.append(" group by dcsv.AREA,dcsv.dcobjtype ")
		.append(" UNION ")
		.append(" select dcsv.AREA,ifnull(count(dcsv.AREA),0) as area_count,dcsv.dcobjtype,ifnull(count(dcsv.dcobjtype),0) as dcobjtype_count,1 as type ")
		.append(" from double_check_stat_view as dcsv,FHP_DOUBLE_CHECK_OBJECT as dco ")
		.append(" where dcsv.ID = dco.WOMAN_ID ");
		if(StringUtils.equals(status, "0")){
			sql.append(" and dco.year = ? and dco.seq = ? ");
			params.add(year);
			params.add(seq);
		}else if(StringUtils.equals(status, "1")){
			sql.append(" and dco.START >= ? and dco.END <= ? ");
			params.add(start);
			params.add(end);
		}
		sql.append(" and dco.DC_STATUS = 760 ")
		.append(" group by dcsv.AREA,dcsv.dcobjtype");
		List<Map<String,Object>> result_orin = this.doubleCheckDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
		String area = null , key_tmp = null;
		Integer dcObjType = null ,dcObjTypeCount = null , type = null;
		for(Map<String,Object> ros : result_orin){
			area = (String)ros.get("area");
			dcObjType = ((BigInteger)ros.get("dcObjType")).intValue();
			dcObjTypeCount = ((BigInteger)ros.get("dcObjTypeCount")).intValue();
			type = ((BigInteger)ros.get("type")).intValue();
			if(!result.containsKey(area)){
				result.put(area, new HashMap<String,Integer>());
			}
			key_tmp = "s_"+dcObjType+"_"+type;
			if(result.get(area).containsKey(key_tmp))
				result.get(area).put(key_tmp, dcObjTypeCount+result.get(area).get(key_tmp));
			else
				result.get(area).put(key_tmp, dcObjTypeCount);
		}
		return result;
	}
	
	public List searchDoubleCheck4Stat4AutoPrint(String status,String year,String seq,String start,String end){
		Map<String,Map<String,Integer>> result = searchDoubleCheck4Stat(status, year, seq, start, end);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Integer> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map(tmp,dv.getName(),0,0,0,0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map(tmp,dv.getName(),0,0,0,0,0,0,0,0);
				}else{
					setValue2Map(tmp,dv.getName(),si.get("s_161_0"),si.get("s_162_0"),si.get("s_166_0"),si.get("s_165_0"),si.get("s_161_1"),si.get("s_162_1"),si.get("s_166_1"),si.get("s_165_1"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal(lst));
		return lst;
	}
	
	private Map getTotal(List<Map> lst){
		Map tmp = new HashMap();
		int s_161_0 = 0, s_162_0 = 0, s_166_0 = 0, s_165_0 = 0, s_161_1 = 0, s_162_1 = 0, s_166_1 = 0, s_165_1 = 0;
		for(Map m : lst){
			s_161_0 += (Integer)m.get("s_161_0");
			s_162_0 += (Integer)m.get("s_162_0");
			s_166_0 += (Integer)m.get("s_166_0");
			s_165_0 += (Integer)m.get("s_165_0");
			s_161_1 += (Integer)m.get("s_161_1");
			s_162_1 += (Integer)m.get("s_162_1");
			s_166_1 += (Integer)m.get("s_166_1");
			s_165_1 += (Integer)m.get("s_165_1");
		}
		setValue2Map(tmp, "合计", s_161_0, s_162_0, s_166_0, s_165_0, s_161_1, s_162_1, s_166_1, s_165_1);
		return tmp;
	}
	
	private void setValue2Map(Map tmp,String area,Integer s_161_0,Integer s_162_0,Integer s_166_0,Integer s_165_0,Integer s_161_1,Integer s_162_1,Integer s_166_1,Integer s_165_1){
		if(s_161_0 == null ) s_161_0 = 0;
		if(s_162_0 == null ) s_162_0 = 0;
		if(s_166_0 == null ) s_166_0 = 0;
		if(s_165_0 == null ) s_165_0 = 0;
		if(s_161_1 == null ) s_161_1 = 0;
		if(s_162_1 == null ) s_162_1 = 0;
		if(s_166_1 == null ) s_166_1 = 0;
		if(s_165_1 == null ) s_165_1 = 0;
		
		tmp.put("area", area);
		
		int s_0 = s_161_0+s_162_0+s_166_0+s_165_0;
		tmp.put("s_161_0", s_161_0);
		tmp.put("s_162_0", s_162_0);
		tmp.put("s_166_0", s_166_0);
		tmp.put("s_165_0", s_165_0);
		tmp.put("s_0", s_0);
		
		int s_1  = s_161_1+s_162_1+s_166_1+s_165_1;
		tmp.put("s_161_1", s_161_1);
		tmp.put("s_162_1", s_162_1);
		tmp.put("s_166_1", s_166_1);
		tmp.put("s_165_1", s_165_1);
		tmp.put("s_1", s_1);
		

		tmp.put("s_161_2", s_161_0-s_161_1);
		tmp.put("s_162_2", s_162_0-s_162_1);
		tmp.put("s_166_2", s_166_0-s_166_1);
		tmp.put("s_165_2", s_165_0-s_165_1);
		tmp.put("s_2", s_0 - s_1);
		
		tmp.put("s_scale", s_0 == 0 ? 0d : (new Double(s_1)/new Double(s_0)));
	}

}
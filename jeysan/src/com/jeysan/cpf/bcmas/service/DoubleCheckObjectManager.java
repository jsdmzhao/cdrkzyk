package com.jeysan.cpf.bcmas.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.tool.hbm2x.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.DoubleCheckObjectDao;
import com.jeysan.cpf.bcmas.dao.FertileWomanExtendsDao;
import com.jeysan.cpf.bcmas.entity.DoubleCheckObject;
import com.jeysan.cpf.bcmas.vo.FertileWomanExtends;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.PropertyFilter;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class DoubleCheckObjectManager {
	private static Logger logger = LoggerFactory.getLogger(DoubleCheckObjectManager.class);
	
	private DoubleCheckObjectDao doubleCheckObjectDao;
	private FertileWomanExtendsDao fertileWomanExtendsDao;
	/**
	 * 增加
	 * @param entity
	 */
	public void saveDoubleCheckObject(DoubleCheckObject entity){
		doubleCheckObjectDao.save(entity);
	}
	/**
	 * 增加Collection
	 * @param entites
	 */
	public void saveDoubleCheckObjects(List<DoubleCheckObject> entites){
		for(DoubleCheckObject entity : entites)
			doubleCheckObjectDao.save(entity);
	}
	/**
	 * 删除
	 * @param id
	 */
	public void deleteDoubleCheckObject(Long id){
		doubleCheckObjectDao.delete(id);
	}
	/**
	 * 用于无关联实体的批量删除
	 * @param ids
	 */
	public void deleteDoubleCheckObjects(Long id){
		doubleCheckObjectDao.batchExecute("delete DoubleCheckObject where id = ? ", id);
	}
	/**
	 * 批量删除
	 * @param id
	 */
	public void deleteDoubleCheckObjects(String ids){
		String[] ids_array = StringUtils.split(ids,",");
		if(ids_array!=null&&ids_array.length>0){
			for(String id : ids_array){
				deleteDoubleCheckObjects(Long.parseLong(id));
			}
		}
	}
	/**
	 * 主键查找
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public DoubleCheckObject getDoubleCheckObject(Long id){
		return doubleCheckObjectDao.get(id);
	}
	@Transactional(readOnly = true)
	public List<DoubleCheckObject> findDoubleCheckObjects(Long fertileWomanId){
		return doubleCheckObjectDao.find("from DoubleCheckObject as dco where dco.fertileWoman.id = ? and dco.dcStatus = ? order by dco.dcDate ", fertileWomanId , Constants.DC_STATUS.CHECKED );
	}
	/**
	 * 分页查找
	 * @param page
	 * @param filter
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<DoubleCheckObject> searchDoubleCheckObject(final Page<DoubleCheckObject> page,final List<PropertyFilter> filter){
		return doubleCheckObjectDao.findPage(page, filter);
	}
	
	@Transactional(readOnly = true)
	public Page<FertileWomanExtends> searchFertileWomanExtends(final Page<FertileWomanExtends> page,Integer year,Integer seq,Long dcObjType,String area){
		String columns = " fw.ID as id,fw.PERSON_ID as personId,fw.NAMEH as nameh,fw.CREATE_DATE as createDate,fw.TYPEH as typeh,fw.CODE as code,fw.AREA as area,fw.REGISTER_TYPE as registerType,fw.BIRTH2_TYPE as birth2Type,fw.ASS_STATUS as assStatus,fw.CARD_STATUS as cardStatus,pb.DOMICILE as domicile,pb.ADDRESS as address,pb.BIRTHDAY as birthday, pb.MARRY_STATUS as marryStatus ,p.CODE as code2 ,p.DOMICILE_TYPE as domicileType ";
		//String columns = " fw.* ";
		StringBuilder sql = new StringBuilder().append(" select * from ( ")
		.append(" select ").append(columns).append(",if(wc.METHOD=203,161,if(wc.METHOD=207,163,164)) as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN FHP_WOMAN_CONTRACEPT as wc on wc.person_id = p.id ")
		.append(" where wc.METHOD in (203,207,212) ")
		.append(" UNION ")
		.append(" select ").append(columns).append(",162 as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN FHP_WOMAN_CONTRACEPT as wc on wc.person_id = p.id ")
		.append(" where wc.METHOD in (204,205,206,209,211) ")
		.append(" UNION ")
		.append(" select ").append(columns).append(",165 as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN FHP_WOMAN_CONTRACEPT as wc on wc.person_id = p.id ")
		.append(" where wc.METHOD in (202,210) and DATE_ADD(wc.ops_date,INTERVAL '1' YEAR)<now() ")
		.append(" UNION ")
		.append(" select ").append(columns).append(",null as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN FHP_WOMAN_CONTRACEPT as wc on wc.person_id = p.id ")
		.append(" where wc.METHOD is null ")
		.append(" UNION ")
		.append(" select ").append(columns).append(",166 as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN FHP_WOMAN_CONTRACEPT as wc on wc.person_id = p.id ")
		.append(" where wc.NO_METHOD_TYPE is not null ")
		.append(" UNION ")
		.append(" select ").append(columns).append(",167 as dcObjType ")
		.append(" from fhp_fertile_woman as fw ")
		.append(" LEFT JOIN fhp_person as p on p.ID = fw.PERSON_ID ")
		.append(" LEFT JOIN FHP_PERSON_BASIC as pb on pb.PERSON_ID = p.id ")
		.append(" LEFT JOIN fhp_birth2_apply as ba on ba.WOMAN_ID = fw.id ")
		.append(" LEFT JOIN FHP_BIRTH2_CHECK as bc on bc.apply_id = ba.id ")
		.append(" where bc.IS_AGREE = 12 and ba.MATENAL_STATUS = 735 ")
		.append(" ) as funion  ")
		.append(" where not EXISTS (select 1 from FHP_DOUBLE_CHECK_OBJECT as dco where dco.year = ? and dco.seq = ? and dco.woman_id = funion.id) ");
		List lst = new ArrayList();
		lst.add(year);
		lst.add(seq);
		if(dcObjType != null){
			sql.append(" and funion.dcObjType = ? ");
			lst.add(dcObjType);
		}
		if(StringUtils.isNotEmpty(area)){
			sql.append(" and funion.area = ? ");
			lst.add(area);
		}
		if(StringUtils.isNotEmpty(page.getOrderBy())){
			sql.append(" order by ").append(page.getOrderBy());
			if(StringUtils.isNotEmpty(page.getOrder()))
				sql.append(" ").append(page.getOrder());
		}
		return fertileWomanExtendsDao.findPageBySql(page, sql.toString(), lst.toArray());
	}
	
	@Autowired
	public void setDoubleCheckObjectDao(DoubleCheckObjectDao doubleCheckObjectDao) {
		this.doubleCheckObjectDao = doubleCheckObjectDao;
	}
	@Autowired
	public void setFertileWomanExtendsDao(FertileWomanExtendsDao fertileWomanExtendsDao) {
		this.fertileWomanExtendsDao = fertileWomanExtendsDao;
	}
	
}
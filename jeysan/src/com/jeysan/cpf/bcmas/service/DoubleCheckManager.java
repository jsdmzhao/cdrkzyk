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
	
	//第一个统计表****************************************
	
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
		tmp.put("s_161_0", s_161_0);//（应查）上环
		tmp.put("s_162_0", s_162_0);//（应查）使用药具
		tmp.put("s_166_0", s_166_0);//（应查）应落实未落实
		tmp.put("s_165_0", s_165_0);//（应查）结扎不到一年
		tmp.put("s_0", s_0);//（应查）合计
		
		int s_1  = s_161_1+s_162_1+s_166_1+s_165_1;
		tmp.put("s_161_1", s_161_1);//（已查）上环
		tmp.put("s_162_1", s_162_1);//（已查）使用药具
		tmp.put("s_166_1", s_166_1);//（已查）应落实未落实
		tmp.put("s_165_1", s_165_1);//（已查）结扎不到一年
		tmp.put("s_1", s_1);//（已查）合计
		

		tmp.put("s_161_2", s_161_0-s_161_1);//（未查）上环
		tmp.put("s_162_2", s_162_0-s_162_1);//（未查）使用药具
		tmp.put("s_166_2", s_166_0-s_166_1);//（未查）应落实未落实
		tmp.put("s_165_2", s_165_0-s_165_1);//（未查）结扎不到一年
		tmp.put("s_2", s_0 - s_1);//（未查）合计
		
		tmp.put("s_scale", s_0 == 0 ? 0d : (new Double(s_1)/new Double(s_0)));//查环查验率
	}
	
	//第二个统计表****************************************
	
	@Transactional(readOnly = true)
	public Map searchDoubleCheck4Stat2(String status,String year,String seq,String start,String end) {
		if(StringUtils.isEmpty(status))
			return null;
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder();
		//未孕应查已取环
		sql
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,1 as type ")
				.append(" from fhp_fertile_woman as fw,FHP_DOUBLE_CHECK_OBJECT as dco,FHP_BIRTH2_APPLY as ba,FHP_BIRTH2_CHECK as bc ")
				.append(" where fw.id = dco.WOMAN_ID and ba.WOMAN_ID = fw.id and ba.ID = bc.APPLY_ID and bc.IS_AGREE = 12 and ba.MATENAL_STATUS = 72 ");
		if(StringUtils.equals(status, "0")){
			sql.append(" and dco.year = ? and dco.seq = ? ");
			params.add(year);
			params.add(seq);
		}else if(StringUtils.equals(status, "1")){
			sql.append(" and dco.START >= ? and dco.END <= ? ");
			params.add(start);
			params.add(end);
		}
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
				sql.append(" and EXISTS(select 1 from FHP_GET_IUD as gi where gi.WOMAN_ID = fw.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 未孕应查未取环
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,2 as type ")
				.append(" from fhp_fertile_woman as fw,FHP_DOUBLE_CHECK_OBJECT as dco,FHP_BIRTH2_APPLY as ba,FHP_BIRTH2_CHECK as bc ")
				.append(" where fw.id = dco.WOMAN_ID and ba.WOMAN_ID = fw.id and ba.ID = bc.APPLY_ID and bc.IS_AGREE = 12 and ba.MATENAL_STATUS = 72 ");
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
				if(StringUtils.equals(status, "0")){
					sql.append(" and dco.year = ? and dco.seq = ? ");
					params.add(year);
					params.add(seq);
				}else if(StringUtils.equals(status, "1")){
					sql.append(" and dco.START >= ? and dco.END <= ? ");
					params.add(start);
					params.add(end);
				}
				sql.append(" and NOT EXISTS(select 1 from FHP_GET_IUD as gi where gi.WOMAN_ID = fw.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 未孕已查已取环
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,3 as type ")
				.append(" from fhp_fertile_woman as fw,FHP_DOUBLE_CHECK_OBJECT as dco,FHP_BIRTH2_APPLY as ba,FHP_BIRTH2_CHECK as bc ")
				.append(" where fw.id = dco.WOMAN_ID and ba.WOMAN_ID = fw.id and ba.ID = bc.APPLY_ID and bc.IS_AGREE = 12 and ba.MATENAL_STATUS = 72 ");
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
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
				.append(" and EXISTS(select 1 from FHP_GET_IUD as gi where gi.WOMAN_ID = fw.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 未孕已查未取环
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,4 as type ")
				.append(" from fhp_fertile_woman as fw,FHP_DOUBLE_CHECK_OBJECT as dco,FHP_BIRTH2_APPLY as ba,FHP_BIRTH2_CHECK as bc ")
				.append(" where fw.id = dco.WOMAN_ID and ba.WOMAN_ID = fw.id and ba.ID = bc.APPLY_ID and bc.IS_AGREE = 12 and ba.MATENAL_STATUS = 72 ");
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
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
				.append(" and NOT EXISTS(select 1 from FHP_GET_IUD as gi where gi.WOMAN_ID = fw.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 已怀孕人数
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,5 as type ")
				.append(" from fhp_fertile_woman as fw,FHP_DOUBLE_CHECK_OBJECT as dco ")
				.append(" where fw.ID = dco.WOMAN_ID and dco.DC_STATUS = 760 and dco.DC_RESULT2 = 764 ");
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
				if(StringUtils.equals(status, "0")){
					sql.append(" and dco.year = ? and dco.seq = ? ");
					params.add(year);
					params.add(seq);
				}else if(StringUtils.equals(status, "1")){
					sql.append(" and dco.START >= ? and dco.END <= ? ");
					params.add(start);
					params.add(end);
				}
				sql.append(" group by fw.AREA ");

		List<Map<String,Object>> result_orin = this.doubleCheckDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
		String area = null , key_tmp = null;
		Integer areaCount = null , type = null;
		for(Map<String,Object> ros : result_orin){
			area = (String)ros.get("area");
			areaCount = ((BigInteger)ros.get("areaCount")).intValue();
			type = ((BigInteger)ros.get("type")).intValue();
			if(!result.containsKey(area)){
				result.put(area, new HashMap<String,Integer>());
			}
			key_tmp = "s"+type;
			if(result.get(area).containsKey(key_tmp))
				result.get(area).put(key_tmp, areaCount+result.get(area).get(key_tmp));
			else
				result.get(area).put(key_tmp, areaCount);
		}
		return result;
	}
	
	public List searchDoubleCheck4Stat2_4AutoPrint(String status,String year,String seq,String start,String end){
		Map<String,Map<String,Integer>> result = searchDoubleCheck4Stat2(status, year, seq, start, end);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Integer> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat2(tmp,dv.getName(),0,0,0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat2(tmp,dv.getName(),0,0,0,0,0);
				}else{
					setValue2Map4stat2(tmp,dv.getName(),si.get("s1"),si.get("s2"),si.get("s3"),si.get("s4"),si.get("s5"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal2(lst));
		return lst;
	}
	
	private void setValue2Map4stat2(Map tmp,String area,Integer s1,Integer s2,Integer s3,Integer s4,Integer s5){
		if(s1 == null ) s1 = 0;
		if(s2 == null ) s2 = 0;
		if(s3 == null ) s3 = 0;
		if(s4 == null ) s4 = 0;
		if(s5 == null ) s5 = 0;
		
		tmp.put("area", area);
		
		int s12 = s1+s2;
		int s34 = s3+s4;
		tmp.put("s1", s1);//(安排生育二胎未孕)应查已取环
		tmp.put("s2", s2);//(安排生育二胎未孕)应查未取环
		tmp.put("s12", s12);//(安排生育二胎未孕)应查合计
		tmp.put("s3", s3);//(安排生育二胎未孕)已查已取环
		tmp.put("s4", s4);//(安排生育二胎未孕)已查未取环
		tmp.put("s34", s34);//(安排生育二胎未孕)已查合计
		tmp.put("s5", s5);//(安排生育二胎未孕)未查已取环
		tmp.put("s6", s1-s3);//(安排生育二胎未孕)未查未取环
		tmp.put("s7", s2-s4);//(安排生育二胎未孕)未查合计
		tmp.put("s67", s12-s34);//已怀孕人数合计
		
		tmp.put("s_scale", s12 == 0 ? 0d : (new Double(s34)/new Double(s12)));//查环查孕率
	}
	
	private Map getTotal2(List<Map> lst){
		Map tmp = new HashMap();
		int s1_0 = 0, s2_0 = 0, s3_0 = 0, s4_0 = 0, s5_0 = 0;
		for(Map m : lst){
			s1_0 += (Integer)m.get("s1");
			s2_0 += (Integer)m.get("s2");
			s3_0 += (Integer)m.get("s3");
			s4_0 += (Integer)m.get("s4");
			s5_0 += (Integer)m.get("s5");
		}
		setValue2Map4stat2(tmp, "合计", s1_0, s2_0, s3_0, s4_0, s5_0);
		return tmp;
	}
	
	//第三个统计表****************************************
	
	@Transactional(readOnly = true)
	public Map searchDoubleCheck4Stat3(String status,String year,String seq,String start,String end) {
		if(StringUtils.isEmpty(status))
			return null;
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder();
		//已婚未育应检
		sql
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,1 as type ")
				.append(" from fhp_fertile_woman as fw,fhp_woman_basic as wb,FHP_DOUBLE_CHECK_OBJECT as dco,fhp_person as p ")
				.append(" where fw.ID = wb.WOMAN_ID and fw.id = dco.WOMAN_ID and p.ID = fw.PERSON_ID ");
		if(StringUtils.equals(status, "0")){
			sql.append(" and dco.year = ? and dco.seq = ? ");
			params.add(year);
			params.add(seq);
		}else if(StringUtils.equals(status, "1")){
			sql.append(" and dco.START >= ? and dco.END <= ? ");
			params.add(start);
			params.add(end);
		}
				//.append(" and wb.MARRY_STATUS != 175 ")
				sql.append(" and dco.year = 2011 and dco.seq = 1 ")
				.append(" and NOT EXISTS(select 1 from fhp_woman_children as wc where wc.PERSON_ID = p.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 已婚未育已检
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,2 as type  ")
				.append(" from fhp_fertile_woman as fw,fhp_woman_basic as wb,FHP_DOUBLE_CHECK_OBJECT as dco,fhp_person as p ")
				.append(" where fw.ID = wb.WOMAN_ID and fw.id = dco.WOMAN_ID and p.ID = fw.PERSON_ID ")
				.append(" and wb.MARRY_STATUS != 175 ");
				if(StringUtils.equals(status, "0")){
					sql.append(" and dco.year = ? and dco.seq = ? ");
					params.add(year);
					params.add(seq);
				}else if(StringUtils.equals(status, "1")){
					sql.append(" and dco.START >= ? and dco.END <= ? ");
					params.add(start);
					params.add(end);
				}
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
				sql.append(" and dco.DC_STATUS = 760 ")
				.append(" and NOT EXISTS(select 1 from fhp_woman_children as wc where wc.PERSON_ID = p.id) ")
				.append(" group by fw.AREA ")
				.append(" union all ")
				// 已婚未育已检（有孕）
				.append(" select ifnull(count(1),0) as areaCount,fw.AREA as area,3 as type ")
				.append(" from fhp_fertile_woman as fw,fhp_woman_basic as wb,FHP_DOUBLE_CHECK_OBJECT as dco,fhp_person as p ")
				.append(" where fw.ID = wb.WOMAN_ID and fw.id = dco.WOMAN_ID and p.ID = fw.PERSON_ID ")
				.append(" and wb.MARRY_STATUS != 175 ");
				if(StringUtils.equals(status, "0")){
					sql.append(" and dco.year = ? and dco.seq = ? ");
					params.add(year);
					params.add(seq);
				}else if(StringUtils.equals(status, "1")){
					sql.append(" and dco.START >= ? and dco.END <= ? ");
					params.add(start);
					params.add(end);
				}
				//.append(" and dco.year = 2011 and dco.seq = 1 ")
				sql.append(" and dco.DC_STATUS = 760 ")
				.append(" and dco.DC_RESULT2 = 764 ")
				.append(" and NOT EXISTS(select 1 from fhp_woman_children as wc where wc.PERSON_ID = p.id) ")
				.append(" group by fw.AREA ");

		List<Map<String,Object>> result_orin = this.doubleCheckDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
		String area = null , key_tmp = null;
		Integer areaCount = null , type = null;
		for(Map<String,Object> ros : result_orin){
			area = (String)ros.get("area");
			areaCount = ((BigInteger)ros.get("areaCount")).intValue();
			type = ((BigInteger)ros.get("type")).intValue();
			if(!result.containsKey(area)){
				result.put(area, new HashMap<String,Integer>());
			}
			key_tmp = "s"+type;
			if(result.get(area).containsKey(key_tmp))
				result.get(area).put(key_tmp, areaCount+result.get(area).get(key_tmp));
			else
				result.get(area).put(key_tmp, areaCount);
		}
		return result;
	}
	
	public List searchDoubleCheck4Stat3_4AutoPrint(String status,String year,String seq,String start,String end){
		Map<String,Map<String,Integer>> result = searchDoubleCheck4Stat3(status, year, seq, start, end);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Integer> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map4stat3(tmp,dv.getName(),0,0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map4stat3(tmp,dv.getName(),0,0,0);
				}else{
					setValue2Map4stat3(tmp,dv.getName(),si.get("s1"),si.get("s2"),si.get("s3"));
				}
			}
			lst.add(tmp);
		}
		lst.set(0, getTotal3(lst));
		return lst;
	}
	
	private void setValue2Map4stat3(Map tmp,String area,Integer s1,Integer s2,Integer s3){
		if(s1 == null ) s1 = 0;
		if(s2 == null ) s2 = 0;
		if(s3 == null ) s3 = 0;
		
		tmp.put("area", area);
		
		tmp.put("s1", s1);//(已结婚未育)应查
		tmp.put("s2", s2);//(已结婚未育)已查
		tmp.put("s3", s3);//(已结婚未育)已查已怀孕
		tmp.put("s4", s1-s2);//(已结婚未育)未检人数
		
		tmp.put("s_scale", s1 == 0 ? 0d : (new Double(s2)/new Double(s1)));//查环查孕率
	}
	
	private Map getTotal3(List<Map> lst){
		Map tmp = new HashMap();
		int s1_0 = 0, s2_0 = 0, s3_0 = 0;
		for(Map m : lst){
			s1_0 += (Integer)m.get("s1");
			s2_0 += (Integer)m.get("s2");
			s3_0 += (Integer)m.get("s3");
		}
		setValue2Map4stat3(tmp, "合计", s1_0, s2_0, s3_0);
		return tmp;
	}

}
package com.jeysan.cpf.decision.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.decision.dao.Flowbasicquery13ViewDao;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.district.service.DistrictVillageManager;
import com.jeysan.cpf.util.Constants;

/**
 * @author 黄静
 *
 */
@Component
@Transactional
public class Flowbasicquery13ViewManager {
	private Flowbasicquery13ViewDao flowbasicquery13ViewDao;
	private DistrictVillageManager districtVillageManager;
	
	@Autowired
	public void setFlowbasicquery13ViewDao(Flowbasicquery13ViewDao flowbasicquery13ViewDao) {
		this.flowbasicquery13ViewDao = flowbasicquery13ViewDao;
	}

	@Autowired
	public void setDistrictVillageManager(DistrictVillageManager districtVillageManager) {
		this.districtVillageManager = districtVillageManager;
	}
	
	@Transactional(readOnly = true)
	public Map searchFlowbasicquery13View(Integer domicileType,Integer areaLevel , Date start,Date end) {
		List params = new ArrayList();
		StringBuilder sql = new StringBuilder();
		sql
		.append(" select area,personNum,in_out_type from fhp_flowbasicquery13_view where DOMICILE_TYPE = ? ");
		params.add(domicileType);
		if(start!=null && end != null){
			sql.append(" and datah between ? and ? ");
			params.add(start);
			params.add(end);
		}
		if(areaLevel != null){
			sql.append(" and areaLevel = ? ");
			params.add(areaLevel);
		}
		//List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List<Map<String,Object>> result_orin = this.flowbasicquery13ViewDao.findBySql(sql.toString(), params.toArray());
		Map<String,Map<String,Integer>> result = new HashMap<String,Map<String,Integer>>();
		String area = null , key_tmp = null;
		Integer personNum = null , inOutType = null;
		for(Map<String,Object> ros : result_orin){
			area = (String)ros.get("area");
			personNum = ((BigInteger)ros.get("personNum")).intValue();
			inOutType = ((BigInteger)ros.get("in_out_type")).intValue();
			if(!result.containsKey(area)){
				result.put(area, new HashMap<String,Integer>());
			}
			key_tmp = "s_"+inOutType;
			if(result.get(area).containsKey(key_tmp))
				result.get(area).put(key_tmp, personNum+result.get(area).get(key_tmp));
			else
				result.get(area).put(key_tmp, personNum);
		}
		return result;
	}
	@Transactional(readOnly = true)
	public List searchFlowbasicquery13View4AutoPrint(Integer domicileType,Integer areaLevel , Date start,Date end){
		Map<String,Map<String,Integer>> result = searchFlowbasicquery13View(domicileType, areaLevel, start, end);
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		List lst = new ArrayList();
		Map tmp = null;
		Map<String,Integer> si = null; 
		for(DistrictVillage dv : villages){
			tmp = new HashMap();
			if(result == null){
				setValue2Map(tmp,dv.getName(),0,0);
			}else{
				si = result.get(dv.getCode());
				if(si == null){
					setValue2Map(tmp,dv.getName(),0,0);
				}else{
					setValue2Map(tmp,dv.getName(),si.get("s_1"),si.get("s_2"));
				}
			}
			lst.add(tmp);
		}
		return lst;
	}
	
	private void setValue2Map(Map tmp,String area,Integer s_1,Integer s_2){
		if(s_1 == null ) s_1 = 0;
		if(s_2 == null ) s_2 = 0;
		
		tmp.put("area", area);
		int s_12  = s_1 + s_2;
		tmp.put("s_1", s_1);//流入人数
		tmp.put("s_2", s_2);//流出人数
		tmp.put("s_3", s_12 == 0 ? 0d : (new Double(s_1)/new Double(s_12)));//流入比例
		tmp.put("s_4", s_12 == 0 ? 0d : (new Double(s_2)/new Double(s_12)));//流出比例
	}
	
	
}
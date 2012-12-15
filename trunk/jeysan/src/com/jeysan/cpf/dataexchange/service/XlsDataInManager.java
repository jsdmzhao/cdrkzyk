package com.jeysan.cpf.dataexchange.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.WomanContracept;
import com.jeysan.cpf.bcmas.service.FertileWomanManager;
import com.jeysan.cpf.bcmas.service.WomanContraceptManager;
import com.jeysan.cpf.dataexchange.dao.XlsDataInDao;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.district.service.DistrictVillageManager;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.entity.PersonBasic;
import com.jeysan.cpf.pmas.entity.PersonIn;
import com.jeysan.cpf.pmas.entity.PersonOut;
import com.jeysan.cpf.pmas.entity.Spouse;
import com.jeysan.cpf.pmas.service.PersonBasicManager;
import com.jeysan.cpf.pmas.service.PersonInManager;
import com.jeysan.cpf.pmas.service.PersonManager;
import com.jeysan.cpf.pmas.service.PersonOutManager;
import com.jeysan.cpf.pmas.service.SpouseManager;
import com.jeysan.cpf.security.entity.Dict;
import com.jeysan.cpf.security.entity.DictSub;
import com.jeysan.cpf.security.service.DictManager;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;

/**
 * 
 * @author gemstone
 *
 */
@Component
public class XlsDataInManager {
	
	@Autowired
	private XlsDataInDao xlsDataInDao;
	private DistrictVillageManager districtVillageManager;
	private PersonManager personManager;
	private SpouseManager spouseManager;
	private PersonBasicManager personBasicManager;
	private DictManager dictManager;
	private FertileWomanManager fertileWomanManager;
	private WomanContraceptManager womanContraceptManager;
	private PersonInManager personInManager;
	private PersonOutManager personOutManager;
	
	@Autowired
	public void setDistrictVillageManager(DistrictVillageManager districtVillageManager) {
		this.districtVillageManager = districtVillageManager;
	}
	@Autowired
	public void setPersonManager(PersonManager personManager) {
		this.personManager = personManager;
	}
	@Autowired
	public void setSpouseManager(SpouseManager spouseManager) {
		this.spouseManager = spouseManager;
	}
	@Autowired
	public void setPersonBasicManager(PersonBasicManager personBasicManager) {
		this.personBasicManager = personBasicManager;
	}
	@Autowired
	public void setDictManager(DictManager dictManager) {
		this.dictManager = dictManager;
	}
	@Autowired
	public void setFertileWomanManager(FertileWomanManager fertileWomanManager) {
		this.fertileWomanManager = fertileWomanManager;
	}
	@Autowired
	public void setWomanContraceptManager(
			WomanContraceptManager womanContraceptManager) {
		this.womanContraceptManager = womanContraceptManager;
	}
	@Autowired
	public void setPersonInManager(PersonInManager personInManager) {
		this.personInManager = personInManager;
	}
	@Autowired
	public void setPersonOutManager(PersonOutManager personOutManager) {
		this.personOutManager = personOutManager;
	}
	public int importFullData(Map<Integer,List> data) throws Exception{
		//47:0~46
		//person
		List<String> name_lst = data.get(1);
		List<String> certType_lst = data.get(38);
		List<String> code_lst = data.get(2);
		List<String> sex_lst = data.get(3);
		List<String> kind_lst = data.get(45);//人员类别
		List<String> birthday_lst = data.get(5);
		List<String> cancelType_lst = data.get(15);
		List<String> cancelDate_lst = data.get(16);
		List<String> domicileType_lst = data.get(17);//户口类别
		List<String> area_lst = data.get(46);
		
		List<Person> persons = savePerson(name_lst, certType_lst, code_lst, sex_lst, kind_lst, birthday_lst, cancelType_lst, cancelDate_lst, domicileType_lst, area_lst);
		//spouse
		List<String> spouseName_lst = data.get(21);
		List<String> spouseCode_lst = data.get(22);
		
		List<Spouse> spouses = saveSpouse(persons, spouseName_lst, spouseCode_lst);
		
		//personBasic
		List<String> househodeKind_lst = data.get(4);//户口性质
		//List<String> age_lst = data.get(6);
		List<String> native_lst = data.get(0);
		List<String> domicile_lst = data.get(7);
		List<String> domicileHouseNo_lst = data.get(8);
		List<String> address_lst = data.get(9);
		List<String> houseNo_lst = data.get(10);
		List<String> marryStatus_lst = data.get(11);
		List<String> firstMarryDate_lst = data.get(12);
		List<String> marryCryDate_lst = data.get(13);
		List<String> tel_lst = data.get(14);
		List<String> politicalStatus_lst = data.get(18);
		List<String> isSingle_lst = data.get(29);
		List<String> job_lst = data.get(30);
		List<String> company_lst = data.get(31);
		List<String> edu_lst = data.get(34);
		List<String> houseHoldCode_lst = data.get(37);
		List<String> relation_lst = data.get(44);
		
		List<PersonBasic> personBasics = savePersonBasic(persons, birthday_lst,househodeKind_lst, native_lst, domicile_lst, domicileHouseNo_lst, address_lst, houseNo_lst, marryStatus_lst, firstMarryDate_lst, marryCryDate_lst, tel_lst, politicalStatus_lst, isSingle_lst, job_lst, company_lst, edu_lst, houseHoldCode_lst, relation_lst);
		
		//fertileWoman
		List<String> createDate_lst = data.get(19);
		List<FertileWoman> fertileWomans = saveFertileWoman(persons,createDate_lst);
		
		//List<String> createPlace_lst = data.get(20);建卡地

		
		List<String> settleInCause_lst = data.get(23);
		List<String> settleInDate_lst = data.get(24);
		List<String> settleOutDate_lst = data.get(25);
		
		List<PersonIn> personIns = savePersonIn(persons, settleInCause_lst, settleInDate_lst);
		List<PersonOut> personOuts = savePersonOut(persons, settleInCause_lst, settleOutDate_lst);
		
//		List<String> tel_lst = data.get(26);//户籍口径统计地

//		List<String> tel_lst = data.get(27);//常住口径统计地

//		List<String> tel_lst = data.get(28);//流动口径统计地

		
//		List<String> tel_lst = data.get(32);//单位性质

//		List<String> tel_lst = data.get(33);//健康状况

//		List<String> tel_lst = data.get(35);//是否标记迁出

//		List<String> tel_lst = data.get(36);//是否标记离开

		//List<String> tel_lst = data.get(38);
//		List<String> tel_lst = data.get(39);//最小子女出生日期

//		List<String> tel_lst = data.get(40);//子女数

//		List<String> tel_lst = data.get(41);//女孩数

		List<String> method_lst = data.get(42);//当前有效避孕节育措施

		List<String> opsDate_lst = data.get(43);//落实节育措施时间

		List<WomanContracept> womanContracepts = saveWomanContraceptManager(persons, method_lst, opsDate_lst);
		
		return persons.size() + spouses.size() 
		+ personBasics.size() + fertileWomans.size() 
		+ personIns.size() + personOuts.size()
		+ womanContracepts.size();
	}
	
	private List<FertileWoman> saveFertileWoman(List<Person> persons,List<String> createDate_lst) throws Exception{
		List<FertileWoman> result = new ArrayList<FertileWoman>();
		try{
			FertileWoman fertileWoman = null;
			Person person = null;
			for(int i=0;i<persons.size();i++){
				person = persons.get(i);
				if(person.getSex()!=null && person.getSex()==Constants.SEX.FEMALE.intValue()
						&& person.getKind()!=null && person.getKind()==Constants.FW_KIND.FW){
					fertileWoman = new FertileWoman();
					fertileWoman.setPerson(person);
					fertileWoman.setNameh(person.getNameh());
					fertileWoman.setCreateDate(DateUtil.createUtilDate(createDate_lst.get(i)));
					fertileWoman.setArea(person.getArea());
					result.add(fertileWoman);
				}
			}
			if(result.size() > 0)
				fertileWomanManager.saveFertileWomans(result);
		}catch(Exception e){
			throw new Exception("saveFertileWoman Error : "+e);
		}
		return result;
	}
	private List<Person> savePerson(
			List<String> name_lst,
			List<String> certType_lst,
			List<String> code_lst,
			List<String> sex_lst,
			List<String> kind_lst,
			List<String> birthday_lst,
			List<String> cancelType_lst,
			List<String> cancelDate_lst,
			List<String> domicileType_lst,
			List<String> area_lst) throws Exception{
		List<Person> result = new ArrayList<Person>();
		List<DistrictVillage> villages = districtVillageManager.getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		Map<String,String> vgs = new HashMap<String,String>();
		for(DistrictVillage vg : villages){
			vgs.put(vg.getName(), vg.getCode());
		}
		try{
			Person person = null;
			Date currentDate = new Date();
			String area = null;
			for(int i=0;i<name_lst.size();i++){
				person = new Person();
				person.setNameh(name_lst.get(i));
				person.setCertType(Constants.CARD_TYPE.getStatusByLabel(certType_lst.get(i)));
				person.setCode(code_lst.get(i));
				person.setSex(Constants.SEX.getStatusByLabel(sex_lst.get(i)));
				person.setKind(Constants.FW_KIND.getStatusByLabel(kind_lst.get(i)));
				if(birthday_lst.get(i)!=null)
					person.setAge(DateUtil.dateDiff("YEAR", DateUtil.createUtilDate(birthday_lst.get(i)), currentDate));
				person.setCancelDate(DateUtil.createUtilDate(cancelDate_lst.get(i)));
				person.setCancelType(Constants.CANCEL_TYPE.getStatusByLabel(cancelType_lst.get(i)));
				person.setDomicileType(Constants.DOMICILE_TYPE.getStatusByLabel(domicileType_lst.get(i)));
				area = area_lst.get(i);
				if(StringUtils.isNotEmpty(area)){
					if(area.indexOf("社区居委会")==-1){
						if(area.indexOf("社区")==-1) area += "社区居委会";
						else area += "居委会";
					}
					person.setArea(vgs.get(area));
				}
				result.add(person);
			}
			if(result.size() > 0)
				personManager.savePersons(result);
		}catch(Exception e){
			throw new Exception("savePerson Error : "+e);
		}
		return result;
	}
	
	private List<Spouse> saveSpouse(
			List<Person> persons,
			List<String> spouseName_lst,
			List<String> spouseCode_lst) throws Exception{
		List<Spouse> result = new ArrayList<Spouse>();
		try{
			Spouse spouse = null;
			for(int i=0;i<persons.size();i++){
				spouse = new Spouse();
				spouse.setNameh(spouseName_lst.get(i));
				spouse.setCode(spouseCode_lst.get(i));
				spouse.setPerson(persons.get(i));
				if(persons.get(i).getSex()!=null)
					spouse.setSex(persons.get(i).getSex()==Constants.SEX.MALE.intValue()?Constants.SEX.FEMALE:Constants.SEX.MALE);
				result.add(spouse);
			}
			if(result.size() > 0)
				spouseManager.saveSpouses(result);
		}catch(Exception e){
			throw new Exception("saveSpouse Error : "+e);
		}
		return result;
	}
	
	private List<PersonIn> savePersonIn(
			List<Person> persons,
			List<String> settleInCause_lst,
			List<String> settleInDate_lst) throws Exception{
		List<PersonIn> result = new ArrayList<PersonIn>();
		try{
			PersonIn personIn = null;
			for(int i=0;i<persons.size();i++){
				if(StringUtils.isNotEmpty(settleInDate_lst.get(i))){
					personIn = new PersonIn();
					personIn.setPerson(persons.get(i));
					personIn.setInCause(Constants.IN_CAUSE.getStatusByLabel(settleInCause_lst.get(i)));
					personIn.setInDate(DateUtil.createUtilDate(settleInDate_lst.get(i)));
					result.add(personIn);
				}
			}
			if(result.size() > 0)
				personInManager.savePersonIns(result);
		}catch(Exception e){
			throw new Exception("savePersonIn Error : "+e);
		}
		return result;
	}
	
	private List<PersonOut> savePersonOut(
			List<Person> persons,
			List<String> settleOutCause_lst,
			List<String> settleOutDate_lst) throws Exception{
		List<PersonOut> result = new ArrayList<PersonOut>();
		try{
			PersonOut personOut = null;
			for(int i=0;i<persons.size();i++){
				if(StringUtils.isNotEmpty(settleOutDate_lst.get(i))){
					personOut = new PersonOut();
					personOut.setPerson(persons.get(i));
					personOut.setOutCause(Constants.IN_CAUSE.getStatusByLabel(settleOutCause_lst.get(i)));
					personOut.setOutDate(DateUtil.createUtilDate(settleOutDate_lst.get(i)));
					result.add(personOut);
				}
			}
			if(result.size() > 0)
				personOutManager.savePersonOuts(result);
		}catch(Exception e){
			throw new Exception("savePersonPersonOut Error : "+e);
		}
		return result;
	}
	
	
	
	private List<WomanContracept> saveWomanContraceptManager(
			List<Person> persons,
			List<String> method_lst,
			List<String> opsDate_lst) throws Exception{
		List<WomanContracept> result = new ArrayList<WomanContracept>();
		try{
			WomanContracept womanContracept = null;
			for(int i=0;i<persons.size();i++){
				womanContracept = new WomanContracept();
				womanContracept.setPerson(persons.get(i));
				womanContracept.setMethod(Constants.METHOD.getStatusByLabel(method_lst.get(i)));
				womanContracept.setOpsDate(DateUtil.createUtilDate(opsDate_lst.get(i)));
				result.add(womanContracept);
			}
			if(result.size() > 0)
				womanContraceptManager.saveWomanContracepts(result);
		}catch(Exception e){
			throw new Exception("saveWomanContraceptManager Error : "+e);
		}
		return result;
	}
	
	private List<PersonBasic> savePersonBasic(
			List<Person> persons,
			List<String> birthday_lst,
			List<String> househodeKind_lst,
			List<String> native_lst,
			List<String> domicile_lst,
			List<String> domicileHouseNo_lst,
			List<String> address_lst,
			List<String> houseNo_lst,
			List<String> marryStatus_lst,
			List<String> firstMarryDate_lst,
			List<String> marryCryDate_lst,
			List<String> tel_lst,
			List<String> politicalStatus_lst,
			List<String> isSingle_lst,
			List<String> job_lst,
			List<String> company_lst,
			List<String> edu_lst,
			List<String> houseHoldCode_lst,
			List<String> relation_lst) throws Exception{
		Dict native_dict = dictManager.getDict("JS1044");
		Map<String,Integer> n_dts = new HashMap<String,Integer>();
		for(DictSub ds : native_dict.getDictSubList()){
			n_dts.put(ds.getSubName(),ds.getId());
		}

		Dict job_dict = dictManager.getDict("JS1017");
		Map<String,Integer> job_dts = new HashMap<String,Integer>();
		for(DictSub ds : job_dict.getDictSubList()){
			job_dts.put(ds.getSubName(),ds.getId());
		}

		Dict edu_dict = dictManager.getDict("JS1041");
		Map<String,Integer> edu_dts = new HashMap<String,Integer>();
		for(DictSub ds : edu_dict.getDictSubList()){
			edu_dts.put(ds.getSubName(),ds.getId());
		}
		
		List<PersonBasic> result = new ArrayList<PersonBasic>();
		try{
			PersonBasic personBasic = null;
			for(int i=0;i<persons.size();i++){
				personBasic = new PersonBasic();
				personBasic.setPerson(persons.get(i));
				personBasic.setBirthday(DateUtil.createUtilDate(birthday_lst.get(i)));
				personBasic.setHousehodeKind(Constants.HOUSEHODE_KIND.getStatusByLabel(househodeKind_lst.get(i)));
				if(native_lst.get(i) != null)
					personBasic.setNative(n_dts.get(native_lst.get(i)));
				personBasic.setDomicile(domicile_lst.get(i));
				personBasic.setDomicileHouseNo(domicileHouseNo_lst.get(i));
				personBasic.setAddress(address_lst.get(i));
				personBasic.setHouseNo(houseNo_lst.get(i));
				personBasic.setMarryStatus(Constants.MARRY_STATUS.getStatusByLabel(marryStatus_lst.get(i)));
				personBasic.setFirstMarryDate(DateUtil.createUtilDate(firstMarryDate_lst.get(i)));
				personBasic.setMarryCryDate(DateUtil.createUtilDate(marryCryDate_lst.get(i)));
				personBasic.setTel(tel_lst.get(i));
				personBasic.setPoliticalStatus(Constants.PoliticalStatus.getStatusByLabel(politicalStatus_lst.get(i)));
				if(isSingle_lst.get(i) != null)
					personBasic.setIsSingle(StringUtils.equals(isSingle_lst.get(i), "是")?1:0);
				if(job_lst.get(i) != null)
					personBasic.setJob(job_dts.get(job_lst.get(i)));
				personBasic.setCompany(company_lst.get(i));
				if(edu_lst.get(i) != null)
					personBasic.setEdu(edu_dts.get(edu_lst.get(i)));
				personBasic.setHouseHoldCode(houseHoldCode_lst.get(i));
				personBasic.setRelation(Constants.RELATION.getStatusByLabel(relation_lst.get(i)));
				
				result.add(personBasic);
			}
			if(result.size() > 0)
				personBasicManager.savePersonBasics(result);
		}catch(Exception e){
			throw new Exception("saveSpouse Error : "+e);
		}
		return result;
	}
	
}
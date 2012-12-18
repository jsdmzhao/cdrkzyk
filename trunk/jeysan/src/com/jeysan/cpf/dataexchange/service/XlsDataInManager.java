package com.jeysan.cpf.dataexchange.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jeysan.cpf.bcmas.dao.FertileWomanDao;
import com.jeysan.cpf.bcmas.dao.WomanContraceptDao;
import com.jeysan.cpf.bcmas.entity.FertileWoman;
import com.jeysan.cpf.bcmas.entity.WomanContracept;
import com.jeysan.cpf.district.dao.DistrictVillageDao;
import com.jeysan.cpf.district.entity.DistrictVillage;
import com.jeysan.cpf.pmas.dao.PersonBasicDao;
import com.jeysan.cpf.pmas.dao.PersonDao;
import com.jeysan.cpf.pmas.dao.PersonInDao;
import com.jeysan.cpf.pmas.dao.PersonOutDao;
import com.jeysan.cpf.pmas.dao.SpouseDao;
import com.jeysan.cpf.pmas.entity.Person;
import com.jeysan.cpf.pmas.entity.PersonBasic;
import com.jeysan.cpf.pmas.entity.PersonIn;
import com.jeysan.cpf.pmas.entity.PersonOut;
import com.jeysan.cpf.pmas.entity.Spouse;
import com.jeysan.cpf.security.dao.DictDao;
import com.jeysan.cpf.security.entity.Dict;
import com.jeysan.cpf.security.entity.DictSub;
import com.jeysan.cpf.util.Constants;
import com.jeysan.modules.utils.date.DateUtil;

/**
 * 
 * @author gemstone
 *
 */
@Component
@Transactional
public class XlsDataInManager {
	
	private DistrictVillageDao districtVillageDao;
	private PersonDao personDao;
	private SpouseDao spouseDao;
	private PersonBasicDao personBasicDao;
	private DictDao dictDao;
	private FertileWomanDao fertileWomanDao;
	private WomanContraceptDao womanContraceptDao;
	private PersonInDao personInDao;
	private PersonOutDao personOutDao;
	
	@Autowired
	public void setDistrictVillageDao(DistrictVillageDao districtVillageDao) {
		this.districtVillageDao = districtVillageDao;
	}
	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	@Autowired
	public void setSpouseDao(SpouseDao spouseDao) {
		this.spouseDao = spouseDao;
	}
	@Autowired
	public void setPersonBasicDao(PersonBasicDao personBasicDao) {
		this.personBasicDao = personBasicDao;
	}
	@Autowired
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}
	@Autowired
	public void setFertileWomanDao(FertileWomanDao fertileWomanDao) {
		this.fertileWomanDao = fertileWomanDao;
	}
	@Autowired
	public void setWomanContraceptDao(
			WomanContraceptDao womanContraceptDao) {
		this.womanContraceptDao = womanContraceptDao;
	}
	@Autowired
	public void setPersonInDao(PersonInDao personInDao) {
		this.personInDao = personInDao;
	}
	@Autowired
	public void setPersonOutDao(PersonOutDao personOutDao) {
		this.personOutDao = personOutDao;
	}
	public int importFullData(Map<Integer,List> data) throws Exception{
		//47:0~46
		//person
		List<String> name_lst = data.get(1);
		List<String> certType_lst = data.get(38);
		List<String> code_lst = data.get(2);
		List<String> sex_lst = data.get(3);
		List<String> kind_lst = data.get(4);//人员类别
		List<String> birthday_lst = data.get(5);
		List<String> cancelType_lst = data.get(15);
		List<String> cancelDate_lst = data.get(16);
		List<String> domicileType_lst = data.get(45);//户口类别
		List<String> area_lst = data.get(46);
		
		Map<Integer,Person> persons = savePerson(name_lst, certType_lst, code_lst, sex_lst, kind_lst, birthday_lst, cancelType_lst, cancelDate_lst, domicileType_lst, area_lst);
		//spouse
		List<String> spouseName_lst = data.get(21);
		List<String> spouseCode_lst = data.get(22);
		
		List<Spouse> spouses = saveSpouse(persons, name_lst,spouseName_lst, spouseCode_lst);
		
		//personBasic
		List<String> househodeKind_lst = data.get(17);//户口性质
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
		
		List<PersonBasic> personBasics = savePersonBasic(persons,name_lst, birthday_lst,househodeKind_lst, native_lst, domicile_lst, domicileHouseNo_lst, address_lst, houseNo_lst, marryStatus_lst, firstMarryDate_lst, marryCryDate_lst, tel_lst, politicalStatus_lst, isSingle_lst, job_lst, company_lst, edu_lst, houseHoldCode_lst, relation_lst);
		
		//fertileWoman
		List<String> createDate_lst = data.get(19);
		List<FertileWoman> fertileWomans = saveFertileWoman(persons,name_lst,createDate_lst);
		
		//List<String> createPlace_lst = data.get(20);建卡地

		
		List<String> settleInCause_lst = data.get(23);
		List<String> settleInDate_lst = data.get(24);
		List<String> settleOutDate_lst = data.get(25);
		
		List<PersonIn> personIns = savePersonIn(persons,name_lst, settleInCause_lst, settleInDate_lst);
		List<PersonOut> personOuts = savePersonOut(persons,name_lst, settleInCause_lst, settleOutDate_lst);
		
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

		List<WomanContracept> womanContracepts = saveWomanContraceptDao(persons, name_lst,method_lst, opsDate_lst);
		
		return persons.size() + spouses.size() 
		+ personBasics.size() + fertileWomans.size() 
		+ personIns.size() + personOuts.size()
		+ womanContracepts.size();
	}
	private List<FertileWoman> saveFertileWoman(
			Map<Integer,Person> persons,
			List<String> name_lst,
			List<String> createDate_lst) throws Exception{
		List<FertileWoman> result = new ArrayList<FertileWoman>();
		try{
			FertileWoman fertileWoman = null;
			Person person = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				person = persons.get(i);
				if(person.getSex()!=null && person.getSex()==Constants.SEX.FEMALE.intValue()
						&& person.getKind()!=null && person.getKind()==Constants.FW_KIND.FW){
					if(StringUtils.equals(person.getSexLabel(),"isYet")){
						fertileWoman = getFertileWomanByPersonId(person.getId());
					}
					if(fertileWoman == null){
						fertileWoman = new FertileWoman();
					}
					fertileWoman.setPerson(person);
					fertileWoman.setNameh(person.getNameh());
					fertileWoman.setCreateDate(DateUtil.createUtilDate(createDate_lst.get(i)));
					fertileWoman.setArea(person.getArea());
					result.add(fertileWoman);
				}
			}
			if(result.size() > 0)
				fertileWomanDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("saveFertileWoman Error : "+e);
		}
		return result;
	}
	private Map<Integer,Person> savePerson(
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
		Map<Integer,Person> result = new HashMap<Integer,Person>();
		List<DistrictVillage> villages = getAllByParentId(Constants.COMMON_PARAM.CURRENT_TOWN_ID);
		Map<String,String> vgs = new HashMap<String,String>();
		for(DistrictVillage vg : villages){
			vgs.put(vg.getName(), vg.getCode());
		}
		try{
			Person person = null;
			Date currentDate = new Date();
			String area = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				person = getPerson(code_lst.get(i),certType_lst.get(i));
				person.setNameh(name_lst.get(i));
				person.setCertType(Constants.CARD_TYPE.getStatusByLabel(certType_lst.get(i)));
				person.setCode(code_lst.get(i));
				person.setSex(Constants.SEX.getStatusByLabel(sex_lst.get(i)));
				person.setKind(Constants.FW_KIND.getStatusByLabel(kind_lst.get(i)));
				//System.out.println("****"+i+"**"+birthday_lst.get(i));
				if(StringUtils.isNotEmpty(birthday_lst.get(i)))
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
				result.put(i,person);
			}
			if(result.size() > 0)
				personDao.save(result.values());
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("savePerson Error : "+e);
		}
		return result;
	}
	
	private List<Spouse> saveSpouse(
			Map<Integer,Person> persons,
			List<String> name_lst,
			List<String> spouseName_lst,
			List<String> spouseCode_lst) throws Exception{
		List<Spouse> result = new ArrayList<Spouse>();
		try{
			Spouse spouse = null;
			Person person = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i))||StringUtils.isEmpty(spouseName_lst.get(i)))
					continue;
				person = persons.get(i);
				if(StringUtils.equals(person.getSexLabel(),"isYet")){
					spouse = getSpouseByPersonId(person.getId());
				}
				if(spouse == null){
					spouse = new Spouse();
				}
				spouse.setPerson(persons.get(i));
				spouse.setNameh(spouseName_lst.get(i));
				spouse.setCode(spouseCode_lst.get(i));
				if(persons.get(i).getSex()!=null)
					spouse.setSex(persons.get(i).getSex()==Constants.SEX.MALE.intValue()?Constants.SEX.FEMALE:Constants.SEX.MALE);
				result.add(spouse);
			}
			if(result.size() > 0)
				spouseDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("saveSpouse Error : "+e);
		}
		return result;
	}
	
	private List<PersonIn> savePersonIn(
			Map<Integer,Person> persons,
			List<String> name_lst,
			List<String> settleInCause_lst,
			List<String> settleInDate_lst) throws Exception{
		List<PersonIn> result = new ArrayList<PersonIn>();
		try{
			PersonIn personIn = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				if(StringUtils.isNotEmpty(settleInDate_lst.get(i))){
					personIn = new PersonIn();
					personIn.setPerson(persons.get(i));
					personIn.setInCause(Constants.IN_CAUSE.getStatusByLabel(settleInCause_lst.get(i)));
					personIn.setInDate(DateUtil.createUtilDate(settleInDate_lst.get(i)));
					result.add(personIn);
				}
			}
			if(result.size() > 0)
				personInDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("savePersonIn Error : "+e);
		}
		return result;
	}
	
	private List<PersonOut> savePersonOut(
			Map<Integer,Person> persons,
			List<String> name_lst,
			List<String> settleOutCause_lst,
			List<String> settleOutDate_lst) throws Exception{
		List<PersonOut> result = new ArrayList<PersonOut>();
		try{
			PersonOut personOut = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				if(StringUtils.isNotEmpty(settleOutDate_lst.get(i))){
					personOut = new PersonOut();
					personOut.setPerson(persons.get(i));
					personOut.setOutCause(Constants.IN_CAUSE.getStatusByLabel(settleOutCause_lst.get(i)));
					personOut.setOutDate(DateUtil.createUtilDate(settleOutDate_lst.get(i)));
					result.add(personOut);
				}
			}
			if(result.size() > 0)
				personOutDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("savePersonPersonOut Error : "+e);
		}
		return result;
	}
	
	
	
	private List<WomanContracept> saveWomanContraceptDao(
			Map<Integer,Person> persons,
			List<String> name_lst,
			List<String> method_lst,
			List<String> opsDate_lst) throws Exception{
		List<WomanContracept> result = new ArrayList<WomanContracept>();
		try{
			WomanContracept womanContracept = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				womanContracept = new WomanContracept();
				womanContracept.setPerson(persons.get(i));
				womanContracept.setMethod(Constants.METHOD.getStatusByLabel(method_lst.get(i)));
				womanContracept.setOpsDate(DateUtil.createUtilDate(opsDate_lst.get(i)));
				result.add(womanContracept);
			}
			if(result.size() > 0)
				womanContraceptDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("saveWomanContraceptDao Error : "+e);
		}
		return result;
	}
	
	private List<PersonBasic> savePersonBasic(
			Map<Integer,Person> persons,
			List<String> name_lst,
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
		Dict native_dict = getDict("JS1044");
		Map<String,Integer> n_dts = new HashMap<String,Integer>();
		for(DictSub ds : native_dict.getDictSubList()){
			n_dts.put(ds.getSubName(),ds.getId());
		}

		Dict job_dict = getDict("JS1017");
		Map<String,Integer> job_dts = new HashMap<String,Integer>();
		for(DictSub ds : job_dict.getDictSubList()){
			job_dts.put(ds.getSubName(),ds.getId());
		}

		Dict edu_dict = getDict("JS1041");
		Map<String,Integer> edu_dts = new HashMap<String,Integer>();
		for(DictSub ds : edu_dict.getDictSubList()){
			edu_dts.put(ds.getSubName(),ds.getId());
		}
		
		List<PersonBasic> result = new ArrayList<PersonBasic>();
		try{
			PersonBasic personBasic = null;
			for(int i=1;i<name_lst.size();i++){
				if(StringUtils.isEmpty(name_lst.get(i)))
					continue;
				personBasic = persons.get(i).getPersonBasic();
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
				personBasicDao.save(result);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("savePersonBasic Error : "+e);
		}
		return result;
	}
	
	private Person getPerson(String code,String certType){
		Person person = null;
		if(StringUtils.isNotEmpty(code)){
			List<Person> persons = getPersonByCertCodeOrPersonCode(code, true);
			if(persons.size() == 1){
				person = persons.get(0);
			}else if(persons.size() > 1){
				for(Person p : persons){
					if(StringUtils.isNotEmpty(certType)&&p.getCertType()!=null&&Constants.CARD_TYPE.getStatusByLabel(certType) == p.getCertType().intValue()){
						person = p;
						break;
					}
				}
				if(person == null)
					person = persons.get(0);
			}
		}
		if(person == null){
			person = new Person();
			person.setSexLabel("isNew");
		}else
			person.setSexLabel("isYet");
		return person;
	}
	
	@Transactional(readOnly = true)
	public FertileWoman getFertileWomanByPersonId(Long id){
		List<FertileWoman> lst = fertileWomanDao.findBy("person.id", id);
		if(lst != null && lst.size() > 0)
			return lst.get(0);
		return null;
	}
	@Transactional(readOnly = true)
	public List<DistrictVillage> getAllByParentId(Integer parentId){
		return districtVillageDao.find(" from DistrictVillage where town.id = ? order by id ",parentId);
	}
	@Transactional(readOnly = true)
	public Spouse getSpouseByPersonId(Long id){
		return spouseDao.findUniqueBy("person.id", id);
	}
	@Transactional(readOnly = true)
	public Dict getDict(String dictCode){
		return dictDao.findUniqueBy("dictCode", dictCode);
	}
	@Transactional(readOnly = true)
	public List<Person> getPersonByCertCodeOrPersonCode(String code , boolean isCert){
		StringBuilder hql = new StringBuilder();
		hql.append("select p from Person as p where p.")
		.append(isCert?"code":"personCode")
		.append(" = ? ");
		return personDao.createQuery(hql.toString(),code).list();
	}
	
}
######20110805更新######
alter table fhp_person_basic add COLUMN FATHER varchar(50);
alter table fhp_person_basic add COLUMN FATHER_CODE varchar(20);
alter table fhp_person_basic add COLUMN MOTHER varchar(50);
alter table fhp_person_basic add COLUMN MOTHER_CODE varchar(20);
alter table fhp_person add COLUMN CERT_TYPE int;
alter table fhp_person add COLUMN SEX int;
alter table fhp_person_basic drop COLUMN SEX;
alter table fhp_person add COLUMN age tinyint;
alter table fhp_person_basic drop COLUMN age;
######20110806更新######
alter table FHP_PERSON_OUT add COLUMN OUT_TYPE int null;
alter table FHP_PERSON_IN add COLUMN IN_TYPE int null;
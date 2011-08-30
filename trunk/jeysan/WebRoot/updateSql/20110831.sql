/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011-8-26 10:39:43                           */
/*==============================================================*/


drop table if exists FHP_CONFIRM_DC_OBJ;

drop table if exists FHP_DOUBLE_CHECK;

drop table if exists FHP_DOUBLE_CHECK2;

drop table if exists FHP_DOUBLE_CHECK_DETAIL;

drop table if exists FHP_LOST_REG;

/*==============================================================*/
/* Table: FHP_CONFIRM_DC_OBJ                                    */
/*==============================================================*/
create table FHP_CONFIRM_DC_OBJ
(
   ID                   bigint not null auto_increment,
   DETAIL_ID            bigint not null,
   OBJ_TYPE             int comment '应查、免查、不查',
   WOMAN_ID             bigint,
   DC_STATUS            int comment '已查、未查',
   DC_DATE              date,
   DC_RESULT1           int comment '环正常
            环脱落
            环移位
            其它',
   DC_RESULT2           int comment '怀孕
            未怀孕',
   HOSPITAL             varchar(50) comment '应查、免查、不查',
   HOSPITAL_TYPE        int,
   DOCTOR               varchar(20),
   REMARK               varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DOUBLE_CHECK                                      */
/*==============================================================*/
create table FHP_DOUBLE_CHECK
(
   ID                   bigint not null,
   WOMAN_ID             bigint comment '妇女id为空时，表示此行为通用的双查轮次设定',
   DETAIL_ID            bigint not null,
   TYPEH                int comment '应查、免查、不查',
   COUNT                tinyint,
   CAUSE                varchar(50),
   START                varchar(7),
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DOUBLE_CHECK2                                     */
/*==============================================================*/
create table FHP_DOUBLE_CHECK2
(
   ID                   bigint not null auto_increment,
   COUNT                tinyint,
   START                varchar(7),
   YEAR                 int,
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DOUBLE_CHECK_DETAIL                               */
/*==============================================================*/
create table FHP_DOUBLE_CHECK_DETAIL
(
   ID                   bigint not null,
   DC_ID                bigint not null,
   SEQ                  tinyint comment '第几次双查',
   START                varchar(7),
   END                  varchar(7),
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_LOST_REG                                          */
/*==============================================================*/
create table FHP_LOST_REG
(
   ID                   bigint not null auto_increment,
   DETAIL_ID            bigint not null,
   WOMAN_ID             bigint,
   LDW_STATUS           int comment '未处理、已处理',
   LDW_CONTENT          varchar(50),
   LDW_DATE             date,
   MONEYH               double,
   PAY_DATE             date,
   CASHIER              varchar(20),
   primary key (ID)
);

alter table FHP_CONFIRM_DC_OBJ add constraint FK_Reference_20 foreign key (WOMAN_ID)
      references FHP_FERTILE_WOMAN (ID) on delete restrict on update restrict;

alter table FHP_CONFIRM_DC_OBJ add constraint FK_Reference_21 foreign key (DETAIL_ID)
      references FHP_DOUBLE_CHECK_DETAIL (ID) on delete restrict on update restrict;

alter table FHP_DOUBLE_CHECK add constraint FK_Reference_19 foreign key (WOMAN_ID)
      references FHP_FERTILE_WOMAN (ID) on delete restrict on update restrict;

alter table FHP_DOUBLE_CHECK add constraint FK_Reference_43 foreign key (DETAIL_ID)
      references FHP_DOUBLE_CHECK_DETAIL (ID) on delete restrict on update restrict;

alter table FHP_DOUBLE_CHECK_DETAIL add constraint FK_Reference_42 foreign key (DC_ID)
      references FHP_DOUBLE_CHECK2 (ID) on delete restrict on update restrict;

alter table FHP_LOST_REG add constraint FK_Reference_22 foreign key (DETAIL_ID)
      references FHP_DOUBLE_CHECK_DETAIL (ID) on delete restrict on update restrict;

alter table FHP_LOST_REG add constraint FK_Reference_23 foreign key (WOMAN_ID)
      references FHP_FERTILE_WOMAN (ID) on delete restrict on update restrict;



drop view if EXISTS fhp_fertile_woman_view ;
create view fhp_fertile_woman_view as
select fw.ID,fw.TYPEH,fw.`CODE`,fw.nameh,fw.AREA,p.age,p.CERT_TYPE,p.`CODE` as cert_Code,p.DOMICILE_TYPE,p.KIND,bc.IS_AGREE,gi.ID as gi_id,gi.RECORD_TYPE,gi.TYPEH as gi_typeh
from fhp_fertile_woman fw 
left join fhp_person p on fw.PERSON_ID=p.ID
left join fhp_birth2_apply ba on ba.WOMAN_ID = fw.ID
left join fhp_birth2_check bc on bc.APPLY_ID = ba.ID
left join FHP_GET_IUD gi on fw.ID = gi.WOMAN_ID
order by fw.id asc;

drop view if EXISTS fhp_fertile_woman_dc_view  ;
create view fhp_fertile_woman_dc_view as 
select 
CONCAT(fw.id,'_',dc.DC_ID) as id,fw.id as id_,fw.nameh,fw.`CODE`,fw.TYPEH,fw.AREA
,wb.MARRY_STATUS,wb.SPOUSE_MARRY_STATUS
,dc.DC_ID as dc_id,dc.TYPEH as dc_typeh ,dc.CAUSE,dc.`START`
,dc2.`YEAR`
,p.age,p.DOMICILE_TYPE,p.`CODE` as cert_code
,pb.JOB,pb.COMPANY,pb.HOUSEHODE_KIND,pb.HOUSE_NO
#,sp.NAMEH as sp_nameh
,(select count(1) from fhp_woman_children where PERSON_ID = fw.PERSON_ID and sex = 1) as boy_count
,(select count(1) from fhp_woman_children where PERSON_ID = fw.PERSON_ID and sex = 2) as girl_count
,wc.METHOD,wc.NO_CAUSE,wc.OPS_DATE
from fhp_fertile_woman as fw 
left join fhp_double_check as dc on fw.ID = dc.WOMAN_ID
left join fhp_woman_basic as wb on fw.id = wb.WOMAN_ID
left join fhp_person as p on fw.PERSON_ID = p.ID
left join fhp_person_basic as pb on fw.PERSON_ID = pb.PERSON_ID
#left join fhp_spouse as sp on fw.PERSON_ID = sp.PERSON_ID
left join FHP_WOMAN_CONTRACEPT as wc on fw.ID = wc.WOMAN_ID
left join fhp_double_check2 as dc2 on dc.DC_ID = dc2.ID;

drop view if EXISTS fhp_ass_view;
create view fhp_ass_view as
select fw.ID,fw.TYPEH,fw.ASS_STATUS,fw.`CODE`,fw.nameh,fw.AREA,pb.BIRTHDAY,pb.HOUSEHODE_KIND,pb.MARRY_STATUS,wcn.METHOD,sp.NAMEH as sp_nameh,
(select count(1) from fhp_woman_children as wc1 where wc1.sex = 1 and wc1.PERSON_ID = fw.PERSON_ID) as boy_Count,
(select count(1) from fhp_woman_children as wc2 where wc2.sex = 2 and wc2.PERSON_ID = fw.PERSON_ID) as girl_Count
from fhp_fertile_woman as fw 
left join fhp_person_basic as pb on fw.PERSON_ID = pb.PERSON_ID
left join FHP_WOMAN_CONTRACEPT as wcn on fw.ID = wcn.WOMAN_ID
left join FHP_SPOUSE as sp on fw.PERSON_ID = sp.PERSON_ID;


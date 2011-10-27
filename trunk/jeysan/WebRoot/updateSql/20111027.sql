/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011-10-27 21:21:25                          */
/*==============================================================*/
drop table if EXISTS FHP_CONFIRM_DC_OBJ ;
drop table if EXISTS  FHP_DOUBLE_CHECK;
drop table if EXISTS  FHP_DOUBLE_CHECK2;
drop table if EXISTS  FHP_DOUBLE_CHECK_DETAIL;

drop table if exists FHP_DOUBLE_CHECK;

drop table if exists FHP_DOUBLE_CHECK_OBJECT;

drop table if exists FHP_LOST_REG;

/*==============================================================*/
/* Table: FHP_DOUBLE_CHECK                                      */
/*==============================================================*/
create table FHP_DOUBLE_CHECK
(
   ID                   bigint not null auto_increment,
   TOTAL                tinyint,
   YEAR                 int,
   SEQ                  tinyint comment '第几次双查',
   START                varchar(7),
   END                  varchar(7),
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DOUBLE_CHECK_OBJECT                               */
/*==============================================================*/
create table FHP_DOUBLE_CHECK_OBJECT
(
   ID                   bigint not null auto_increment,
   DC_ID                bigint,
   WOMAN_ID             bigint comment '妇女id为空时，表示此行为通用的双查轮次设定',
   ISSINGLE             tinyint comment '个人
            整体',
   YEAR                 int,
   TOTAL                tinyint,
   SEQ                  tinyint comment '第几次双查',
   TYPEH                int comment '应查、免查、不查',
   CAUSE                varchar(50),
   START                varchar(7),
   END                  varchar(7),
   DC_STATUS            int comment '已确定、已查、未查',
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
/* Table: FHP_LOST_REG                                          */
/*==============================================================*/
create table FHP_LOST_REG
(
   ID                   bigint not null auto_increment,
   DCB_ID               bigint not null comment '
            ',
   LDW_STATUS           int comment '未处理、已处理',
   LDW_CONTENT          varchar(50),
   LDW_DATE             date,
   MONEYH               double,
   PAY_DATE             date,
   CASHIER              varchar(20),
   primary key (ID)
);

alter table FHP_DOUBLE_CHECK_OBJECT add constraint FK_Reference_19 foreign key (WOMAN_ID)
      references FHP_FERTILE_WOMAN (ID) on delete restrict on update restrict;

alter table FHP_DOUBLE_CHECK_OBJECT add constraint FK_Reference_43 foreign key (DC_ID)
      references FHP_DOUBLE_CHECK (ID) on delete restrict on update restrict;

alter table FHP_LOST_REG add constraint FK_Reference_42 foreign key (DCB_ID)
      references FHP_DOUBLE_CHECK_OBJECT (ID) on delete restrict on update restrict;


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
   OBJ_TYPE             int comment 'Ӧ�顢��顢����',
   WOMAN_ID             bigint,
   DC_STATUS            int comment '�Ѳ顢δ��',
   DC_DATE              date,
   DC_RESULT1           int comment '������
            ������
            ����λ
            ����',
   DC_RESULT2           int comment '����
            δ����',
   HOSPITAL             varchar(50) comment 'Ӧ�顢��顢����',
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
   WOMAN_ID             bigint comment '��ŮidΪ��ʱ����ʾ����Ϊͨ�õ�˫���ִ��趨',
   DETAIL_ID            bigint not null,
   TYPEH                int comment 'Ӧ�顢��顢����',
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
   SEQ                  tinyint comment '�ڼ���˫��',
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
   LDW_STATUS           int comment 'δ�����Ѵ���',
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


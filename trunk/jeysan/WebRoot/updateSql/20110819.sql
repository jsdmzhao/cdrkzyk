alter table fhp_woman_upbring_detail drop COLUMN count;
alter table fhp_woman_upbring_detail add COLUMN counth INTEGER null;
alter table FHP_WOMAN_SOCIAL_UPBRING add COLUMN IS_PAYUP TINYINT null;
alter table FHP_WOMAN_SOCIAL_UPBRING add COLUMN YET_MONEY DOUBLE null;
alter table FHP_WOMAN_UPBRING_DETAIL add COLUMN FACT_MONEY DOUBLE null;
alter table FHP_WOMAN_SOCIAL_UPBRING add COLUMN INSTALLMENT_NUM TINYINT null;




/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2011-8-14 17:02:39                           */
/*==============================================================*/


drop table if exists FHP_DISTRICT_CITY;

drop table if exists FHP_DISTRICT_COUNTY;

drop table if exists FHP_DISTRICT_PROVINCE;

drop table if exists FHP_DISTRICT_TOWN;

drop table if exists FHP_DISTRICT_VILLAGE;

/*==============================================================*/
/* Table: FHP_DISTRICT_CITY                                     */
/*==============================================================*/
create table FHP_DISTRICT_CITY
(
   ID                   int not null,
   CODE                 varchar(12),
   NAME                 varchar(255),
   PARENT_ID            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DISTRICT_COUNTY                                   */
/*==============================================================*/
create table FHP_DISTRICT_COUNTY
(
   ID                   int not null,
   CODE                 varchar(12),
   NAME                 varchar(255),
   PARENT_ID            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DISTRICT_PROVINCE                                 */
/*==============================================================*/
create table FHP_DISTRICT_PROVINCE
(
   ID                   int not null auto_increment,
   CODE                 varchar(12),
   NAME                 varchar(255),
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DISTRICT_TOWN                                     */
/*==============================================================*/
create table FHP_DISTRICT_TOWN
(
   ID                   int not null,
   CODE                 varchar(12),
   NAME                 varchar(255),
   PARENT_ID            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: FHP_DISTRICT_VILLAGE                                  */
/*==============================================================*/
create table FHP_DISTRICT_VILLAGE
(
   ID                   int not null,
   CODE                 varchar(12),
   NAME                 varchar(255),
   PARENT_ID            int,
   primary key (ID)
);

alter table FHP_DISTRICT_CITY add constraint FK_Reference_38 foreign key (PARENT_ID)
      references FHP_DISTRICT_PROVINCE (ID) on delete restrict on update restrict;

alter table FHP_DISTRICT_COUNTY add constraint FK_Reference_39 foreign key (PARENT_ID)
      references FHP_DISTRICT_CITY (ID) on delete restrict on update restrict;

alter table FHP_DISTRICT_TOWN add constraint FK_Reference_40 foreign key (PARENT_ID)
      references FHP_DISTRICT_COUNTY (ID) on delete restrict on update restrict;

alter table FHP_DISTRICT_VILLAGE add constraint FK_Reference_41 foreign key (PARENT_ID)
      references FHP_DISTRICT_TOWN (ID) on delete restrict on update restrict;


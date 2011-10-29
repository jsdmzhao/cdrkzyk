drop table if EXISTS fhp_lost_reg;
alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN CASHIER              varchar(20);
alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN    PAY_DATE             date;
 alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN   MONEYH               double;
 alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN   LDW_DATE             date;
 alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN   LDW_CONTENT          varchar(50);
  alter table FHP_DOUBLE_CHECK_OBJECT add COLUMN  LDW_STATUS           int comment '未处理、已处理';
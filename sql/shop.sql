drop table if exists goods;
create table goods (
  good_id bigint(20) not null  primary key auto_increment comment '商品id',
  category_id int not null comment '商品类别id' ,
  good_name VARCHAR(64) not null comment '商品名称',
  original_price  DECIMAL(19,2) not null comment '原价',
  members_price  DECIMAL(19,2) not null comment '会员价',
  picture VARCHAR(256) default '' comment '商品图片保存地址',
  good_inventory int DEFAULT 0 comment '库存',
  status VARCHAR(1) default '0' comment '状态',
  sales int DEFAULT '0' comment '销量',
  goods_weight int default 0 comment '商品权重',
  INDEX(good_name,category_id)
)auto_increment=100 comment = '商品表(goods)';


drop table if EXISTS spending;
create table spending (
  spending_id int PRIMARY key auto_increment comment '支出id',
  spending_name varchar(64) not null comment '支出名称'

) auto_increment = 100000 comment = '支出项目表';

drop table if EXISTS account;
create table account (
  account_id bigint(20) PRIMARY  key auto_increment comment '账单id',
  account_type VARCHAR(1) default '1' comment '类别 0收入 1支出',
  account_item_id int  comment '商品id或支出项目id',
  account_item varchar(64) comment '项目名称',
  record_time datetime  comment '记录时间',
  price DECIMAL(19,2) default 0 comment '金额',
  agent varchar(32) not null  comment '经办人',
  members_id int comment '会员id'
) auto_increment = 100000 comment = '账本表';

drop table if EXISTS members;
create table members (
  members_num int primary key auto_increment comment '会员卡号',
  phone_id varchar(16) not null UNIQUE comment '电话号',
  mambers_name varchar(16)  not null comment '姓名',
  create_time datetime  DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  upload_time datetime  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '上次充值日期',
  balance DECIMAL(19,2) default 0 comment '余额'
)auto_increment = 1000000000 comment = '会员表';
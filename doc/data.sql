CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL auto_increment,
  `username` varchar(32) DEFAULT '' comment '用户名',
  `password` varchar(32) DEFAULT '' comment '密码',
  `role_id` varchar(32) DEFAULT '' comment '角色ID',
  `mobile` varchar(32) DEFAULT '' comment '手机号',
  `email` varchar(64) DEFAULT '' comment '邮箱',
  `token` varchar(64) DEFAULT '' comment 'token',
  `login_time` datetime DEFAULT '' comment '登陆时间',
  `logout_time` datetime DEFAULT '' comment '登出时间',
  `c_uid` varchar(32) DEFAULT '' comment '创建人ID',
  `c_time` datetime DEFAULT '' comment '创建时间',
  `e_uid` varchar(32) DEFAULT '' comment '编辑人ID',
  `e_time` datetime DEFAULT '' comment '编辑时间',
  `description` varchar(64) DEFAULT '' comment '备注',
  primary key(id),
  UNIQUE KEY  username
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `page_id` varchar(64) not null default '',
  `c_uid` varchar(32) DEFAULT '' comment '创建人ID',
  `c_time` datetime DEFAULT '' comment '创建时间',
  `description` varchar(64) DEFAULT '' comment '备注',
  primary key(id)

)


CREATE TABLE `t_operation_log` (
  `id` bigint(20) NOT NULL auto_increment,
  user_name int(11) DEFAULT 0 comment '用户id',
  log_type varchar(32)  DEFAULT '' comment '日志类型',
  log_name varchar(32)  DEFAULT '' comment '业务类型',
  module_name varchar(32) DEFAULT '' comment '系统模块名',
  ip_address varchar(32) DEFAULT '' comment 'ip 地址',
  successed varchar(16) DEFAULT '' comment '是否成功',
  c_time datetime  comment '创建时间',
  complete_time datetime comment '完成时间',
  msg varchar(64) DEFAULT '' comment '信息',
  primary key(id),
  key (`c_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `t_banks` (
  `id` bigint(20) NOT NULL auto_increment,
  bank_name varchar(64) not null DEFAULT '' comment '银行名字',
  level smallint not null DEFAULT 0 comment '银行级别',
  address varchar(128) not null DEFAULT '' comment '银行地址',
  ip_address varchar(128) not null DEFAULT '' comment '银行ip地址段',
  lng varchar(16) not null DEFAULT '' comment '经度',
  lat varchar(16) not null DEFAULT '' comment '维度',
  c_time datetime comment '创建时间',
  c_uid int default 0 comment '创建人ID',
  e_time datetime comment '编辑时间',
  e_uid int default 0 comment '编辑人ID',
  primary key (id)
  );

-- 威胁次数
create table t_threat(
  id int(11) NOT NULL ,
  device_ip varchar(32) not null default '' comment '主机IP',
  name varchar(32) not null default '',
  start_time datetime ,
  end_time datetime,
  threat_type varchar(32),
  sip varchar(32) not null default '' comment '源ip',
  dip varchar(32) not null default '' comment '目标ip',
  protocol varchar(16) not null default '' comment '协议',
  severity varchar(8) not null default '' comment '级别',
  attack_num bigint not null default 0 comment '攻击次数',
  c_time datetime,
  primary key(id),
  key(start_time,end_time)
);
--
create table t_app_rank(
  id int(11) NOT NULL auto_increment,
  device_ip varchar(32) not null default '' comment '主机IP',
  app_type varchar(32) not null default '' comment '类型',
  app_sub_type varchar(32) not null default '' comment '子类型',
  app_name varchar(32) not null default '',
  total_stream bigint not null default 0 comment '总流量',
  c_time datetime,
  primary key(id),
  key(c_time));

-- 用户流量排名

create table t_user_rank(
  id int(11) NOT NULL auto_increment,
  device_ip varchar(32) not null default '' comment '主机IP',
  user varchar(32) not null default '' comment '用户IP',
  total_stream bigint not null default 0 comment '总流量',
   c_time datetime,
  primary key(id),
  key(c_time)
);

create table t_device_load(
  id int(11) NOT NULL auto_increment,
  device_ip varchar(32) not null default '' comment '主机IP',
  cpu varchar(8) not null default '' comment 'cpu负载',
  memory varchar(8) not null default '' comment '内存负载',
  sessions bigint not null default 0 comment '连接数',
  device_type tinyint comment '1:防火墙2F5',
  c_time datetime,
  primary key(id),
  key(c_time)
);

create table t_total_stream(
  id int(11) NOT NULL auto_increment,
  device_ip varchar(32) not null default '' comment '主机IP',
  device_port varchar(16) not null default '' comment '接口名字',
  up_traffic  bigint not null default 0 comment '上行流量',
  down_traffic bigint not null default 0 comment '下行流量',
  device_type tinyint comment '1:防火墙2F5',
  c_time datetime,
  primary key(id),
  key(c_time)
);


create table t_request_log(
  id int(11) NOT NULL auto_increment,
  bank_id smallint comment '支行ID',
  ip varchar(16) not null default '' comment 'ip',
  client_ip varchar(16) not null default '' comment 'client_ip',
  server_ip varchar(16) not null default '' ,
  server_port smallint not null default 0 ,
  virtual_ip varchar(16) not null default '' ,
  virtual_port   smallint not null default 0 ,
  virtual_name varchar(64) not null default '' ,
  virtual_pool_name  varchar(64) not null default '' ,
  response_size int not null default 0 ,
  response_time int not null default 0 comment '响应时间ms',
  http_statcode smallint not null default 0 comment '状态码',
  c_time datetime ,
  primary key(id),
  key(c_time))

create table t_f5_vs_stat (
id int not null AUTO_INCREMENT ,
vs_name varchar(64) not null default '' comment 'VS 名字',
connections bigint   comment '当前连接数',
net_in bigint   comment '入口流量',
net_out bigint  comment  '出口流量',
c_time datetime comment '时间',
primary key (id),
key (c_time)
);


create table t_f5_vs_info(
  id int not null AUTO_INCREMENT ,
  vs_name varchar(64) not null default '' comment 'VS 名字',
  vs_state varchar(16) not null default '',
  vs_conn bigint default 0,
  pool_name varchar(64) not null default '',
  server_name  varchar(64) not null default '',
  server_address varchar(64) not null default '',
  server_state varchar(16) not null default '',

  c_time datetime ,
  primary key(id),
  key(c_time)
);


create table t_from_to(
  id int not null AUTO_INCREMENT ,
  from_bank varchar(64),
  to_bank varchar(64),
  c_time datetime ,
  primary key(id),
  UNIQUE KEY from_to (from_bank,to_bank)
);

CREATE TABLE `t_f5_access_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_time` datetime DEFAULT NULL,
  `success_num` int(11) DEFAULT NULL comment '成功次数',
  `fail_num` int(11) DEFAULT NULL comment '失败次数',
  `bank_id` int(11) DEFAULT NULL comment '银行id',
  `virtual_name` varchar(64) DEFAULT NULL 'vs name',
  `success_rate` varchar(8) DEFAULT NULL '成功率',
  PRIMARY KEY (`id`),
  KEY `c_time` (`c_time`)
)






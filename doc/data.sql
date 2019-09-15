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
  log_type varchar(32)  DEFAULT '' comment '日志类型',
  log_name varchar(32)  DEFAULT '' comment '业务类型',
  user_id varchar(32) DEFAULT '' comment '用户名',
  module_name varchar(32) DEFAULT '' comment '用户名',
  ip_address varchar(32) DEFAULT '' comment 'ip 地址',
  successed varchar(16) DEFAULT '' comment '是否成功'
  c_time datetime  comment '创建时间',
  complete_time datetime comment '完成时间',
  msg varchar(64) DEFAULT '' comment '信息',
  primary key(id),
  key (`c_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `t_login_log` (
  `id` bigint(20) NOT NULL auto_increment,
  log_type varchar(32)  DEFAULT '' comment '日志类型',
  log_name varchar(32)  DEFAULT '' comment '业务类型',
  user_id varchar(32) DEFAULT '' comment '用户名',
  ip_address varchar(32) DEFAULT '' comment 'ip 地址',
  successed varchar(16) DEFAULT '' comment '是否成功'
  `c_time` datetime DEFAULT '' comment '创建时间',
  complete_time datetime comment '完成时间',
  `msg` varchar(64) DEFAULT '' comment '邮箱',

  primary key(id),
  key (`c_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_hosts` (

  `id` bigint(20) NOT NULL auto_increment,
  uuid varchar(64)  DEFAULT '' comment '主机uuid',
  zone_uuid varchar(64)  DEFAULT '' comment 'zone uuid',
  cluster_uuid varchar(64)  DEFAULT '' comment 'cluster uuid',
  image_uuid varchar(64)  DEFAULT '' comment 'cluster uuid',
  host_uuid varchar(64)  DEFAULT '' comment 'host uuid',
  instance_offering_uuid DEFAULT '' comment '计算规格UUID',
  root_volume_uuid DEFAULT '' comment ' 根云盘UUID',
  name varchar(32)  DEFAULT '' comment '主机名',
  cpu_num smallint DEFAULT 0 comment 'cpu数量',
  memory_size varchar(32) DEFAULT '' comment '内存信息',
  state varchar(16) DEFAULT '' comment '主机状态',
  platform varchar(32) DEFAULT '' comment '主机类型',
 primary key(id)) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_device` (
  `id` int(11) NOT NULL auto_increment,
  name varchar(32)  DEFAULT '' comment '组名称',
  device_ip varchar(32) default '' comment "设备ip",
  device_port smallint default 0 comment "设备端口",
  device_type varchar(16) default '' comment '设备类型',
  device_stat varchar(16) default '' comment '设备状态',
  device_status varchar(16) default '' comment '启用、禁用',
  c_time datetime DEFAULT null comment '创建时间',
  c_uid int DEFAULT 0 comment '创建人',
  e_time datetime DEFAULT null comment '编辑时间',
  e_uid int DEFAULT 0 comment '编辑人',
  primary key(id)) comment '设备信息';







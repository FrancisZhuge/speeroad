DROP TABLE IF EXISTS em_user;
CREATE TABLE IF NOT EXISTS em_user (
  id BIGINT NOT NULL auto_increment COMMENT '设置主键自增',
  username varchar(128) NOT NULL COMMENT '用户名',
  password varchar(128) NOT NULL COMMENT '密码',
  nickname varchar(128) default NULL COMMENT '用户名',
  uuid varchar(128) NOT NULL COMMENT 'uuid',
  type varchar(32) not null COMMENT '类型',
  created bigint not null COMMENT '创建时间',
  modified bigint not null COMMENT '修改时间',
  activated bool not null default false COMMENT '是否有效',
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;
-- -----
-- 用户表
-- -----
DROP TABLE IF EXISTS ease_user;
CREATE TABLE IF NOT EXISTS ease_user (
  id BIGINT NOT NULL auto_increment COMMENT '设置主键自增',
  username VARCHAR(100) NOT NULL COMMENT '用户名',
  password varchar(100) NOT NULL COMMENT '密码 md5加密',
  ease_password varchar (100) NOT NULL COMMENT '访问easemob的密码',
  salt varchar(16) not null comment '盐',
  uuid varchar (64) NOT NULL COMMENT 'easemob返回uuid',
  create_time BIGINT not null comment '创建时间',
  modify_time BIGINT not null comment '修改时间',
  device_token varchar (256) comment '设备token',
  active bool not null default false comment '是否有效0-false-无效， 1-true-有效',
  nickname VARCHAR(100) COMMENT '用户昵称',
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;
CREATE UNIQUE INDEX idx_ease_user_username ON ease_user(username);

DROP TABLE IF EXISTS ease_token;
CREATE TABLE IF NOT EXISTS ease_token(
  id BIGINT NOT NULL auto_increment COMMENT '设置主键自增',
  user_id BIGINT NOT NULL COMMENT '用户id',
  token varchar(128) NOT NULL COMMENT 'ticket',
  expired DATETIME COMMENT '过期时间',
  status INT NULL DEFAULT 0 COMMENT '状态，登出改为1',
  PRIMARY KEY  (id)
)CHARSET=utf8 ENGINE=InnoDB;
create unique INDEX idx_ease_token_token on ease_token(token);

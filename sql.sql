CREATE DATABASE IF Not EXISTS springboot CHARACTER SET UTF8;

USE springboot;

-- 菜单表

DROP TABLE IF EXISTS td_menu;

CREATE TABLE td_menu (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  is_expand TINYINT(1) DEFAULT '0' COMMENT '是否展开菜单(0:不展开,1:展开)',
  name varchar(50) NOT NULL COMMENT '菜单名称',
  sort INT(11) COMMENT '排序',
  parent_id INT(11) NOT NULL DEFAULT '-10'	COMMENT '上级id',
  url VARCHAR(50) COMMENT '菜单跳转url',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- 用户表

DROP TABLE IF EXISTS td_user;

CREATE TABLE td_user (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_name varchar(50) NOT NULL UNIQUE COMMENT '用户名称',
  nick_name varchar(50) COMMENT '用户昵称',
  password VARCHAR(50) NOT NULL COMMENT '用户密码',
  authority INT(11) NOT NULL DEFAULT '1' COMMENT '用户权限(0:管理员,1:普通用户)',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

INSERT INTO td_user (user_name,password,authority) VALUES ('admin',MD5('admin'),0);

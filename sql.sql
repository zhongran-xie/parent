CREATE DATABASE IF Not EXISTS `springboot` CHARACTER SET UTF8;

USE `springboot`;

-- 商品表

DROP TABLE IF EXISTS `td_product`;

CREATE TABLE `td_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shop_id` int(11) DEFAULT '0' COMMENT '商家ID',
  `product_name` varchar(50) NOT NULL COMMENT '商品名称',
  `product_type` int(11) NOT NULL DEFAULT '1' COMMENT '商品类型(1:虚拟商品;2:实体商品)',
  `product_price` decimal(18,2) NOT NULL COMMENT '商品价格',
  `product_stock` int(11) NOT NULL DEFAULT '0' COMMENT '商品库存',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_valid` int(11) DEFAULT '1' COMMENT '是否有效（0：无效 1：有效）',
  `is_alipay` int(11) DEFAULT NULL COMMENT '是否支持支付宝（0：不支持 1：支持）',
  `is_wechat` int(11) DEFAULT NULL COMMENT '是否支持微信（0：不支持 1：支持）',
  `is_remaining_sum` int(11) NOT NULL DEFAULT '0' COMMENT '是否支持余额（0：不支持 1：支持）',
  `product_putaway` int(11) NOT NULL DEFAULT '0' COMMENT '是否上架(0:下架,1:上架)',
  `product_code` varchar(50) DEFAULT NULL COMMENT '商品编码',
  `product_auth` int(11) DEFAULT '1' COMMENT '审核状态(1:待审核;2:审核通过;3:审核不通过;)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品信息';

-- 菜单表

DROP TABLE IF EXISTS `td_menu`;

CREATE TABLE `td_menu` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `is_expand` TINYINT(1) DEFAULT '0' COMMENT '是否展开菜单(0:不展开,1:展开)',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `sort` INT(11) COMMENT '排序',
  `parent_id` INT(11) NOT NULL DEFAULT '-10'	COMMENT '上级id',
  `url` VARCHAR(50) COMMENT '菜单跳转url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- 用户表

DROP TABLE IF EXISTS `td_user`;

CREATE TABLE `td_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(50) NOT NULL UNIQUE COMMENT '用户名称',
	`nick_name` varchar(50) COMMENT '用户昵称',
  `password` VARCHAR(50) NOT NULL COMMENT '用户密码',
	`authority` INT(11) NOT NULL DEFAULT '1' COMMENT '用户权限(0:管理员,1:普通用户)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

INSERT INTO `td_user` (`user_name`,`password`,`authority`) VALUES ('admin','admin',0);

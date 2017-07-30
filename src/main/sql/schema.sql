--数据库初始化脚本

--创建数据库
CREATE DATABASE seckill
-- 使用数据库

use seckill;

CREATE TABLE seckill(
  `seckill_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id' ,
  `name`  varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称' ,
  `number`  int(11) NOT NULL COMMENT '库存数量' ,
  `start_time`  timestamp NULL DEFAULT NULL COMMENT '秒杀开始时间' ,
  `end_time`  timestamp NULL DEFAULT NULL COMMENT '秒杀结束时间' ,
  `create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '秒杀创建时间' ,
  PRIMARY KEY (`seckill_id`),
  INDEX `idx_create_time` (`create_time`) USING BTREE ,
  INDEX `idx_end_time` (`end_time`) USING BTREE ,
  INDEX `idx_start_time` (`start_time`) USING BTREE
)ENGINE=InnoDB AUTO_INCREAMENT=10000 DEFAULT CHARSET = UTF8 COMMENT='秒杀库存表';


--初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iphone6',100,'2017-07-30 00:00:00','2017-07-31 00:00:00'),
  ('500元秒杀ipad2',200,'2017-07-30 00:00:00','2017-07-31 00:00:00'),
  ('300元秒杀小米4',300,'2017-07-30 00:00:00','2017-07-31 00:00:00'),
  ('200元秒杀红米note',400,'2017-07-30 00:00:00','2017-07-31 00:00:00');


--秒杀成功明细表
--用户登录认证的相关的信息
CREATE TABLE success_killed(
  `seckill_id`  bigint(20) NOT NULL COMMENT '秒杀商品id' ,
  `user_phone`  bigint(20) NOT NULL COMMENT '用户手机号' ,
  `state`  tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态标识：-1：无效，0：成功，1：已付款，2：已发货' ,
  `create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
  PRIMARY KEY (`seckill_id`, `user_phone`),
  INDEX `idx_create_time` (`create_time`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='秒杀成功明细表';


--链接数据库的控制台
mysql -uroot -proot
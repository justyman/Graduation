/* 新建员工表 */
CREATE TABLE `credit_card`.`db_staff` (
  `id`       INT(6)      NOT NULL
  COMMENT '员工账号',
  `password` VARCHAR(50) NOT NULL
  COMMENT '员工密码',
  `name`     VARCHAR(20) NOT NULL
  COMMENT '员工姓名',
  `position` VARCHAR(10) NOT NULL
  COMMENT '员工职位',
  `status`   VARCHAR(10) NOT NULL
  COMMENT '员工状态',
  `phone`    INT(11)     NOT NULL
  COMMENT '员工手机',
  `count`    INT(2)      NOT NULL DEFAULT 0
  COMMENT '员工连续登陆失败次数',
  `time`     DATETIME COMMENT '员工上次尝试登陆时间',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  CHARSET = utf8;
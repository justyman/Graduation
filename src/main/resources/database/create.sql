/* 新建员工表 */
CREATE TABLE `credit_card`.`db_staff` (
  `username` VARCHAR(6)   NOT NULL
  COMMENT '员工账号',
  `password` VARCHAR(255) NOT NULL
  COMMENT '员工密码',
  `name`     VARCHAR(20)  NOT NULL
  COMMENT '员工姓名',
  `phone`    VARCHAR(11)  NOT NULL
  COMMENT '员工手机',
  `status`   VARCHAR(2)   NOT NULL DEFAULT 'Y'
  COMMENT '员工状态 Y:正常 N:冻结',
  `count`    INT(2)       NOT NULL DEFAULT 0
  COMMENT '连续登陆失败次数',
  `time`     DATETIME COMMENT '上次尝试登陆时间',
  `position` INT          NOT NULL
  COMMENT '职位ID',
  PRIMARY KEY (`username`),
  UNIQUE INDEX `UNIQUE` (`phone`),
  FOREIGN KEY (`position`) REFERENCES `credit_card`.`db_position` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建职位表 */
CREATE TABLE `credit_card`.`db_position` (
  `id`         INT(2)      NOT NULL
  COMMENT '职位ID',
  `name`       VARCHAR(20) NOT NULL
  COMMENT '职位名称',
  `permission` VARCHAR(50) NOT NULL
  COMMENT '职位权限',
  PRIMARY KEY (`id`)
)
  ENGINE = INNODB
  CHARSET = utf8;
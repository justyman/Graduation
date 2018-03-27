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
  UNIQUE INDEX `UNIQUE` (`phone`)
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建客户表 */
CREATE TABLE `credit_card`.`db_customer` (
  `id`      VARCHAR(18)  NOT NULL
  COMMENT '身份证',
  `phone`   VARCHAR(11)  NOT NULL
  COMMENT '手机号',
  `card`    VARCHAR(16)  NOT NULL
  COMMENT '卡号',
  `name`    VARCHAR(50)  NOT NULL
  COMMENT '姓名',
  `gender`  VARCHAR(6)   NOT NULL
  COMMENT '性别',
  `address` VARCHAR(255) NOT NULL
  COMMENT '地址',
  `level`   INT(2)       NOT NULL DEFAULT 1
  COMMENT '偿还等级',
  `credit`  INT(4)       NOT NULL DEFAULT 60
  COMMENT '信用评分',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UNIQUE` (`phone`)
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建偿还等级表 */
CREATE TABLE `credit_card`.`db_level` (
  `level` INT(2)         NOT NULL
  COMMENT '偿还等级',
  `max`   DECIMAL(12, 2) NOT NULL
  COMMENT '最大额度',
  PRIMARY KEY (`level`)
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建客户表外键字段 偿还等级 */
ALTER TABLE `credit_card`.`db_customer`
  ADD FOREIGN KEY (`level`) REFERENCES `credit_card`.`db_level` (`level`)
  ON UPDATE CASCADE
  ON DELETE CASCADE;

/* 新建信用评分表 */
CREATE TABLE `credit_card`.`db_credit` (
  `id`    VARCHAR(18)    NOT NULL
  COMMENT '身份证',
  `name`  VARCHAR(50)    NOT NULL
  COMMENT '姓名',
  `delay` INT(4)         NOT NULL DEFAULT 0
  COMMENT '总延期未还款次数',
  `debt`  DECIMAL(12, 2) NOT NULL DEFAULT 0.00
  COMMENT '总延期未还款金额',
  `total` INT(4)         NOT NULL DEFAULT 0
  COMMENT '总还款日次数',
  `money` DECIMAL(12, 2) NOT NULL DEFAULT 0.00
  COMMENT '总消费金额',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `credit_card`.`db_customer` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建信用卡表 */
CREATE TABLE `credit_card`.`db_card` (
  `card`   VARCHAR(16)    NOT NULL
  COMMENT '卡号',
  `id`     VARCHAR(18)    NOT NULL
  COMMENT '身份证',
  `date`   VARCHAR(8)     NOT NULL
  COMMENT '开户日期',
  `amount` DECIMAL(12, 2) NOT NULL
  COMMENT '当前额度',
  `bill`   VARCHAR(8)     NOT NULL
  COMMENT '账单日',
  `status` INT(2)         NOT NULL DEFAULT 0
  COMMENT '信用卡状态 0:正常 1:冻结 -1:注销',
  PRIMARY KEY (`card`),
  UNIQUE INDEX `UNIQUE` (`id`),
  FOREIGN KEY (`id`) REFERENCES `credit_card`.`db_customer` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 新建客户表外键字段 信用卡卡号 */
ALTER TABLE `credit_card`.`db_customer`
  ADD FOREIGN KEY (`card`) REFERENCES `credit_card`.`db_card` (`card`)
  ON UPDATE CASCADE
  ON DELETE CASCADE;

/* 新建办卡信息表 */
CREATE TABLE `credit_card`.`db_case` (
  `card`      VARCHAR(16) NOT NULL
  COMMENT '办卡号',
  `channel`   VARCHAR(4)  NOT NULL
  COMMENT '渠道',
  `id`        VARCHAR(18) NOT NULL
  COMMENT '身份证',
  `staff`     VARCHAR(6)  NOT NULL
  COMMENT '业务人员id',
  `emergency` INT(2)      NOT NULL
  COMMENT '紧急程度',
  `deadline`  INT(2)      NOT NULL DEFAULT 7
  COMMENT '处理期限 默认7天',
  `time`      DATETIME    NOT NULL
  COMMENT '受理时间',
  PRIMARY KEY (`card`),
  UNIQUE INDEX (`id`, `time`),
  FOREIGN KEY (`card`) REFERENCES `credit_card`.`db_card` (`card`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY (`id`) REFERENCES `credit_card`.`db_customer` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  FOREIGN KEY (`staff`) REFERENCES `credit_card`.`db_staff` (`username`)
    ON UPDATE CASCADE
    ON DELETE NO ACTION
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 创建修改密码表 */
CREATE TABLE `credit_card`.`db_reset` (
  `username`  VARCHAR(6)   NOT NULL
  COMMENT '员工账号',
  `password`  VARCHAR(255) NOT NULL
  COMMENT '员工密码',
  `resetword` VARCHAR(255) NOT NULL
  COMMENT '重置的新密码',
  `reason`    VARCHAR(255) NOT NULL
  COMMENT '重置密码原因',
  `time`      DATETIME     NOT NULL
  COMMENT '申请时间',
  PRIMARY KEY (`username`),
  UNIQUE INDEX `UNIQUE` (`time`, `username`),
  FOREIGN KEY (`username`) REFERENCES `credit_card`.`db_staff` (`username`)
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 创建日志表 */
CREATE TABLE `credit_card`.`db_log` (
  `id`      INT          NOT NULL AUTO_INCREMENT
  COMMENT '日志id',
  `time`    DATETIME     NOT NULL
  COMMENT '日志时间',
  `message` VARCHAR(255) NOT NULL
  COMMENT '日志信息',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UNIQUE` (`id`, `time`)
)
  ENGINE = INNODB
  CHARSET = utf8;

/* 更新日志表 */
ALTER TABLE `credit_card`.`db_log`
  ADD COLUMN `username` VARCHAR(6) NOT NULL
COMMENT '员工账号'
  AFTER `time`,
  DROP INDEX `UNIQUE`,
  ADD UNIQUE INDEX `UNIQUE` (`time`, `username`, `id`),
  ADD FOREIGN KEY (`username`) REFERENCES `credit_card`.`db_staff` (`username`);

/* 简化员工表 */
ALTER TABLE `credit_card`.`db_staff`
  DROP COLUMN `count`,
  DROP COLUMN `time`,
  DROP INDEX `position`;

/* 新增员工头像字段 */
ALTER TABLE `credit_card`.`db_staff`
  ADD COLUMN `image` VARCHAR(20) NULL COMMENT '员工头像' AFTER `phone`;

/* 新增员工性别、出生年月、入职日期字段 */
ALTER TABLE `credit_card`.`db_staff`
  ADD COLUMN `sex` VARCHAR(2) NULL COMMENT '员工性别' AFTER `name`,
  ADD COLUMN `birth` DATE NULL COMMENT '员工出生年月' AFTER `sex`,
  ADD COLUMN `entry` DATE NULL COMMENT '员工入职日期' AFTER `image`;
ALTER TABLE `credit_card`.`db_staff`
  CHANGE `sex` `sex` VARCHAR(2) CHARSET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工性别',
  CHANGE `birth` `birth` DATE NOT NULL COMMENT '员工出生年月',
  CHANGE `entry` `entry` DATE NOT NULL COMMENT '员工入职日期';
ALTER TABLE `credit_card`.`db_staff`
  CHANGE `image` `image` VARCHAR(20) CHARSET utf8 COLLATE utf8_general_ci DEFAULT 'null.png' NOT NULL COMMENT '员工头像';

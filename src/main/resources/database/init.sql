/* 初始化职位表 */
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('0', '超级管理员', '00');
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('1', '业务人员', '01');
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('2', '审批人员', '02');

/* 初始化员工表 */
INSERT INTO `credit_card`.`db_staff` (`username`, `password`, `name`, `phone`, `position`) VALUES ('admin', 'admin', '张亮', '18926037091', '0');

/* 初始化偿还等级表 */
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('1', '2000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('2', '3000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('3', '4000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('4', '5000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('5', '6000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('6', '7000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('7', '8000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('8', '9000.00');
INSERT INTO `credit_card`.`db_level` (`level`, `max`) VALUES ('9', '10000.00');
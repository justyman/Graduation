/* 初始化职位表 */
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('0', '超级管理员', '00');
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('1', '业务人员', '01');
INSERT INTO `credit_card`.`db_position` (`id`, `name`, `permission`) VALUES ('2', '审批人员', '02');

/* 初始化员工表 */
INSERT INTO `credit_card`.`db_staff` (`username`, `password`, `name`, `phone`, `position`) VALUES ('admin', 'admin', '张亮', '18926037091', '0');
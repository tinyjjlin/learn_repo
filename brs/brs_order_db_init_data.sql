INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('clientGroup', '订单客户');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('managerGroup', '订单经理');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('editorDirectorGroup', '订单编辑主管');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('editorGroup', '订单编辑');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('dataProcessorGroup', '订单数据处理人员');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('submitterGroup', '订单投稿人');
INSERT INTO `brs_order`.`act_id_group` (`ID_`, `NAME_`) VALUES ('dataDirectorGroup', '订单数据主管');

INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100011', '僧', '唐');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100022', '悟空', '孙');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100033', '八戒', '猪');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100044', '和尚', '沙');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100055', '龙马', '白');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100066', '魔王', '牛');
INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100077', '娥', '嫦');

INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100011', 'clientGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100022', 'managerGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100033', 'editorDirectorGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100044', 'editorGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100055', 'dataDirectorGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100066', 'dataProcessorGroup');
INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100077', 'submitterGroup');



INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100122', '帝', '玉');

INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100122', 'managerGroup');


INSERT INTO `brs_order`.`act_id_user` (`ID_`, `FIRST_`, `LAST_`) VALUES ('100133', '白', '李');

INSERT INTO `brs_order`.`act_id_membership` (`USER_ID_`, `GROUP_ID_`) VALUES ('100133', 'editorDirectorGroup');







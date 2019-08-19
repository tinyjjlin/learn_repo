CREATE TABLE `brs_idm`.`brs_user` (
  `id_` VARCHAR(64) NOT NULL,
  `first_` VARCHAR(255) NULL,
  `last_` VARCHAR(255) NULL,
  `email_` VARCHAR(255) NULL,
  `pwd_` VARCHAR(255) NULL,
  `pictrue_id_` VARCHAR(64) NULL,
  PRIMARY KEY (`id_`));

ALTER TABLE `brs_idm`.`brs_user` 
RENAME TO  `brs_idm`.`brs_idm_user` ;

CREATE TABLE `brs_idm`.`brs_idm_role` (
  `id_` VARCHAR(64) NOT NULL,
  `name_` VARCHAR(255) NULL,
  `type_` VARCHAR(255) NULL,
  PRIMARY KEY (`id_`));

CREATE TABLE `brs_idm_priv` (
  `id_` varchar(64) NOT NULL,
  `name_` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `brs_idm`.`brs_idm_membership` (
  `user_id_` VARCHAR(64) NOT NULL,
  `role_id_` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`user_id_`, `role_id_`));

CREATE TABLE `brs_idm`.`brs_idm_priv_mapping` (
  `id_` VARCHAR(64) NOT NULL,
  `priv_id_` VARCHAR(64) NOT NULL,
  `user_id_` VARCHAR(64) NULL,
  `role_id_` VARCHAR(64) NULL,
  PRIMARY KEY (`id_`));

CREATE TABLE `brs_idm`.`brs_idm_bytearray` (
  `id_` VARCHAR(64) NOT NULL,
  `name_` VARCHAR(255) NULL,
  `rev_` INT NULL,
  `bytes_` LONGBLOB NULL,
  PRIMARY KEY (`id_`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
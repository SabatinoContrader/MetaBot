SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- Schema contrader-schema-jsp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contrader-schema-jsp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `contrader-schema-jsp` ;

-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`bot_message_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`bot_message_options` (
  `bot_message_options_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bot_message_options` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`bot_message_options_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`bot_messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`bot_messages` (
  `bot_messages_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bot_messages` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`bot_messages_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`chatbots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`chatbots` (
  `chatbots_id` INT(11) NOT NULL AUTO_INCREMENT,
  `initial_message` VARCHAR(200) NOT NULL,
  `users_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`chatbots_id`),
  CONSTRAINT `fk_chatbots_users1`
    FOREIGN KEY (`users_id_fk`)
    REFERENCES `contrader-schema-jsp`.`users` (`users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_chatbots_users1_idx` ON `contrader-schema-jsp`.`chatbots` (`users_id_fk` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`nodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`nodes` (
  `nodes_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sequence` INT(11) NOT NULL COMMENT 'Sequenza per rendere intercambiabile l\'ordine delle domande',
  `chatbots_id_fk` INT(11) NOT NULL,
  `bot_messages_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`nodes_id`),
  CONSTRAINT `fk_nodes_chatbots1`
    FOREIGN KEY (`chatbots_id_fk`)
    REFERENCES `contrader-schema-jsp`.`chatbots` (`chatbots_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nodes_bot_messages1`
    FOREIGN KEY (`bot_messages_id_fk`)
    REFERENCES `contrader-schema-jsp`.`bot_messages` (`bot_messages_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_nodes_chatbots1_idx` ON `contrader-schema-jsp`.`nodes` (`chatbots_id_fk` ASC) VISIBLE;

CREATE INDEX `fk_nodes_bot_messages1_idx` ON `contrader-schema-jsp`.`nodes` (`bot_messages_id_fk` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`sub_nodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`sub_nodes` (
  `sub_nodes_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sequence` INT(11) NULL DEFAULT NULL COMMENT 'sequenza per gestire l\'ordine delle domande',
  `prossimo_nodo` INT(11) NULL,
  `nodes_id_fk` INT(11) NOT NULL,
  `bot_message_options_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`sub_nodes_id`),
  CONSTRAINT `fk_sub_nodes_nodes1`
    FOREIGN KEY (`nodes_id_fk`)
    REFERENCES `contrader-schema-jsp`.`nodes` (`nodes_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sub_nodes_bot_message_options1`
    FOREIGN KEY (`bot_message_options_id_fk`)
    REFERENCES `contrader-schema-jsp`.`bot_message_options` (`bot_message_options_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_sub_nodes_nodes1_idx` ON `contrader-schema-jsp`.`sub_nodes` (`nodes_id_fk` ASC) VISIBLE;

CREATE INDEX `fk_sub_nodes_bot_message_options1_idx` ON `contrader-schema-jsp`.`sub_nodes` (`bot_message_options_id_fk` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`user_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`user_types` (
  `user_types_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_types` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_types_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `contrader-schema-jsp`.`user_types` (`user_types_id`, `user_types`) VALUES ('0', 'ADMIN');

INSERT INTO `contrader-schema-jsp`.`user_types` (`user_types_id`, `user_types`) VALUES ('0', 'CHAT_MASTER');

-- -----------------------------------------------------
-- Table `contrader-schema-jsp`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contrader-schema-jsp`.`users` (
  `users_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `user_types_id_fk` INT(11) NOT NULL,
  PRIMARY KEY (`users_id`),
  CONSTRAINT `fk_users_user_types`
    FOREIGN KEY (`user_types_id_fk`)
    REFERENCES `contrader-schema-jsp`.`user_types` (`user_types_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_users_user_types_idx` ON `contrader-schema-jsp`.`users` (`user_types_id_fk` ASC) VISIBLE;

INSERT INTO `contrader-schema-jsp`.`users` (`users_id`, `username`, `password`, `user_types_id_fk`) VALUES ('0', 'admin', 'admin', '1');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

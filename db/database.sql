SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `alps_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `alps_db` ;

-- -----------------------------------------------------
-- Table `alps_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;

insert into user values (1, 'ate_lainee', md5('password'));

-- -----------------------------------------------------
-- Table `alps_db`.`faculty`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`faculty` (
  `id` INT NOT NULL,
  `birthdate` DATE NULL,
  `address` VARCHAR(255) NULL,
  `status` INT NULL,
  `employment_start` VARCHAR(45) NULL,
  `employment_end` VARCHAR(45) NULL,
  `photo` VARCHAR(255) NULL,
  `surname` VARCHAR(255) NULL,
  `first_name` VARCHAR(255) NULL,
  `name_ext` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_faculty_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_faculty_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `alps_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`activity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`activity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `facultyID` INT NOT NULL,
  `venue` VARCHAR(255) NULL,
  `title` VARCHAR(255) NULL,
  `type` INT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `facultyID_idx` (`facultyID` ASC),
  CONSTRAINT `facultyID`
    FOREIGN KEY (`facultyID`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`contact_number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`contact_number` (
  `id` INT NOT NULL,
  `faculty_id` INT NOT NULL,
  `number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contact_number_faculty1_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_contact_number_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`email` (
  `id` INT NOT NULL,
  `email` VARCHAR(255) NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_email_faculty1_idx` (`faculty_id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_email_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`acad_degree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`acad_degree` (
  `id` INT NOT NULL,
  `type` INT NULL,
  `title` VARCHAR(255) NULL,
  `school` VARCHAR(255) NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_acad_degree_faculty1_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_acad_degree_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`publication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`publication` (
  `id` INT NOT NULL,
  `type` INT NULL,
  `title` VARCHAR(255) NULL,
  `datePublished` DATE NULL,
  `filename` VARCHAR(255) NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_publication_faculty1_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_publication_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`subject` (
  `id` INT NOT NULL,
  `subject` VARCHAR(255) NULL,
  `time` VARCHAR(255) NULL,
  `room` VARCHAR(45) NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subject_faculty1_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_subject_faculty1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `alps_db`.`faculty` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`communication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`communication` (
  `id` INT NOT NULL,
  `type` INT NULL,
  `to_or_from` VARCHAR(255) NULL,
  `date` DATE NULL,
  `filename` VARCHAR(255) NULL,
  `title` VARCHAR(255) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_communication_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_communication_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `alps_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alps_db`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `alps_db`.`report` (
  `id` INT NOT NULL,
  `type` INT NULL,
  `date` DATE NULL,
  `requestor` VARCHAR(255) NULL,
  `lower_range` VARCHAR(45) NULL,
  `upper_range` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_report_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_report_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `alps_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

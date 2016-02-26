-- MySQL Script generated by MySQL Workbench
-- 10/16/15 11:24:21
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema exam
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema exam
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exam` DEFAULT CHARACTER SET utf8 ;
USE `exam` ;

-- -----------------------------------------------------
-- Table `exam`.`question_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`question_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(15) NOT NULL,
  `title` VARCHAR(6000) NOT NULL,
  `title_text` VARCHAR(6000) NOT NULL,
  `answer` VARCHAR(6000) NULL DEFAULT NULL,
  `question_type_id` INT NOT NULL,
  `source` VARCHAR(100) NULL DEFAULT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` DATETIME NULL DEFAULT NULL,
  `status` ENUM('new', 'accpet', 'reject') NULL DEFAULT 'new',
  `author` VARCHAR(100) NULL DEFAULT NULL,
  `author_id` INT NULL,
  `parent_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_question_question_type1_idx` (`question_type_id` ASC) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  CONSTRAINT `fk_question_question_type1`
    FOREIGN KEY (`question_type_id`)
    REFERENCES `exam`.`question_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `parent_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`question_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`question_option` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(6000) NOT NULL,
  `title_text` VARCHAR(6000) NOT NULL,
  `correct` TINYINT NOT NULL DEFAULT 0,
  `question_id` INT NOT NULL,
  `order` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) ,
  INDEX `fk_option_question1_idx` (`question_id` ASC) ,
  CONSTRAINT `fk_option_question1`
    FOREIGN KEY (`question_id`)
    REFERENCES `exam`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `job_number` VARCHAR(15) NULL,
  `name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(32) NOT NULL DEFAULT 'e397433ba52b69656be325c89581b13a',
  `icon` VARCHAR(500) NULL DEFAULT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`question_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`question_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `question_id` INT NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `created_time` DATETIME NOT NULL,
  `refer_id` INT NULL DEFAULT NULL,
  `status` ENUM('new', 'accpet') NOT NULL DEFAULT 'new',
  PRIMARY KEY (`id`) ,
  INDEX `fk_question_comment_question1_idx` (`question_id` ASC) ,
  INDEX `fk_question_comment_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_question_comment_question`
    FOREIGN KEY (`question_id`)
    REFERENCES `exam`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_comment_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_time` DATETIME NOT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `content` VARCHAR(1000) NULL,
  `entity_type` ENUM('question', 'paper', 'exam', 'api') NOT NULL,
  `entity_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_log_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_log_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `weight` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`privilege` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_user_role` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) ,
  INDEX `fk_user_has_role_role1_idx` (`role_id` ASC) ,
  INDEX `fk_user_has_role_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user_has_role_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `exam`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_role_privilege`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_role_privilege` (
  `role_id` INT NOT NULL,
  `privilege_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `privilege_id`) ,
  INDEX `fk_role_has_privilege_privilege1_idx` (`privilege_id` ASC) ,
  INDEX `fk_role_has_privilege_role1_idx` (`role_id` ASC) ,
  CONSTRAINT `fk_role_privilege_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `exam`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_privilege_privilege`
    FOREIGN KEY (`privilege_id`)
    REFERENCES `exam`.`privilege` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_question_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_question_tag` (
  `question_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`question_id`, `tag_id`) ,
  INDEX `fk_question_has_tag_tag1_idx` (`tag_id` ASC) ,
  INDEX `fk_question_has_tag_question1_idx` (`question_id` ASC) ,
  CONSTRAINT `fk_question_has_tag_question`
    FOREIGN KEY (`question_id`)
    REFERENCES `exam`.`question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_question_has_tag_tag`
    FOREIGN KEY (`tag_id`)
    REFERENCES `exam`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`question_copy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`question_copy` (
  `id` INT NOT NULL,
  `code` VARCHAR(15) NOT NULL,
  `title` VARCHAR(6000) NOT NULL,
  `title_text` VARCHAR(6000) NOT NULL,
  `answer` VARCHAR(6000) NULL,
  `question_type_id` INT NOT NULL,
  `source` VARCHAR(100) NULL DEFAULT NULL,
  `created_time` DATETIME NOT NULL,
  `updated_time` DATETIME NULL DEFAULT NULL,
  `status` ENUM('new', 'accept', 'reject') NOT NULL DEFAULT 'new',
  `author` VARCHAR(100) NULL DEFAULT NULL,
  `author_id` INT NULL DEFAULT NULL,
  `parent_id` INT NULL DEFAULT NULL,
  `is_deleted` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`paper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`paper` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(15) NOT NULL,
  `name` VARCHAR(1000) NOT NULL,
  `advice_duration` INT NULL DEFAULT NULL,
  `description` VARCHAR(6000) NULL,
  `creator_id` INT NULL,
  `created_time` DATETIME NOT NULL,
  `status` ENUM('draft', 'open', 'used', 'expired') NULL,
  `total_score` DOUBLE NOT NULL DEFAULT 0.0,
  `total_question` INT NOT NULL DEFAULT 0,
  `refer_paper_id` INT NULL,
  `shadow_of` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) ,
  INDEX `fk_paper_user_idx` (`creator_id` ASC) ,
  CONSTRAINT `fk_paper_user`
    FOREIGN KEY (`creator_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`paper_part`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`paper_part` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `total_question` INT NOT NULL DEFAULT 0,
  `total_score` DOUBLE NOT NULL DEFAULT 0.0,
  `description` VARCHAR(6000) NULL DEFAULT NULL,
  `order` INT NOT NULL DEFAULT 0,
  `paper_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_paper_part_paper1_idx` (`paper_id` ASC) ,
  CONSTRAINT `fk_paper_part_paper`
    FOREIGN KEY (`paper_id`)
    REFERENCES `exam`.`paper` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`api`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`api` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `limit` INT NULL DEFAULT NULL,
  `method` ENUM('post', 'get', 'delete', 'put', 'option') NULL DEFAULT 'get',
  `status` ENUM('close','open') NULL DEFAULT 'open',
  `url` VARCHAR(500) NULL,
  `description` VARCHAR(6000) NULL,
  `icon` VARCHAR(500) NULL,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`user_api`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`user_api` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `api_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `app_name` VARCHAR(100) NOT NULL,
  `ip` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `key` VARCHAR(1000) NOT NULL,
  `status` ENUM('new', 'accpet', 'reject') NOT NULL DEFAULT 'new',
  `reason` VARCHAR(2000) NOT NULL,
  `created_time` DATETIME NOT NULL,
  `comment` VARCHAR(2000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_api_api` (`api_id` ASC) ,
  INDEX `fk_user_api_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user_api_api`
    FOREIGN KEY (`api_id`)
    REFERENCES `exam`.`api` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_api_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`paper_question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`paper_question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(6000) NOT NULL,
  `title_text` VARCHAR(6000) NOT NULL,
  `answer` VARCHAR(6000) NULL DEFAULT NULL,
  `question_type_id` INT NOT NULL,
  `source` VARCHAR(100) NULL,
  `created_time` DATETIME NOT NULL,
  `author_id` INT NULL,
  `parent_id` INT NULL,
  `order` INT NOT NULL DEFAULT 0,
  `score` DOUBLE NOT NULL DEFAULT 0.0,
  `refer_question_id` INT NULL DEFAULT NULL,
  `paper_part_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_paper_question_paper_part1_idx` (`paper_part_id` ASC) ,
  INDEX `fk_paper_question_question_type1` (`question_type_id` ASC) ,
  CONSTRAINT `fk_paper_question_paper_part1`
    FOREIGN KEY (`paper_part_id`)
    REFERENCES `exam`.`paper_part` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_paper_question_question_type1`
    FOREIGN KEY (`question_type_id`)
    REFERENCES `exam`.`question_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`paper_question_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`paper_question_option` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(6000) NOT NULL,
  `title_text` VARCHAR(6000) NOT NULL,
  `correct` TINYINT NOT NULL DEFAULT 0,
  `paper_question_id` INT NOT NULL,
  `order` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) ,
  INDEX `fk_option_question1_idx` (`paper_question_id` ASC) ,
  CONSTRAINT `fk_option_question`
    FOREIGN KEY (`paper_question_id`)
    REFERENCES `exam`.`paper_question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`exam` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(15) NOT NULL,
  `name` VARCHAR(1000) NOT NULL,
  `description` VARCHAR(6000) NULL,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  `duration` INT NOT NULL,
  `is_published` TINYINT NOT NULL DEFAULT 0,
  `is_result_published` TINYINT NOT NULL DEFAULT 0,
  `attended_count` INT NOT NULL DEFAULT 0,
  `examinee_count` INT NOT NULL DEFAULT 0,
  `pass_rate` DOUBLE NULL,
  `pass_score` DOUBLE NULL DEFAULT NULL,
  `average` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `exam`.`examinee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`examinee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `exam_id` INT NOT NULL,
  `paper_id` INT NOT NULL,
  `score` DOUBLE NOT NULL DEFAULT 0.0,
  `attended_time` DATETIME NULL,
  `answered_count` INT NULL DEFAULT NULL,
  `comment` VARCHAR(1000) NULL DEFAULT NULL,
  `markers` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_examinee_exam` (`exam_id` ASC) ,
  INDEX `fk_examinee_user` (`user_id` ASC) ,
  CONSTRAINT `fk_examinee_exam`
    FOREIGN KEY (`exam_id`)
    REFERENCES `exam`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_examinee_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `exam`.`map_examinee_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_examinee_answer` (
  `examinee_id` INT NOT NULL,
  `paper_question_id` INT NOT NULL,
  `score` DOUBLE NULL DEFAULT NULL,
  `answer` VARCHAR(6000) NULL DEFAULT NULL,
  `comment` VARCHAR(2000) NULL DEFAULT NULL,
  `markers` VARCHAR(500) NULL DEFAULT NULL,
  INDEX `fk_map_user_paper_question_map_user_exam1_idx` (`examinee_id` ASC) ,
  PRIMARY KEY (`examinee_id`, `paper_question_id`) ,
  CONSTRAINT `fk_map_user_paper_question_map_user_exam1`
    FOREIGN KEY (`examinee_id`)
    REFERENCES `exam`.`examinee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `exam`.`message_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`message_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `template_url` VARCHAR(500) NULL,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `code_UNIQUE` (`code` ASC) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NOT NULL,
  `message_type_id` INT NOT NULL,
  `entity_id` INT NULL,
  `created_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_message_message_type1` (`message_type_id` ASC) ,
  CONSTRAINT `fk_message_message_type1`
    FOREIGN KEY (`message_type_id`)
    REFERENCES `exam`.`message_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`user_message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`user_message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NOT NULL,
  `message_type_id` INT NOT NULL,
  `received_time` DATETIME NOT NULL,
  `url` VARCHAR(500) NULL,
  `user_id` INT NOT NULL,
  `from_user_id` INT NULL DEFAULT NULL,
  `message_id` INT NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_message_message` (`message_id` ASC),
  INDEX `fk_user_message_user_idx` (`user_id` ASC),
  INDEX `fk_user_message_message_type_idx` (`message_type_id` ASC),
  CONSTRAINT `fk_user_message_message`
    FOREIGN KEY (`message_id`)
    REFERENCES `exam`.`message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_message_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_message_message_type`
    FOREIGN KEY (`message_type_id`)
    REFERENCES `exam`.`message_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `exam`.`map_exam_paper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_exam_paper` (
  `exam_id` INT NOT NULL,
  `paper_id` INT NOT NULL,
  INDEX `fk_map_exam_paper_exam1_idx` (`exam_id` ASC) ,
  PRIMARY KEY (`paper_id`, `exam_id`) ,
  CONSTRAINT `fk_map_exam_paper__exam`
    FOREIGN KEY (`exam_id`)
    REFERENCES `exam`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_map_exam_paper_paper`
    FOREIGN KEY (`paper_id`)
    REFERENCES `exam`.`paper` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`marker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`marker` (
  `exam_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`exam_id`, `user_id`) ,
  INDEX `fk_map_grader_exam_exam1_idx` (`exam_id` ASC) ,
  INDEX `fk_marker_user` (`user_id` ASC) ,
  CONSTRAINT `fk_map_grader_exam_exam`
    FOREIGN KEY (`exam_id`)
    REFERENCES `exam`.`exam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_marker_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_paper_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_paper_tag` (
  `paper_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`paper_id`, `tag_id`) ,
  INDEX `fk_map_paper_tag_paper1` (`paper_id` ASC) ,
  INDEX `fk_map_paper_tag_tag1` (`tag_id` ASC) ,
  CONSTRAINT `fk_map_paper_tag_paper1`
    FOREIGN KEY (`paper_id`)
    REFERENCES `exam`.`paper` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_map_paper_tag_tag1`
    FOREIGN KEY (`tag_id`)
    REFERENCES `exam`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`log_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`log_history` (
  `id` INT NOT NULL,
  `created_time` DATETIME NOT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `content` VARCHAR(1000) NULL,
  `entity_type` ENUM('question', 'paper', 'exam', 'api') NOT NULL,
  `entity_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_log_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_log_user0`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`message_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`message_history` (
  `id` INT NOT NULL,
  `title` VARCHAR(1000) NOT NULL,
  `message_type_id` INT NOT NULL,
  `entity_id` INT NULL,
  `created_time` DATETIME NOT NULL,
  PRIMARY KEY (`id`) ,
  INDEX `fk_message_message_type1` (`message_type_id` ASC) ,
  CONSTRAINT `fk_message_message_type10`
    FOREIGN KEY (`message_type_id`)
    REFERENCES `exam`.`message_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_user_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_user_tag` (
  `user_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `tag_id`) ,
  INDEX `fk_user_has_tag_user_idx` (`user_id` ASC) ,
  INDEX `fk_user_has_tag_tag_idx` (`tag_id` ASC) ,
  CONSTRAINT `fk_user_has_user_user0`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_tag_tag0`
    FOREIGN KEY (`tag_id`)
    REFERENCES `exam`.`tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`show_field`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`show_field` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `order` INT NOT NULL,
  `is_must_showed` TINYINT NOT NULL DEFAULT 0,
  `is_visible` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`show_size`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`show_size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `page_size` INT NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `is_default_showed` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) ,
  INDEX `fk_show_size_user_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_show_size_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `exam`.`map_user_show_field`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exam`.`map_user_show_field` (
  `user_id` INT NOT NULL,
  `show_field_id` INT NOT NULL,
  INDEX `fk_map_user_show_field_user_idx` (`user_id` ASC) ,
  INDEX `fk_map_user_show_field_show_field_idx` (`show_field_id` ASC) ,
  PRIMARY KEY (`user_id`, `show_field_id`) ,
  CONSTRAINT `fk_map_user_show_field_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `exam`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_map_user_show_field_show_field`
    FOREIGN KEY (`show_field_id`)
    REFERENCES `exam`.`show_field` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
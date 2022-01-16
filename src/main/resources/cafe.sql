-- MySQL Script generated by MySQL Workbench
-- Tue Jul 20 21:03:41 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cafe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cafe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cafe` DEFAULT CHARACTER SET utf8 ;
USE `cafe` ;

-- -----------------------------------------------------
-- Table `cafe`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`status` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `discount` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(45) NOT NULL UNIQUE,
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `dateOfBirth` DATE NOT NULL,
  `statusId` BIGINT NOT NULL,
  `roleId` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_role_idx` (`roleId` ASC) VISIBLE,
  INDEX `user_status_idx` (`statusId` ASC) VISIBLE,
  CONSTRAINT `user_role`
    FOREIGN KEY (`roleId`)
    REFERENCES `cafe`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_status`
    FOREIGN KEY (`statusId`)
    REFERENCES `cafe`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`cart` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `clientId` BIGINT NOT NULL,
  `state` VARCHAR(45),
  `createDate` DATETIME,
  `price` DECIMAL NOT NULL,
  `deliveryTime` DATETIME,
  `comment` VARCHAR(45),
  PRIMARY KEY (`id`),
  CONSTRAINT `client_id`
    FOREIGN KEY (`clientId`)
    REFERENCES `cafe`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL UNIQUE,
  `price` DECIMAL NOT NULL,
  `typeId` BIGINT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `image_src` VARCHAR(45),
  PRIMARY KEY (`id`),
  CONSTRAINT `product_type`
    FOREIGN KEY (`id`)
    REFERENCES `cafe`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cafe`.`productSet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cafe`.`productSet` (
  `orderId` BIGINT NOT NULL,
  `productId` BIGINT NOT NULL,
  `quantity` INT NULL,
  INDEX `orderId_idx` (`orderId` ASC) VISIBLE,
  PRIMARY KEY (`orderId`, `productId`),
  CONSTRAINT `orderId`
    FOREIGN KEY (`orderId`)
    REFERENCES `cafe`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `productId`
    FOREIGN KEY (`orderId`)
    REFERENCES `cafe`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
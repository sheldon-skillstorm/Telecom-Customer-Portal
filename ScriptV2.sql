-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema chinook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chinook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chinook` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema teleskill
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema teleskill
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teleskill` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `chinook` ;

-- -----------------------------------------------------
-- Table `chinook`.`artist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`artist` (
  `ArtistId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(120) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`ArtistId`))
ENGINE = InnoDB
AUTO_INCREMENT = 276
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`album` (
  `AlbumId` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(160) CHARACTER SET 'utf8mb3' NOT NULL,
  `ArtistId` INT NOT NULL,
  PRIMARY KEY (`AlbumId`),
  INDEX `IFK_AlbumArtistId` (`ArtistId` ASC) VISIBLE,
  CONSTRAINT `FK_AlbumArtistId`
    FOREIGN KEY (`ArtistId`)
    REFERENCES `chinook`.`artist` (`ArtistId`))
ENGINE = InnoDB
AUTO_INCREMENT = 348
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`employee` (
  `EmployeeId` INT NOT NULL AUTO_INCREMENT,
  `LastName` VARCHAR(20) CHARACTER SET 'utf8mb3' NOT NULL,
  `FirstName` VARCHAR(20) CHARACTER SET 'utf8mb3' NOT NULL,
  `Title` VARCHAR(30) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `ReportsTo` INT NULL DEFAULT NULL,
  `BirthDate` DATETIME NULL DEFAULT NULL,
  `HireDate` DATETIME NULL DEFAULT NULL,
  `Address` VARCHAR(70) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `City` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `State` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Country` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `PostalCode` VARCHAR(10) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Phone` VARCHAR(24) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Fax` VARCHAR(24) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Email` VARCHAR(60) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`),
  INDEX `IFK_EmployeeReportsTo` (`ReportsTo` ASC) VISIBLE,
  CONSTRAINT `FK_EmployeeReportsTo`
    FOREIGN KEY (`ReportsTo`)
    REFERENCES `chinook`.`employee` (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`customer` (
  `CustomerId` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(40) CHARACTER SET 'utf8mb3' NOT NULL,
  `LastName` VARCHAR(20) CHARACTER SET 'utf8mb3' NOT NULL,
  `Company` VARCHAR(80) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Address` VARCHAR(70) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `City` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `State` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Country` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `PostalCode` VARCHAR(10) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Phone` VARCHAR(24) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Fax` VARCHAR(24) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Email` VARCHAR(60) CHARACTER SET 'utf8mb3' NOT NULL,
  `SupportRepId` INT NULL DEFAULT NULL,
  PRIMARY KEY (`CustomerId`),
  INDEX `IFK_CustomerSupportRepId` (`SupportRepId` ASC) VISIBLE,
  CONSTRAINT `FK_CustomerSupportRepId`
    FOREIGN KEY (`SupportRepId`)
    REFERENCES `chinook`.`employee` (`EmployeeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 60
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`genre` (
  `GenreId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(120) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`GenreId`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`invoice` (
  `InvoiceId` INT NOT NULL AUTO_INCREMENT,
  `CustomerId` INT NOT NULL,
  `InvoiceDate` DATETIME NOT NULL,
  `BillingAddress` VARCHAR(70) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `BillingCity` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `BillingState` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `BillingCountry` VARCHAR(40) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `BillingPostalCode` VARCHAR(10) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Total` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`InvoiceId`),
  INDEX `IFK_InvoiceCustomerId` (`CustomerId` ASC) VISIBLE,
  CONSTRAINT `FK_InvoiceCustomerId`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `chinook`.`customer` (`CustomerId`))
ENGINE = InnoDB
AUTO_INCREMENT = 413
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`mediatype`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`mediatype` (
  `MediaTypeId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(120) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`MediaTypeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`track`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`track` (
  `TrackId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) CHARACTER SET 'utf8mb3' NOT NULL,
  `AlbumId` INT NULL DEFAULT NULL,
  `MediaTypeId` INT NOT NULL,
  `GenreId` INT NULL DEFAULT NULL,
  `Composer` VARCHAR(220) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  `Milliseconds` INT NOT NULL,
  `Bytes` INT NULL DEFAULT NULL,
  `UnitPrice` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`TrackId`),
  INDEX `IFK_TrackAlbumId` (`AlbumId` ASC) VISIBLE,
  INDEX `IFK_TrackGenreId` (`GenreId` ASC) VISIBLE,
  INDEX `IFK_TrackMediaTypeId` (`MediaTypeId` ASC) VISIBLE,
  CONSTRAINT `FK_TrackAlbumId`
    FOREIGN KEY (`AlbumId`)
    REFERENCES `chinook`.`album` (`AlbumId`),
  CONSTRAINT `FK_TrackGenreId`
    FOREIGN KEY (`GenreId`)
    REFERENCES `chinook`.`genre` (`GenreId`),
  CONSTRAINT `FK_TrackMediaTypeId`
    FOREIGN KEY (`MediaTypeId`)
    REFERENCES `chinook`.`mediatype` (`MediaTypeId`))
ENGINE = InnoDB
AUTO_INCREMENT = 3504
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`invoiceline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`invoiceline` (
  `InvoiceLineId` INT NOT NULL AUTO_INCREMENT,
  `InvoiceId` INT NOT NULL,
  `TrackId` INT NOT NULL,
  `UnitPrice` DECIMAL(10,2) NOT NULL,
  `Quantity` INT NOT NULL,
  PRIMARY KEY (`InvoiceLineId`),
  INDEX `IFK_InvoiceLineInvoiceId` (`InvoiceId` ASC) VISIBLE,
  INDEX `IFK_InvoiceLineTrackId` (`TrackId` ASC) VISIBLE,
  CONSTRAINT `FK_InvoiceLineInvoiceId`
    FOREIGN KEY (`InvoiceId`)
    REFERENCES `chinook`.`invoice` (`InvoiceId`),
  CONSTRAINT `FK_InvoiceLineTrackId`
    FOREIGN KEY (`TrackId`)
    REFERENCES `chinook`.`track` (`TrackId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2241
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`playlist` (
  `PlaylistId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(120) CHARACTER SET 'utf8mb3' NULL DEFAULT NULL,
  PRIMARY KEY (`PlaylistId`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `chinook`.`playlisttrack`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chinook`.`playlisttrack` (
  `PlaylistId` INT NOT NULL,
  `TrackId` INT NOT NULL,
  PRIMARY KEY (`PlaylistId`, `TrackId`),
  INDEX `IFK_PlaylistTrackTrackId` (`TrackId` ASC) VISIBLE,
  CONSTRAINT `FK_PlaylistTrackPlaylistId`
    FOREIGN KEY (`PlaylistId`)
    REFERENCES `chinook`.`playlist` (`PlaylistId`),
  CONSTRAINT `FK_PlaylistTrackTrackId`
    FOREIGN KEY (`TrackId`)
    REFERENCES `chinook`.`track` (`TrackId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `teleskill` ;

-- -----------------------------------------------------
-- Table `teleskill`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `invoicedate` DATETIME NULL DEFAULT NULL,
  `billingaddress` VARCHAR(45) NULL DEFAULT NULL,
  `billingcity` VARCHAR(45) NULL DEFAULT NULL,
  `billingstate` VARCHAR(45) NULL DEFAULT NULL,
  `billingcountry` VARCHAR(45) NULL DEFAULT NULL,
  `billingpostalcode` VARCHAR(45) NULL DEFAULT NULL,
  `total` DECIMAL(12,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `teleskill`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `postalcode` VARCHAR(45) NULL DEFAULT NULL,
  `bill_id` INT NOT NULL,
  PRIMARY KEY (`id`, `bill_id`),
  INDEX `fk_customer_bill1_idx` (`bill_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_bill1`
    FOREIGN KEY (`bill_id`)
    REFERENCES `teleskill`.`bill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `teleskill`.`device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`device` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `price` INT NULL DEFAULT NULL,
  `number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `teleskill`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`plan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `price` DECIMAL(12,2) NULL DEFAULT NULL,
  `data` VARCHAR(45) NULL DEFAULT NULL,
  `hotspot` VARCHAR(45) NULL DEFAULT NULL,
  `streaming` VARCHAR(45) NULL DEFAULT NULL,
  `devicelimit` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `teleskill`.`customer_has_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`customer_has_plan` (
  `customer_id` INT NOT NULL,
  `plan_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `plan_id`),
  INDEX `fk_customer_has_plan_plan1_idx` (`plan_id` ASC) VISIBLE,
  INDEX `fk_customer_has_plan_customer_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_plan_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `teleskill`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_plan_plan1`
    FOREIGN KEY (`plan_id`)
    REFERENCES `teleskill`.`plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `teleskill`.`customer_has_device`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teleskill`.`customer_has_device` (
  `customer_id` INT NOT NULL,
  `device_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `device_id`),
  INDEX `fk_customer_has_device_device1_idx` (`device_id` ASC) VISIBLE,
  INDEX `fk_customer_has_device_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_device_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `teleskill`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_device_device1`
    FOREIGN KEY (`device_id`)
    REFERENCES `teleskill`.`device` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

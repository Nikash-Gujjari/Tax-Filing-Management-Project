# A SCHEMA FOR A TAX FILING MANAGEMENT SYSTEM

# SCHEMA IDEAS
-- one CPA can have multiple Tax Returns
-- one Tax Return can have multiple Taxpayers (Joint Filing, Dependents, etc.)
-- one Tax Return can have multiple FORMS (with the following type):
	-- W-2 Forms
    -- 1099 Forms
    -- Unemployment Benefits (1099-G)
    -- Investment Income (1099-DIV or 1099-INT)
    -- Retirement Income (1099-R)
    -- Other Income Statements (Alimony, Gambling Winnings, etc.)
    -- Dependent Care Expenses
    -- Mortgage Interests
    -- Student Loan Interests
    -- Charitable Donations
    -- Medical Expenses
    -- Retirement Contributions
    -- State Taxes
    -- Local Taxes
    -- Education Expenses
    -- Health Savings Account Contributions
-- one Taxpayer has one Employment Sector


        
CREATE SCHEMA `Tax Filing Management System`;

# Employment Sector Table
CREATE TABLE `tax filing management system`.`employment_sector` (
  `sector_id` INT NOT NULL AUTO_INCREMENT,
  `sector_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`sector_id`),
  UNIQUE INDEX `sector_id_UNIQUE` (`sector_id` ASC) VISIBLE,
  UNIQUE INDEX `sector_name_UNIQUE` (`sector_name` ASC) VISIBLE);


# CPA Table
CREATE TABLE `tax filing management system`.`cpa` (
  `cpa_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  `hashed_password` VARCHAR(30) NOT NULL,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cpa_id`),
  UNIQUE INDEX `cpa_id_UNIQUE` (`cpa_id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
# Tax Return Table
CREATE TABLE `tax filing management system`.`tax_return` (
  `tax_return_id` INT NOT NULL AUTO_INCREMENT,
  `filing_status` VARCHAR(27) NOT NULL,
  PRIMARY KEY (`tax_return_id`),
  UNIQUE INDEX `tax_return_id_UNIQUE` (`tax_return_id` ASC) VISIBLE,
  CONSTRAINT `tax_return_cpa`
    FOREIGN KEY (`tax_return_id`)
    REFERENCES `tax filing management system`.`cpa` (`cpa_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
  
  
# Taxpayer Table
CREATE TABLE `tax filing management system`.`taxpayer` (
  `taxpayer_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `middle_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `social_security_number` VARCHAR(11) NOT NULL,
  `address` VARCHAR(75) NOT NULL,
  `date_of_birth` VARCHAR(10) NOT NULL,
  `bank_account_number` VARCHAR(17) NOT NULL,
  `bank_routing_number` VARCHAR(9) NOT NULL,
  `employment_sector` INT NULL,
  `tax_return` INT NULL,
  PRIMARY KEY (`taxpayer_id`),
  UNIQUE INDEX `taxpayer_id_UNIQUE` (`taxpayer_id` ASC) VISIBLE,
  INDEX `employment_sector_idx` (`employment_sector` ASC) VISIBLE,
  CONSTRAINT `taxpayer_employment_sector`
    FOREIGN KEY (`employment_sector`)
    REFERENCES `tax filing management system`.`employment_sector` (`sector_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `taxpayer_tax_return`
    FOREIGN KEY (`tax_return`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);

# General Form Type

CREATE TABLE `tax filing management system`.`form` (
  `w2_id` INT NOT NULL AUTO_INCREMENT,
  `form_type` VARCHAR(50) NOT NULL,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`w2_id`),
  UNIQUE INDEX `w2_id_UNIQUE` (`w2_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_w2`
    FOREIGN KEY (`w2_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    




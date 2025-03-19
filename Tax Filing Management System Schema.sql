# A SCHEMA FOR A TAX FILING MANAGEMENT SYSTEM

# SCHEMA IDEAS
-- one CPA can have multiple Tax Returns
-- one Tax Return can have multiple Taxpayers (Joint Filing, Dependents, etc.)
-- one Tax Return can have multiple:
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

# SPECIFIC INFORMATION THAT WILL BE STORED in the Forms related to the Tax Return:

	-- Personal Information (Stored in Taxpayer):
		-- 1.	Full Name: As it appears on your legal documents.
		-- 2.	Social Security Number (SSN) or Taxpayer Identification Number (TIN): For yourself, your spouse (if applicable), and dependents.
		-- 3.	Address: Current mailing address.
		-- 4.	Filing Status: Single, Married Filing Jointly, Married Filing Separately, Head of Household, or Qualifying Surviving Spouse.
		-- 5.	Date of Birth: For both you and your dependents.
		-- 6.	Bank Account Details (if you want a direct deposit of your refund): Bank account number and routing number.
	-- Income Information:
		-- 1.	W-2 Forms: From your employer showing your wages, salary, and tax withheld.
		-- 2.	1099 Forms: If you're a freelancer, contractor, or have other types of income (e.g., 1099-NEC, 1099-MISC, 1099-INT for interest income, 1099-DIV for dividends).
		-- 3.	Unemployment Benefits: 1099-G if you received unemployment compensation.
		-- 4.	Investment Income: Statements on interest, dividends, and capital gains (Form 1099-B, 1099-INT, 1099-DIV).
		-- 5.	Retirement Income: Forms such as 1099-R for distributions from pensions, IRAs, etc.
		-- 6.	Other Income: This could include rental income, alimony, gambling winnings, etc.
	-- Deductions and Credits:
		-- 1.	Child and Dependent Care Expenses: Receipts or records for daycare, education, or other care services.
		-- 2.	Mortgage Interest: Form 1098 if you paid mortgage interest.
		-- 3.	Student Loan Interest: Form 1098-E if applicable.
		-- 4.	Charitable Donations: Receipts or records for donations made.
		-- 5.	Medical Expenses: Documentation of out-of-pocket medical expenses (if you itemize deductions).
		-- 6.	Retirement Contributions: For example, contributions to IRAs, 401(k)s, etc.
		-- 7.	State and Local Taxes Paid: If you're itemizing, you can deduct state and local taxes paid.
		-- 8.	Education Expenses: 1098-T form for tuition and qualified expenses.
		-- 9.	Health Savings Account (HSA) Contributions: Form 5498-SA.
        
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

# Tables for the Various Forms in a Tax Return
# the form_path VARCHAR will be used to store the path of the locally available copy of the tax return

CREATE TABLE `tax filing management system`.`w2` (
  `w2_id` INT NOT NULL AUTO_INCREMENT,
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
    
CREATE TABLE `tax filing management system`.`form_1099` (
  `form_1099_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`form_1099_id`),
  UNIQUE INDEX `form_1099_id_UNIQUE` (`form_1099_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_1099`
    FOREIGN KEY (`form_1099_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`unemployment_benefit` (
  `unemployment_benefit_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`unemployment_benefit_id`),
  UNIQUE INDEX `unemployment_benefit_id_UNIQUE` (`unemployment_benefit_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_unemployment_benefit`
    FOREIGN KEY (`unemployment_benefit_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`investment_income` (
  `investment_income_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`investment_income_id`),
  UNIQUE INDEX `investment_income_id_UNIQUE` (`investment_income_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_investment_income`
    FOREIGN KEY (`investment_income_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `tax filing management system`.`retirement_income` (
  `retirement_income_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`retirement_income_id`),
  UNIQUE INDEX `retirement_income_id_UNIQUE` (`retirement_income_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_retirement_income`
    FOREIGN KEY (`retirement_income_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`other_income` (
  `other_income_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`other_income_id`),
  UNIQUE INDEX `other_income_id_UNIQUE` (`other_income_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_other_income`
    FOREIGN KEY (`other_income_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`dependent_care_expense` (
  `dependent_care_expense_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`dependent_care_expense_id`),
  UNIQUE INDEX `dependent_care_expense_id_UNIQUE` (`dependent_care_expense_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_dependent_care_expense`
    FOREIGN KEY (`dependent_care_expense_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `tax filing management system`.`mortgage_interest` (
  `mortgage_interest_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`mortgage_interest_id`),
  UNIQUE INDEX `mortgage_interest_id_UNIQUE` (`mortgage_interest_id` ASC) VISIBLE,
   UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_mortgage_interest`
    FOREIGN KEY (`mortgage_interest_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `tax filing management system`.`student_loan_interest` (
  `student_loan_interest_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`student_loan_interest_id`),
  UNIQUE INDEX `student_loan_interest_id_UNIQUE` (`student_loan_interest_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_student_loan_interest`
    FOREIGN KEY (`student_loan_interest_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`charitable_donation` (
  `charitable_donation_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NULL,
  PRIMARY KEY (`charitable_donation_id`),
  UNIQUE INDEX `charitable_donation_id_UNIQUE` (`charitable_donation_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_charitable_donation`
    FOREIGN KEY (`charitable_donation_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `tax filing management system`.`medical_expense` (
  `medical_expense_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`medical_expense_id`),
  UNIQUE INDEX `medical_expense_id_UNIQUE` (`medical_expense_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_medical_expense`
    FOREIGN KEY (`medical_expense_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`retirement_contribution` (
  `retirement_contribution_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`retirement_contribution_id`),
  UNIQUE INDEX `retirement_contribution_id_UNIQUE` (`retirement_contribution_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_retirement_contribution`
    FOREIGN KEY (`retirement_contribution_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`state_tax` (
  `state_tax_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`state_tax_id`),
  UNIQUE INDEX `state_tax_id_UNIQUE` (`state_tax_id` ASC) VISIBLE,
   UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_state_tax`
    FOREIGN KEY (`state_tax_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`local_tax` (
  `local_tax_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`local_tax_id`),
  UNIQUE INDEX `local_tax_id_UNIQUE` (`local_tax_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_local_tax`
    FOREIGN KEY (`local_tax_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`education_expense` (
  `education_expense_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`education_expense_id`),
  UNIQUE INDEX `education_expense_id_UNIQUE` (`education_expense_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_education_expense`
    FOREIGN KEY (`education_expense_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE `tax filing management system`.`health_savings_account_contribution` (
  `health_savings_account_contribution_id` INT NOT NULL AUTO_INCREMENT,
  `form_name` VARCHAR(50) NOT NULL,
  `form` LONGBLOB NOT NULL,
  PRIMARY KEY (`health_savings_account_contribution_id`),
  UNIQUE INDEX `health_savings_account_contribution_id_UNIQUE` (`health_savings_account_contribution_id` ASC) VISIBLE,
  UNIQUE INDEX `form_name_UNIQUE` (`form_name` ASC) VISIBLE,
  CONSTRAINT `tax_return_health_savings_account_contribution`
    FOREIGN KEY (`health_savings_account_contribution_id`)
    REFERENCES `tax filing management system`.`tax_return` (`tax_return_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


    



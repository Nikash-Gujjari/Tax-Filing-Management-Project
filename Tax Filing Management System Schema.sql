# A SCHEMA FOR MY TAX FILING MANAGEMENT SYSTEM


-- one CPA can have multiple Taxpayers
-- one Tax Return can have multiple Taxpayers (Joint Filing, Dependents, etc.)
-- one Taxpayer has one Employment Sector

# INFORMATION THAT WILL BE STORED in a Tax Return:
	-- Personal Information:
		-- 1.	Full Name: As it appears on your legal documents.
		-- 2.	Social Security Number (SSN) or Taxpayer Identification Number (TIN): For yourself, your spouse (if applicable), and dependents.
		-- 3.	Address: Current mailing address.
		-- 4.	Filing Status: Single, Married Filing Jointly, Married Filing Separately, Head of Household, or Qualifying Surviving Spouse.
		-- 5.	Date of Birth: For both you and your dependents.
		-- 6.	Bank Account Details (if you want a direct deposit of your refund): Bank account number and routing number.
	-- Income Information:
		-- 1.	W-2 Forms: From your employer showing your wages, salary, and tax withheld.
		-- 2.	1099 Forms: If you're a freelancer, contractor, or have other types of income (e.g., 1099-NEC, 1099-MISC, 1099-INT for interest income, 1099-DIV for dividends).
		-- 3.	Self-Employment Income: Record of your earnings if you’re self-employed (along with expenses).
		-- 4.	Unemployment Benefits: 1099-G if you received unemployment compensation.
		-- 5.	Investment Income: Statements on interest, dividends, and capital gains (Form 1099-B, 1099-INT, 1099-DIV).
		-- 6.	Retirement Income: Forms such as 1099-R for distributions from pensions, IRAs, etc.
		-- 7.	Other Income: This could include rental income, alimony, gambling winnings, etc.
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
	-- Other Relevant Information:
		-- 1.	Estimated Tax Payments: If you've made estimated payments throughout the year.
		-- 2.	Previous Year’s Tax Return: To carry over certain credits or deductions.
        
CREATE SCHEMA `Tax Filing Management System`;

# Employment Sector Table
CREATE TABLE `tax filing management system`.`employment_sector` (
  `sector_id` INT NOT NULL AUTO_INCREMENT,
  `sector_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`sector_id`),
  UNIQUE INDEX `sector_id_UNIQUE` (`sector_id` ASC) VISIBLE,
  UNIQUE INDEX `sector_name_UNIQUE` (`sector_name` ASC) VISIBLE);

# Taxpayer Table
CREATE TABLE `tax filing management system`.`taxpayer` (
  `taxpayer_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  `social_security_number` VARCHAR(11) NOT NULL,
  `address` VARCHAR(75) NOT NULL,
  `filing_status` VARCHAR(27) NOT NULL,
  `date_of_birth` VARCHAR(10) NOT NULL,
  `bank_account_number` VARCHAR(17) NOT NULL,
  `bank_routing_number` VARCHAR(9) NOT NULL,
  `employment_sector` INT NOT NULL,
  PRIMARY KEY (`taxpayer_id`),
  UNIQUE INDEX `taxpayer_id_UNIQUE` (`taxpayer_id` ASC) VISIBLE,
  INDEX `employment_sector_idx` (`employment_sector` ASC) VISIBLE,
  CONSTRAINT `employment_sector`
    FOREIGN KEY (`employment_sector`)
    REFERENCES `tax filing management system`.`employment_sector` (`sector_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


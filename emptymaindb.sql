# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     procrastinating_db
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:16:16
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for procrastinating_db
CREATE DATABASE IF NOT EXISTS `procrastinating_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `procrastinating_db`;


# Dumping structure for table procrastinating_db.attr_share
CREATE TABLE IF NOT EXISTS `attr_share` (
  `file_name` varchar(30) DEFAULT NULL,
  `owner_name` varchar(30) DEFAULT NULL,
  `desc_file` varchar(30) DEFAULT NULL,
  `file_date` varchar(30) DEFAULT NULL,
  `owner_gender` varchar(30) DEFAULT NULL,
  `prime` varchar(30) DEFAULT NULL,
  `secret` int(30) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  `emailid` text,
  `O_Number` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.filerequest
CREATE TABLE IF NOT EXISTS `filerequest` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `Filename` text NOT NULL,
  `Ownername` text NOT NULL,
  `Status` text NOT NULL,
  `RequestAuthorName` text NOT NULL,
  `OName` text NOT NULL,
  `U_Status` text NOT NULL,
  `Smart_Contract_Status` text NOT NULL,
  `CurrentDate_U` text NOT NULL,
  `CurrentTime_U` text NOT NULL,
  `Duration_Data` text NOT NULL,
  `EndDate_U` text NOT NULL,
  `EndTime_U` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.file_info
CREATE TABLE IF NOT EXISTS `file_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Username` text NOT NULL,
  `Filename` text NOT NULL,
  `P_Key` text NOT NULL,
  `emailid` text,
  `filedata` longtext,
  `keydata` longtext,
  `role` longtext,
  `status_o` longtext,
  `ContentType` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.ownerotpcode
CREATE TABLE IF NOT EXISTS `ownerotpcode` (
  `Email` text NOT NULL,
  `OTP_Code` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.request
CREATE TABLE IF NOT EXISTS `request` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` text NOT NULL,
  `Filename` text NOT NULL,
  `Ownername` text NOT NULL,
  `Status` text NOT NULL,
  `Status_Msg` text NOT NULL,
  `RequestName` text NOT NULL,
  `Duration_Data` text NOT NULL,
  `SendRequest` text NOT NULL,
  `ShareSendRequest` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.response
CREATE TABLE IF NOT EXISTS `response` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(70) NOT NULL,
  `Filename` varchar(30) NOT NULL,
  `FileKey` varchar(500) NOT NULL,
  `sender` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblaa
CREATE TABLE IF NOT EXISTS `tblaa` (
  `A_id` int(10) NOT NULL AUTO_INCREMENT,
  `A_Name` text,
  `A_Email_ID` text,
  `A_Password` text,
  `A_Gender` text,
  `A_Mobile` text,
  `A_Role` text,
  `A_BirthDate` text,
  PRIMARY KEY (`A_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblaccessnew
CREATE TABLE IF NOT EXISTS `tblaccessnew` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Owner_Name` text,
  `Owner_Email_ID` text,
  `File_Name` text,
  `User_Email_ID` text,
  `Status_U` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblaccess_revoke
CREATE TABLE IF NOT EXISTS `tblaccess_revoke` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Current_Times` longtext,
  `Nonce` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblmaster
CREATE TABLE IF NOT EXISTS `tblmaster` (
  `Trans_ID` int(10) NOT NULL AUTO_INCREMENT,
  `Transcation_Hash` text,
  `FromName` text,
  `ToName` text,
  `FileName` text,
  `ActionData` text,
  `FileTime` text,
  `DurationTime` text,
  `OwnerCost` text,
  `TransferCost` text,
  `NonceData` text,
  `PreViewHash` text,
  PRIMARY KEY (`Trans_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblowner
CREATE TABLE IF NOT EXISTS `tblowner` (
  `O_id` int(10) NOT NULL AUTO_INCREMENT,
  `O_Name` text,
  `O_Email_ID` text,
  `O_Password` text,
  `O_Gender` text,
  `O_Mobile` text,
  `O_Role` text,
  `Birth_Date` text,
  `O_Status` text,
  `O_Number` text,
  PRIMARY KEY (`O_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblownername
CREATE TABLE IF NOT EXISTS `tblownername` (
  `Email_ID` text,
  `Cost_Data` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblsmart_contracts
CREATE TABLE IF NOT EXISTS `tblsmart_contracts` (
  `Duration_Data` text,
  `Cost_Data` text,
  `Owner_Cost` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblsmart_contracts_new
CREATE TABLE IF NOT EXISTS `tblsmart_contracts_new` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EmailID` text,
  `Duration_Data` text,
  `Duration_Time` text,
  `Status_U` text,
  `O_Email_ID` text,
  `O_File_Name` text,
  `CurrentDate_U` text,
  `CurrentTime_U` text,
  `DayCount` text,
  PRIMARY KEY (`S_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tbluser
CREATE TABLE IF NOT EXISTS `tbluser` (
  `U_id` int(10) NOT NULL AUTO_INCREMENT,
  `U_Name` text,
  `U_Email_ID` text,
  `U_Password` text,
  `U_Gender` text,
  `U_Role` text,
  `U_Mobile` text,
  `Account_Balances` text,
  `Birth_Date` text,
  `U_Status` text,
  PRIMARY KEY (`U_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.tblusername
CREATE TABLE IF NOT EXISTS `tblusername` (
  `Email_ID` text,
  `Cost_Data` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table procrastinating_db.userotpcode
CREATE TABLE IF NOT EXISTS `userotpcode` (
  `Email` text NOT NULL,
  `OTP_Code` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

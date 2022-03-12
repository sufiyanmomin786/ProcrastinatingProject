# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     procrastinating_db
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:15:44
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

# Dumping data for table procrastinating_db.attr_share: 2 rows
/*!40000 ALTER TABLE `attr_share` DISABLE KEYS */;
INSERT INTO `attr_share` (`file_name`, `owner_name`, `desc_file`, `file_date`, `owner_gender`, `prime`, `secret`, `filename`, `emailid`, `O_Number`) VALUES ('aa:92', 'om:13', 'test:115', '2020-05-15:169', '9999999999:175', '229', 123, 'a.txt', 'om@gmail.com', '1:133'), ('aa:41', 'om:155', 'test:103', '2020-05-15:66', '9999999999:44', '181', 123, 'a.txt', 'om@gmail.com', '1:37');
/*!40000 ALTER TABLE `attr_share` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.filerequest: 2 rows
/*!40000 ALTER TABLE `filerequest` DISABLE KEYS */;
INSERT INTO `filerequest` (`id`, `username`, `Filename`, `Ownername`, `Status`, `RequestAuthorName`, `OName`, `U_Status`, `Smart_Contract_Status`, `CurrentDate_U`, `CurrentTime_U`, `Duration_Data`, `EndDate_U`, `EndTime_U`) VALUES (1, 'rohitburke007@gmail.com', 'a.txt', 'om@gmail.com', 'Request Accept', 'admin@gmail.com', 'om', 'Pending', 'Pending', '0', '0', '0', '0', '0'), (2, 'rohitburke007@gmail.com', 'a.txt', 'om@gmail.com', 'Request Accept', 'admin@gmail.com', 'om', 'Pending', 'Pending', '0', '0', '0', '0', '0');
/*!40000 ALTER TABLE `filerequest` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

# Dumping data for table procrastinating_db.file_info: 1 rows
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.ownerotpcode
CREATE TABLE IF NOT EXISTS `ownerotpcode` (
  `Email` text NOT NULL,
  `OTP_Code` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.ownerotpcode: 1 rows
/*!40000 ALTER TABLE `ownerotpcode` DISABLE KEYS */;
INSERT INTO `ownerotpcode` (`Email`, `OTP_Code`) VALUES ('om@gmail.com', '0');
/*!40000 ALTER TABLE `ownerotpcode` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.request: 3 rows
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` (`id`, `username`, `Filename`, `Ownername`, `Status`, `Status_Msg`, `RequestName`, `Duration_Data`, `SendRequest`, `ShareSendRequest`) VALUES (1, 'rohitburke007@gmail.com', 'a.txt', 'om@gmail.com', 'Accept', 'Accept', 'KeyandAttribute', '0', '1', '1'), (2, 'rohitburke007@gmail.com', 'a.txt', 'om@gmail.com', 'Accept', 'Accept', 'KeyandAttribute', '0', '0', '0'), (3, 'rohitburke007@gmail.com', 'a.txt', 'om@gmail.com', 'Accept', 'Accept', 'KeyandAttribute', '30#Min', '0', '0');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.response
CREATE TABLE IF NOT EXISTS `response` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(70) NOT NULL,
  `Filename` varchar(30) NOT NULL,
  `FileKey` varchar(500) NOT NULL,
  `sender` varchar(70) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.response: 1 rows
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
INSERT INTO `response` (`id`, `user`, `Filename`, `FileKey`, `sender`) VALUES (1, 'rohitburke007@gmail.com', 'a.txt', 'YLQMF', 'om@gmail.com');
/*!40000 ALTER TABLE `response` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblaa: 1 rows
/*!40000 ALTER TABLE `tblaa` DISABLE KEYS */;
INSERT INTO `tblaa` (`A_id`, `A_Name`, `A_Email_ID`, `A_Password`, `A_Gender`, `A_Mobile`, `A_Role`, `A_BirthDate`) VALUES (1, 'admin', 'admin@gmail.com', 'Ad@1234', 'Male', '7777777777', 'Admin', '2020-12-01');
/*!40000 ALTER TABLE `tblaa` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.tblaccessnew
CREATE TABLE IF NOT EXISTS `tblaccessnew` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Owner_Name` text,
  `Owner_Email_ID` text,
  `File_Name` text,
  `User_Email_ID` text,
  `Status_U` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblaccessnew: 1 rows
/*!40000 ALTER TABLE `tblaccessnew` DISABLE KEYS */;
INSERT INTO `tblaccessnew` (`id`, `Owner_Name`, `Owner_Email_ID`, `File_Name`, `User_Email_ID`, `Status_U`) VALUES (1, 'om', 'om@gmail.com', 'a.txt', 'rohitburke007@gmail.com', 'Accept');
/*!40000 ALTER TABLE `tblaccessnew` ENABLE KEYS */;


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

# Dumping data for table procrastinating_db.tblaccess_revoke: 0 rows
/*!40000 ALTER TABLE `tblaccess_revoke` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblaccess_revoke` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblmaster: 1 rows
/*!40000 ALTER TABLE `tblmaster` DISABLE KEYS */;
INSERT INTO `tblmaster` (`Trans_ID`, `Transcation_Hash`, `FromName`, `ToName`, `FileName`, `ActionData`, `FileTime`, `DurationTime`, `OwnerCost`, `TransferCost`, `NonceData`, `PreViewHash`) VALUES (1, '00000f797a652285310e5fbf458ca8de2bb923444c831f13c4a0dfba23f229ca', 'om@gmail.com', 'rohitburke007@gmail.com', 'a.txt', 'FileShare', 'Fri May 15 11:02:25 IST 2020', '30#Min', '45', '0.4', '3479417', '0x');
/*!40000 ALTER TABLE `tblmaster` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblowner: 1 rows
/*!40000 ALTER TABLE `tblowner` DISABLE KEYS */;
INSERT INTO `tblowner` (`O_id`, `O_Name`, `O_Email_ID`, `O_Password`, `O_Gender`, `O_Mobile`, `O_Role`, `Birth_Date`, `O_Status`, `O_Number`) VALUES (1, 'om', 'om@gmail.com', 'Om@1234', 'Male', '9999999999', 'IT_Dept', '2000-02-15', 'Pending', '0');
/*!40000 ALTER TABLE `tblowner` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.tblownername
CREATE TABLE IF NOT EXISTS `tblownername` (
  `Email_ID` text,
  `Cost_Data` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table procrastinating_db.tblownername: 1 rows
/*!40000 ALTER TABLE `tblownername` DISABLE KEYS */;
INSERT INTO `tblownername` (`Email_ID`, `Cost_Data`) VALUES ('om@gmail.com', '45.0');
/*!40000 ALTER TABLE `tblownername` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.tblsmart_contracts
CREATE TABLE IF NOT EXISTS `tblsmart_contracts` (
  `Duration_Data` text,
  `Cost_Data` text,
  `Owner_Cost` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Dumping data for table procrastinating_db.tblsmart_contracts: 5 rows
/*!40000 ALTER TABLE `tblsmart_contracts` DISABLE KEYS */;
INSERT INTO `tblsmart_contracts` (`Duration_Data`, `Cost_Data`, `Owner_Cost`) VALUES ('5#Min', '0.55', '2'), ('10#Min', '0.45', '19'), ('15#Min', '0.35', '27'), ('20#Min', '0.10', '35'), ('30#Min', '0.4', '45');
/*!40000 ALTER TABLE `tblsmart_contracts` ENABLE KEYS */;


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
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblsmart_contracts_new: 2 rows
/*!40000 ALTER TABLE `tblsmart_contracts_new` DISABLE KEYS */;
INSERT INTO `tblsmart_contracts_new` (`S_ID`, `EmailID`, `Duration_Data`, `Duration_Time`, `Status_U`, `O_Email_ID`, `O_File_Name`, `CurrentDate_U`, `CurrentTime_U`, `DayCount`) VALUES (1, 'rohitburke007@gmail.com', '0', '0', '0', NULL, NULL, NULL, NULL, NULL), (2, 'rohitburke007@gmail.com', '30#Min', '11:06:05', 'Working', 'om@gmail.com', 'a.txt', '2020-05-15', '11:36:05', '1');
/*!40000 ALTER TABLE `tblsmart_contracts_new` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tbluser: 1 rows
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` (`U_id`, `U_Name`, `U_Email_ID`, `U_Password`, `U_Gender`, `U_Role`, `U_Mobile`, `Account_Balances`, `Birth_Date`, `U_Status`) VALUES (1, 'rohit', 'rohitburke007@gmail.com', 'Ro@1234', 'Male', 'IT_Dept', '8888888888', '1000', '2002-12-31', 'Accept');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.tblusername
CREATE TABLE IF NOT EXISTS `tblusername` (
  `Email_ID` text,
  `Cost_Data` text
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.tblusername: 1 rows
/*!40000 ALTER TABLE `tblusername` DISABLE KEYS */;
INSERT INTO `tblusername` (`Email_ID`, `Cost_Data`) VALUES ('rohitburke007@gmail.com', '943');
/*!40000 ALTER TABLE `tblusername` ENABLE KEYS */;


# Dumping structure for table procrastinating_db.userotpcode
CREATE TABLE IF NOT EXISTS `userotpcode` (
  `Email` text NOT NULL,
  `OTP_Code` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table procrastinating_db.userotpcode: 1 rows
/*!40000 ALTER TABLE `userotpcode` DISABLE KEYS */;
INSERT INTO `userotpcode` (`Email`, `OTP_Code`) VALUES ('rohitburke007@gmail.com', '0');
/*!40000 ALTER TABLE `userotpcode` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
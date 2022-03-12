# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     blockchain1
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:16:50
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for blockchain1
CREATE DATABASE IF NOT EXISTS `blockchain1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blockchain1`;


# Dumping structure for table blockchain1.transhash
CREATE TABLE IF NOT EXISTS `transhash` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `HashBlock` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table blockchain1.transhash1
CREATE TABLE IF NOT EXISTS `transhash1` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Nonce` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table blockchain1.transhashnew
CREATE TABLE IF NOT EXISTS `transhashnew` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Current_Times` longtext,
  `Nonce` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     blockchain2
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:16:50
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for blockchain2
CREATE DATABASE IF NOT EXISTS `blockchain2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blockchain2`;


# Dumping structure for table blockchain2.transhash
CREATE TABLE IF NOT EXISTS `transhash` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `HashBlock` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table blockchain2.transhashnew
CREATE TABLE IF NOT EXISTS `transhashnew` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Current_Times` longtext,
  `Nonce` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     blockchain3
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:16:50
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for blockchain3
CREATE DATABASE IF NOT EXISTS `blockchain3` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blockchain3`;


# Dumping structure for table blockchain3.transhash
CREATE TABLE IF NOT EXISTS `transhash` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `HashBlock` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table blockchain3.transhashnew
CREATE TABLE IF NOT EXISTS `transhashnew` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Current_Times` longtext,
  `Nonce` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     blockchain4
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2020-05-15 11:16:50
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for blockchain4
CREATE DATABASE IF NOT EXISTS `blockchain4` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blockchain4`;


# Dumping structure for table blockchain4.transhash
CREATE TABLE IF NOT EXISTS `transhash` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `HashBlock` longtext,
  `Current_Times` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.


# Dumping structure for table blockchain4.transhashnew
CREATE TABLE IF NOT EXISTS `transhashnew` (
  `TransactionID` int(11) NOT NULL AUTO_INCREMENT,
  `PlainData` longtext,
  `BlocKData` longtext,
  `PreviousHash` longtext,
  `Current_Times` longtext,
  `Nonce` longtext,
  PRIMARY KEY (`TransactionID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

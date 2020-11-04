/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - house
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`house` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `house`;

/*Table structure for table `myarea` */

DROP TABLE IF EXISTS `myarea`;

CREATE TABLE `myarea` (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `ANAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myarea` */

insert  into `myarea`(`AID`,`ANAME`) values (1,'洪山区'),(2,'武昌区'),(3,'东湖高新技术开发区'),(4,'汉阳区'),(5,'1'),(6,'12');

/*Table structure for table `mybiao` */

DROP TABLE IF EXISTS `mybiao`;

CREATE TABLE `mybiao` (
  `BID` decimal(8,0) NOT NULL,
  `HID` decimal(8,0) DEFAULT NULL,
  `DKD` float DEFAULT NULL,
  `SKD` float DEFAULT NULL,
  `MKD` float DEFAULT NULL,
  `MTIME` varchar(20) DEFAULT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mybiao` */

/*Table structure for table `mybs` */

DROP TABLE IF EXISTS `mybs`;

CREATE TABLE `mybs` (
  `BID` decimal(8,0) NOT NULL,
  `HID` decimal(8,0) DEFAULT NULL,
  `MTIME` varchar(20) DEFAULT NULL,
  `BREMARK` varchar(500) DEFAULT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mybs` */

/*Table structure for table `mycus` */

DROP TABLE IF EXISTS `mycus`;

CREATE TABLE `mycus` (
  `CID` bigint(8) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(20) DEFAULT NULL,
  `CSEX` varchar(20) DEFAULT NULL,
  `CTEL` varchar(20) DEFAULT NULL,
  `CTEL1` varchar(20) DEFAULT NULL,
  `CCARD` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mycus` */

insert  into `mycus`(`CID`,`CNAME`,`CSEX`,`CTEL`,`CTEL1`,`CCARD`) values (1,'老王',NULL,NULL,NULL,NULL),(2,'小王','男',NULL,NULL,NULL),(3,'小王','小王','小王','小王','小王'),(4,NULL,NULL,NULL,NULL,NULL),(5,'5','1','男','1','1'),(13,'李钢毅','33','男','11','22'),(14,'李钢毅2','11','男','11','11'),(15,'李钢毅3','1','男','1','1'),(16,'李钢毅4','24','男','24','24'),(17,'李钢毅5','111','男','11','22'),(18,'11','11','男','11','11');

/*Table structure for table `mydept` */

DROP TABLE IF EXISTS `mydept`;

CREATE TABLE `mydept` (
  `PID` int(11) NOT NULL AUTO_INCREMENT,
  `PNAME` varchar(50) DEFAULT NULL,
  `PFLAG` decimal(8,0) DEFAULT NULL,
  `PREMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `mydept` */

insert  into `mydept`(`PID`,`PNAME`,`PFLAG`,`PREMARK`) values (1,'管理规划部','0','管理部门,不可删除'),(2,'房管一部','0','主要负责房源信息录入'),(3,'房管二部','0','主要负责房子出租'),(4,'房管三部','0','主要负责房子出租'),(11,'12','0','12'),(12,'121','0','121');

/*Table structure for table `mydj` */

DROP TABLE IF EXISTS `mydj`;

CREATE TABLE `mydj` (
  `MID` decimal(8,0) NOT NULL,
  `MDATE` varchar(20) DEFAULT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  `CID` decimal(8,0) DEFAULT NULL,
  `HID` decimal(8,0) DEFAULT NULL,
  `MIMG` varchar(200) DEFAULT NULL,
  `MYJ` float DEFAULT NULL,
  `MYZJ` float DEFAULT NULL,
  `MFLAG` decimal(8,0) DEFAULT '0',
  `MBEGINTIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mydj` */

/*Table structure for table `myemp` */

DROP TABLE IF EXISTS `myemp`;

CREATE TABLE `myemp` (
  `EID` decimal(8,0) NOT NULL,
  `PID` decimal(8,0) DEFAULT NULL,
  `JID` decimal(8,0) DEFAULT NULL,
  `ENAME` varchar(20) DEFAULT NULL,
  `EPSW` varchar(20) DEFAULT NULL,
  `EREALNAME` varchar(20) DEFAULT NULL,
  `ETEL` varchar(20) DEFAULT NULL,
  `EADDRESS` varchar(200) DEFAULT NULL,
  `EFLAG` decimal(8,0) DEFAULT NULL,
  `EREMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`EID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myemp` */

insert  into `myemp`(`EID`,`PID`,`JID`,`ENAME`,`EPSW`,`EREALNAME`,`ETEL`,`EADDRESS`,`EFLAG`,`EREMARK`) values ('1','1','1','admin','admin','赵本山','13995668339','武汉市洪山区120号','0','此人为系统管理员，不可删除'),('2','2','2','liuxq','123','刘小庆','13995668330','武汉市洪山区121号','0','优秀的置业顾问'),('3','3','2','zhaozw','123','赵子武','15895668330','武汉市洪山区122号','0','优秀的置业顾问'),('4','3','2','zhanghy','123','张海洋','13095668331','武汉市洪山区123号','0','优秀的置业顾问');

/*Table structure for table `myhouse` */

DROP TABLE IF EXISTS `myhouse`;

CREATE TABLE `myhouse` (
  `HID` decimal(8,0) NOT NULL,
  `SID` decimal(8,0) DEFAULT NULL,
  `AID` decimal(8,0) DEFAULT NULL,
  `HADDRESS` varchar(200) DEFAULT NULL,
  `HFH` varchar(50) DEFAULT NULL,
  `HHX` varchar(50) DEFAULT NULL,
  `HMJ` varchar(20) DEFAULT NULL,
  `HCX` varchar(20) DEFAULT NULL,
  `HMONEY` float DEFAULT NULL,
  `HWF` float DEFAULT NULL,
  `HDX` float DEFAULT NULL,
  `HSF` float DEFAULT NULL,
  `HMQ` float DEFAULT NULL,
  `DKD` float DEFAULT NULL,
  `SKD` float DEFAULT NULL,
  `MKD` float DEFAULT NULL,
  `HJP` varchar(20) DEFAULT NULL,
  `HREMARK` varchar(500) DEFAULT NULL,
  `HIMG` varchar(500) DEFAULT NULL,
  `HFLAG` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`HID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myhouse` */

insert  into `myhouse`(`HID`,`SID`,`AID`,`HADDRESS`,`HFH`,`HHX`,`HMJ`,`HCX`,`HMONEY`,`HWF`,`HDX`,`HSF`,`HMQ`,`DKD`,`SKD`,`MKD`,`HJP`,`HREMARK`,`HIMG`,`HFLAG`) values ('1','2','2','洪山区保利花园小区','A区4栋2单元801室','3室2厅2卫','130','坐北朝南',3500,1800,0.5,1.2,1.2,456,456,789,'BLHY','upload/1.jpg、upload/2.jpg、upload/3.jpg','0',NULL);

/*Table structure for table `myht` */

DROP TABLE IF EXISTS `myht`;

CREATE TABLE `myht` (
  `HTID` decimal(8,0) NOT NULL,
  `HTNAME` varchar(50) DEFAULT NULL,
  `HTREMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`HTID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myht` */

/*Table structure for table `myjs` */

DROP TABLE IF EXISTS `myjs`;

CREATE TABLE `myjs` (
  `JID` int(11) NOT NULL AUTO_INCREMENT,
  `JNAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`JID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myjs` */

insert  into `myjs`(`JID`,`JNAME`) values (1,'系统管理员'),(2,'置业顾问'),(3,'会计'),(5,'12');

/*Table structure for table `mysf` */

DROP TABLE IF EXISTS `mysf`;

CREATE TABLE `mysf` (
  `YID` decimal(8,0) NOT NULL,
  `MID` decimal(8,0) DEFAULT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  `MYZJ` float DEFAULT NULL,
  `MBEGINTIME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`YID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mysf` */

/*Table structure for table `myshouru` */

DROP TABLE IF EXISTS `myshouru`;

CREATE TABLE `myshouru` (
  `SID` decimal(8,0) NOT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  `SMONEY` float DEFAULT NULL,
  `STM` varchar(20) DEFAULT NULL,
  `STIME` varchar(20) DEFAULT NULL,
  `SREMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myshouru` */

/*Table structure for table `mysort` */

DROP TABLE IF EXISTS `mysort`;

CREATE TABLE `mysort` (
  `SID` int(11) NOT NULL AUTO_INCREMENT,
  `SNAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mysort` */

insert  into `mysort`(`SID`,`SNAME`) values (1,'标准住宅'),(2,'标准厂房'),(3,'标准仓库'),(4,'标准车位'),(6,'12');

/*Table structure for table `mytf` */

DROP TABLE IF EXISTS `mytf`;

CREATE TABLE `mytf` (
  `TID` decimal(8,0) NOT NULL,
  `MID` decimal(8,0) DEFAULT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  `TYZJ` float DEFAULT NULL,
  `MTIME` varchar(20) DEFAULT NULL,
  `MREMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`TID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `mytf` */

/*Table structure for table `myzc` */

DROP TABLE IF EXISTS `myzc`;

CREATE TABLE `myzc` (
  `CID` decimal(8,0) NOT NULL,
  `CTITLE` varchar(200) DEFAULT NULL,
  `CTIME` varchar(20) DEFAULT NULL,
  `CREMARK` text,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myzc` */

/*Table structure for table `myzhichu` */

DROP TABLE IF EXISTS `myzhichu`;

CREATE TABLE `myzhichu` (
  `ZID` decimal(8,0) NOT NULL,
  `EID` decimal(8,0) DEFAULT NULL,
  `ZMONEY` float DEFAULT NULL,
  `ZTM` varchar(20) DEFAULT NULL,
  `ZTIME` varchar(20) DEFAULT NULL,
  `ZREMARK` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ZID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `myzhichu` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

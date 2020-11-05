/*
 Navicat MySQL Data Transfer

 Source Server         : 111
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : house

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 05/11/2020 17:02:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for myarea
-- ----------------------------
DROP TABLE IF EXISTS `myarea`;
CREATE TABLE `myarea`  (
  `AID` int(11) NOT NULL AUTO_INCREMENT,
  `ANAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`AID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myarea
-- ----------------------------
INSERT INTO `myarea` VALUES (1, '洪山区');
INSERT INTO `myarea` VALUES (2, '武昌区');
INSERT INTO `myarea` VALUES (3, '东湖高新技术开发区');
INSERT INTO `myarea` VALUES (4, '汉阳区');
INSERT INTO `myarea` VALUES (5, '1');
INSERT INTO `myarea` VALUES (6, '12');
INSERT INTO `myarea` VALUES (7, '111');

-- ----------------------------
-- Table structure for mybiao
-- ----------------------------
DROP TABLE IF EXISTS `mybiao`;
CREATE TABLE `mybiao`  (
  `BID` decimal(8, 0) NOT NULL,
  `HID` decimal(8, 0) NULL DEFAULT NULL,
  `DKD` float NULL DEFAULT NULL,
  `SKD` float NULL DEFAULT NULL,
  `MKD` float NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mybs
-- ----------------------------
DROP TABLE IF EXISTS `mybs`;
CREATE TABLE `mybs`  (
  `BID` decimal(8, 0) NOT NULL,
  `HID` decimal(8, 0) NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`BID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mycus
-- ----------------------------
DROP TABLE IF EXISTS `mycus`;
CREATE TABLE `mycus`  (
  `CID` bigint(8) NOT NULL AUTO_INCREMENT,
  `CNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CSEX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTEL1` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CCARD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mycus
-- ----------------------------
INSERT INTO `mycus` VALUES (1, '老王', NULL, NULL, NULL, NULL);
INSERT INTO `mycus` VALUES (2, '小王', '男', NULL, NULL, NULL);
INSERT INTO `mycus` VALUES (3, '小王', '小王', '小王', '小王', '小王');
INSERT INTO `mycus` VALUES (4, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `mycus` VALUES (5, '5', '1', '男', '1', '1');
INSERT INTO `mycus` VALUES (13, '李钢毅', '33', '男', '11', '22');
INSERT INTO `mycus` VALUES (14, '李钢毅2', '11', '男', '11', '11');
INSERT INTO `mycus` VALUES (15, '李钢毅3', '1', '男', '1', '1');
INSERT INTO `mycus` VALUES (16, '李钢毅4', '24', '男', '24', '24');
INSERT INTO `mycus` VALUES (17, '李钢毅5', '111', '男', '11', '22');
INSERT INTO `mycus` VALUES (18, '11', '11', '男', '11', '11');

-- ----------------------------
-- Table structure for mydept
-- ----------------------------
DROP TABLE IF EXISTS `mydept`;
CREATE TABLE `mydept`  (
  `PID` int(11) NOT NULL AUTO_INCREMENT,
  `PNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PFLAG` decimal(8, 0) NULL DEFAULT NULL,
  `PREMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 AVG_ROW_LENGTH = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mydept
-- ----------------------------
INSERT INTO `mydept` VALUES (1, '管理规划部', 0, '管理部门,不可删除');
INSERT INTO `mydept` VALUES (2, '房管一部', 0, '主要负责房源信息录入');
INSERT INTO `mydept` VALUES (3, '房管二部', 0, '主要负责房子出租');
INSERT INTO `mydept` VALUES (4, '房管三部', 0, '主要负责房子出租');
INSERT INTO `mydept` VALUES (11, '12', 0, '12');
INSERT INTO `mydept` VALUES (12, '121', 0, '121');

-- ----------------------------
-- Table structure for mydj
-- ----------------------------
DROP TABLE IF EXISTS `mydj`;
CREATE TABLE `mydj`  (
  `MID` decimal(8, 0) NOT NULL,
  `MDATE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  `CID` decimal(8, 0) NULL DEFAULT NULL,
  `HID` decimal(8, 0) NULL DEFAULT NULL,
  `MIMG` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MYJ` float NULL DEFAULT NULL,
  `MYZJ` float NULL DEFAULT NULL,
  `MFLAG` decimal(8, 0) NULL DEFAULT 0,
  `MBEGINTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myemp
-- ----------------------------
DROP TABLE IF EXISTS `myemp`;
CREATE TABLE `myemp`  (
  `EID` decimal(8, 0) NOT NULL,
  `PID` decimal(8, 0) NULL DEFAULT NULL,
  `JID` decimal(8, 0) NULL DEFAULT NULL,
  `ENAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EPSW` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EREALNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ETEL` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EFLAG` decimal(8, 0) NULL DEFAULT NULL,
  `EREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`EID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myemp
-- ----------------------------
INSERT INTO `myemp` VALUES (1, 1, 1, 'admin', 'admin', '赵本山', '13995668339', '武汉市洪山区120号', 0, '此人为系统管理员，不可删除');
INSERT INTO `myemp` VALUES (2, 2, 2, 'liuxq', '123', '刘小庆', '13995668330', '武汉市洪山区121号', 0, '优秀的置业顾问');
INSERT INTO `myemp` VALUES (3, 3, 2, 'zhaozw', '123', '赵子武', '15895668330', '武汉市洪山区122号', 0, '优秀的置业顾问');
INSERT INTO `myemp` VALUES (4, 3, 2, 'zhanghy', '123', '张海洋', '13095668331', '武汉市洪山区123号', 0, '优秀的置业顾问');

-- ----------------------------
-- Table structure for myhouse
-- ----------------------------
DROP TABLE IF EXISTS `myhouse`;
CREATE TABLE `myhouse`  (
  `HID` int(11) NOT NULL AUTO_INCREMENT,
  `SID` decimal(8, 0) NULL DEFAULT NULL,
  `AID` decimal(8, 0) NULL DEFAULT NULL,
  `HADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HFH` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HHX` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HMJ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HCX` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HMONEY` float NULL DEFAULT NULL,
  `HWF` float NULL DEFAULT NULL,
  `HDX` float NULL DEFAULT NULL,
  `HSF` float NULL DEFAULT NULL,
  `HMQ` float NULL DEFAULT NULL,
  `DKD` float NULL DEFAULT NULL,
  `SKD` float NULL DEFAULT NULL,
  `MKD` float NULL DEFAULT NULL,
  `HJP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HIMG` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HFLAG` decimal(8, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`HID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myhouse
-- ----------------------------
INSERT INTO `myhouse` VALUES (1, 2, 2, '洪山区保利花园小区', 'A区4栋2单元801室', '3室2厅2卫', '130', '坐北朝南', 3500, 1800, 0.5, 1.2, 1.2, 456, 456, 789, 'BLHY', 'upload/1.jpg、upload/2.jpg、upload/3.jpg', '0', NULL);

-- ----------------------------
-- Table structure for myht
-- ----------------------------
DROP TABLE IF EXISTS `myht`;
CREATE TABLE `myht`  (
  `HTID` decimal(8, 0) NOT NULL,
  `HTNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `HTREMARK` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`HTID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myjs
-- ----------------------------
DROP TABLE IF EXISTS `myjs`;
CREATE TABLE `myjs`  (
  `JID` int(11) NOT NULL AUTO_INCREMENT,
  `JNAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`JID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of myjs
-- ----------------------------
INSERT INTO `myjs` VALUES (1, '系统管理员');
INSERT INTO `myjs` VALUES (2, '置业顾问');
INSERT INTO `myjs` VALUES (3, '会计');
INSERT INTO `myjs` VALUES (5, '12');

-- ----------------------------
-- Table structure for mysf
-- ----------------------------
DROP TABLE IF EXISTS `mysf`;
CREATE TABLE `mysf`  (
  `YID` decimal(8, 0) NOT NULL,
  `MID` decimal(8, 0) NULL DEFAULT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  `MYZJ` float NULL DEFAULT NULL,
  `MBEGINTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`YID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myshouru
-- ----------------------------
DROP TABLE IF EXISTS `myshouru`;
CREATE TABLE `myshouru`  (
  `SID` decimal(8, 0) NOT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  `SMONEY` float NULL DEFAULT NULL,
  `STM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mysort
-- ----------------------------
DROP TABLE IF EXISTS `mysort`;
CREATE TABLE `mysort`  (
  `SID` int(11) NOT NULL AUTO_INCREMENT,
  `SNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mysort
-- ----------------------------
INSERT INTO `mysort` VALUES (1, '标准住宅');
INSERT INTO `mysort` VALUES (2, '标准厂房');
INSERT INTO `mysort` VALUES (3, '标准仓库');
INSERT INTO `mysort` VALUES (4, '标准车位');
INSERT INTO `mysort` VALUES (6, '12');
INSERT INTO `mysort` VALUES (7, '1212');

-- ----------------------------
-- Table structure for mytf
-- ----------------------------
DROP TABLE IF EXISTS `mytf`;
CREATE TABLE `mytf`  (
  `TID` decimal(8, 0) NOT NULL,
  `MID` decimal(8, 0) NULL DEFAULT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  `TYZJ` float NULL DEFAULT NULL,
  `MTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`TID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myzc
-- ----------------------------
DROP TABLE IF EXISTS `myzc`;
CREATE TABLE `myzc`  (
  `CID` decimal(8, 0) NOT NULL,
  `CTITLE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `CREMARK` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for myzhichu
-- ----------------------------
DROP TABLE IF EXISTS `myzhichu`;
CREATE TABLE `myzhichu`  (
  `ZID` decimal(8, 0) NOT NULL,
  `EID` decimal(8, 0) NULL DEFAULT NULL,
  `ZMONEY` float NULL DEFAULT NULL,
  `ZTM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ZTIME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ZREMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ZID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

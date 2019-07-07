/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : attendance

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 07/07/2019 21:08:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for checkreports
-- ----------------------------
DROP TABLE IF EXISTS `checkreports`;
CREATE TABLE `checkreports`  (
  `chInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `chId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chTimeStart` timestamp(6) NULL DEFAULT NULL,
  `chTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `chMark` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`chInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkreports
-- ----------------------------
INSERT INTO `checkreports` VALUES ('000001', 'LM', '李明', '2019-06-23 08:00:00.000000', '2019-06-23 18:05:00.000000', '正常');
INSERT INTO `checkreports` VALUES ('000002', 'XH', '小红', '2019-06-23 08:00:00.000000', '2019-06-23 18:05:00.000000', '正常');
INSERT INTO `checkreports` VALUES ('000003', 'XW', '小王', '2019-06-24 09:00:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports` VALUES ('000004', 'LW', '老王', '2019-06-25 08:00:00.000000', '2019-06-25 17:55:00.000000', '早退');

-- ----------------------------
-- Table structure for checkreports_copy1
-- ----------------------------
DROP TABLE IF EXISTS `checkreports_copy1`;
CREATE TABLE `checkreports_copy1`  (
  `chInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `chId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `chTimeStart` timestamp(6) NULL DEFAULT NULL,
  `chTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `chMark` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`chInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkreports_copy1
-- ----------------------------
INSERT INTO `checkreports_copy1` VALUES ('000001', 'KDM', '柯登明', '2019-06-23 08:00:00.000000', '2019-06-23 18:05:00.000000', '正常');
INSERT INTO `checkreports_copy1` VALUES ('000002', 'JLB', '蒋绿波', '2019-06-23 08:00:00.000000', '2019-06-23 18:05:00.000000', '正常');
INSERT INTO `checkreports_copy1` VALUES ('000003', 'BWF', '白伟发', '2019-06-24 09:00:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000004', 'LHQ', '林湖钦', '2019-06-26 08:00:00.000000', '2019-06-26 17:55:00.000000', '早退');
INSERT INTO `checkreports_copy1` VALUES ('000005', 'WNM', '吴念梅', '2019-06-27 09:00:00.000000', '2019-06-27 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000006', 'ZY', '张毅', '2019-06-25 08:00:00.000000', '2019-06-25 17:55:00.000000', '早退');
INSERT INTO `checkreports_copy1` VALUES ('000007', 'XS', '薛松', '2019-06-24 09:00:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000008', 'HJ', '邗江', '2019-06-25 08:00:00.000000', '2019-06-25 18:05:00.000000', '正常');
INSERT INTO `checkreports_copy1` VALUES ('000009', 'LSD', '刘诗殿', '2019-06-24 08:15:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000010', 'WBC', '王滨城', '2019-06-25 08:00:00.000000', '2019-06-25 19:55:00.000000', '正常');
INSERT INTO `checkreports_copy1` VALUES ('000011', 'XZX', '许志新', '2019-06-24 09:00:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000012', 'JWW', '蒋文维', '2019-06-25 08:00:00.000000', '2019-06-25 17:55:00.000000', '早退');
INSERT INTO `checkreports_copy1` VALUES ('000013', 'CZX', '陈志鑫', '2019-06-24 08:00:00.000000', '2019-06-24 18:10:00.000000', '正常');
INSERT INTO `checkreports_copy1` VALUES ('000014', 'ZSY', '张诗妍', '2019-06-25 08:00:00.000000', '2019-06-25 17:55:00.000000', '早退');
INSERT INTO `checkreports_copy1` VALUES ('000015', 'LHF', '李慧峰', '2019-06-24 09:00:00.000000', '2019-06-24 18:00:00.000000', '迟到');
INSERT INTO `checkreports_copy1` VALUES ('000016', 'HNKZ', '哈妮克孜', '2019-06-25 08:00:00.000000', '2019-06-25 17:55:00.000000', '早退');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `cInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cTimeStart` time(6) NULL DEFAULT NULL,
  `cTimeEnd` time(6) NULL DEFAULT NULL,
  PRIMARY KEY (`cInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('000001', 'EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes` VALUES ('000002', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes` VALUES ('000003', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');
INSERT INTO `classes` VALUES ('000004', 'EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes` VALUES ('000005', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes` VALUES ('000006', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');

-- ----------------------------
-- Table structure for classes_copy1
-- ----------------------------
DROP TABLE IF EXISTS `classes_copy1`;
CREATE TABLE `classes_copy1`  (
  `cInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cTimeStart` time(6) NULL DEFAULT NULL,
  `cTimeEnd` time(6) NULL DEFAULT NULL,
  PRIMARY KEY (`cInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes_copy1
-- ----------------------------
INSERT INTO `classes_copy1` VALUES ('000001', 'EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000002', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000003', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000004', 'EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000005', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000006', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000007', ' EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000008', 'EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000009', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000010', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000011', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000012', ' EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000013', ' EBZ', '二班制', '09:00:00.000000', '18:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000014', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000015', 'SBZ', '三班制', '07:00:00.000000', '23:00:00.000000');
INSERT INTO `classes_copy1` VALUES ('000016', 'YBZ', '一班制', '08:00:00.000000', '16:00:00.000000');

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
  `dInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dDuty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dSuper` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dLeader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments
-- ----------------------------
INSERT INTO `departments` VALUES ('000001', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李白');
INSERT INTO `departments` VALUES ('000002', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李二狗');
INSERT INTO `departments` VALUES ('000003', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '杜甫');
INSERT INTO `departments` VALUES ('000004', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李白');
INSERT INTO `departments` VALUES ('000005', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李二狗');
INSERT INTO `departments` VALUES ('000006', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '杜甫');
INSERT INTO `departments` VALUES ('000007', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李白');
INSERT INTO `departments` VALUES ('000008', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李二狗');
INSERT INTO `departments` VALUES ('000009', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '杜甫');
INSERT INTO `departments` VALUES ('000010', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李白');
INSERT INTO `departments` VALUES ('000011', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李二狗');
INSERT INTO `departments` VALUES ('000012', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '杜甫');
INSERT INTO `departments` VALUES ('000013', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李白');
INSERT INTO `departments` VALUES ('000014', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李二狗');
INSERT INTO `departments` VALUES ('000015', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '杜甫');
INSERT INTO `departments` VALUES ('000016', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '李白');
INSERT INTO `departments` VALUES ('000017', 'ZCS', '总裁室', '负责管理总裁', '财务室', '偶是备注', '李二狗');
INSERT INTO `departments` VALUES ('000018', 'KJ', '会计室', '负责会计', '财务室', '偶是也备注', '杜甫');

-- ----------------------------
-- Table structure for departments_copy1
-- ----------------------------
DROP TABLE IF EXISTS `departments_copy1`;
CREATE TABLE `departments_copy1`  (
  `dInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dDuty` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dSuper` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dLeader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departments_copy1
-- ----------------------------
INSERT INTO `departments_copy1` VALUES ('000001', 'ZCS', '总裁室', '负责管理总裁', '财务室', '管理人员', '杜甫');
INSERT INTO `departments_copy1` VALUES ('000002', 'KJ', '会计室', '负责会计', '财务室', '骨干', '李白');
INSERT INTO `departments_copy1` VALUES ('000003', 'ZCS', '总裁室', '负责管理总裁', '财务室', '管理人员', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000004', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000005', 'ZCS', '总裁室', '负责管理总裁', '财务室', '技术人员', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000006', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000007', 'ZCS', '总裁室', '负责管理总裁', '财务室', '技术人员', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000008', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000009', 'ZCS', '总裁室', '负责管理总裁', '财务室', '管理人员', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000010', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000011', 'ZCS', '总裁室', '负责管理总裁', '财务室', '骨干', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000012', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000013', 'ZCS', '总裁室', '负责管理总裁', '财务室', '骨干', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000014', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');
INSERT INTO `departments_copy1` VALUES ('000015', 'ZCS', '总裁室', '负责管理总裁', '财务室', '管理人员', '林湖钦');
INSERT INTO `departments_copy1` VALUES ('000016', 'KJ', '会计室', '负责会计', '财务室', '技术人员', '吴念梅');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
  `eEmpId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '自增主键',
  `eId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-2位：部门编号\r\n3位：性别  0:男 1:女\r\n4-6位：各部门内部编号',
  `eName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '只允许 中文、英文、空格，且字母开头',
  `eAge` int(3) NOT NULL,
  `eIdNum` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许0-9数字和X，且只允许最后一位出现X',
  `eSalary` int(7) NULL DEFAULT NULL COMMENT '默认值位0，即为未设置薪水',
  `ePhoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许11位数字',
  `eEmerContact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许 中文、英文、空格，且字母开头',
  `eEmerContactPhoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许11位数字',
  `ePersDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选填，默认为空',
  `eSex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0:男 1:女；  下拉选择男女',
  `eNation` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '只允许中文，且不包含“族”字，可从下拉框选择',
  `eDeptId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  PRIMARY KEY (`eEmpId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('000001', '316601', '柯登明', 1, '350521199709157801', 20001, '15259598701', '柯联系', '18059774701', '我是柯登明', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000002', '316602', '蒋绿波', 2, '350521199709157802', 20002, '15259598702', '蒋联系', '18059774702', '我是蒋绿波', '女', '傣', 'HR');
INSERT INTO `employees` VALUES ('000003', '316603', '白伟发', 3, '350521199709157803', 20003, '15259598703', '白联系', '18059774703', '我是白伟发', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000004', '316604', '林湖钦', 4, '350521199709157804', 20004, '15259598704', '林联系', '18059774704', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000005', '316605', '吴念梅', 5, '350521199709157805', 20005, '15259598705', '吴联系', '18059774705', '我是吴念梅', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000006', '316606', '柯登明', 6, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000007', '316607', '蒋绿波', 7, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000008', '316608', '白伟发', 8, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000009', '316609', '林湖钦', 9, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000010', '316610', '吴念梅', 10, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000011', '316611', '柯登明', 11, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000012', '316612', '蒋绿波', 12, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000013', '316613', '白伟发', 13, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000014', '316614', '林湖钦', 14, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000015', '316615', '吴念梅', 15, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees` VALUES ('000016', '316616', '林湖钦', 16, '350521199709157840', 404040, '15259598740', '林', '18059774740', '我是林湖钦', '男', '汉', 'CWS');

-- ----------------------------
-- Table structure for employees_copy1
-- ----------------------------
DROP TABLE IF EXISTS `employees_copy1`;
CREATE TABLE `employees_copy1`  (
  `eEmpId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '自增主键',
  `eId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1-2位：部门编号\r\n3位：性别  0:男 1:女\r\n4-6位：各部门内部编号',
  `eName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '只允许 中文、英文、空格，且字母开头',
  `eAge` int(3) NOT NULL,
  `eIdNum` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许0-9数字和X，且只允许最后一位出现X',
  `eSalary` int(7) NULL DEFAULT NULL COMMENT '默认值位0，即为未设置薪水',
  `ePhoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许11位数字',
  `eEmerContact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许 中文、英文、空格，且字母开头',
  `eEmerContactPhoneNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只允许11位数字',
  `ePersDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选填，默认为空',
  `eSex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0:男 1:女；  下拉选择男女',
  `eNation` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '只允许中文，且不包含“族”字，可从下拉框选择',
  `eDeptId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门编号',
  PRIMARY KEY (`eEmpId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employees_copy1
-- ----------------------------
INSERT INTO `employees_copy1` VALUES ('000001', '316601', '柯登明', 22, '350521199709157801', 20001, '15259598701', '柯一', '18059774701', '我是柯登明', '男', '汉', 'CWS');
INSERT INTO `employees_copy1` VALUES ('000002', '316602', '蒋绿波', 23, '350521199709157802', 20002, '15259598702', '蒋二', '18059774702', '我是蒋绿波', '女', '傣', 'KJ');
INSERT INTO `employees_copy1` VALUES ('000003', '316603', '白伟发', 25, '350521199709157803', 20003, '15259598703', '白三', '18059774703', '我是白伟发', '男', '汉', 'HR');
INSERT INTO `employees_copy1` VALUES ('000004', '316604', '林湖钦', 21, '350521199709157804', 20004, '15259598704', '林四', '18059774704', '我是林湖钦', '男', '汉', 'CWS');
INSERT INTO `employees_copy1` VALUES ('000005', '316605', '吴念梅', 30, '350521199709157805', 20005, '15259598705', '吴五', '18059774705', '我是吴念梅', '男', '汉', 'KJ');
INSERT INTO `employees_copy1` VALUES ('000006', '316606', '张毅', 60, '350521199709157806', 404040, '15259598706', '张六', '18059774706', '我是张毅', '男', '朝鲜', 'HR');
INSERT INTO `employees_copy1` VALUES ('000007', '316607', '薛松', 27, '350521199709157807', 404040, '15259598707', '薛七', '18059774707', '我是薛松', '男', '汉', 'HR');
INSERT INTO `employees_copy1` VALUES ('000008', '316608', '邗江', 38, '350521199709157808', 404040, '15259598708', '邗八', '18059774708', '我是邗江', '男', '畲', 'KJ');
INSERT INTO `employees_copy1` VALUES ('000009', '316609', '刘诗殿', 19, '350521199709157809', 404040, '15259598709', '刘九', '18059774709', '我是刘诗殿', '男', '汉', 'HR');
INSERT INTO `employees_copy1` VALUES ('000010', '316610', '王滨城', 52, '350521199709157810', 404040, '15259598710', '王十', '18059774710', '我是王滨城', '男', '苗', 'CWS');
INSERT INTO `employees_copy1` VALUES ('000011', '316611', '许志新', 58, '350521199709157811', 404040, '15259598711', '许十一', '18059774711', '我是许志新', '男', '壮', 'KJ');
INSERT INTO `employees_copy1` VALUES ('000012', '316612', '蒋文维', 52, '350521199709157812', 404040, '15259598712', '蒋十二', '18059774712', '我是蒋文维', '男', '汉', 'HR');
INSERT INTO `employees_copy1` VALUES ('000013', '316613', '陈志鑫', 33, '350521199709157813', 404040, '15259598713', '陈十三', '18059774713', '我是陈志鑫', '男', '汉', 'CWS');
INSERT INTO `employees_copy1` VALUES ('000014', '316614', '张诗妍', 44, '350521199709157814', 404040, '15259598714', '张十四', '18059774714', '我是张诗妍', '女', '汉', 'HR');
INSERT INTO `employees_copy1` VALUES ('000015', '316615', '李慧峰', 25, '350521199709157815', 404040, '15259598715', '李十五', '18059774715', '我是李慧峰', '男', '汉', 'KJ');
INSERT INTO `employees_copy1` VALUES ('000016', '316616', '哈妮克孜', 19, '350521199709157816', 404040, '15259598716', '迪丽热巴', '18059774716', '我是哈妮克孜', '女', '藏', 'KJ');

-- ----------------------------
-- Table structure for jobs
-- ----------------------------
DROP TABLE IF EXISTS `jobs`;
CREATE TABLE `jobs`  (
  `jInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jParent` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jSuper` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jType` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs
-- ----------------------------
INSERT INTO `jobs` VALUES ('000001', 'CWS', '财务室', '管理财务的东西', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs` VALUES ('000002', 'KJ', '会计', '计算税收的东西', 'CEO', NULL, '技术类');
INSERT INTO `jobs` VALUES ('000003', 'HR', '人事部', '招人的东西', NULL, 'CEO', '测试类');
INSERT INTO `jobs` VALUES ('000004', 'CWS', '财务室', '管理财务的东西', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs` VALUES ('000005', 'KJ', '会计', '计算税收的东西', 'CEO', NULL, '技术类');
INSERT INTO `jobs` VALUES ('000006', 'HR', '人事部', '招人的东西', NULL, 'CEO', '测试类');
INSERT INTO `jobs` VALUES ('000007', 'HR', '人事部', '招人的东西', NULL, 'CEO', '测试类');
INSERT INTO `jobs` VALUES ('000008', 'KJ', '会计', '计算税收的东西', 'CEO', NULL, '技术类');
INSERT INTO `jobs` VALUES ('000009', 'HR', '人事部', '招人的东西', NULL, 'CEO', '测试类');
INSERT INTO `jobs` VALUES ('000010', 'CCWS', '财务室', '管理财务的东西', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs` VALUES ('000011', 'KJG', '会计', '计算税收的东西', 'CEO', NULL, '技术类');
INSERT INTO `jobs` VALUES ('000012', 'HRY', '人事部', '招人的东西', NULL, 'CEO', '测试类');

-- ----------------------------
-- Table structure for jobs_copy1
-- ----------------------------
DROP TABLE IF EXISTS `jobs_copy1`;
CREATE TABLE `jobs_copy1`  (
  `jInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jParent` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jSuper` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jType` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobs_copy1
-- ----------------------------
INSERT INTO `jobs_copy1` VALUES ('000001', 'CWS', '财务室', '管理财务', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs_copy1` VALUES ('000002', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');
INSERT INTO `jobs_copy1` VALUES ('000003', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000004', 'CWS', '财务室', '管理财务', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs_copy1` VALUES ('000005', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');
INSERT INTO `jobs_copy1` VALUES ('000006', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000007', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000008', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');
INSERT INTO `jobs_copy1` VALUES ('000009', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000010', 'CWS', '财务室', '管理财务', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs_copy1` VALUES ('000011', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');
INSERT INTO `jobs_copy1` VALUES ('000012', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000013', 'CWS', '财务室', '管理财务', 'ZCS', 'CEO', '管理类');
INSERT INTO `jobs_copy1` VALUES ('000014', 'HR', '人事部', '招收人才', NULL, 'CEO', '测试类');
INSERT INTO `jobs_copy1` VALUES ('000015', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');
INSERT INTO `jobs_copy1` VALUES ('000016', 'KJ', '会计', '计算税收', 'CEO', NULL, '技术类');

-- ----------------------------
-- Table structure for leaves
-- ----------------------------
DROP TABLE IF EXISTS `leaves`;
CREATE TABLE `leaves`  (
  `qInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qTimeStart` timestamp(6) NULL DEFAULT NULL,
  `qTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `qDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`qInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leaves
-- ----------------------------
INSERT INTO `leaves` VALUES ('000001', 'admin', '管理员', '2019-02-03 00:09:00.000000', '2019-02-05 00:00:00.000000', NULL);
INSERT INTO `leaves` VALUES ('000002', 'ming', '小明', '2019-05-05 00:00:00.000000', '2019-05-14 15:00:00.000000', NULL);

-- ----------------------------
-- Table structure for leaves_copy1
-- ----------------------------
DROP TABLE IF EXISTS `leaves_copy1`;
CREATE TABLE `leaves_copy1`  (
  `qInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qTimeStart` timestamp(6) NULL DEFAULT NULL,
  `qTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `qDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`qInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leaves_copy1
-- ----------------------------
INSERT INTO `leaves_copy1` VALUES ('000001', '316601', '柯登明', '2019-02-03 00:09:00.000000', '2019-02-05 00:00:00.000000', '回家');
INSERT INTO `leaves_copy1` VALUES ('000002', '316605', '吴念梅', '2019-05-05 00:00:00.000000', '2019-05-14 15:00:00.000000', '病假');
INSERT INTO `leaves_copy1` VALUES ('000003', '316604', '林湖钦', '2019-06-04 07:22:58.000000', '2019-06-12 07:23:18.000000', '病假');
INSERT INTO `leaves_copy1` VALUES ('000004', '316612', '蒋文维', '2019-07-02 12:21:18.000000', '2019-07-05 15:11:31.000000', '回家');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `Id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '为员工表  Employees中的eEmpId字段\r\n',
  `UserName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '默认为Admin，用户可修改',
  `PassWord` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '默认为1，用户必须修改\r\n修改后的密码至少6位，最多12位且位数字和字符的组合，区分大小写',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('316601', '柯登明', '1');
INSERT INTO `login` VALUES ('316602', '蒋绿波', '1');
INSERT INTO `login` VALUES ('316603', '白伟发', '1');
INSERT INTO `login` VALUES ('316604', '林湖钦', '1');
INSERT INTO `login` VALUES ('316605', '吴念梅', '1');
INSERT INTO `login` VALUES ('316606', '张毅', '1');
INSERT INTO `login` VALUES ('316607', '薛松', '1');
INSERT INTO `login` VALUES ('316608', '邗江', '1');
INSERT INTO `login` VALUES ('316609', '刘诗殿', '1');
INSERT INTO `login` VALUES ('316610', '王滨城', '1');
INSERT INTO `login` VALUES ('316611', '许志新', '1');
INSERT INTO `login` VALUES ('316612', '蒋文维', '1');
INSERT INTO `login` VALUES ('316613', '陈志鑫', '1');
INSERT INTO `login` VALUES ('316614', '张诗妍', '1');
INSERT INTO `login` VALUES ('316615', '李慧峰', '1');
INSERT INTO `login` VALUES ('316616', '哈妮克孜', '1');

-- ----------------------------
-- Table structure for login_copy1
-- ----------------------------
DROP TABLE IF EXISTS `login_copy1`;
CREATE TABLE `login_copy1`  (
  `Id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '为员工表  Employees中的eEmpId字段\r\n',
  `UserName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '默认为Admin，用户可修改',
  `PassWord` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '默认为1，用户必须修改\r\n修改后的密码至少6位，最多12位且位数字和字符的组合，区分大小写',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_copy1
-- ----------------------------
INSERT INTO `login_copy1` VALUES ('316601', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316602', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316603', 'name3', '1');
INSERT INTO `login_copy1` VALUES ('316604', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316605', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316606', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316607', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316608', 'kedengming', '1');
INSERT INTO `login_copy1` VALUES ('316609', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316610', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316611', 'name3', '1');
INSERT INTO `login_copy1` VALUES ('316612', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316613', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316614', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316615', 'Admin', '1');
INSERT INTO `login_copy1` VALUES ('316616', 'kedengming', '1');

-- ----------------------------
-- Table structure for paysalarys
-- ----------------------------
DROP TABLE IF EXISTS `paysalarys`;
CREATE TABLE `paysalarys`  (
  `pInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pSalary` int(6) NULL DEFAULT NULL,
  `pTimeStart` timestamp(6) NULL DEFAULT NULL,
  `pTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `pHours` int(6) NULL DEFAULT NULL,
  PRIMARY KEY (`pInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paysalarys
-- ----------------------------
INSERT INTO `paysalarys` VALUES ('000001', '101001', '小明', 90, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys` VALUES ('000002', '101002', '小明', 90, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys` VALUES ('000003', '101003', '小明', 100, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);

-- ----------------------------
-- Table structure for paysalarys_copy1
-- ----------------------------
DROP TABLE IF EXISTS `paysalarys_copy1`;
CREATE TABLE `paysalarys_copy1`  (
  `pInnerId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pSalary` int(6) NULL DEFAULT NULL,
  `pTimeStart` timestamp(6) NULL DEFAULT NULL,
  `pTimeEnd` timestamp(6) NULL DEFAULT NULL,
  `pHours` int(6) NULL DEFAULT NULL,
  PRIMARY KEY (`pInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paysalarys_copy1
-- ----------------------------
INSERT INTO `paysalarys_copy1` VALUES ('000001', '316601', '柯登明', 90, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000002', '316602', '蒋绿波', 90, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000003', '316603', '白伟发', 100, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);
INSERT INTO `paysalarys_copy1` VALUES ('000004', '316604', '林湖钦', 45, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000005', '316605', '吴念梅', 60, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000006', '316606', '张毅', 105, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);
INSERT INTO `paysalarys_copy1` VALUES ('000007', '316607', '薛松', 65, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000008', '316608', '邗江', 85, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000009', '316609', '刘诗殿', 70, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);
INSERT INTO `paysalarys_copy1` VALUES ('000010', '316610', '王滨城', 45, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000011', '316611', '许志新', 55, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000012', '316612', '蒋文维', 60, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);
INSERT INTO `paysalarys_copy1` VALUES ('000013', '316613', '陈志鑫', 95, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000014', '316614', '张诗妍', 50, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);
INSERT INTO `paysalarys_copy1` VALUES ('000015', '316615', '李慧峰', 55, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 10);
INSERT INTO `paysalarys_copy1` VALUES ('000016', '316616', '哈妮克孜', 60, '2019-06-01 00:00:00.000000', '2019-06-30 00:00:00.000000', 9);

-- ----------------------------
-- Table structure for punchcards
-- ----------------------------
DROP TABLE IF EXISTS `punchcards`;
CREATE TABLE `punchcards`  (
  `pInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pDateTime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`pInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punchcards
-- ----------------------------
INSERT INTO `punchcards` VALUES ('000001', '101001', '姓名1', '2019-07-01 08:55:00.000000');
INSERT INTO `punchcards` VALUES ('000002', '101001', '姓名1', '2019-07-01 17:55:00.000000');
INSERT INTO `punchcards` VALUES ('000003', '101002', '姓名2', '2019-07-04 09:00:00.000000');
INSERT INTO `punchcards` VALUES ('000004', '101002', '姓名2', '2019-07-04 18:01:00.000000');
INSERT INTO `punchcards` VALUES ('000005', '101003', '姓名3', '2019-07-03 09:01:00.000000');
INSERT INTO `punchcards` VALUES ('000006', '101003', '姓名3', '2019-07-03 18:00:00.000000');
INSERT INTO `punchcards` VALUES ('000007', '101004', '姓名4', '2019-07-04 09:05:00.000000');
INSERT INTO `punchcards` VALUES ('000008', '101004', '姓名4', '2019-07-04 17:45:00.000000');
INSERT INTO `punchcards` VALUES ('000009', '101005', '姓名5', '2019-07-05 09:00:00.000000');
INSERT INTO `punchcards` VALUES ('000010', '101006', '姓名6', '2019-07-05 20:00:00.000000');

-- ----------------------------
-- Table structure for punchcards_copy1
-- ----------------------------
DROP TABLE IF EXISTS `punchcards_copy1`;
CREATE TABLE `punchcards_copy1`  (
  `pInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pDateTime` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`pInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punchcards_copy1
-- ----------------------------
INSERT INTO `punchcards_copy1` VALUES ('000001', '316601', '柯登明', '2019-07-07 09:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000002', '316602', '蒋绿波', '2019-07-07 15:55:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000003', '316603', '白伟发', '2019-07-07 19:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000004', '316604', '林湖钦', '2019-07-07 18:01:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000005', '316605', '吴念梅', '2019-07-07 09:01:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000006', '316606', '张毅', '2019-07-07 18:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000007', '316607', '薛松', '2019-07-07 09:05:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000008', '316608', '邗江', '2019-07-07 19:45:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000009', '316609', '刘诗殿', '2019-07-07 20:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000010', '316610', '王滨城', '2019-07-07 07:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000011', '316611', '许志新', '2019-07-07 09:01:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000012', '316612', '蒋文维', '2019-07-07 19:01:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000013', '316613', '陈志鑫', '2019-07-07 08:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000014', '316614', '张诗妍', '2019-07-07 09:55:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000015', '316615', '李慧峰', '2019-07-07 18:00:00.000000');
INSERT INTO `punchcards_copy1` VALUES ('000016', '316616', '哈妮克孜', '2019-07-07 08:00:00.000000');

-- ----------------------------
-- Table structure for repaircards
-- ----------------------------
DROP TABLE IF EXISTS `repaircards`;
CREATE TABLE `repaircards`  (
  `rrInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rrId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rrName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rrDateTime` timestamp(6) NULL DEFAULT NULL,
  `rrDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rrInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repaircards
-- ----------------------------
INSERT INTO `repaircards` VALUES ('000001', '101005', '姓名5', '2019-07-05 18:00:00.000000', '我迟到了');
INSERT INTO `repaircards` VALUES ('000002', '101006', '姓名6', '2019-07-05 09:00:00.000000', '我迟到了FF');
INSERT INTO `repaircards` VALUES ('000003', '101007', '姓名7', '2019-07-07 18:00:00.000000', '我迟到了');
INSERT INTO `repaircards` VALUES ('000004', '101007', '姓名7', '2019-07-07 09:00:00.000000', '我迟到了');
INSERT INTO `repaircards` VALUES ('000005', '101009', '姓名9', '2019-07-09 09:00:00.000000', '我迟到了');
INSERT INTO `repaircards` VALUES ('000006', '101009', '姓名9', '2019-07-09 18:00:00.000000', '我迟到了');

-- ----------------------------
-- Table structure for repaircards_copy1
-- ----------------------------
DROP TABLE IF EXISTS `repaircards_copy1`;
CREATE TABLE `repaircards_copy1`  (
  `rrInnerId` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rrId` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rrName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rrDateTime` timestamp(6) NULL DEFAULT NULL,
  `rrDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rrInnerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repaircards_copy1
-- ----------------------------
INSERT INTO `repaircards_copy1` VALUES ('000001', '316601', '柯登明', '2019-07-07 18:00:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000002', '316602', '蒋绿波', '2019-07-07 08:00:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000003', '316603', '白伟发', '2019-07-07 08:05:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000004', '316604', '林湖钦', '2019-07-07 09:01:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000005', '316605', '吴念梅', '2019-07-07 17:01:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000006', '316606', '张毅', '2019-07-07 09:00:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000007', '316607', '薛松', '2019-07-07 18:05:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000008', '316608', '邗江', '2019-07-07 08:45:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000009', '316609', '刘诗殿', '2019-07-07 09:00:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000010', '316610', '王滨城', '2019-07-07 20:00:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000011', '316611', '许志新', '2019-07-07 18:01:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000012', '316612', '蒋文维', '2019-07-07 09:01:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000013', '316613', '陈志鑫', '2019-07-07 18:00:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000014', '316614', '张诗妍', '2019-07-07 17:55:00.000000', '我迟到了');
INSERT INTO `repaircards_copy1` VALUES ('000015', '316615', '李慧峰', '2019-07-07 09:00:00.000000', '我早退了');
INSERT INTO `repaircards_copy1` VALUES ('000016', '316616', '哈妮克孜', '2019-07-07 20:00:00.000000', '我早退了');

SET FOREIGN_KEY_CHECKS = 1;

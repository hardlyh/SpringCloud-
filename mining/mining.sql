/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50649
 Source Host           : localhost:3306
 Source Schema         : mining

 Target Server Type    : MySQL
 Target Server Version : 50649
 File Encoding         : 65001

 Date: 06/08/2020 18:09:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mining_account
-- ----------------------------
DROP TABLE IF EXISTS `mining_account`;
CREATE TABLE `mining_account`  (
  `member_id` int(32) NOT NULL DEFAULT '' AUTO_INCREMENT COMMENT '会员ID',
  `staff_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '账号/手机号',
  `staff_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '工作人员姓名',
  `staff_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '登录密码',
  `identity_card_type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '证件种类',
  `identity_card_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '身份证号',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '账号有效状态',
  `member_note` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `member_register_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '注册者',
  `member_register_datetime` datetime(0) NOT NULL COMMENT '注册日时',
  `member_update_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `member_update_datetime` datetime(0) NOT NULL COMMENT '更新日时',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '挖矿用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mining_account
-- ----------------------------
INSERT INTO `mining_account` VALUES (1, '123', '123', '', 1, '', 0, 1, '', '', '2020-08-06 15:10:26', '', '2020-08-06 15:10:30');

-- ----------------------------
-- Table structure for mining_income
-- ----------------------------
DROP TABLE IF EXISTS `mining_income`;
CREATE TABLE `mining_income`  (
  `income_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表ID',
  `income_day` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '时间',
  `principal` int(64) NOT NULL DEFAULT 0 COMMENT '本金(总)',
  `profit` int(64) NOT NULL DEFAULT 0 COMMENT '利润(总)',
  `profit_margin` int(64) NOT NULL DEFAULT 0 COMMENT '利润率(总)',
  `count` int(4) NOT NULL DEFAULT 0 COMMENT '笔数(总)',
  `total_amt` int(64) NOT NULL COMMENT '总额',
  `create_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单生成者',
  `create_datetime` datetime(0) DEFAULT NULL COMMENT '订单生成日时',
  `update_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单更新者',
  `update_datetime` datetime(0) DEFAULT NULL COMMENT '订单更新日时',
  PRIMARY KEY (`income_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '挖矿收入表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mining_income
-- ----------------------------
INSERT INTO `mining_income` VALUES (1, '2020-08-08', 891950, 71356, 8, 5, 963306, '', '2020-08-06 17:40:00', '2020-08-06 17:40:00', NULL);

-- ----------------------------
-- Table structure for mining_outlay
-- ----------------------------
DROP TABLE IF EXISTS `mining_outlay`;
CREATE TABLE `mining_outlay`  (
  `outlay_id` int(32) NOT NULL DEFAULT 1 AUTO_INCREMENT COMMENT '表Id',
  `outlay_day` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '购买时间',
  `day_number` int(8) NOT NULL DEFAULT 0 COMMENT '天数',
  `price` int(64) NOT NULL DEFAULT 0 COMMENT '价格',
  `total_amt` int(64) NOT NULL COMMENT '总金额',
  `profit` int(64) NOT NULL DEFAULT 0 COMMENT '利润',
  `rete` int(4) NOT NULL DEFAULT 0 COMMENT '利率',
  `line_number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '到期日',
  `register_datetime` datetime(0) NOT NULL COMMENT '登录日时',
  `update_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_datetime` datetime(0) NOT NULL COMMENT '更新日时',
  PRIMARY KEY (`outlay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '挖矿支出' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mining_outlay
-- ----------------------------
INSERT INTO `mining_outlay` VALUES (1, '2020-08-06', 2, 235900, 254772, 18872, 8, '2020-08-08', '2020-08-06 17:39:59', '', '2020-08-06 17:39:59');
INSERT INTO `mining_outlay` VALUES (2, '2020-08-06', 2, 235900, 254772, 18872, 8, '2020-08-08', '2020-08-06 17:40:21', '', '2020-08-06 17:40:21');
INSERT INTO `mining_outlay` VALUES (3, '2020-08-06', 2, 128950, 139266, 10316, 8, '2020-08-08', '2020-08-06 17:41:08', '', '2020-08-06 17:41:08');
INSERT INTO `mining_outlay` VALUES (4, '2020-08-06', 2, 145600, 157248, 11648, 8, '2020-08-08', '2020-08-06 17:41:38', '', '2020-08-06 17:41:38');
INSERT INTO `mining_outlay` VALUES (5, '2020-08-06', 2, 145600, 157248, 11648, 8, '2020-08-08', '2020-08-06 17:50:22', '', '2020-08-06 17:50:22');

SET FOREIGN_KEY_CHECKS = 1;

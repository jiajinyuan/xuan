/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : xuan

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 11/06/2019 10:13:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID，自增长',
  `NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `CREATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = 'TEST' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES (1, '张三', '2019-02-02 12:59:04', '2019-02-02 12:59:04');
INSERT INTO `t_test` VALUES (2, '李四', '2019-02-02 12:59:15', '2019-02-02 12:59:15');
INSERT INTO `t_test` VALUES (3, '王五', '2019-02-02 12:59:21', '2019-02-02 12:59:21');
INSERT INTO `t_test` VALUES (4, '赵六', '2019-02-02 12:59:28', '2019-02-02 12:59:28');
INSERT INTO `t_test` VALUES (5, '王川', '2018-12-04 19:25:26', '2018-12-04 19:25:26');

SET FOREIGN_KEY_CHECKS = 1;

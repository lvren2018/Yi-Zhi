/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 06/06/2024 14:05:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dev_entries
-- ----------------------------
DROP TABLE IF EXISTS `dev_entries`;
CREATE TABLE `dev_entries`  (
  `entries` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作品名',
  `entries_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `score` int NULL DEFAULT NULL COMMENT '实时平均分',
  `user_id` int NOT NULL COMMENT '账号ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`entries_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dev_entries
-- ----------------------------
INSERT INTO `dev_entries` VALUES ('参赛作品', 1, '17838912389', 55, 3, '2024-06-05 09:43:42');
INSERT INTO `dev_entries` VALUES ('参赛作品User', 5, '1782361', NULL, 5, NULL);
INSERT INTO `dev_entries` VALUES ('参赛作品User', 7, '1782361', NULL, 5, NULL);
INSERT INTO `dev_entries` VALUES ('参赛作品User', 8, '1782361', NULL, 5, NULL);
INSERT INTO `dev_entries` VALUES ('参赛作品1008', 9, '1238456', 243, 3, '2024-06-06 13:58:37');
INSERT INTO `dev_entries` VALUES ('参赛作品1008', 10, '1238456', 243, 3, '2024-06-06 13:58:37');

SET FOREIGN_KEY_CHECKS = 1;

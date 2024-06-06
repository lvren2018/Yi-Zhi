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

 Date: 06/06/2024 14:05:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dev_valuation
-- ----------------------------
DROP TABLE IF EXISTS `dev_valuation`;
CREATE TABLE `dev_valuation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teaching_implementation_score` int NULL DEFAULT NULL COMMENT '教学实施',
  `teaching_plan_score` int NULL DEFAULT NULL COMMENT '教案',
  `video_materials_score` int NULL DEFAULT NULL COMMENT '视频资料',
  `training_plan_score` int NULL DEFAULT NULL COMMENT '专业人才培养方案',
  `curriculum_criterion_score` int NULL DEFAULT NULL COMMENT '课程标准',
  `textbook_selection_score` int NULL DEFAULT NULL COMMENT '教材选用',
  `create_time` datetime NULL DEFAULT NULL COMMENT '评分时间',
  `entries_id` int NULL DEFAULT NULL COMMENT '作品ID',
  `create_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评委名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dev_valuation
-- ----------------------------
INSERT INTO `dev_valuation` VALUES (1, 55, 23, 31, 22, 11, 33, '2024-06-05 13:34:36', 1, '曾令根');
INSERT INTO `dev_valuation` VALUES (3, 24, 13, 55, 77, 42, 57, '2024-06-06 13:16:00', 5, '曾令根');

SET FOREIGN_KEY_CHECKS = 1;

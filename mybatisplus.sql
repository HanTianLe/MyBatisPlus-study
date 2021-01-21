/*
 Navicat Premium Data Transfer

 Source Server         : mysql-8.0.16
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : mybatisplus

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 22/12/2020 22:16:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `account_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '张三', 11);
INSERT INTO `account` VALUES (2, '李四', 22);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `category` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 20, '电脑', 1);
INSERT INTO `product` VALUES (1, 30, '电视', 1);
INSERT INTO `product` VALUES (2, 14, '手机', 2);
INSERT INTO `product` VALUES (3, 15, '平板', 2);
INSERT INTO `product` VALUES (3, 35, 'Surface', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `update_time` datetime(0) DEFAULT NULL,
  `version` int(11) DEFAULT 1,
  `status` int(11) DEFAULT 1,
  `level` int(11) DEFAULT 1,
  `deleted` int(11) DEFAULT 0 COMMENT '0 表示没有被删除，1 表示被删除了',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 10, NULL, '2020-12-16 19:16:01', 1, 1, 1, 0);
INSERT INTO `user` VALUES (2, '李四', 20, NULL, '2020-12-16 19:04:47', 1, 1, 2, 0);
INSERT INTO `user` VALUES (3, '王五', 30, NULL, NULL, 1, 1, 3, 0);
INSERT INTO `user` VALUES (12, '韩七', 50, '2020-12-13 13:45:17', '2020-12-13 13:45:17', 1, 0, 3, 0);
INSERT INTO `user` VALUES (13, '张四', 10, '2020-12-17 07:58:50', NULL, 1, 1, 1, 0);
INSERT INTO `user` VALUES (14, '小张', 10, '2020-12-17 08:09:28', NULL, 1, 1, 1, 0);
INSERT INTO `user` VALUES (15, '小韩', 20, '2020-12-18 21:48:12', '2020-12-18 21:48:15', 1, 1, 1, 0);
INSERT INTO `user` VALUES (16, '小陈', 30, '2020-12-18 21:48:31', '2020-12-18 21:48:32', 1, 1, 1, 0);
INSERT INTO `user` VALUES (17, '小刘', 40, '2020-12-18 21:48:44', '2020-12-18 21:48:47', 1, 1, 1, 0);
INSERT INTO `user` VALUES (23, '测试3', 11, NULL, '2020-12-19 09:13:46', 1, 1, 1, 0);

SET FOREIGN_KEY_CHECKS = 1;

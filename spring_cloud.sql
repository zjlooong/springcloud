/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : spring_cloud

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 29/07/2019 10:19:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `detail_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小图',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1545817578640203769', '1545817578593129285', '157875196366160022', '皮蛋粥', 0.01, 1, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2018-12-26 17:46:20', '2018-12-26 17:46:20');
INSERT INTO `order_detail` VALUES ('1545817580763256605', '1545817578593129285', '157875227953464068', '慕斯蛋糕', 10.90, 5, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2018-12-26 17:46:22', '2018-12-26 17:46:22');
INSERT INTO `order_detail` VALUES ('1545817677996908230', '1545817677969286937', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2018-12-26 17:47:58', '2018-12-26 17:47:58');
INSERT INTO `order_detail` VALUES ('1545817678004484193', '1545817677969286937', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2018-12-26 17:47:58', '2018-12-26 17:47:58');
INSERT INTO `order_detail` VALUES ('1545817775351476221', '1545817775318559561', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2018-12-26 17:49:35', '2018-12-26 17:49:35');
INSERT INTO `order_detail` VALUES ('1545817775360828173', '1545817775318559561', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2018-12-26 17:49:35', '2018-12-26 17:49:35');
INSERT INTO `order_detail` VALUES ('1545817792217976168', '1545817792196645540', '157875196366160022', '皮蛋粥', 0.01, 330, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2018-12-26 17:49:52', '2018-12-26 17:49:52');
INSERT INTO `order_detail` VALUES ('1545817792226612061', '1545817792196645540', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2018-12-26 17:49:52', '2018-12-26 17:49:52');
INSERT INTO `order_detail` VALUES ('1546480135889540586', '1546480135661794682', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-01-03 09:48:56', '2019-01-03 09:48:56');
INSERT INTO `order_detail` VALUES ('1546480136583914892', '1546480135661794682', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-01-03 09:48:56', '2019-01-03 09:48:56');
INSERT INTO `order_detail` VALUES ('1550803345355430983', '1550803345267849347', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 10:42:25', '2019-02-22 10:42:25');
INSERT INTO `order_detail` VALUES ('1550803345416241636', '1550803345267849347', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 10:42:25', '2019-02-22 10:42:25');
INSERT INTO `order_detail` VALUES ('1550803364761106462', '1550803364730481639', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 10:42:44', '2019-02-22 10:42:44');
INSERT INTO `order_detail` VALUES ('1550803364763863751', '1550803364730481639', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 10:42:44', '2019-02-22 10:42:44');
INSERT INTO `order_detail` VALUES ('1550803568024541429', '1550803567159193512', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 10:46:08', '2019-02-22 10:46:08');
INSERT INTO `order_detail` VALUES ('1550803568087410222', '1550803567159193512', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 10:46:08', '2019-02-22 10:46:08');
INSERT INTO `order_detail` VALUES ('1550803578361753194', '1550803578319233571', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 10:46:18', '2019-02-22 10:46:18');
INSERT INTO `order_detail` VALUES ('1550803578365978914', '1550803578319233571', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 10:46:18', '2019-02-22 10:46:18');
INSERT INTO `order_detail` VALUES ('1550804945361214464', '1550804944451485358', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:09:05', '2019-02-22 11:09:05');
INSERT INTO `order_detail` VALUES ('1550804945426700044', '1550804944451485358', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:09:05', '2019-02-22 11:09:05');
INSERT INTO `order_detail` VALUES ('1550805102755567206', '1550805102035533019', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:11:42', '2019-02-22 11:11:42');
INSERT INTO `order_detail` VALUES ('1550805102809939696', '1550805102035533019', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:11:42', '2019-02-22 11:11:42');
INSERT INTO `order_detail` VALUES ('1550805618986552145', '1550805618334781919', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:20:19', '2019-02-22 11:20:19');
INSERT INTO `order_detail` VALUES ('1550805619036793802', '1550805618334781919', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:20:19', '2019-02-22 11:20:19');
INSERT INTO `order_detail` VALUES ('1550806299327964964', '1550806298670252574', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:31:39', '2019-02-22 11:31:39');
INSERT INTO `order_detail` VALUES ('1550806299377693229', '1550806298670252574', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:31:39', '2019-02-22 11:31:39');
INSERT INTO `order_detail` VALUES ('1550806303966698304', '1550806303944117773', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:31:44', '2019-02-22 11:31:44');
INSERT INTO `order_detail` VALUES ('1550806303968364841', '1550806303944117773', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:31:44', '2019-02-22 11:31:44');
INSERT INTO `order_detail` VALUES ('1550806306707749292', '1550806306682551116', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:31:46', '2019-02-22 11:31:46');
INSERT INTO `order_detail` VALUES ('1550806306712279242', '1550806306682551116', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:31:46', '2019-02-22 11:31:46');
INSERT INTO `order_detail` VALUES ('1550806845134406628', '1550806845105776881', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:40:45', '2019-02-22 11:40:45');
INSERT INTO `order_detail` VALUES ('1550806845136656561', '1550806845105776881', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:40:45', '2019-02-22 11:40:45');
INSERT INTO `order_detail` VALUES ('1550806953274989098', '1550806952614991902', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:42:33', '2019-02-22 11:42:33');
INSERT INTO `order_detail` VALUES ('1550806953325646911', '1550806952614991902', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:42:33', '2019-02-22 11:42:33');
INSERT INTO `order_detail` VALUES ('1550807098659226394', '1550807097885829042', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 11:44:58', '2019-02-22 11:44:58');
INSERT INTO `order_detail` VALUES ('1550807098724613326', '1550807097885829042', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 11:44:58', '2019-02-22 11:44:58');
INSERT INTO `order_detail` VALUES ('1550808561253988467', '1550808560413599793', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 12:09:21', '2019-02-22 12:09:21');
INSERT INTO `order_detail` VALUES ('1550808561308428173', '1550808560413599793', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 12:09:21', '2019-02-22 12:09:21');
INSERT INTO `order_detail` VALUES ('1550809926899778156', '1550809926168778360', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 12:32:07', '2019-02-22 12:32:07');
INSERT INTO `order_detail` VALUES ('1550809926954996994', '1550809926168778360', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 12:32:07', '2019-02-22 12:32:07');
INSERT INTO `order_detail` VALUES ('1550809956283859556', '1550809956246921421', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 12:32:36', '2019-02-22 12:32:36');
INSERT INTO `order_detail` VALUES ('1550809956285441313', '1550809956246921421', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 12:32:36', '2019-02-22 12:32:36');
INSERT INTO `order_detail` VALUES ('1550813841051690006', '1550813841017810471', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 13:37:21', '2019-02-22 13:37:21');
INSERT INTO `order_detail` VALUES ('1550813841058150059', '1550813841017810471', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 13:37:21', '2019-02-22 13:37:21');
INSERT INTO `order_detail` VALUES ('1550820844747946957', '1550820844687522051', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 15:34:04', '2019-02-22 15:34:04');
INSERT INTO `order_detail` VALUES ('1550820844754453995', '1550820844687522051', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 15:34:04', '2019-02-22 15:34:04');
INSERT INTO `order_detail` VALUES ('1550820869461202301', '1550820869440370397', '157875196366160022', '皮蛋粥', 0.01, 3, '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '2019-02-22 15:34:29', '2019-02-22 15:34:29');
INSERT INTO `order_detail` VALUES ('1550820869463339206', '1550820869440370397', '157875227953464068', '慕斯蛋糕', 10.90, 1, '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '2019-02-22 15:34:29', '2019-02-22 15:34:29');

-- ----------------------------
-- Table structure for order_master
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master`  (
  `order_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `buyer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8, 2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '支付状态, 默认未支付',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `idx_buyer_openid`(`buyer_openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO `order_master` VALUES ('1545817578593129285', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 54.51, 0, 0, '2018-12-26 17:46:22', '2018-12-26 17:46:22');
INSERT INTO `order_master` VALUES ('1545817677969286937', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2018-12-26 17:47:58', '2018-12-26 17:47:58');
INSERT INTO `order_master` VALUES ('1545817775318559561', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2018-12-26 17:49:35', '2018-12-26 17:49:35');
INSERT INTO `order_master` VALUES ('1546480135661794682', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 1, '2019-01-03 09:48:57', '2019-02-21 16:05:07');
INSERT INTO `order_master` VALUES ('1550803345267849347', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 10:42:25', '2019-02-22 10:42:25');
INSERT INTO `order_master` VALUES ('1550803364730481639', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 10:42:44', '2019-02-22 10:42:44');
INSERT INTO `order_master` VALUES ('1550803567159193512', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 10:46:08', '2019-02-22 10:46:08');
INSERT INTO `order_master` VALUES ('1550803578319233571', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 10:46:18', '2019-02-22 10:46:18');
INSERT INTO `order_master` VALUES ('1550804944451485358', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:09:05', '2019-02-22 11:09:05');
INSERT INTO `order_master` VALUES ('1550805102035533019', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:11:42', '2019-02-22 11:11:42');
INSERT INTO `order_master` VALUES ('1550805618334781919', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:20:19', '2019-02-22 11:20:19');
INSERT INTO `order_master` VALUES ('1550806298670252574', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:31:39', '2019-02-22 11:31:39');
INSERT INTO `order_master` VALUES ('1550806303944117773', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:31:44', '2019-02-22 11:31:44');
INSERT INTO `order_master` VALUES ('1550806306682551116', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:31:46', '2019-02-22 11:31:46');
INSERT INTO `order_master` VALUES ('1550806845105776881', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:40:45', '2019-02-22 11:40:45');
INSERT INTO `order_master` VALUES ('1550806952614991902', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:42:33', '2019-02-22 11:42:33');
INSERT INTO `order_master` VALUES ('1550807097885829042', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 11:44:58', '2019-02-22 11:44:58');
INSERT INTO `order_master` VALUES ('1550808560413599793', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 12:09:21', '2019-02-22 12:09:21');
INSERT INTO `order_master` VALUES ('1550809926168778360', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 12:32:07', '2019-02-22 12:32:07');
INSERT INTO `order_master` VALUES ('1550809956246921421', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 12:32:36', '2019-02-22 12:32:36');
INSERT INTO `order_master` VALUES ('1550813841017810471', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 13:37:21', '2019-02-22 13:37:21');
INSERT INTO `order_master` VALUES ('1550820844687522051', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 15:34:04', '2019-02-22 15:34:04');
INSERT INTO `order_master` VALUES ('1550820869440370397', 'zjl', '18108190656', 'shanghai', 'a8x32d8a256f6ad', 10.93, 0, 0, '2019-02-22 15:34:29', '2019-02-22 15:34:29');

-- ----------------------------
-- Table structure for product_category
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `uqe_category_type`(`category_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO `product_category` VALUES (1, '热榜', 1, '2017-03-28 16:40:22', '2018-12-14 15:23:08');
INSERT INTO `product_category` VALUES (2, '好吃的', 2, '2017-03-14 17:38:46', '2018-12-14 15:23:10');

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `product_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `product_price` decimal(8, 2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `product_icon` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '小图',
  `product_status` tinyint(3) DEFAULT 0 COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('157875196366160022', '皮蛋粥', 0.01, 972, '好吃的皮蛋粥', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', 0, 1, '2017-03-28 19:39:15', '2019-02-22 11:40:39');
INSERT INTO `product_info` VALUES ('157875227953464068', '慕斯蛋糕', 10.90, 166, '美味爽口', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', 1, 1, '2017-03-28 19:35:54', '2017-04-21 10:05:57');
INSERT INTO `product_info` VALUES ('164103465734242707', '蜜汁鸡翅', 0.02, 976, '好吃', '//fuss10.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg', 0, 1, '2017-03-30 17:11:56', '2017-06-24 19:20:54');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `openid` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '微信openid',
  `role` tinyint(1) NOT NULL COMMENT '1买家2卖家',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1111', '', '', 'abc', 0, '2019-02-21 13:40:17', '2019-02-21 13:40:17');
INSERT INTO `user_info` VALUES ('2222', '', '', 'xyz', 1, '2019-02-21 13:40:30', '2019-02-21 13:40:30');

SET FOREIGN_KEY_CHECKS = 1;

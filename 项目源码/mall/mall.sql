/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 02/04/2021 15:54:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT 'user_id外键',
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人的电话号，可以与用户的电话号不通',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人真名',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  `county` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区/县',
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详细地址',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (2, 1, '18888888888', '陈勤', '陕西省', '西安市', '未央区', '渭水校区');
INSERT INTO `address` VALUES (5, 5, '16666666666', '刘文广', '陕西省', '宝鸡市', '渭滨区', '长安大学渭水校区');
INSERT INTO `address` VALUES (6, 1, '12312312312', '刘聪', '陕西省', '西安市', '未央区', '长安大学渭水校区16楼');
INSERT INTO `address` VALUES (9, 1, '12343434343', '张帅', '陕西省', '西安市', '未央区', '长安大学渭水校区');
INSERT INTO `address` VALUES (16, 4, '15768620259', '庞晓军', '陕西省', '西安市', '未央区', '长安大学渭水校区');
INSERT INTO `address` VALUES (17, 1, '13720555921', '庞晓军', '陕西省', '西安市', '未央区', '长安大学渭水校区16号楼');
INSERT INTO `address` VALUES (18, 1, '12345678910', '元素打击', '四川省', '成都市', '锦江区', '厕所');
INSERT INTO `address` VALUES (19, 5, '15009299999', '庞晓君', '重庆市', '县', '垫江县', '海底捞');
INSERT INTO `address` VALUES (20, 6, '13572082079', '小陈', '青海省', '西宁市', '城北区', '呃呃呃呃呃呃呃呃呃');
INSERT INTO `address` VALUES (21, 5, '13572082099', '陈', '四川省', '成都市', '武侯区', '烦烦烦方法');
INSERT INTO `address` VALUES (22, 5, '13572082079', '树时', '四川省', '成都市', '锦江区', '的烦烦烦');
INSERT INTO `address` VALUES (23, 13, '17626341234', '小马哥', '陕西省', '西安市', '未央区', '恶事地址啊');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `product_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 1);
INSERT INTO `collect` VALUES (6, 1);
INSERT INTO `collect` VALUES (1, 2);
INSERT INTO `collect` VALUES (6, 2);
INSERT INTO `collect` VALUES (1, 3);
INSERT INTO `collect` VALUES (5, 3);
INSERT INTO `collect` VALUES (5, 15);
INSERT INTO `collect` VALUES (5, 45);

-- ----------------------------
-- Table structure for logistic_com
-- ----------------------------
DROP TABLE IF EXISTS `logistic_com`;
CREATE TABLE `logistic_com`  (
  `logistic_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '物流公司id',
  `com_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司名',
  PRIMARY KEY (`logistic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of logistic_com
-- ----------------------------
INSERT INTO `logistic_com` VALUES (1, '顺丰');
INSERT INTO `logistic_com` VALUES (2, '圆通');
INSERT INTO `logistic_com` VALUES (3, '与田');
INSERT INTO `logistic_com` VALUES (4, '第三方');
INSERT INTO `logistic_com` VALUES (5, '中通');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `product_id` int(20) NOT NULL COMMENT '货物id',
  `product_num` int(10) NOT NULL COMMENT '货物数量',
  `price` double(20, 2) NOT NULL COMMENT '金额,货物的单价',
  `buyer_id` int(20) NOT NULL COMMENT '买家id',
  `seller_id` int(20) NOT NULL COMMENT '卖家id',
  `order_time` datetime NOT NULL COMMENT '生成时间',
  `buyer_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '买家地址',
  `seller_addr` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家地址',
  `logistic_id` int(10) UNSIGNED NULL DEFAULT 1 COMMENT '物流公司id',
  `status` int(5) NOT NULL DEFAULT 0 COMMENT '订单状态；0--包括未发货，1--已发货，2--已签收，3--退款申请中，4--退款成功',
  `orderno` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '沙箱支付返回的订单号（退款需要）',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (44, 9, 1, 3.50, 13, 3, '2021-03-10 21:37:48', '陕西省西安市未央区恶事地址啊', NULL, 1, 2, NULL);
INSERT INTO `order` VALUES (45, 11, 1, 4.00, 13, 3, '2021-03-11 09:14:50', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (46, 14, 1, 6999.00, 13, 3, '2021-03-11 09:14:50', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (47, 14, 1, 6999.00, 13, 3, '2021-03-12 13:52:35', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (48, 14, 1, 6999.00, 13, 3, '2021-03-12 13:52:39', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (49, 14, 1, 6999.00, 13, 3, '2021-03-12 13:53:01', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (50, 14, 1, 6999.00, 13, 3, '2021-03-12 13:53:14', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (51, 14, 1, 6999.00, 13, 3, '2021-03-12 13:54:52', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (52, 10, 1, 4.00, 13, 3, '2021-03-12 13:55:29', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (53, 14, 2, 6999.00, 13, 3, '2021-03-29 18:10:51', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (54, 14, 1, 6999.00, 13, 3, '2021-04-02 10:55:19', '陕西省西安市未央区恶事地址啊', NULL, 1, 0, NULL);
INSERT INTO `order` VALUES (55, 10, 2, 4.00, 13, 3, '2021-04-02 14:18:38', '陕西省西安市未央区恶事地址啊', '', 1, 3, '20210402141838082');
INSERT INTO `order` VALUES (56, 15, 1, 433.00, 13, 3, '2021-04-02 15:00:46', '陕西省西安市未央区恶事地址啊', NULL, 1, 3, '20210402150046355');
INSERT INTO `order` VALUES (57, 27, 1, 44.00, 13, 4, '2021-04-02 15:26:23', '陕西省西安市未央区恶事地址啊', NULL, 1, 3, '20210402152623204');
INSERT INTO `order` VALUES (63, 13, 1, 7000.00, 13, 3, '2021-04-02 15:40:29', '陕西省西安市未央区恶事地址啊', NULL, 1, 4, '20210402154029833');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `product_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `seller_id` int(20) NOT NULL COMMENT '卖家id',
  `product_type_id` int(20) NULL DEFAULT NULL COMMENT '类型id',
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货品名字',
  `product_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `price` double(20, 2) NOT NULL COMMENT '价格',
  `discount_price` double(20, 2) NULL DEFAULT NULL COMMENT '优惠价',
  `storage` int(20) NOT NULL COMMENT '库存',
  `sale` int(20) NULL DEFAULT NULL COMMENT '销量',
  `state` int(1) NOT NULL COMMENT '1：上架 ;  0 : 下架',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `product_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`) USING BTREE,
  INDEX `product_type`(`product_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (9, 3, 2, '钓鱼板', '1.jpg', 3.50, 3.20, 925, 18, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (10, 3, 3, '花蝶', '2.jpg', 4.00, 3.50, 1023, 6, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (11, 3, 2, '特急车', '3.jpg', 4.00, 3.50, 11320, 13, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (12, 3, 4, '画笔包', '4.jpg', 1000000.00, 5000.00, 1218, 3, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (13, 3, 3, '化妆包', '5.jpg', 7000.00, 6999.00, 130, 1, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (14, 3, 1, '魔仙棒', '6.jpg', 6999.00, 5000.00, 126, 29, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (15, 3, 1, '别墅过家家', '7.jpg', 433.00, 400.00, 1509, 17, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (16, 4, 1, '水果塑料', '8.jpg', 30.00, 25.00, 1621, 16, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (17, 4, 1, '游戏墙', '9.jpg', 17.00, 15.00, 1716, 24, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (18, 4, 1, '陀螺', '31.jpg', 40.00, 35.00, 1842, 19, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (19, 4, 1, '画纸', '11.jpg', 500.00, 466.00, 1934, 19, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (20, 4, 1, '滑翔伞', '12.jpg', 550.00, 500.00, 20354, 20, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (21, 4, 1, '形状', '13.jpg', 50.00, 49.00, 2000, 600, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (22, 4, 1, '遥控车', '14.jpg', 33.00, 30.00, 400, 400, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (23, 4, 2, '好丽友派', '15.jpg', 5.00, 4.50, 4000, 3222, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (24, 4, 1, '和田玉', '16.jpg', 350.00, 336.00, 5000, 3000, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (25, 4, 1, '发光陀螺', '17.jpg', 77.00, 70.00, 23333, 200, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (26, 4, 2, '特技车', '18.jpg', 44.00, 43.00, 5550, 60, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (27, 4, 4, '七巧板', '19.jpg', 44.00, 43.00, 5554, 56, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (28, 4, 1, '玩具枪', '20.jpg', 788.00, 755.00, 42, 33, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (29, 4, 1, '小熊', '21.jpg', 655.00, 600.00, 3888, 4332, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (30, 4, 1, '漫步机器人', '22.jpg', 65.00, 60.00, 5543, 44, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (31, 4, 1, '小水池', '23.jpg', 77.00, 70.00, 4443, 443, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (32, 4, 1, '大水池', '24.jpg', 689.00, 688.00, 232, 20, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (34, 1, 1, '色板', '25.jpg', 2.00, 2.00, 200, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (35, 1, 1, '画笔', '26.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (36, 1, 1, '布偶', '27.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (37, 1, 1, '拼板', '28.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (38, 1, 1, '小汽车', '29.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (39, 1, 1, '橡皮泥', '30.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);
INSERT INTO `product` VALUES (41, 1, 1, '滑行飞机', '0.jpg', 1.00, 1.00, 1, 0, 1, '2021-02-13 10:28:09', '2021-02-19 16:45:51', NULL);

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `product_type_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '货物分类id',
  `product_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名',
  PRIMARY KEY (`product_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES (1, '励志');
INSERT INTO `product_type` VALUES (2, '益智');
INSERT INTO `product_type` VALUES (3, '男孩');
INSERT INTO `product_type` VALUES (4, '女孩');

-- ----------------------------
-- Table structure for refund
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sellerid` int(11) NULL DEFAULT NULL COMMENT '卖家id',
  `buyerid` int(11) NULL DEFAULT NULL COMMENT '买家id',
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款金额',
  `orderno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `inputtime` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `status` int(255) NULL DEFAULT NULL COMMENT '申请状态（0未同意  1已同意）',
  `orderid` int(11) NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund
-- ----------------------------
INSERT INTO `refund` VALUES (2, 3, 13, '8.0', '20210402141838082', '2021-04-02 14:43:55', 0, NULL);
INSERT INTO `refund` VALUES (3, 3, 13, '433.0', '20210402150046355', '2021-04-02 15:02:22', 0, NULL);
INSERT INTO `refund` VALUES (4, 4, 13, '44.0', '20210402152623204', '2021-04-02 15:30:38', 0, NULL);
INSERT INTO `refund` VALUES (5, 3, 13, '7000.0', '20210402154029833', '2021-04-02 15:42:43', 1, NULL);

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `product_id` int(20) NOT NULL COMMENT '货物id',
  `buyer_id` int(20) NOT NULL COMMENT '买家id',
  `price` double(20, 2) NOT NULL COMMENT '加入购物车时的商品单价',
  `num` int(20) NOT NULL COMMENT '货物数量',
  PRIMARY KEY (`product_id`, `buyer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名，登录用',
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户类型 0管理员 1商家 2客户',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE COMMENT '用户名索引',
  UNIQUE INDEX `phone_number`(`phone_number`) USING BTREE COMMENT '手机号索引'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'oushivv', '13572082079', '陈勤', 'e10adc3949ba59abbe56e057f20f883e', '0', '男', 'a9e98914-fff7-49a1-8282-9a8da0719987.png', 1);
INSERT INTO `user` VALUES (2, 'wojiaobaixiaobai', '13299042795', '我叫白小白', 'e10adc3949ba59abbe56e057f20f883e', '0', '男', NULL, 1);
INSERT INTO `user` VALUES (3, 'zhangsan', '11111111112', '张三', 'e10adc3949ba59abbe56e057f20f883e', '1', '女', 'ccbd4e7b-d9bd-4996-b330-e00b7322853e.jpg', 1);
INSERT INTO `user` VALUES (4, 'zhangsi', '11111111111', '张四', 'e10adc3949ba59abbe56e057f20f883e', '1', '女', NULL, 1);
INSERT INTO `user` VALUES (5, 'wangwu', '22222222221', '王武', 'e10adc3949ba59abbe56e057f20f883e', '2', '女', 'cb4dea4d-466b-476b-a84a-bc8fe9f365f0.jpg', 1);
INSERT INTO `user` VALUES (6, 'liuqi', '13456789', '刘七', 'e10adc3949ba59abbe56e057f20f883e', '2', '男', 'a5cff376-8926-44d3-b223-2564e2cc1c3c.JPG', 1);
INSERT INTO `user` VALUES (7, 'admin', '00000000000', '管理员', 'e10adc3949ba59abbe56e057f20f883e', '0', '保密', NULL, 1);
INSERT INTO `user` VALUES (8, 'admin2', '0', 'gly', 'e10adc3949ba59abbe56e057f20f883e', '0', NULL, NULL, 1);
INSERT INTO `user` VALUES (9, 'shangjia', NULL, '商家1', 'e10adc3949ba59abbe56e057f20f883e', '1', NULL, NULL, 1);
INSERT INTO `user` VALUES (10, '商家', NULL, '商家2', 'e10adc3949ba59abbe56e057f20f883e', '1', NULL, NULL, 1);
INSERT INTO `user` VALUES (11, 'test', NULL, 'asp', 'e10adc3949ba59abbe56e057f20f883e', '0', '男', NULL, 1);
INSERT INTO `user` VALUES (12, '1', '1', '1', 'e10adc3949ba59abbe56e057f20f883e', '1', '1', NULL, 1);
INSERT INTO `user` VALUES (13, 'maker', '15056408312', '小马哥', 'e10adc3949ba59abbe56e057f20f883e', '2', '男', '6edd5f21-48b1-4d07-a422-fe6348440f2e.jpg', 1);
INSERT INTO `user` VALUES (14, 'ha', '23231', 'dda', 'e10adc3949ba59abbe56e057f20f883e', '1', '男', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;

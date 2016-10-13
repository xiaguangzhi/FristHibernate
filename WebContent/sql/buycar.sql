/*
Navicat MySQL Data Transfer

Source Server         : hello
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : buycar

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-10-12 23:50:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contry` varchar(255) DEFAULT NULL,
  `road` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_user` (`user_id`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for add_shelf
-- ----------------------------
DROP TABLE IF EXISTS `add_shelf`;
CREATE TABLE `add_shelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `add_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_as_p` (`product_id`),
  KEY `fk_as_admin` (`admin_id`),
  CONSTRAINT `fk_as_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `fk_as_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of add_shelf
-- ----------------------------

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for buycar
-- ----------------------------
DROP TABLE IF EXISTS `buycar`;
CREATE TABLE `buycar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_buycar_user` (`user_id`),
  KEY `fk_buycar_p` (`product_id`),
  CONSTRAINT `fk_buycar_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_buycar_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buycar
-- ----------------------------

-- ----------------------------
-- Table structure for innerstock
-- ----------------------------
DROP TABLE IF EXISTS `innerstock`;
CREATE TABLE `innerstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `inner_count` int(11) DEFAULT NULL,
  `inner_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_is_p` (`product_id`),
  KEY `fk_is_admin` (`admin_id`),
  CONSTRAINT `fk_is_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `fk_is_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of innerstock
-- ----------------------------

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orders_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `item_state` int(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_oi_orders` (`orders_id`),
  KEY `fk_oi_p` (`product_id`),
  CONSTRAINT `fk_oi_orders` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `fk_oi_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `total_money` decimal(10,2) DEFAULT NULL,
  `order_state` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_orders_user` (`user_id`),
  CONSTRAINT `fk_orders_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for outerstock
-- ----------------------------
DROP TABLE IF EXISTS `outerstock`;
CREATE TABLE `outerstock` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `out_count` int(11) DEFAULT NULL,
  `out_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_os_p` (`product_id`),
  KEY `fk_os_admin` (`admin_id`),
  CONSTRAINT `fk_os_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `fk_os_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outerstock
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_detail` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '矿泉水', '12345.00', '饮用水');
INSERT INTO `product` VALUES ('2', '2', '矿泉水', '12345.00', '饮用水');

-- ----------------------------
-- Table structure for productdetail
-- ----------------------------
DROP TABLE IF EXISTS `productdetail`;
CREATE TABLE `productdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image1` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `image3` varchar(255) DEFAULT NULL,
  `caption` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productdetail
-- ----------------------------
INSERT INTO `productdetail` VALUES ('1', '假装有照片1', '假装有照片2', '假装有照片3', '这个商品好水啊');
INSERT INTO `productdetail` VALUES ('2', '假装有照片1', '假装有照片2', '假装有照片3', '这个商品好水啊');

-- ----------------------------
-- Table structure for removeshelf
-- ----------------------------
DROP TABLE IF EXISTS `removeshelf`;
CREATE TABLE `removeshelf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `remove_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rs_p` (`product_id`),
  KEY `fk_rs_admin` (`admin_id`),
  CONSTRAINT `fk_rs_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `fk_rs_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of removeshelf
-- ----------------------------

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `inner_stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_s_p` (`product_id`),
  KEY `fk_s_admin` (`admin_id`),
  CONSTRAINT `fk_s_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `fk_s_p` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` varchar(11) DEFAULT NULL,
  `user_detail` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xiao huang', '123456', '23', '1');

-- ----------------------------
-- Table structure for userdetail
-- ----------------------------
DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` varchar(10) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('1', null, '13167253358', '1484073720@qq.com', null);

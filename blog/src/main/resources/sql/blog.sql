/*
Navicat MySQL Data Transfer

Source Server         : 10.128.0.1
Source Server Version : 50725
Source Host           : 10.128.0.1:9999
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-25 20:17:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `article_type_id` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `praise_number` int(11) DEFAULT '0' COMMENT '点赞数',
  `negative_number` int(11) DEFAULT '0' COMMENT '差赞数',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  `priacy` tinyint(1) DEFAULT NULL COMMENT '是否为私密文章',
  `update_time` datetime DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  PRIMARY KEY (`id`),
  KEY `article_ibfk_1` (`user_id`),
  KEY `article_ibfk_2` (`article_type_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`article_type_id`) REFERENCES `article_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('8', '1', '10', '测试', '1', '1', '124', '0', '2019-03-13 16:42:51', '# helloworld');
INSERT INTO `article` VALUES ('9', '1', '10', '123', '3', '1', '103', '0', '2019-03-14 09:48:15', '# hello world');
INSERT INTO `article` VALUES ('10', '1', '10', 'java的哇', '2', '2', '103', '0', '2019-03-14 09:58:49', 'dazzling');
INSERT INTO `article` VALUES ('11', '1', '10', '我的测试dd', '5', '3', '230', '0', '2019-03-14 15:47:48', 'hello');
INSERT INTO `article` VALUES ('12', '1', '10', '我的测试', '1', '1', '12', '0', '2019-03-14 15:47:56', 'hello');

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `type_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '博客类型--通过逗号隔开',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`type_name`),
  CONSTRAINT `article_type_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES ('10', '1', 'java');
INSERT INTO `article_type` VALUES ('12', '1', 'mysql');
INSERT INTO `article_type` VALUES ('2', '1', 'python');
INSERT INTO `article_type` VALUES ('4', '1', 'redis');
INSERT INTO `article_type` VALUES ('14', '1', 'test');
INSERT INTO `article_type` VALUES ('3', '1', '大数据笔记');
INSERT INTO `article_type` VALUES ('13', '1', '毕设日记');

-- ----------------------------
-- Table structure for professional_type1
-- ----------------------------
DROP TABLE IF EXISTS `professional_type1`;
CREATE TABLE `professional_type1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of professional_type1
-- ----------------------------
INSERT INTO `professional_type1` VALUES ('1', '哲学');
INSERT INTO `professional_type1` VALUES ('2', '经济学');
INSERT INTO `professional_type1` VALUES ('3', '法学');
INSERT INTO `professional_type1` VALUES ('4', '教育学');
INSERT INTO `professional_type1` VALUES ('5', '文学');
INSERT INTO `professional_type1` VALUES ('6', '历史学');
INSERT INTO `professional_type1` VALUES ('7', '理学');
INSERT INTO `professional_type1` VALUES ('8', '工学');
INSERT INTO `professional_type1` VALUES ('9', '农学');
INSERT INTO `professional_type1` VALUES ('10', '医学');
INSERT INTO `professional_type1` VALUES ('11', '管理学');
INSERT INTO `professional_type1` VALUES ('12', '艺术类');

-- ----------------------------
-- Table structure for professional_type2
-- ----------------------------
DROP TABLE IF EXISTS `professional_type2`;
CREATE TABLE `professional_type2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `professional_type1_id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `professional_type1_id` (`professional_type1_id`),
  CONSTRAINT `professional_type2_ibfk_1` FOREIGN KEY (`professional_type1_id`) REFERENCES `professional_type1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of professional_type2
-- ----------------------------
INSERT INTO `professional_type2` VALUES ('1', '1', '哲学类');
INSERT INTO `professional_type2` VALUES ('2', '2', '经济学类');
INSERT INTO `professional_type2` VALUES ('3', '2', '财政学类');
INSERT INTO `professional_type2` VALUES ('4', '2', '金融学类');
INSERT INTO `professional_type2` VALUES ('5', '2', '经济与贸易');
INSERT INTO `professional_type2` VALUES ('6', '3', '法学类');
INSERT INTO `professional_type2` VALUES ('7', '3', '政治学类');
INSERT INTO `professional_type2` VALUES ('8', '3', '社会学类');
INSERT INTO `professional_type2` VALUES ('9', '3', '民族学类');
INSERT INTO `professional_type2` VALUES ('10', '3', '马克思主义理论类');
INSERT INTO `professional_type2` VALUES ('11', '3', '公安学类');
INSERT INTO `professional_type2` VALUES ('12', '4', '教育学类');
INSERT INTO `professional_type2` VALUES ('13', '4', '体育学类');
INSERT INTO `professional_type2` VALUES ('14', '5', '中国语言文学类');
INSERT INTO `professional_type2` VALUES ('16', '5', '外国语言文学类');
INSERT INTO `professional_type2` VALUES ('17', '5', '新闻传播文学类');
INSERT INTO `professional_type2` VALUES ('18', '6', '历史学类');
INSERT INTO `professional_type2` VALUES ('19', '7', '数学类');
INSERT INTO `professional_type2` VALUES ('20', '7', '物理学类');
INSERT INTO `professional_type2` VALUES ('21', '7', '化学类');
INSERT INTO `professional_type2` VALUES ('22', '7', '天文学类');
INSERT INTO `professional_type2` VALUES ('23', '7', '地理科学类');
INSERT INTO `professional_type2` VALUES ('24', '7', '大气科学类');
INSERT INTO `professional_type2` VALUES ('25', '7', '海洋科学类');
INSERT INTO `professional_type2` VALUES ('26', '7', '地球物理学');
INSERT INTO `professional_type2` VALUES ('27', '7', '地质学类');
INSERT INTO `professional_type2` VALUES ('28', '7', '生物科学类');
INSERT INTO `professional_type2` VALUES ('29', '7', '心理学类');
INSERT INTO `professional_type2` VALUES ('30', '7', '统计学类');
INSERT INTO `professional_type2` VALUES ('31', '8', '力学类');
INSERT INTO `professional_type2` VALUES ('32', '8', '机械类');
INSERT INTO `professional_type2` VALUES ('33', '8', '仪器类');
INSERT INTO `professional_type2` VALUES ('34', '8', '材料类');
INSERT INTO `professional_type2` VALUES ('35', '8', '能源动力类');
INSERT INTO `professional_type2` VALUES ('36', '8', '电气类');
INSERT INTO `professional_type2` VALUES ('37', '8', '电子信息类');
INSERT INTO `professional_type2` VALUES ('38', '8', '自动化类');
INSERT INTO `professional_type2` VALUES ('39', '8', '计算机类');
INSERT INTO `professional_type2` VALUES ('40', '8', '土木类');
INSERT INTO `professional_type2` VALUES ('41', '8', '水利类');
INSERT INTO `professional_type2` VALUES ('42', '8', '测绘类');
INSERT INTO `professional_type2` VALUES ('43', '8', '化工与制药类');
INSERT INTO `professional_type2` VALUES ('44', '8', '地质类');
INSERT INTO `professional_type2` VALUES ('45', '8', '矿业类');
INSERT INTO `professional_type2` VALUES ('46', '8', '纺织类');
INSERT INTO `professional_type2` VALUES ('47', '8', '轻工类');
INSERT INTO `professional_type2` VALUES ('48', '8', '交通运输类');
INSERT INTO `professional_type2` VALUES ('49', '8', '海洋工程类');
INSERT INTO `professional_type2` VALUES ('50', '8', '航空航天类');
INSERT INTO `professional_type2` VALUES ('51', '8', '兵器类');
INSERT INTO `professional_type2` VALUES ('52', '8', '核工程类');
INSERT INTO `professional_type2` VALUES ('53', '8', '林业工程类');
INSERT INTO `professional_type2` VALUES ('54', '8', '环境科学与工程类');
INSERT INTO `professional_type2` VALUES ('55', '8', '农业工程类');
INSERT INTO `professional_type2` VALUES ('56', '8', '生物医学工程类');
INSERT INTO `professional_type2` VALUES ('57', '8', '食品科学与工程');
INSERT INTO `professional_type2` VALUES ('58', '8', '建筑类');
INSERT INTO `professional_type2` VALUES ('59', '8', '安全科学与工程类');
INSERT INTO `professional_type2` VALUES ('60', '8', '生物工程类');
INSERT INTO `professional_type2` VALUES ('61', '8', '公安技术类');
INSERT INTO `professional_type2` VALUES ('62', '9', '植物生产类');
INSERT INTO `professional_type2` VALUES ('63', '9', '自然保护与环境生态');
INSERT INTO `professional_type2` VALUES ('64', '9', '动物生产类');
INSERT INTO `professional_type2` VALUES ('65', '9', '动物医学类');
INSERT INTO `professional_type2` VALUES ('66', '9', '林学类');
INSERT INTO `professional_type2` VALUES ('67', '9', '水产类');
INSERT INTO `professional_type2` VALUES ('68', '9', '草学类');
INSERT INTO `professional_type2` VALUES ('69', '10', '基础医学类');
INSERT INTO `professional_type2` VALUES ('70', '10', '临床医学类');
INSERT INTO `professional_type2` VALUES ('71', '10', '口腔医学类');
INSERT INTO `professional_type2` VALUES ('72', '10', '中医学类');
INSERT INTO `professional_type2` VALUES ('73', '10', '公共卫生与预防医学');
INSERT INTO `professional_type2` VALUES ('74', '10', '中西医结合类');
INSERT INTO `professional_type2` VALUES ('75', '10', '药学类');
INSERT INTO `professional_type2` VALUES ('76', '10', '中药学类');
INSERT INTO `professional_type2` VALUES ('77', '10', '法医学类');
INSERT INTO `professional_type2` VALUES ('78', '10', '医学技术类');
INSERT INTO `professional_type2` VALUES ('79', '10', '护理学类');
INSERT INTO `professional_type2` VALUES ('80', '11', '管理科学与工程类');
INSERT INTO `professional_type2` VALUES ('81', '11', '工商管理类');
INSERT INTO `professional_type2` VALUES ('82', '11', '农业经济管理类');
INSERT INTO `professional_type2` VALUES ('83', '11', '公共管理类');
INSERT INTO `professional_type2` VALUES ('84', '11', '图书情报与档案管理');
INSERT INTO `professional_type2` VALUES ('85', '11', '物流管理与工程类');
INSERT INTO `professional_type2` VALUES ('86', '11', '旅游管理类');
INSERT INTO `professional_type2` VALUES ('87', '11', '工业工程类');
INSERT INTO `professional_type2` VALUES ('88', '11', '电子商务类');
INSERT INTO `professional_type2` VALUES ('89', '12', '艺术学理论类');
INSERT INTO `professional_type2` VALUES ('90', '12', '音乐与舞蹈学类');
INSERT INTO `professional_type2` VALUES ('91', '12', '戏剧与影视学类');
INSERT INTO `professional_type2` VALUES ('92', '12', '美术学类');
INSERT INTO `professional_type2` VALUES ('93', '12', '设计学类');

-- ----------------------------
-- Table structure for professional_type3
-- ----------------------------
DROP TABLE IF EXISTS `professional_type3`;
CREATE TABLE `professional_type3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `professional_type2_id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `professional_type2_id` (`professional_type2_id`),
  CONSTRAINT `professional_type3_ibfk_1` FOREIGN KEY (`professional_type2_id`) REFERENCES `professional_type2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of professional_type3
-- ----------------------------
INSERT INTO `professional_type3` VALUES ('1', '1', '哲学');
INSERT INTO `professional_type3` VALUES ('2', '1', '逻辑学');
INSERT INTO `professional_type3` VALUES ('3', '1', '宗教学');
INSERT INTO `professional_type3` VALUES ('4', '1', '伦理学');
INSERT INTO `professional_type3` VALUES ('5', '39', '计算机科学与技术');
INSERT INTO `professional_type3` VALUES ('6', '39', '软件工程');
INSERT INTO `professional_type3` VALUES ('7', '39', '网络工程');
INSERT INTO `professional_type3` VALUES ('8', '39', '信息安全');
INSERT INTO `professional_type3` VALUES ('9', '39', '物联网工程');
INSERT INTO `professional_type3` VALUES ('10', '39', '数字媒体技术');
INSERT INTO `professional_type3` VALUES ('11', '39', '智能科学与技术');
INSERT INTO `professional_type3` VALUES ('12', '39', '空间信息与数字技术');
INSERT INTO `professional_type3` VALUES ('13', '39', '电子与计算机工程');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'haojunjie', 'haojunjie');
INSERT INTO `user` VALUES ('2', 'dazzling', 'dazzling');
INSERT INTO `user` VALUES ('3', '1275119618', 'haojunjie');
INSERT INTO `user` VALUES ('4', '1234', '1234');
INSERT INTO `user` VALUES ('5', '12345', '1234');
INSERT INTO `user` VALUES ('6', 'hjjdazzing', '123');
INSERT INTO `user` VALUES ('7', 'hhh', 'hhh');
INSERT INTO `user` VALUES ('8', 'hjhjh', 'wwe');

-- ----------------------------
-- Table structure for user_information
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `professional_type3_id` int(11) DEFAULT NULL,
  `real_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `phone` char(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `attention_number` int(11) DEFAULT NULL COMMENT '关注的人数',
  `fans_number` int(11) DEFAULT NULL COMMENT '粉丝数',
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `professional_type3_id` (`professional_type3_id`),
  CONSTRAINT `user_information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_information_ibfk_2` FOREIGN KEY (`professional_type3_id`) REFERENCES `professional_type3` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', '1', '7', '郝俊杰', '1997-09-18', '18700860366', '127511918@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('2', '2', '7', '你太过耀眼', '2019-02-25', '18700860366', '2250170537@qq.cm', '0', '0', '最强王者');
INSERT INTO `user_information` VALUES ('3', '3', '7', 'dazzling', '2019-02-25', '18700860366', '2250170537@qq.com', '0', '0', '666');
INSERT INTO `user_information` VALUES ('4', '6', '7', '郝俊杰', '2019-03-03', '18700860366', '1275119618@qq.com', '0', '0', '无');
INSERT INTO `user_information` VALUES ('5', '7', '7', 'hjj', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', 'dwa');
INSERT INTO `user_information` VALUES ('6', '8', '7', 'hjj', '1997-09-01', '18700860366', '1275119618@qq.com', '0', '0', 'ew');
INSERT INTO `user_information` VALUES ('7', '4', '7', 'hjj', '2019-03-12', '18700860366', '1275119618@qq.com', '0', '0', null);

-- ----------------------------
-- Table structure for user_information2
-- ----------------------------
DROP TABLE IF EXISTS `user_information2`;
CREATE TABLE `user_information2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `praise_all_id` json DEFAULT NULL,
  `negative_all_id` json DEFAULT NULL,
  `collect_all_id` json DEFAULT NULL,
  `attention_all_id` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `user_information2_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_information2
-- ----------------------------
INSERT INTO `user_information2` VALUES ('1', '1', '[1, 2, 3, 4]', '[1, 2, 3, 4]', '[1, 2, 3, 4]', '[1, 2, 3, 4]');
INSERT INTO `user_information2` VALUES ('2', '4', '[9, 11, 12]', '[11]', '[]', '[]');

-- ----------------------------
-- Table structure for view_record
-- ----------------------------
DROP TABLE IF EXISTS `view_record`;
CREATE TABLE `view_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `view_time` date DEFAULT NULL,
  `view_record` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `view_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of view_record
-- ----------------------------
INSERT INTO `view_record` VALUES ('1', '1', '2019-03-18', '[1, 2, 3, 4]');
INSERT INTO `view_record` VALUES ('2', '1', '2019-03-19', '[1, 2, 3, 5]');
INSERT INTO `view_record` VALUES ('4', '1', '2019-03-21', '[]');
INSERT INTO `view_record` VALUES ('5', '4', '2019-03-21', '[12]');
INSERT INTO `view_record` VALUES ('6', '1', '2019-03-25', '[8]');
INSERT INTO `view_record` VALUES ('7', '4', '2019-03-25', '[9]');

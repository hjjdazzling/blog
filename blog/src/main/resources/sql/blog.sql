/*
Navicat MySQL Data Transfer

Source Server         : 10.128.0.3
Source Server Version : 50725
Source Host           : 10.128.0.3:9999
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-11 19:44:54
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
  `praise_number` int(11) DEFAULT NULL COMMENT '点赞数',
  `negative_number` int(11) DEFAULT NULL COMMENT '差赞数',
  `view_count` int(11) DEFAULT NULL COMMENT '浏览次数',
  `priacy` tinyint(1) DEFAULT NULL COMMENT '是否为私密文章',
  `update_time` datetime DEFAULT NULL,
  `content` text COLLATE utf8mb4_unicode_ci COMMENT '文章内容',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `article_type_id` (`article_type_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`article_type_id`) REFERENCES `article_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', '1', 'markDown语法变成html语法', null, null, null, '0', null, '## maven中配置\r\n```xml\r\n        <!-- https://mvnrepository.com/artifact/org.pegdown/pegdown -->\r\n        <dependency>\r\n            <groupId>org.pegdown</groupId>\r\n            <artifactId>pegdown</artifactId>\r\n            <version>1.6.0</version>\r\n        </dependency>\r\n```\r\n## java中使用PegDownProcessor\r\n```java\r\nPegDownProcessor  peg=new PegDownProcessor();\r\nString html =peg.markdownToHtml(content);\r\nrequest.setAttribute(\"content\", html);\r\n```\r\n');
INSERT INTO `article` VALUES ('2', '1', '1', 'spring boot和redis,改变默认的序列化器', null, null, null, '0', null, '```java\r\n@Configuration\r\npublic class LoginCacheConfiguration {\r\n\r\n    @Bean(name=\"userRedisTemplate\")\r\n    public RedisTemplate<String, Map<String, User>> userRedisTemplate(RedisConnectionFactory redisConnectionFactory) {\r\n        RedisTemplate<String, Map<String, User>> userRedisTemplate = new RedisTemplate<>();\r\n        userRedisTemplate.setConnectionFactory(redisConnectionFactory);\r\n\r\n        GenericJackson2JsonRedisSerializer serializer = new\r\n                GenericJackson2JsonRedisSerializer();\r\n        //注意必须是setDefaultSerializer 的方法才能改变默认的\r\n        userRedisTemplate.setDefaultSerializer(serializer);\r\n        return userRedisTemplate;\r\n    }\r\n}\r\n\r\n```');
INSERT INTO `article` VALUES ('3', '1', '1', '测试', null, null, null, '0', null, '# hello\r\n## hello world\r\n郝俊杰');

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `type_name` text COLLATE utf8mb4_unicode_ci COMMENT '博客类型--通过逗号隔开',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `article_type_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES ('1', '1', 'java');
INSERT INTO `article_type` VALUES ('2', '1', 'mysql');
INSERT INTO `article_type` VALUES ('3', '1', '大数据');
INSERT INTO `article_type` VALUES ('4', '1', 'redis');
INSERT INTO `article_type` VALUES ('5', '1', '工作笔记');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `article_id_collect` text COLLATE utf8mb4_unicode_ci COMMENT '收藏的文章id,使用逗号隔开',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of collect
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of professional_type3
-- ----------------------------
INSERT INTO `professional_type3` VALUES ('1', '1', '哲学');
INSERT INTO `professional_type3` VALUES ('2', '1', '逻辑学');
INSERT INTO `professional_type3` VALUES ('3', '1', '宗教学');
INSERT INTO `professional_type3` VALUES ('4', '1', '伦理学');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', '1', '2', '郝俊杰', '1997-09-18', '18700860366', '127511918@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('2', '2', '2', '你太过耀眼', '2019-02-25', '18700860366', '2250170537@qq.cm', '0', '0', '最强王者');
INSERT INTO `user_information` VALUES ('3', '3', '2', 'dazzling', '2019-02-25', '18700860366', '2250170537@qq.com', '0', '0', '666');
INSERT INTO `user_information` VALUES ('4', '6', '1', '郝俊杰', '2019-03-03', '18700860366', '1275119618@qq.com', '0', '0', '无');
INSERT INTO `user_information` VALUES ('5', '7', '1', 'hjj', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', 'dwa');
INSERT INTO `user_information` VALUES ('6', '8', '1', 'hjj', '1997-09-01', '18700860366', '1275119618@qq.com', '0', '0', 'ew');

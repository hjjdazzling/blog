/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.200
Source Server Version : 50725
Source Host           : 192.168.10.200:9999
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-05-22 13:37:17
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('8', '1', '10', '测试', '1', '1', '131', '0', '2019-03-13 16:42:51', '# helloworld');
INSERT INTO `article` VALUES ('9', '1', '10', '123', '3', '1', '132', '0', '2019-03-14 09:48:15', '# hello world');
INSERT INTO `article` VALUES ('11', '1', '10', '我的测试dd', '5', '3', '232', '0', '2019-03-14 15:47:48', 'hello');
INSERT INTO `article` VALUES ('12', '1', '10', '我的测试', '1', '2', '15', '0', '2019-03-14 15:47:56', 'hello');
INSERT INTO `article` VALUES ('14', '1', '10', 'spring boot代码', '1', '0', '3', '0', '2019-04-15 09:55:00', '```java\r\npackage com.hjj.blog.deleteBlog.controller;\r\n\r\nimport com.hjj.blog.deleteBlog.service.DeleteBlogService;\r\nimport com.hjj.blog.projo.Article;\r\nimport com.hjj.blog.projo.ArticleType;\r\nimport com.hjj.blog.projo.User;\r\nimport org.springframework.beans.factory.annotation.Autowired;\r\nimport org.springframework.stereotype.Controller;\r\nimport org.springframework.web.bind.annotation.RequestMapping;\r\nimport org.springframework.web.bind.annotation.RequestParam;\r\n\r\nimport javax.servlet.http.HttpSession;\r\nimport java.util.List;\r\n\r\n/**\r\n * @author haojunjie\r\n * @create 2019-03-13 15:52\r\n */\r\n@Controller\r\n@RequestMapping(\"/DeleteBlogController\")\r\npublic class DeleteBlogController {\r\n    @Autowired\r\n    DeleteBlogService deleteBlogService;\r\n\r\n    @RequestMapping(\"/deleteBlogById\")\r\n    public String deleteBlogById(@RequestParam(\"id\") int id, HttpSession session) {\r\n        deleteBlogService.deleteBlogById(id);\r\n\r\n        List<Article> articles = (List<Article>)session.getAttribute(\"articles\");\r\n\r\n        for(int i=0; i<articles.size(); i++) {\r\n            if(articles.get(i).getId() == id) {\r\n                articles.remove(i);\r\n                break;\r\n            }\r\n        }\r\n\r\n        session.setAttribute(\"articles\", articles);\r\n        return \"displayMyBlog\";\r\n    }\r\n}\r\n\r\n```');
INSERT INTO `article` VALUES ('15', '1', '10', 'java config', '0', '0', '1', '0', '2019-04-17 14:43:13', '```java\r\npackage com.hjj.blog.criteria.configuration;\r\n\r\nimport com.hjj.blog.projo.CriteriaMessage;\r\nimport org.springframework.context.annotation.Bean;\r\nimport org.springframework.context.annotation.Configuration;\r\n\r\n/**\r\n * @author haojunjie\r\n * @create 2019-03-27 14:42\r\n */\r\n@Configuration\r\npublic class CriteriaConfiguration {\r\n    @Bean\r\n    public CriteriaMessage criteriaMessage() {\r\n        return new CriteriaMessage();\r\n    }\r\n}\r\n```');
INSERT INTO `article` VALUES ('16', '1', '12', 'sql语句', '0', '0', '1', '0', '2019-04-18 14:27:11', 'select * from user;');
INSERT INTO `article` VALUES ('18', '1', '14', 'test', '2', '0', '6', '0', '2019-04-18 14:40:57', '# Test');
INSERT INTO `article` VALUES ('19', '1', '15', '123', '0', '0', '1', '0', '2019-04-18 15:55:06', '# hello world');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES ('15', '1', 'HDFS');
INSERT INTO `article_type` VALUES ('10', '1', 'java');
INSERT INTO `article_type` VALUES ('12', '1', 'mysql');
INSERT INTO `article_type` VALUES ('2', '1', 'python');
INSERT INTO `article_type` VALUES ('4', '1', 'redis');
INSERT INTO `article_type` VALUES ('14', '1', 'test2');
INSERT INTO `article_type` VALUES ('16', '1', 'YARN');
INSERT INTO `article_type` VALUES ('3', '1', '大数据笔记');
INSERT INTO `article_type` VALUES ('13', '1', '毕设日记');

-- ----------------------------
-- Table structure for criteria
-- ----------------------------
DROP TABLE IF EXISTS `criteria`;
CREATE TABLE `criteria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `criteria_time` datetime DEFAULT NULL,
  `criteria_article` json DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `criteria_ibfk_1` (`article_id`),
  KEY `criteria_ibfk_2` (`user_id`),
  CONSTRAINT `criteria_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `criteria_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of criteria
-- ----------------------------
INSERT INTO `criteria` VALUES ('1', '8', '4', '2019-03-27 10:50:56', '[{\"time\": 1553665037305, \"content\": \"4评论:hello world\"}, {\"time\": 1553665037305, \"content\": \"作者回复:hello world2\"}, {\"time\": 1553665037305, \"content\": \"4回复作者:hello world3\"}]');
INSERT INTO `criteria` VALUES ('2', '8', '2', '2019-03-27 14:21:31', '[{\"time\": 1553667691082, \"content\": \"你的文章写得真是太好了\"}]');
INSERT INTO `criteria` VALUES ('4', '9', '4', '2019-03-28 14:36:11', '[{\"time\": 1553754971229, \"content\": \"1234评论:hello world\"}, {\"time\": 1553759903341, \"content\": \"haojunjie回复了1234:hello world2\"}, {\"time\": 1553770360955, \"content\": \"dazzling回复了1234:hello world3\"}, {\"time\": 1553771662719, \"content\": \"hhh回复了haojunjie:hello world4\"}]');
INSERT INTO `criteria` VALUES ('7', '9', '2', '2019-03-28 18:52:26', '[{\"time\": 1553770346245, \"content\": \"dazzling评论:好短的文章\"}]');
INSERT INTO `criteria` VALUES ('8', '9', '7', '2019-03-28 19:30:54', '[{\"time\": 1553772653604, \"content\": \"hhh评论:fuck\"}, {\"time\": 1553772734489, \"content\": \"haojunjie回复了hhh:fuck you\"}]');
INSERT INTO `criteria` VALUES ('9', '9', '7', '2019-03-28 19:31:06', '[{\"time\": 1553772666161, \"content\": \"hhh评论:好短的文章\"}, {\"time\": 1553772742990, \"content\": \"haojunjie回复了hhh:嘿嘿嘿\"}]');
INSERT INTO `criteria` VALUES ('10', '9', '5', '2019-03-28 19:39:13', '[{\"time\": 1553773153133, \"content\": \"12345评论:你好\"}, {\"time\": 1553773319921, \"content\": \"dazzling回复了12345:你更好\"}, {\"time\": 1553773624316, \"content\": \"dazzling回复了12345:how are you\"}, {\"time\": 1553774475841, \"content\": \"dazzling回复了12345:hello world4\"}]');
INSERT INTO `criteria` VALUES ('11', '14', '4', '2019-04-15 09:56:43', '[{\"time\": 1555293402886, \"content\": \"1234评论:好短的文章\"}, {\"time\": 1555293993064, \"content\": \"haojunjie回复了1234:fuck\"}, {\"time\": 1555294059077, \"content\": \"1234回复了haojunjie:嘿嘿嘿\"}]');
INSERT INTO `criteria` VALUES ('12', '8', '1', '2019-04-15 09:58:35', '[{\"time\": 1555293514588, \"content\": \"haojunjie评论:hello world3\"}]');
INSERT INTO `criteria` VALUES ('13', '12', '1', '2019-04-17 14:40:22', '[{\"time\": 1555483221958, \"content\": \"haojunjie评论:hello world\"}, {\"time\": 1555483274506, \"content\": \"1234回复了haojunjie:hello\"}, {\"time\": 1555483299393, \"content\": \"1234回复了haojunjie:hello\"}]');
INSERT INTO `criteria` VALUES ('14', '18', '4', '2019-04-18 15:44:31', '[{\"time\": 1555573471044, \"content\": \"1234评论:test\"}, {\"time\": 1555573924294, \"content\": \"haojunjie回复了1234:hello world\"}, {\"time\": 1555575328937, \"content\": \"1234回复了haojunjie:hello world2\"}]');
INSERT INTO `criteria` VALUES ('15', '11', '1', '2019-04-18 15:54:50', '[{\"time\": 1555574090482, \"content\": \"haojunjie评论:好短的文章\"}]');
INSERT INTO `criteria` VALUES ('16', '16', '4', '2019-04-18 16:08:57', '[{\"time\": 1555574936795, \"content\": \"1234评论:好短的文章\"}]');
INSERT INTO `criteria` VALUES ('17', '18', '4', '2019-04-18 16:20:33', '[{\"time\": 1555575632573, \"content\": \"1234评论:hello world\\r\\n            \"}]');
INSERT INTO `criteria` VALUES ('18', '19', '11', '2019-04-21 21:21:26', '[{\"time\": 1555852885840, \"content\": \"3150931023评论:hello world\"}]');
INSERT INTO `criteria` VALUES ('19', '8', '4', '2019-04-23 14:58:04', '[{\"time\": 1556002683531, \"content\": \"1234评论:hello\"}]');
INSERT INTO `criteria` VALUES ('20', '15', '4', '2019-04-30 16:35:50', '[{\"time\": 1556613349544, \"content\": \"1234评论:hello world\"}]');
INSERT INTO `criteria` VALUES ('21', '8', '1', '2019-05-13 15:23:12', '[{\"time\": 1557732191943, \"content\": \"haojunjie评论:好短的文章\"}]');

-- ----------------------------
-- Table structure for criteria_message
-- ----------------------------
DROP TABLE IF EXISTS `criteria_message`;
CREATE TABLE `criteria_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `from_user_id` (`from_user_id`),
  CONSTRAINT `criteria_message_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `criteria_message_ibfk_2` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of criteria_message
-- ----------------------------
INSERT INTO `criteria_message` VALUES ('1', '5', '2', '0', '2019-03-28 20:01:16', 'dazzling对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=9\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('2', '1', '2', '1', '2019-03-28 20:01:16', 'dazzling对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=9\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('3', '1', '4', '1', '2019-04-15 09:56:43', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=14\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('4', '1', '1', '0', '2019-04-15 09:58:35', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=8\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('5', '4', '1', '1', '2019-04-15 10:06:33', 'haojunjie对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=14\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('6', '1', '1', '0', '2019-04-15 10:06:33', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=14\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('7', '1', '4', '0', '2019-04-15 10:07:39', '1234对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=14\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('8', '1', '4', '1', '2019-04-15 10:07:39', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=14\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('9', '1', '1', '1', '2019-04-17 14:40:22', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=12\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('10', '1', '4', '1', '2019-04-17 14:41:15', '1234对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=12\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('11', '1', '4', '1', '2019-04-17 14:41:15', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=12\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('12', '1', '4', '1', '2019-04-17 14:41:39', '1234对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=12\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('13', '1', '4', '0', '2019-04-17 14:41:39', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=12\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('14', '1', '4', '1', '2019-04-18 15:44:31', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('15', '4', '1', '1', '2019-04-18 15:52:04', 'haojunjie对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('16', '1', '1', '1', '2019-04-18 15:52:04', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('17', '1', '1', '1', '2019-04-18 15:54:50', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=11\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('18', '1', '4', '1', '2019-04-18 16:08:57', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=16\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('19', '1', '4', '1', '2019-04-18 16:15:29', '1234对你的评价做出了回复 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('20', '1', '4', '0', '2019-04-18 16:15:29', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('21', '1', '4', '0', '2019-04-18 16:20:33', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=18\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('22', '1', '11', '0', '2019-04-21 21:21:26', '3150931023对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=19\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('23', '1', '4', '0', '2019-04-23 14:58:04', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=8\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('24', '1', '4', '0', '2019-04-30 16:35:50', '1234对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=15\'>点击查看</a>');
INSERT INTO `criteria_message` VALUES ('25', '1', '1', '0', '2019-05-13 15:23:12', 'haojunjie对你的文章做出了评价 <a href = \'/viewBlogController/getArticleContent/?id=8\'>点击查看</a>');

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
INSERT INTO `user` VALUES ('9', '654', '123');
INSERT INTO `user` VALUES ('11', '3150931023', 'hjj817918.++');
INSERT INTO `user` VALUES ('12', 'sll', 'sll');
INSERT INTO `user` VALUES ('13', 'wwe', 'wwe');
INSERT INTO `user` VALUES ('14', 'wwe123', 'wwe123');
INSERT INTO `user` VALUES ('15', '123456789', 'haojunjie');
INSERT INTO `user` VALUES ('16', '123', 'haojunjie');
INSERT INTO `user` VALUES ('17', '9999', 'haojunjie');
INSERT INTO `user` VALUES ('19', '4444', '4444');
INSERT INTO `user` VALUES ('20', '555', '555');

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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', '1', '9', '郝俊杰', '1997-09-18', '18700860366', '127511918@qq.com', '1', '0', null);
INSERT INTO `user_information` VALUES ('2', '2', '7', '你太过耀眼', '2019-02-25', '18700860366', '2250170537@qq.cm', '0', '0', '最强王者');
INSERT INTO `user_information` VALUES ('3', '3', '7', 'dazzling', '2019-02-25', '18700860366', '2250170537@qq.com', '0', '0', '666');
INSERT INTO `user_information` VALUES ('4', '6', '7', '郝俊杰', '2019-03-03', '18700860366', '1275119618@qq.com', '0', '0', '无');
INSERT INTO `user_information` VALUES ('5', '7', '7', 'hjj', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', 'dwa');
INSERT INTO `user_information` VALUES ('6', '8', '7', 'hjj', '1997-09-01', '18700860366', '1275119618@qq.com', '0', '0', 'ew');
INSERT INTO `user_information` VALUES ('7', '4', '7', 'hjj', '2019-03-12', '18700860366', '1275119618@qq.com', '0', '1', null);
INSERT INTO `user_information` VALUES ('8', '11', '7', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('9', '12', '7', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('10', '13', '7', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('11', '14', '8', 'haojunjie', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('12', '15', '6', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('13', '16', '7', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('14', '17', '7', 'haojunjie', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('15', '19', '6', '郝俊杰', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);
INSERT INTO `user_information` VALUES ('16', '20', '6', 'haojunjie', '1997-09-18', '18700860366', '1275119618@qq.com', '0', '0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_information2
-- ----------------------------
INSERT INTO `user_information2` VALUES ('1', '1', '[1, 2, 3, 4]', '[1, 2, 3, 4]', '[1, 2, 3, 4]', '[1, 2, 3, 4]');
INSERT INTO `user_information2` VALUES ('2', '4', '[9, 11, 12, 14]', '[11, 12]', '[]', '[1]');
INSERT INTO `user_information2` VALUES ('3', '2', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('4', '7', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('5', '5', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('6', '11', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('7', '12', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('8', '14', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('9', '16', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('10', '17', '[]', '[]', '[]', '[]');
INSERT INTO `user_information2` VALUES ('11', '20', '[]', '[]', '[]', '[]');

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of view_record
-- ----------------------------
INSERT INTO `view_record` VALUES ('1', '1', '2019-03-18', '[1, 2, 3, 4]');
INSERT INTO `view_record` VALUES ('2', '1', '2019-03-19', '[1, 2, 3, 5]');
INSERT INTO `view_record` VALUES ('4', '1', '2019-03-21', '[]');
INSERT INTO `view_record` VALUES ('5', '4', '2019-03-21', '[12]');
INSERT INTO `view_record` VALUES ('6', '1', '2019-03-25', '[8]');
INSERT INTO `view_record` VALUES ('7', '4', '2019-03-25', '[9]');
INSERT INTO `view_record` VALUES ('8', '4', '2019-03-27', '[10, 11]');
INSERT INTO `view_record` VALUES ('9', '4', '2019-03-28', '[8, 9, 10]');
INSERT INTO `view_record` VALUES ('10', '2', '2019-03-28', '[9]');
INSERT INTO `view_record` VALUES ('11', '1', '2019-03-28', '[9]');
INSERT INTO `view_record` VALUES ('12', '7', '2019-03-28', '[9]');
INSERT INTO `view_record` VALUES ('13', '5', '2019-03-28', '[9]');
INSERT INTO `view_record` VALUES ('14', '1', '2019-04-01', '[9]');
INSERT INTO `view_record` VALUES ('15', '1', '2019-04-15', '[8, 14]');
INSERT INTO `view_record` VALUES ('16', '4', '2019-04-15', '[]');
INSERT INTO `view_record` VALUES ('17', '1', '2019-04-17', '[]');
INSERT INTO `view_record` VALUES ('18', '1', '2019-04-17', '[12]');
INSERT INTO `view_record` VALUES ('19', '4', '2019-04-17', '[12]');
INSERT INTO `view_record` VALUES ('20', '1', '2019-04-18', '[10, 11, 12]');
INSERT INTO `view_record` VALUES ('21', '4', '2019-04-18', '[16]');
INSERT INTO `view_record` VALUES ('22', '1', '2019-04-21', '[8]');
INSERT INTO `view_record` VALUES ('23', '11', '2019-04-21', '[19]');
INSERT INTO `view_record` VALUES ('24', '1', '2019-04-22', '[]');
INSERT INTO `view_record` VALUES ('25', '1', '2019-04-23', '[]');
INSERT INTO `view_record` VALUES ('26', '4', '2019-04-23', '[]');
INSERT INTO `view_record` VALUES ('27', '1', '2019-04-28', '[]');
INSERT INTO `view_record` VALUES ('28', '1', '2019-04-30', '[14, 15]');
INSERT INTO `view_record` VALUES ('29', '4', '2019-04-30', '[15]');
INSERT INTO `view_record` VALUES ('30', '1', '2019-05-05', '[]');
INSERT INTO `view_record` VALUES ('31', '1', '2019-05-06', '[]');
INSERT INTO `view_record` VALUES ('32', '1', '2019-05-06', '[12, 14]');
INSERT INTO `view_record` VALUES ('33', '1', '2019-05-08', '[8]');
INSERT INTO `view_record` VALUES ('34', '1', '2019-05-13', '[8]');
INSERT INTO `view_record` VALUES ('35', '12', '2019-05-13', '[8]');
INSERT INTO `view_record` VALUES ('36', '1', '2019-05-14', '[16, 17, 8, 9, 10, 11, 12, 14, 15]');
INSERT INTO `view_record` VALUES ('37', '14', '2019-05-14', '[]');
INSERT INTO `view_record` VALUES ('38', '16', '2019-05-14', '[]');
INSERT INTO `view_record` VALUES ('39', '17', '2019-05-14', '[]');
INSERT INTO `view_record` VALUES ('40', '4', '2019-05-14', '[8]');
INSERT INTO `view_record` VALUES ('41', '1', '2019-05-15', '[19, 8, 9]');
INSERT INTO `view_record` VALUES ('42', '4', '2019-05-15', '[]');
INSERT INTO `view_record` VALUES ('43', '20', '2019-05-15', '[8, 9]');
INSERT INTO `view_record` VALUES ('44', '1', '2019-05-16', '[]');
INSERT INTO `view_record` VALUES ('45', '1', '2019-05-20', '[]');
INSERT INTO `view_record` VALUES ('46', '1', '2019-05-21', '[]');

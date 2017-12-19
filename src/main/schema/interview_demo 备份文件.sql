/*
Navicat MySQL Data Transfer

Source Server         : rxliuli
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : interview_demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-19 17:00:18
*/

SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS interview_demo;
CREATE DATABASE interview_demo;
USE interview_demo;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id`         BIGINT(20)   NOT NULL
  COMMENT '管理员 id',
  `admin_name` VARCHAR(20)  NOT NULL
  COMMENT '管理员登录名',
  `password`   VARCHAR(128) NOT NULL
  COMMENT '管理员的密码',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id`            BIGINT(20)    NOT NULL
  COMMENT '评论',
  `user_login_id` BIGINT(20)    NOT NULL
  COMMENT '评论用户的 id',
  `topic_id`      BIGINT(20)    NOT NULL
  COMMENT '评论题目的 id',
  `content`       VARCHAR(1000) NOT NULL
  COMMENT '评论内容',
  `comment_date`  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '评论日期，默认当前时间'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='题目评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for examination
-- ----------------------------
DROP TABLE IF EXISTS `examination`;
CREATE TABLE `examination` (
  `id`         BIGINT(20)   NOT NULL
  COMMENT '考试编号',
  `name`       VARCHAR(100) NOT NULL
  COMMENT '考试名字',
  `start_time` DATETIME     NOT NULL
  COMMENT '开始时间',
  `end_time`   DATETIME     NOT NULL
  COMMENT '结束时间',
  `topic_ids`  TEXT         NOT NULL
  COMMENT '面试题目 id 集合',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考试信息';

-- ----------------------------
-- Records of examination
-- ----------------------------

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id`             BIGINT(20) NOT NULL
  COMMENT '一个用户一次考试对应的 id',
  `user_login_id`  BIGINT(20) NOT NULL
  COMMENT '用户 id',
  `examination_id` BIGINT(20) NOT NULL
  COMMENT '考试 id',
  `exam_score`     DOUBLE     NOT NULL
  COMMENT '考试成绩',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考试成绩表';

-- ----------------------------
-- Records of result
-- ----------------------------

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id`               BIGINT(20)    NOT NULL
  COMMENT '问题的 id',
  `type_id`          BIGINT(20)    NOT NULL
  COMMENT '题目类型 id',
  `title`            VARCHAR(100)  NOT NULL
  COMMENT '题目的标题',
  `reference_answer` VARCHAR(1000) NOT NULL
  COMMENT '题目的参考答案',
  `update_time`      DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='面试题目表';

-- ----------------------------
-- Records of topic
-- ----------------------------

-- ----------------------------
-- Table structure for topic_status
-- ----------------------------
DROP TABLE IF EXISTS `topic_status`;
CREATE TABLE `topic_status` (
  `result_id` BIGINT(20) NOT NULL
  COMMENT '一个用户一次考试对应的 id',
  `topic_id`  BIGINT(20) NOT NULL
  COMMENT '题目的 id',
  `status`    INT(11)    NOT NULL
  COMMENT '这道题目得到多少分'
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='用户考试题目状态';

-- ----------------------------
-- Records of topic_status
-- ----------------------------

-- ----------------------------
-- Table structure for topic_type
-- ----------------------------
DROP TABLE IF EXISTS `topic_type`;
CREATE TABLE `topic_type` (
  `id`    BIGINT(20)  NOT NULL
  COMMENT '类型编号',
  `title` VARCHAR(20) NOT NULL
  COMMENT '类型标题',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='面试题目类型';

-- ----------------------------
-- Records of topic_type
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id`       BIGINT(20)   NOT NULL
  COMMENT '外键，关联用户登录信息表',
  `nickname` VARCHAR(20)  NOT NULL
  COMMENT '用户昵称',
  `realname` VARCHAR(20)  DEFAULT NULL
  COMMENT '真实姓名',
  `picture`  VARCHAR(100) NOT NULL
  COMMENT '用户头像，默认存在的',
  `birthday` DATE         DEFAULT NULL
  COMMENT '生日',
  `gender`   TINYINT(1)   DEFAULT NULL
  COMMENT '性别',
  `address`  VARCHAR(200) DEFAULT NULL
  COMMENT '地址',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='用户详细信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login` (
  `id`       BIGINT(20)   NOT NULL
  COMMENT '用户 id',
  `username` VARCHAR(20)  NOT NULL
  COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL
  COMMENT '用户密码(加密过后)',
  `email`    VARCHAR(50)  NOT NULL
  COMMENT '邮箱',
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='用户登录信息表';

-- ----------------------------
-- Records of user_login
-- ----------------------------

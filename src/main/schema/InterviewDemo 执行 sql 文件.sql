# region 数据库的建立/修改脚本

# 面试题目数据库
CREATE DATABASE interview_demo;
USE interview_demo;

# 用户登录信息表
CREATE TABLE user_login (
  id       BIGINT       NOT NULL
  COMMENT '用户 id',
  username VARCHAR(20)  NOT NULL
  COMMENT '用户名',
  password VARCHAR(128) NOT NULL
  COMMENT '用户密码(加密过后)',
  email    VARCHAR(50)  NOT NULL
  COMMENT '邮箱',
  PRIMARY KEY (id)
)
  COMMENT '用户登录信息表';

# 用户详细信息表
CREATE TABLE user_info (
  id       BIGINT       NOT NULL
  COMMENT '外键，关联用户登录信息表',
  nickname VARCHAR(20)  NOT NULL
  COMMENT '用户昵称',
  realname VARCHAR(20)
  COMMENT '真实姓名',
  picture  VARCHAR(100) NOT NULL
  COMMENT '用户头像，默认存在的',
  birthday DATE
  COMMENT '生日',
  gender   BOOLEAN
  COMMENT '性别',
  address  VARCHAR(200)
  COMMENT '地址',
  PRIMARY KEY (id)
)
  COMMENT '用户详细信息表';

# 面试题目类型
CREATE TABLE topic_type (
  id    BIGINT      NOT NULL
  COMMENT '类型编号',
  title VARCHAR(20) NOT NULL
  COMMENT '类型标题',
  PRIMARY KEY (id)
)
  COMMENT '面试题目类型';

# 面试题目
DROP TABLE IF EXISTS topic;
CREATE TABLE topic
(
  id               BIGINT                    NOT NULL
  COMMENT '问题的 id'
    PRIMARY KEY,
  type_id          BIGINT                    NOT NULL
  COMMENT '题目类型 id',
  title            VARCHAR(100)              NOT NULL
  COMMENT '题目的标题',
  reference_answer VARCHAR(1000)             NOT NULL
  COMMENT '题目的参考答案',
  update_time      DATETIME DEFAULT now()    NOT NULL
  COMMENT '最后更新时间'
)
  COMMENT '面试题目表';

# 考试信息
DROP TABLE IF EXISTS examination;
CREATE TABLE examination (
  id         BIGINT       NOT NULL
  COMMENT '考试编号',
  name       VARCHAR(100) NOT NULL
  COMMENT '考试名字',
  start_time DATETIME     NOT NULL
  COMMENT '开始时间',
  end_time   DATETIME     NOT NULL
  COMMENT '结束时间',
  topic_ids  TEXT         NOT NULL
  COMMENT '面试题目 id 集合',
  PRIMARY KEY (id)
)
  COMMENT '考试信息';

# 考试成绩表
DROP TABLE IF EXISTS result;
CREATE TABLE result (
  id             BIGINT NOT NULL
  COMMENT '一个用户一次考试对应的 id',
  user_login_id  BIGINT NOT NULL
  COMMENT '用户 id',
  examination_id BIGINT NOT NULL
  COMMENT '考试 id',
  exam_score     DOUBLE NOT NULL
  COMMENT '考试成绩',
  PRIMARY KEY (id)
)
  COMMENT '考试成绩表';

# 用户考试题目状态
DROP TABLE IF EXISTS topic_status;
CREATE TABLE topic_status (
  result_id BIGINT NOT NULL
  COMMENT '一个用户一次考试对应的 id',
  topic_id  BIGINT NOT NULL
  COMMENT '题目的 id',
  status    INT    NOT NULL
  COMMENT '这道题目得到多少分'
)
  COMMENT '用户考试题目状态';

# 查询一个用户一次考试所有题目以及对错
SELECT ui.realname AS 'realname'
FROM topic_status ts
  INNER JOIN topic t ON t.id = ts.topic_id
  INNER JOIN result r ON r.id = ts.result_id
  INNER JOIN user_info ui ON ui.id = r.user_login_id
  INNER JOIN examination e ON e.id = r.examination_id
WHERE ts.result_id = 1200;

DESCRIBE result;

# 题目评论表
CREATE TABLE comment (
  id            BIGINT                NOT NULL
  COMMENT '评论',
  user_login_id BIGINT                NOT NULL
  COMMENT '评论用户的 id',
  topic_id      BIGINT                NOT NULL
  COMMENT '评论题目的 id',
  content       VARCHAR(1000)         NOT NULL
  COMMENT '评论内容',
  comment_date  DATETIME DEFAULT now()NOT NULL
  COMMENT '评论日期，默认当前时间'
)
  COMMENT '题目评论表';

# 管理员表
CREATE TABLE admin (
  id         BIGINT       NOT NULL
  COMMENT '管理员 id',
  admin_name VARCHAR(20)  NOT NULL
  COMMENT '管理员登录名',
  password   VARCHAR(128) NOT NULL
  COMMENT '管理员的密码',
  PRIMARY KEY (id)
)
  COMMENT '管理员表';

# endregion
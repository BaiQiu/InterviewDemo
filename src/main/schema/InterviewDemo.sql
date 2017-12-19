# region 数据库的建立/修改脚本

CREATE DATABASE interview_demo;
USE interview_demo;
USE interview_demo_test;
# 创建面试题目表
CREATE TABLE topic (
  id              BIGINT        NOT NULL
  COMMENT '问题的 id',
  typeId          BIGINT        NOT NULL
  COMMENT '题目类型 id',
  title           VARCHAR(100)  NOT NULL
  COMMENT '题目的标题',
  referenceAnswer VARCHAR(1000) NOT NULL
  COMMENT '题目的参考答案',
  PRIMARY KEY (id)
)
  COMMENT '面试题目表';

# endregion
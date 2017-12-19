package com.interview.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户对面试题目的评论实体类.
 *
 * @author rxliuli
 */
public class Comment implements Serializable {

  private Long id;
  private Long userLoginId;
  private Long topicId;
  private String content;
  private java.sql.Timestamp commentDate;

  public Comment() {
  }

  public Comment(Long id, Long userLoginId, Long topicId, String content, Timestamp commentDate) {

    this.id = id;
    this.userLoginId = userLoginId;
    this.topicId = topicId;
    this.content = content;
    this.commentDate = commentDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getUserLoginId() {
    return userLoginId;
  }

  public void setUserLoginId(Long userLoginId) {
    this.userLoginId = userLoginId;
  }


  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(java.sql.Timestamp commentDate) {
    this.commentDate = commentDate;
  }

}

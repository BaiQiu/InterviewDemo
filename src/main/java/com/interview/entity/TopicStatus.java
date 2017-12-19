package com.interview.entity;

import java.io.Serializable;

/**
 * 用户考试的各个题目的对错得分.
 *
 * @author rxliuli
 */
public class TopicStatus implements Serializable {

  private Long resultId;
  private Long topicId;
  private Long status;


  public Long getResultId() {
    return resultId;
  }

  public void setResultId(Long resultId) {
    this.resultId = resultId;
  }


  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }


  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

}

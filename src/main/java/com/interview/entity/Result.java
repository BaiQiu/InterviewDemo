package com.interview.entity;

import java.io.Serializable;

/**
 * 成绩实体类.
 *
 * @author rxliuli
 */
public class Result implements Serializable {

  private Long id;
  private Long userLoginId;
  private Long examinationId;
  private Double examScore;

  public Result() {
  }

  public Result(Long id, Long userLoginId, Long examinationId, Double examScore) {

    this.id = id;
    this.userLoginId = userLoginId;
    this.examinationId = examinationId;
    this.examScore = examScore;
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

  public Long getExaminationId() {
    return examinationId;
  }

  public void setExaminationId(Long examinationId) {
    this.examinationId = examinationId;
  }

  public Double getExamScore() {
    return examScore;
  }

  public void setExamScore(Double examScore) {
    this.examScore = examScore;
  }

}

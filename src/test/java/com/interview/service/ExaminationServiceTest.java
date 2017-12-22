package com.interview.service;

import com.interview.entity.Examination;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class ExaminationServiceTest extends BaseTestNGUtil {
  @Autowired
  private ExaminationService examinationService;

  @Test
  public void testAddExamination() throws Exception {
    Examination examination = examinationService.addExamination(
      "测试考试",
      "2015-12-11 11:10:00",
      "2015-12-11 12:10:00",
      20
    );
    assertThat(examination).isNotNull();
  }
}

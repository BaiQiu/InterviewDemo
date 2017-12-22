package com.interview.dao;

import com.github.pagehelper.PageHelper;
import com.interview.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class ResultMapperTest extends BaseTestNGUtil {
  @Autowired
  private ResultMapper resultMapper;

  @Test
  public void testListByUserId() throws Exception {
    final int resultNumber = 20;
    PageHelper.startPage(1, resultNumber);
    List<Result> resultList = resultMapper.listByUserId(393730760231751680L);
    assertThat(resultList).hasSize(resultNumber);
  }
}
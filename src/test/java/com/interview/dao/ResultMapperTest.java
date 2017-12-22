package com.interview.dao;

import com.github.pagehelper.PageHelper;
import com.interview.entity.Examination;
import com.interview.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import util.BaseTestNGUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rxliuli
 */
public class ResultMapperTest extends BaseTestNGUtil {
  @Autowired
  private ResultMapper resultMapper;
  @Autowired
  private ExaminationMapper examinationMapper;

  @Test
  public void testListByUserId() throws Exception {
    final int resultNumber = 20;
    PageHelper.startPage(1, resultNumber);
    List<Result> resultList = resultMapper.listByUserId(393730760231751680L);
    assertThat(resultList).hasSize(resultNumber);
  }

  @Test
  public void testListByUserIdAndExaminations() throws Exception {
    //获取最近 20 次的考试
    Long userId = 393730760231751680L;
    List<Examination> examinationList = examinationMapper.listByLimit(20);
    List<Long> examinationIdList = examinationList.stream()
      .map(Examination::getId)
      .collect(Collectors.toList());
    Integer resultNumber = 20;

    //参数
    Map<String, Object> map = new HashMap<>();
    map.put("userId", userId);
    map.put("examinationIdList", examinationIdList);
    map.put("resultNumber", resultNumber);

    //查询
    List<Result> resultList = resultMapper.listByUserIdAndExaminations(map);
    assertThat(resultList)
      .hasSize(resultNumber)
      .allMatch(result -> result.getUserLoginId().equals(userId))
      .allMatch(result -> examinationIdList.contains(result.getExaminationId()));
  }
}
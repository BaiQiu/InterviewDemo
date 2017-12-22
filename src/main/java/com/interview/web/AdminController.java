package com.interview.web;

import com.interview.entity.Admin;
import com.interview.entity.Examination;
import com.interview.service.AdminService;
import com.interview.service.ExaminationService;
import com.interview.util.ConstantsUtil;
import com.interview.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

import static com.interview.util.ConstantsUtil.YYYY_MM_DD_HH_MM_SS;

/**
 * 管理员 web 层的控制器.
 *
 * @author rxliuli
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
  /**
   * log4j 的日志记录对象.
   */
  private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdminController.class);

  /**
   * 管理员业务接口实例.
   */
  @Autowired
  private AdminService adminService;

  /**
   * 考试业务接口实例.
   */
  @Autowired
  private ExaminationService examinationService;


  /**
   * 跳转到用户登录页面.
   *
   * @return 用户登录页面逻辑视图名
   */
  @RequestMapping(path = "/login")
  public String login() {
    return "background/login";
  }

  /**
   * 管理员登陆(使用 ajax 技术).
   *
   * @param adminName 登录账户名
   * @param password  登录密码
   * @param session   当前浏览器会话的 session 对象
   * @return 返回一个 JsonResult<Admin> 对象(会在后台转为 json 格式的字符串)
   */
  @RequestMapping(path = "/loginExecute")
  @ResponseBody
  public JsonResult<Admin> loginExecute(
    @RequestParam(required = false) String adminName,
    @RequestParam(required = false) String password,
    HttpSession session
  ) {
    //服务端验证
    if (StringUtils.isAnyBlank(adminName, password)) {
      return JsonResult.getError("用户名和密码不能为空！");
    }

    //查询数据库
    Admin admin = adminService.login(new Admin(null, adminName, password));

    //判断登录是否成功
    if (admin == null) {
      return JsonResult.getError("用户名或密码错误！");
    }

    //登陆成功就保存到 session 中
    session.setAttribute(ConstantsUtil.ADMIN_SESSION, admin);
    return JsonResult.getSuccess(admin);
  }

  /**
   * 跳转到添加考试的页面.
   *
   * @return 添加考试页面的逻辑视图名
   */
  @RequestMapping(path = "/addExamination")
  public String addExamination() {
    return "background/addExamination";
  }

  /**
   * 执行添加考试的操作.
   *
   * @param name        考试的名字
   * @param startTime   考试开始时间
   * @param endTime     考试结束时间
   * @param topicNumber 题目的数量
   * @return 如果添加成功就返回考试的详细信息，否则返回错误消息.
   */
  @RequestMapping(path = "/addExaminationExecute")
  @ResponseBody
  public JsonResult<Examination> addExaminationExecute(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String startTime,
    @RequestParam(required = false) String endTime,
    @RequestParam(required = false) int topicNumber
  ) {
    //判断参数合法性
    if (name == null) {
      return JsonResult.getError("考试名字不能为空！");
    }
    //Error
//    if (!PatternMatchUtils.simpleMatch(YYYY_MM_DD_HH_MM_SS, startTime)
//      || !PatternMatchUtils.simpleMatch(YYYY_MM_DD_HH_MM_SS, endTime)) {
//      return JsonResult.getError("日期格式错误！");
//    }
    try {
      if (DateUtils.parseDate(startTime, YYYY_MM_DD_HH_MM_SS).getTime() >= DateUtils.parseDate(endTime, YYYY_MM_DD_HH_MM_SS).getTime()) {
        return JsonResult.getError("开始时间不能大于结束日期！");
      }
    } catch (ParseException e) {
      logger.info(e.getMessage());
    }
    if (topicNumber < ConstantsUtil.TOPIC_MIN_NUMBER || topicNumber > ConstantsUtil.TOPIC_MAX_NUMBER) {
      return JsonResult.getError("题目数量只能在 10-60 之间");
    }
    //执行数据库操作
    Examination examination = examinationService.addExamination(name, startTime, endTime, topicNumber);
    //判断结果
    if (examination == null) {
      return JsonResult.getError("添加考试失败！");
    }
    return JsonResult.getSuccess(examination);
  }

}

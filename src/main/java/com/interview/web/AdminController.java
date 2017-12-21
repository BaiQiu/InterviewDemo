package com.interview.web;

import com.interview.entity.Admin;
import com.interview.service.AdminService;
import com.interview.util.ConstantsUtil;
import com.interview.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 管理员 web 层的控制器.
 *
 * @author rxliuli
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
  /**
   * 管理员业务访问接口实例.
   */
  @Autowired
  private AdminService adminService;

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
}

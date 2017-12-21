<%--
  Created by IntelliJ IDEA.
  User: rxliuli
  Date: 2017/12/21
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>管理员登陆页面</title>
  <!--
  注：此处之所以要加上 ${pageContext.request.contextPath} 这句话是因为项目的部署根路径在开发时是不确定的，
  即便我们现在可以自己决定这个问题，然而如果是将项目给别人却并非总是如此！
  -->
  <script src="${pageContext.request.contextPath}/statics/commons/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/statics/commons/js/popper.min.js"></script>
  <link href="${pageContext.request.contextPath}/statics/commons/css/bootstrap.min.css" rel="stylesheet"/>
  <script src="${pageContext.request.contextPath}/statics/commons/js/bootstrap.min.js"></script>
  <!--该页面单独的样式和脚本-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/background/css/login.css">
  <script src="${pageContext.request.contextPath}/statics/background/js/login.js"></script>
</head>
<body>
<div class="container">
  <div class="card card-login mx-auto mt-5 form-login">
    <h2 class="card-header text-primary text-center">管理员登陆</h2>
    <div class="card-body">
      <form action="#">
        <div class="form-group">
          <label for="adminName">登录名</label>
          <input type="text" class="form-control" name="adminName" id="adminName" required/>
        </div>
        <div class="form-group">
          <label for="password">密码</label>
          <input type="password" class="form-control" name="password" id="password" required/>
        </div>
        <div class="check-box">
          <label class="text-white">
            <input type="checkbox" value="remember" name="remember"/>记住密码
          </label>
        </div>
        <div class="btn-group btn-group-justified">
          <div class="btn-group">
            <button type="submit" class="btn btn-primary">登录</button>
          </div>
          <div class="btn-group">
            <button type="reset" class="btn btn-primary">重置</button>
          </div>
          <a href="" class="btn btn-primary">首页</a>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>

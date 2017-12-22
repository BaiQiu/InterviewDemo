<%--
  Created by IntelliJ IDEA.
  User: rxliuli
  Date: 2017/12/21
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>添加新的考试</title>
  <script src="${pageContext.request.contextPath}/statics/commons/js/jquery.min.js"></script>
  <link href="${pageContext.request.contextPath}/statics/commons/css/bootstrap.min.css" rel="stylesheet"/>
  <script src="${pageContext.request.contextPath}/statics/commons/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/statics/background/js/addExamination.js"></script>
</head>
<body>
<!--添加新的考试-->
<h1 class="text-center text-primary">添加考试</h1>
<form class="container" method="post" action="#" id="addExamination">
  <div class="form-group">
    <label for="name">考试名称</label>
    <input type="text" class="form-control" name="name" id="name"/>
  </div>
  <div class="form-group">
    <label for="startTime">开始时间</label>
    <input type="text" class="form-control" name="startTime" id="startTime"/>
  </div>
  <div class="form-group">
    <label for="endTime">结束时间</label>
    <input type="text" class="form-control" name="endTime" id="endTime"/>
  </div>
  <div class="form-group">
    <label for="topicNumber">题目数量</label>
    <input type="number" class="form-control" min="10" max="60" name="topicNumber" id="topicNumber"/>
  </div>
  <div class="btn-group btn-group-justified">
    <div class="btn-group">
      <button type="submit" class="btn btn-default">提交</button>
    </div>
    <div class="btn-group">
      <button type="reset" class="btn btn-default">重置</button>
    </div>
    <a href="" class="btn btn-default">首页</a>
  </div>
</form>
</body>
</html>

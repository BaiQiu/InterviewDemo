
$(document).ready(function () {
  $(".cf button:submit").click(function () {
    var text = document.getElementById("btn").value;//通过id获取需要验证的表单元素的值
    if (text === "") {//当上面获取的值为空时
      alert("不能为空哦！");//弹出提示
      return false;//返回false（不提交表单）
    }
    return true;//提交表单
  });
});


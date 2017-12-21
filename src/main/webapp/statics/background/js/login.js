$(function () {
  /**
   * 管理员登陆.
   */
  $(".form-login button:submit").click(function () {
    //获得登陆名和密码
    var adminName = $("#adminName").val();
    var password = $("#password").val();

    //非空校验
    if (adminName.trim() === ''
      || password.trim() === '') {
      alert("用户名或密码为空!");
      return false;
    }

    //进行 ajax 验证
    $.ajax({
      url: "/admin/loginExecute",
      type: "POST",
      dataType: "json",
      data: {
        adminName: adminName,
        password: password
      },
      success: function (json) {
        var success = json.success;
        if (success) {
          open("/admin/index", "_self");

        } else {
          alert(json.message);
        }
      },
      error: function () {
        alert("网络错误啦！")
      }
    });
    //无论是否成功都不会提交表单(然而如果真的成功就会直接跳转到其他页面了 233333)
    return false;
  })
});
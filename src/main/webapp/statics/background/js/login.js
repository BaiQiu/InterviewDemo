$(function () {
  /**
   * 管理员登陆.
   */
  $("button:submit").click(function () {
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
      url: "/admin/loginExecute",
      type: "POST",
      dataType: "json",
      data: {
        username: username,
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
    return false;
  })
});
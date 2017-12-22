/**
 * @author rxliuli
 */
$(function () {
  /**
   * 添加考试
   */
  $("#addExamination").find(":submit").click(function () {
    var name = $("#name").val().trim();
    var startTime = $("#startTime").val().trim();
    var endTime = $("#endTime").val().trim();
    var topicNumber = $("#topicNumber").val();
    $.ajax({
      url: "/admin/addExaminationExecute",
      type: "POST",
      dataType: "json",
      data: {
        name: name,
        startTime: startTime,
        endTime: endTime,
        topicNumber: topicNumber
      },
      success: function (json) {
        if (json.success) {
          alert("添加考试成功：" + json.data.name);
          //跳转到首页
          open("", "_self");
        } else {
          alert("添加考试失败：" + json.message);
        }
      },
      error: function () {
        alert("网络错误啦！");
      }
    });

    return false;
  })
});

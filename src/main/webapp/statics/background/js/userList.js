
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

$(function () {
  $("#pagination3").pagination({
    currentPage: 1,
    totalPage: 16,
    isShow: true,
    count: 7,
    homePageText: "首页",
    endPageText: "尾页",
    prevPageText: "上一页",
    nextPageText: "下一页",
    callback: function(current) {
      $("#current3").text(current)
    }
  });

  $("#getPage").on("click", function() {
    var info = $("#pagination3").pagination("getPage");
    alert("当前页数：" + info.current + ",总页数：" + info.total);
  });

  $("#setPage").on("click", function() {
    $("#pagination3").pagination("setPage", 1, 10);
  });
});



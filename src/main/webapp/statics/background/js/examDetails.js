/*时钟*/
function clock_12h()
{
  var today = new Date();

  var year = today.getFullYear();
  var month = today.getMonth()+1;
  var date = today.getDate();
  var hour = today.getHours();
  var minute = today.getMinutes();
  var second = today.getSeconds();

  var apm="AM";
  if (hour>12)
  {
    hour=hour-12;
    apm="PM"  ;
  }
  var weekday = 0;
  switch(today.getDay()){
    case 0:
      weekday = "春";
      break;
    case 1:
      weekday = "夏";
      break;
    case 2:
      weekday = "秋";
      break;
    case 3:
      weekday = "冬";
      break;
  }


  document.getElementById("myclock").innerHTML="<h2></h2>"+year+"年"+month+"月"+date+"日"+hour+":"+minute+":"+second+"&nbsp;"+apm+"&nbsp;"+weekday+"</h2>";

}

var myTime = setInterval("clock_12h()",1000);



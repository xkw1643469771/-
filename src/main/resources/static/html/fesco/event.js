$(function(){
    var btn = document.getElementById("btn");
    btn.addEventListener("click",fun1);//添加事件, 事件在冒泡阶段执行
    btn.addEventListener("click",fun1,true);//事件在捕获阶段执行
    btn.addEventListener("click",fun2);//添加事件另一个事件
    btn.removeEventListener("click",fun1);//移除冒泡阶段的事件

    $('[data-toggle="popover"]').popover();

});

function fun1(){
    alert("fun1");
}
function fun2(){
    alert("fun2");
}
function fun3(){
    alert("fun3");
}
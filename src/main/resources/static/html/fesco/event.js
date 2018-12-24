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
//=======================================================================================
// Jquery bind 有参数方法
$(function(){
    // 方式一
    var fun1 = function(event){
        alert(event.data.val);
    }
    $("#btnJqueryBind1").bind("click",{val:123}, fun1);
    // 方式二
    var fun2 = function(a,b,c){
        alert(a+" "+b+" "+c);
    }
    $("#btnJqueryBind2").bind("click",function(){fun2(1,2,3)});
});
//=======================================================================================
// 监听属性变化
$(function(){
    var MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
    var config = {
        attributes: true,//监听属性的增删改
        attributeFilter : ["style","class"],//要监听的属性
        childList: true,//监听子节点的添加或删除
        characterData : true,//监听characterData节点(一个接口)
        subtree : true,//监听子节点属性的增删改
    }
    new MutationObserver(function(mutations){
        console.info(mutations.length);
    }).observe($("#monitorAttrChange1")[0],config);
    $("#monitorAttrChangeBtn").click(function(){
        $("#monitorAttrChange1")[0].classList.add("divRed");
        $("#monitorAttrChange1")[0].setAttribute("class","123");
        $("#monitorAttrChange1")[0].style.backgroundColor = "red";
    })
});

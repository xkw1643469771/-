$(function(){
    // 窗口绑定键盘事件
    /*window.onkeypress = function(e){
        alert(e.key);
    }*/
    // input绑定键盘事件
    /*var is = document.getElementsByTagName("//input");
    for(var i = 0; i<is.length; i++){
        is[i].onkeypress = function(e){
            alert(e.key);
        }
    }
    $("input").keypress(function(){
        console.info($(this).closest("form")[0]);
    })*/
    $("#disabledFromSubmit").click(function(){
        $("#disabledFrom").submit();
    });
});
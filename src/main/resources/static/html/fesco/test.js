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

    myflexbox();
});

function myflexbox(){
    var flex = $("#myFlexbox");
    var input = $("<input type='text'>");
    var divStr = "<div style='background-color: #0c5460; width: 20px; height: 20px; position: absolute;'></div>";
    var div = $(divStr);
    flex.append(input);
    flex.append(div);
}
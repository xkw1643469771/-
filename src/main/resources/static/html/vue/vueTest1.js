var styleBindTest1;

$(function(){
    styleBindTest1 = new Vue({
        el : "#styleBindTest1",
        data : {
            msg : ""
        },
        methods : {
            addInput : function(){
               // $("#styleBindTest1").append("<a href='#' class='btn btn-primary'>按钮</a>");
                var a1 = document.getElementById("a1");
                a1.classList.add("btn");
                a1.classList.add("btn-primary");
                a1.href = "#";
            }
        }
    });

    var MutationObserver = MutationObserver || WebKitMutationObserver || MozMutationObserver;
    new MutationObserver(function(m){
        console.info(m);
    }).observe($("#styleBindTest1")[0],{
        attributes : true,
        //subtree : true,
        childList : true
    })
});
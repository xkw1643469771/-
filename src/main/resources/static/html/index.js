$(function(){
    var catalog = new Vue({
        el : "#catalog",
        data : {
            cls : []
        },
        methods : {
            catalogClick : function(cl){
                getCatalog(cl.projectPath);
            }
        }
    });
    var htmlContent = new Vue({
        el : "#htmlContent",
        data : {
            items : []
        },
        methods : {
            itemClick : function(item){
                if(item.itemIsFolder)
                    getCatalog(item.projectPath);
                else{
                    $("#winDiv").attr("src",item.projectPath);
                }

            }
        }
    });
    var getCatalog = function (parentPath){
        $.get("/html/catalog?parentPath=" + parentPath, function(data){
            catalog.cls = data.parent;
            if(data.items.length == 0)
                htmlContent.items = [{name:"empty"}]
            else
                htmlContent.items = data.items;
        });
    }
    getCatalog("/html");
    resetWinDiv();
})

function resetWinDiv(){
    //setInterval(resetWinDivPosition, 100);
    var htmlContent = document.getElementById("htmlContent");
    var MutationObserver = window.MutationObserver || window.WebKitMutationObserver || window.MozMutationObserver;
    new MutationObserver(resetWinDivPosition).observe(htmlContent, {childList : true});
    window.onresize = resetWinDivPosition;
}

function resetWinDivPosition(){
    var htmlContent = document.getElementById("htmlContent");
    var catalog = document.getElementById("catalog");
    var winLeft = htmlContent.offsetWidth + htmlContent.offsetLeft + 10;
    var winTop = htmlContent.offsetTop;
    var winWidth = catalog.offsetWidth - htmlContent.offsetWidth - 10;
    var winHeight = document.documentElement.clientHeight - winTop - 10;
    var winDivCss = $("<a style='position: absolute; left: " + winLeft +
        "px; top: " + winTop + "px; width: " + winWidth +
        "px; height: " + winHeight + "px;'></a>").attr("style");
    var winDiv = document.getElementById("winDiv");
    $("#winDiv iframe").height = winHeight;
    winDiv.style = winDivCss;
}

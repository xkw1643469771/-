window.onload = function(){
    loadRemoteJs("https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js");
    jqueryStart();
};

function loadRemoteJs(url){
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState==4 && xmlhttp.status==200){
            eval(xmlhttp.responseText);
        }
    }
    xmlhttp.open("GET",url, false);
    xmlhttp.send();
}

// 骚操作开始
function jqueryStart(){
    executionPlanOperation();
}

var ep = {}

function executionPlanOperation(){
    var h3 = $("h3:contains('Execution Plan')");
    var tab = h3.next();
    var btnTop = $("<input type='button' value='top'>");
    var btnBottom = $("<input type='button' value='bottom'>");
    var btnUp = $("<input type='button' value='up'>");
    var btnNext = $("<input type='button' value='next'>");
    h3.after(btnTop);
    btnTop.after(btnUp);
    btnUp.after(btnNext);
    btnNext.after(btnBottom);
    var trs = tab.find("tr");
    var arr = new Array();
    for(var i = 1; i < trs.length; i++){
        var td = $(trs[i]).find("td:eq(1)");
        var str = td.text();
        str = decodeURI(encodeURI(str).replace(/%C2%A0/g,'%20'));
        var sum = 0;
        for(var j = 0; j<str.length; j++){
            if(str[j] == " "){
                sum++;
            }else{
                break;
            }
        }
        var level = (sum - 2) / 3;
        console.info(level,$.trim(str));
    }
}

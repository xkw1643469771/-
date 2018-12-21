window.onload = function(){
    loadRemoteJs("https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js");
    jqueryStart();
};
// ajax同步加载js
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
    xmlhttp.open("GET",url, false);//false同步, true异步
    xmlhttp.send();
}

// 骚操作开始
function jqueryStart(){
    executionPlanOperation();
}



function executionPlanOperation(){
    ep.init();
    //ep.baseSort();
    ep.baseTree();
    console.info(ep.$h3);
}

var ep = {
    init : function(){
        this.$h3 = $("h3:contains('Execution Plan')");
        this.$tab = this.$h3.next();
        this.$btnTop = $("<input type='button' value='top'>");
        this.$btnBottom = $("<input type='button' value='bottom'>");
        this.$btnUp = $("<input type='button' value='up'>");
        this.$btnNext = $("<input type='button' value='next'>");
        this.$h3.after(this.$btnTop);
        this.$btnTop.after(this.$btnUp);
        this.$btnUp.after(this.$btnNext);
        this.$btnNext.after(this.$btnBottom);
    },
    baseTree : function(){
        var trs = this.$tab.find("tr");
        var root = {next:undefined,}
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
            console.info(level);
        }
    },
    baseSort : function(){
        var trs = this.$tab.find("tr");
        var arr = new Array();
        var tds = new Array();
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
            var level = (sum - 2) / 3 * 10;
            arr[level] = arr[level] ? arr[level] - 1 : level;
            tds[arr[level]] = td;
        }
        var tdsArr = new Array();
        var idx = 0;
        for(var td in tds)
            tdsArr[idx++] = tds[td];
        var idx = tdsArr.length-1;
        tdsArr[idx].css("color","red");
        this.$btnNext.click(function(){
            if(idx >= tdsArr.length - 1)
                return;
            var oldTd = tdsArr[idx];
            idx++;
            var td = tdsArr[idx];
            if(td){
                try{
                    oldTd.css("color","black");
                }catch(e){}
                td.css("color","red");
            }
        });
        this.$btnUp.click(function(){
            if(idx<=0)
                return;
            var oldTd = tdsArr[idx];
            idx--;
            var td = tdsArr[idx];
            if(td){
                try{
                    oldTd.css("color","black");
                }catch(e){}
                td.css("color","red");
            }
        });
    }
}
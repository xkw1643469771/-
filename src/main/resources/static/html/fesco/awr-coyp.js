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

loadRemoteJs("https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js");

function print(){
    var trs = $("h3:contains('Execution Plan')").next().find("tr");
    var sb  = "";
    for(var i = 0; i < trs.length; i++){
        var tds = $(trs[i]).find("td");
        var sbRow = "";
        for(var j = 1; j< tds.length; j ++){
            var td = $(tds[j]);
            //sbRow = print2(j, td, sbRow);
            sbRow = print3(j, td, sbRow);
        }
        sb += sbRow + "\n";
    }
    console.log(sb);
}

function print2(idx, td, sbRow){
    if(idx == 1){
        var str = td.text();
        str = decodeURI(encodeURI(str).replace(/%C2%A0/g,'%20'));
        var sum = 0;
        for(var k = 0; k<str.length; k++){
            if(str[k] == " "){
                sum++;
            }else{
                break;
            }
        }
        var level = (sum - 2) / 3 * 1;
        for(var i = 0; i < level; i++){
            sbRow += "    ";
        }
        sbRow += td.text().trim();
    }else if(idx == 2){
        var len = 100 - sbRow.length;
        for(var i=0;i < len;i++){
            sbRow += " ";
        }
        sbRow += td.text().trim();
    }else{
        var len = (idx * 50) - sbRow.length;
        for(var i=0;i < len;i++){
            sbRow += " ";
        }
        sbRow += td.text().trim();
    }
    return sbRow;
}

function print3(idx, td, sbRow){
    if(idx == 1){
        var str = td.text();
        str = decodeURI(encodeURI(str).replace(/%C2%A0/g,'%20'));
        var sum = 0;
        for(var k = 0; k<str.length; k++){
            if(str[k] == " "){
                sum++;
            }else{
                break;
            }
        }
        var level = (sum - 2) / 3 * 1;
        for(var i = 0; i < level; i++){
            sbRow += "|   ";
        }
    }else{
        sbRow += "\t";
    }
    sbRow += td.text().trim();
    return sbRow;
}
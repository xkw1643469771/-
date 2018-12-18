$(function() {
	new Vue({
		el : "#urlSend",
		data : {
			url : ""
		},
		methods : {
			send : function(){
			}
		}
	});

	// 默认获取焦点
	document.getElementById("input2").focus();//获取焦点
	document.getElementById("input2").blur();//失去焦点
	document.getElementById("input3").click();//触发点击


});

function input3Click(){
	alert("点击事件!");
}
$('#login').click(function(){
	openHomePage();
});

document.onkeydown=function(event){
    var e = event || window.event || arguments.callee.caller.arguments[0];
        
    if(e && e.keyCode==13){ // enter 键
         //要做的事情
    	openHomePage();
    }
}; 
$("#register").click(function () {
    SimplePop.alert("系统火速建设中...",{
        drag: true,       //是否可拖动图层
    });
});
$("#chpwd").click(function () {
    SimplePop.alert("系统火速建设中...",{
        drag: true,       //是否可拖动图层
    });
});

function openHomePage(){
	if('undefined' == $('#username').val() || '' == $('#username').val().trim()){
		SimplePop.alert("username can not be empty ! ");
		return;
	}
	
	if('undefined' == $('#password').val() || '' == $('#password').val().trim()){
		SimplePop.alert("password can not be empty ! ");
		return;
	}
	window.location.href="/html/home.html";
}

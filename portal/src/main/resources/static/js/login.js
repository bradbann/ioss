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
    SimplePop.alert("系统火速建设中，请稍后...",{
        drag: true,       //是否可拖动图层
    });
});
$("#chpwd").click(function () {
    SimplePop.alert("系统火速建设中，请稍后...",{
        drag: true,       //是否可拖动图层
    });
});

function openHomePage(){
	if('admin' != $('#username').val()){
		SimplePop.alert("username must be admin ! ");
		return;
	}
	
	if('password' != $('#password').val()){
		SimplePop.alert("password must be 'password' ! ");
		return;
	}
	window.location.href="/html/home.html";
}

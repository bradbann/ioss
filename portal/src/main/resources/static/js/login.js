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
$('#register').click(function(){
	alert("功能火速实现中，请稍等...");
});
$('#chpwd').click(function(){
	alert("功能火速实现中，请稍等...");
});

function openHomePage(){
	if('admin' != $('#username').val()){
		alert("username must be admin ! ");
		return;
	}
	
	if('password' != $('#password').val()){
		alert("password must be 'password' ! ");
		return;
	}
	window.location.href="/html/home.html";
}

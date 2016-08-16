$(function(){
	$('#cancel1').click(function(){
		window.location.href = '../html/login.html';
	});

	$('#cancel2').click(function(){
		window.location.href = '../html/login.html';
	});
	var thisURL = document.URL;    
	var  param =thisURL.split('?')[1];  
	var paramVal= param.split("=")[1];
	
	if(paramVal == 'register'){
		$('#update').hide();
		$('#register').show()
	}
	
	if(paramVal == 'update'){
		$('#register').hide();
		$('#update').show();
	}
});


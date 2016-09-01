$(function(){
	var thisURL = document.URL; 
	var  param =thisURL.split('?')[1];
	var paramVal= param.split("=")[1];
	
	if("" != paramVal){
		$.ajax({
			url: "/ioss/knowledge/querySingleKnowledge?id="+paramVal,
            type: "GET",
            data: {},
            dataType: "json",
            success: function(data){
            	if(data){
            		$('#title').text(data["eventTitle"]);
                	$('#ticketId').text(data["eventId"]);
                	$('#solveDate').text(data["updateTime"]);
                	$('#description').text(data["eventDescr"]);
                	$('#solution').text(data["solution"]);
            	}
             }
        });
	}
});
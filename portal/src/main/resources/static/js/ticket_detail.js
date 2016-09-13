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
            		var regexstr = new RegExp("<[^<]*>", "gi");
            		$('#title').text(data["eventTitle"].replace(regexstr,""));
                	$('#ticketId').text(data["eventId"].replace(regexstr,""));
                	$('#solveDate').text(data["updateTime"].replace(regexstr,""));
                	$('#description').text(data["eventDescr"].replace(regexstr,""));
                	$('#solution').text(data["solution"].replace(regexstr,""));
            	}
             }
        });
	}
});
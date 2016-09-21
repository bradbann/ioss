var thisURL = document.URL; 
	var  param =thisURL.split('?')[1];
	var paramVal= param.split("=")[1];
	
	if("" != paramVal){
		$.ajax({
			url: "/ioss/knowledge/ticket?eventId="+paramVal,
            type: "GET",
            data: {},
            dataType: "json",
            success: function(data){
            	if(data){
            		var str = data;
            		console.log(str);
            		var regexstr = new RegExp("<[^<]*>", "gi");
//            		$('#title').text(data["eventTitle"].replace(regexstr,""));
            	}
             }
        });
	}
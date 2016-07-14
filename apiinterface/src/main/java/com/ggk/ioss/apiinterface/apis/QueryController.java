package com.ggk.ioss.apiinterface.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ggk.ioss.apiinterface.callers.ESCaller;

@RestController
public class QueryController {
	
	@Autowired
	private ESCaller esCaller;
	
	@RequestMapping(value = {"/ioss/apiinterface/apis"}, method = RequestMethod.POST)
	public String query(@RequestParam String queryParams){
		return  esCaller.query(queryParams);
	}
}

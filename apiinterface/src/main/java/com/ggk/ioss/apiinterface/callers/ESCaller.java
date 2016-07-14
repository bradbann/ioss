package com.ggk.ioss.apiinterface.callers;

import org.springframework.stereotype.Service;

@Service
public class ESCaller {
	public String query(String queryJson){
		return queryJson + "ok";
	}
}

package com.app.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

	public Object convertJsonToObj(String json,Class cls){
		Object ob=null;
		try {
			ob=new ObjectMapper()
			.readValue(json, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ob;
	}

	public String convertObjToJson(Object ob){
		String json=null;
		try {
			json=new ObjectMapper()
			.writeValueAsString(ob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;

	}




}

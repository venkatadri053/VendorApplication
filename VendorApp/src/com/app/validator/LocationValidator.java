package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationValidator {
	@Autowired
	private ILocationService service;
	
	//do Validate method
	public String doValidateLocName(String locName){
		String str=null;
		Location loc=service.getLocationByName(locName.toUpperCase());
		if(loc!=null){
			str="Location Name '"+locName+"' already exist in DB";
		}
		return str;
	}
	
	
	
}

package com.app.service;

import java.util.List;

import com.app.model.Location;


//SL-POJI-IService
public interface ILocationService {

	public int saveLocation(Location loc);
	public List<Location> getAllLocations();
	public void deleteLocById(int locId);
	public Location getLocationById(int locId);
	public void updateLocation(Location loc);
	
	public Location getLocationByName(String locName);
	public List<Object[]> getLocationwiseCount();
}



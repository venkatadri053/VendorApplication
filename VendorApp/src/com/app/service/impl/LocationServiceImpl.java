package com.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;
//SL-POJO-ServiceImpl
@Service
public class LocationServiceImpl implements ILocationService{
	@Autowired
	private ILocationDao dao;

	@Override
	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}
	
	@Override
	public List<Location> getAllLocations() {
		List<Location> locList=dao.getAllLocations();
		if(locList!=null && !locList.isEmpty()){
			Collections.sort(locList);
		}
		return locList;
	}
	
	@Override
	public void deleteLocById(int locId) {
		dao.deleteLocById(locId);
	}
	
	@Override
	public Location getLocationById(int locId) {
		return dao.getLocationById(locId);
	}
	
	@Override
	public void updateLocation(Location loc) {
		dao.updateLocation(loc);
	}
	
	@Override
	public Location getLocationByName(String locName) {
		return dao.getLocationByName(locName);
	}
	
	@Override
	public List<Object[]> getLocationwiseCount() {
		return dao.getLocationwiseCount();
	}
	
	
	
	
}
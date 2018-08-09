package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
//DAL-POJO-DaoImpl
@Repository
public class LocationDaoImpl implements ILocationDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}
	
	@Override
	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}
	
	@Override
	public void deleteLocById(int locId) {
		Location loc=new Location(locId);
		ht.delete(loc);
	}
	
	@Override
	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
	}
	
	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
	}
	
	@Override
	public Location getLocationByName(String locName) {
		Location loc=null;
		String hql=" from "+Location.class.getName()
				+" where locName=?";
		List<Location>  locList=ht.find(hql, locName);
		if(locList!=null && locList.size()>0){
			loc=locList.get(0);
		}
		return loc;
	}
	
	@Override
	public List<Object[]> getLocationwiseCount() {
		String hql="select locType,count(locType) from "+Location.class.getName()
				+" group by locType";
		List<Object[]> data=ht.find(hql);
		return data;
	}
	
	
	
	
	
	
}
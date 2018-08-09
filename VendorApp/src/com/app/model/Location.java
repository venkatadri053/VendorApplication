package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOC_TAB")
public class Location implements Comparable<Location>{
	@Id//Primary Key column
	@GeneratedValue(generator="loc")
	@SequenceGenerator(name="loc",sequenceName="LOC_SEQ")
	@Column(name="l_id")
	private int locId;
	@Column(name="l_name")
	private String locName;
	@Column(name="l_type")
	private String locType;
	
	//alt+Shift+S O
	//(DE SELECT ALL)
	public Location() {
	}
	//SELECT ONLY ONE
	public Location(int locId) {
		this.locId = locId;
	}
	//SELECT ALL
	public Location(int locId, String locName, String locType) {
		super();
		this.locId = locId;
		this.locName = locName;
		this.locType = locType;
	}
	//ALT+SHIFT+S R
	public int getLocId() {
		return locId;
	}
	public void setLocId(int locId) {
		this.locId = locId;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	public String getLocType() {
		return locType;
	}
	public void setLocType(String locType) {
		this.locType = locType;
	}
	//alt+shift+S S
	@Override
	public String toString() {
		return "Location [locId=" + locId + ", locName=" + locName
				+ ", locType=" + locType + "]";
	}

	@Override
	public int compareTo(Location o) {
		return locId-o.locId;
	}
	
}

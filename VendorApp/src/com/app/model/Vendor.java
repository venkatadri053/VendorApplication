package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ven_tab")
public class Vendor implements Comparable<Vendor>{
	@Id
	@GeneratedValue(generator="ven")
	@SequenceGenerator(name="ven",sequenceName="VEN_SEQ")
	@Column(name="v_id")
	private int venId;
	@Column(name="v_name")
	private String venName;
	@Column(name="v_mail")
	private String venEmail;
	@ManyToOne
	@JoinColumn(name="locFk")
	private Location loc;//HAS-A

	public Vendor() {
		super();
	}
	public Vendor(int venId) {
		super();
		this.venId = venId;
	}
	
	public int getVenId() {
		return venId;
	}
	public void setVenId(int venId) {
		this.venId = venId;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenEmail() {
		return venEmail;
	}
	public void setVenEmail(String venEmail) {
		this.venEmail = venEmail;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName
				+ ", venEmail=" + venEmail + ", loc=" + loc + "]";
	}
	@Override
	public int compareTo(Vendor o) {
		return this.getVenId()-o.getVenId();
	}
	
}

package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TAB")
public class Item implements Comparable<Item>{
	@Id
	@Column(name="itm_id")
	private int itemId;
	@Column(name="itm_name")
	private String itemName;
	@Column(name="itm_cost")
	private double itemCost;
	@Column(name="itm_cust_id")
	private int custId;
	
	
	public Item() {
		super();
	}
	
	public Item(int itemId) {
		super();
		this.itemId = itemId;
	}



	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemCost() {
		return itemCost;
	}
	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCost=" + itemCost + ", custId=" + custId + "]";
	}
	
	@Override
	public int compareTo(Item o) {
		return itemId-o.itemId;
	}
	
}

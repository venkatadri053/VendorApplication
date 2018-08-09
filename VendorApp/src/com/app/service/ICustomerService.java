package com.app.service;

import java.util.List;

import com.app.model.Customer;
import com.app.model.Item;

public interface ICustomerService {

	public int saveCustomer(Customer cust);
	public Customer getCustByEmail(String email);
	public List<Customer> getAllCustomers();
	public List<Item> getAllItemsOfCust(int custId);
	public String getCustNameById(int custId);
}

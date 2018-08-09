package com.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;

	@Override
	public int saveCustomer(Customer cust) {
		return dao.saveCustomer(cust);
	}

	@Override
	public Customer getCustByEmail(String email) {
		return dao.getCustByEmail(email);
	}
	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public List<Item> getAllItemsOfCust(int custId) {
		List<Item> itemList=dao.getAllItemsOfCust(custId);
		if(itemList!= null && itemList.size()>1){
			Collections.sort(itemList);;
		}
		return itemList;
	}
	
	@Override
	public String getCustNameById(int custId) {
		String custName=dao.getCustNameById(custId);
		if(custName!=null)
			custName=custName.toUpperCase();
		return custName;
	}
}

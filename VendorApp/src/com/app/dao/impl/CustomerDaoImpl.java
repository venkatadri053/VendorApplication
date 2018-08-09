package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveCustomer(Customer cust) {
		return (Integer)ht.save(cust);
	}
	
	@Override
	public Customer getCustByEmail(String email) {
		Customer cust=null;
		String hql="from "+Customer.class.getName()
				+" where custEmail=?";
		List<Customer> custList=ht.find(hql, email);
		
		if(custList!=null && custList.size()>0){
			cust=custList.get(0);
		}
		return cust;
	}
	@Override
	public List<Customer> getAllCustomers() {
		if(ht!=null)
			throw new RuntimeException("Sample");
		return ht.loadAll(Customer.class);
	}

	@Override
	public List<Item> getAllItemsOfCust(int custId) {
		String hql="from "+Item.class.getName()+
				" where custId=?";
		List<Item> itemList=ht.find(hql,custId);
		return itemList;
	}
	
	@Override
	public String getCustNameById(int custId) {
		String custName=null;
		String hql="select custName from "+Customer.class.getName()+
				" where custId=?";
		List<String> strList=ht.find(hql, custId);
		if(strList!=null && strList.size()>0){
			custName=strList.get(0);
		}
		return custName;
	}
}

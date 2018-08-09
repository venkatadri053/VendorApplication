package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CoDecUtil codecUtil;
	
	public boolean isPwdAndTokenValid(String reqPwd,String reqToken,Customer cust){
		boolean flag=false;
		//decode pwd,token from cust obj
		String dbPwd=codecUtil.doDecode(cust.getPassword());
		String dbToken=codecUtil.doDecode(cust.getAccToken());
		
		//compare with request values
		if(reqPwd.equals(dbPwd) && reqToken.equals(dbToken)){
			flag=true;
		}
		
		return flag;	
	}
	
	public boolean isCustTypeSeller(Customer cust){
		return "Seller".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isCustTypeConsumer(Customer cust){
		return "Consumer".equalsIgnoreCase(cust.getCustType());
	}

}

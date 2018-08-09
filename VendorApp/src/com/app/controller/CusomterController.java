package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.util.CoDecUtil;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;

@Controller
public class CusomterController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CoDecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;

	//1.show reg page --.cust
	@RequestMapping("/custReg")
	public String showPage() {
		return "CustomerReg";
	}

	//2. insert data using service
	@RequestMapping(value="/insertCust",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust,ModelMap map){
		//generate pwd,token
		String token=codeUtil.genToken();
		String pwd=codeUtil.genPwd();

		//do encode
		String encToken=codecUtil.doEncode(token);
		String encPwd=codecUtil.doEncode(pwd);

		//set data to cust obj
		cust.setPassword(encPwd);
		cust.setAccToken(encToken);

		//save data using service
		service.saveCustomer(cust);

		//send email
		commonUtil.sendEmail(cust.getCustEmail(), "You are registred as Customer..",
				"Welcome to Customer :"+cust.getCustName()+
				"..your pwd is: "+pwd+", token is :"+token+
				"type is:"+cust.getCustType());

		//message
		map.addAttribute("msg", "Saved with Id:"+cust.getCustId());

		return "CustomerReg";
	}


	//3.display all customer
	@RequestMapping("/viewAllCust")
	public String getAllCust(ModelMap map){
		map.addAttribute("custList",service.getAllCustomers());
		return "CustomerData";
	}
	@RequestMapping("/showCustItem")
	public String getAllItemsOfCust(@RequestParam("custId")int custId,ModelMap map){
		List<Item> itemList=service.getAllItemsOfCust(custId);
		map.addAttribute("itemListObj",itemList);
		map.addAttribute("custId", service.getCustNameById(custId));
		return "CustomerItemsData";
	}






}

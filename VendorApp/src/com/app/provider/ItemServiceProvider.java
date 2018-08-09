package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemServiceProvider {
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService itemService;
	
	@Path("/saveItem")
	@POST
	public String saveItem(
     @HeaderParam("userName")String un,				
     @HeaderParam("password")String pwd,				
     @HeaderParam("accToken")String token,				
     String jsonItem){
		
		//null or empty checks
		if(un == null || "".equals(un.trim())){
			return "User Name can not be empty";
		}
		if(pwd == null || "".equals(pwd.trim()) ){
			return "Password can not be empty";
		}
		if(token == null || "".equals(token.trim()) ){
			return "Access Token can not be empty";
		}
		if(jsonItem == null || "".equals(jsonItem.trim()) ){
			return "Item(JSON) can not be empty";
		}
		
		//check userExist or not?
		Customer cust=custService.getCustByEmail(un);
		if(cust==null){
			return "Customer(User) is not exist";
		}
		
		//validate pwd,token and Type Seller
		boolean flag=custValidator.isPwdAndTokenValid(pwd, token, cust);
		if(!flag){
			return "Invalid pwd/token in request";  
		}
		flag=custValidator.isCustTypeSeller(cust);
		if(!flag){
			return "Invalid customer, only seller allowed for this operation";
		}
		//if valid convert Json-Item
		Object ob=jsonUtil.convertJsonToObj(jsonItem,Item.class);
		if(ob==null){
			return "Invalid Item(JSON) Details in request";
		}
		//save Item to DB
		Item item=(Item)ob;
		item.setCustId(cust.getCustId());
		int itemId=itemService.saveItem(item);
		
		return "Item Saved with Id:"+itemId;
	}
}

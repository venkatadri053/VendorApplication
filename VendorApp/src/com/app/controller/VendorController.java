package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//1.show Reg page
	@RequestMapping("/venReg")
	public String showRegPage(ModelMap map){
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		return "VendorReg";
	}

	//2.save vendor
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor")Vendor ven,ModelMap map,
			@RequestParam("fileObj")CommonsMultipartFile file){
		
		int venId=service.saveVendor(ven);
		map.addAttribute("msg", "Saved with Id:"+venId);

		//send email after saving
		commonUtil.sendEmail(ven.getVenEmail(), "Sample Msg..", "welcome to vendor.."+venId,file);
		
		//after save show again dropdown
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		return "VendorReg";
	}

	//3. view All vendors
	@RequestMapping("/viewAllVen")
	public String getAllVendors(ModelMap map){
		List<Vendor> venList=service.getAllVendors();
		map.addAttribute("venListObj", venList);
		return "VendorData";
	}


	//4.delete vendor
	@RequestMapping("/deleteVen")
	public String deleteVen(@RequestParam("venId")int venId){
		service.deleteVendor(venId);
		return "redirect:viewAllVen";
	}

	//5.show edit
	@RequestMapping("/editVen")
	public String showEditPage(@RequestParam("venId")int venId,ModelMap map){
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList);
		
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("venObj",ven);
		return "VendorDataEdit";
	}

	//6. update vendor
	@RequestMapping(value="/updateVen",method=RequestMethod.POST)
	public String updateVen(@ModelAttribute("vendor")Vendor ven){
		service.updateVendor(ven);
		return "redirect:viewAllVen";
	}

	

}

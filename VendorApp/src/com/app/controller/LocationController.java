package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;
//PL-Controller
@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private LocationValidator validator;
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil locUtil;
	
	/**
	 * Method :1)This is to show reg 
	 * page of Location Module.
	 * Here String return Type indicates
	 * ViewName(Page Name) without 
	 * prefix(location) & suffix(extension)
	 *  
	 * */

	/** When we enter 
	 * URL=>.../mvc/locReg in browser
	 * then this method is executed and
	 * it display the LocationReg.jsp file
	 *  
	 */

	//URL is :/locReg
	@RequestMapping("/locReg")
	public String showRegPage(){
		//View Name is : LocationReg
		return "LocationReg";
	}
	/**
	 * 2. Insert Data in DB
	 * On click UI read as Object
	 * using @ModelAttribute and
	 * send to SL to Save data in DB
	 * as ROW  
	 */
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLoc(@ModelAttribute("location")Location loc, ModelMap map){
		//call validation before save
		String error=validator.doValidateLocName(loc.getLocName());
		if(error!=null){
			//send msg to UI
			map.addAttribute("msg",error);
		}else{
			//no error .. save obj	
			int locId=service.saveLocation(loc);
			map.addAttribute("msg","Saved with Id :"+locId);
		}
		return "LocationReg";
	}

	/**
	 * 3. On click Hyper Link viewLocs
	 * from LocationReg page, request comes
	 * to here as GET Type, we need
	 * to call service layer getAllLocs()
	 * which returns List and add to ModelMap
	 * send back to UI(LocationData.jsp) page
	 * 
	 */
	@RequestMapping("/viewLocs")
	public String showLocs(ModelMap map){
		//call service layer method to get DB Data as List
		List<Location> locList=service.getAllLocations();
		//add to ModelMap to send to UI
		map.addAttribute("locListObj", locList);
		//provide UI(View)page name
		return "LocationData";
	}

	/**
	 * 4. This method reads
	 * request parameters locId
	 * and sends to service layer
	 * deleteLocById and at last
	 * redirects to viewAllLocs
	 * ie 3rd method url.
	 */
	@RequestMapping("/deleteLoc")
	public String deleteLoc(@RequestParam("locId")int id){
		service.deleteLocById(id);
		return "redirect:viewLocs";
	}

	/***
	 * 5.This method is used to
	 * show EditPage of Location data,
	 * on click Update Link, request
	 * comes to here with only ID.
	 * Using Id with help service layer
	 * call getLocationById and get Location obj
	 * send this object to UI using ModelMap
	 */
	@RequestMapping("/updateLoc")
	public String showEditPage(@RequestParam("locId")int locId,ModelMap map){
		Location loc=service.getLocationById(locId);
		map.addAttribute("locObj", loc);
		return "LocationDataEdit";
	}

	/***
	 * 6. On click Update Button from
	 * LocationDataEdit page, request comes to here.
	 * First read ModelAttribute then
	 * call service layer updateLocation Obj
	 * at last redirect to viewAll
	 */
	@RequestMapping(value="/updateLocData",method=RequestMethod.POST)
	public String updateLoc(@ModelAttribute("location")Location loc){
		service.updateLocation(loc);
		return "redirect:viewLocs";
	}
	/**
	 * 7. This method is used to
	 * fetch Data from DB using 
	 * service layer getAllRec and
	 * adds to ModelMap and redirect
	 * to ViewClass using XMLViewResolver
	 */
	@RequestMapping("/locExcelExport")
	public String exportExcel(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locListObj",locList);
		return "LocExcelView";
	}
	/**
	 * 8. PDF Data export same as Excel
	 * @param map
	 * @return
	 */
	@RequestMapping("/locPdfExport")
	public String exportToPdf(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locListObj",locList);
		return "LocPdfView";
	}
	
	/**
	 * 9. Report Design
	 */
	@RequestMapping("/locReport")
	public String showReport(){
		List<Object[]> data=service.getLocationwiseCount();
		String path=context.getRealPath("/");
		locUtil.generatePieLoc(path, data);
		locUtil.generateBarLoc(path, data);
		return "ReportLoc";
	}


}

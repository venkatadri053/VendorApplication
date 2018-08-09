package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Location;
import com.app.service.ILocationService;

@Component
public class LocationUtil {
	@Autowired
	private ILocationService service;
	
	public List<Location> getAllLocations() {
		return service.getAllLocations();
	}
	
	/**
	 * Generate PieChart3D
	 */
	public void generatePieLoc(String path,List<Object[]> data){
		//1.dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		//2.using chartFactory create JFreeChart obj
		JFreeChart chart=ChartFactory.createPieChart3D("Location Report", dataset, true, true, false);
		
		//3.Use chartUtils ,convert JFreeChart obj to Image
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportALoc.jpg"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void generateBarLoc(String path,List<Object[]> data){
		//1.dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:data){
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "");
		}
		//2.use chartFactory ->JFreeChart
		JFreeChart chart=ChartFactory.createBarChart3D("Location Report", "Location Type", "Count", dataset);
		
		//3.ChartUtils used to JFreeChart->Image 
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/reportBLoc.jpg"), chart, 400, 400);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}

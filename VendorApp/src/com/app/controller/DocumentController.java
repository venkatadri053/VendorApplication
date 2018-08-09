package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.UploadFile;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {
	@Autowired
	private IDocumentService service;
	
	//1.show Documents page
	@RequestMapping("/showDocs")
	public String showPage(ModelMap map){
		//read all records and send to UI
		List<Object[]> arrList=service.getIdAndNamesOnly();
		map.addAttribute("docList", arrList);
		return "Documents";
	}
	
	//2.read two params and convert to model , save
	@RequestMapping(value="/uploadDoc",method=RequestMethod.POST)
	public String uploadDoc(
      @RequestParam("docId")int docId,
      @RequestParam("docDtls")CommonsMultipartFile cmf){
		
		//convert CMF -> Model class Obj
		if(cmf!=null){
			//model class obj
			UploadFile uf=new UploadFile();
			uf.setFileId(docId);
			//cmf-file name
			uf.setFileName(cmf.getOriginalFilename());
			//cmf-byte[] as data
			uf.setFileData(cmf.getBytes());
			//save document
			service.saveDocument(uf);
		}
		
		return "redirect:showDocs";
	}

	//3.download process
	@RequestMapping("/download")
	public void downloadDoc(HttpServletResponse res,@RequestParam("fileId")int fid){
		//get file based on Id
		UploadFile file=service.getObjetById(fid);
		
		//add download Header
		res.addHeader("Content-Disposition", "attachment;filename="+file.getFileName());
		//copy data
		try {
			FileCopyUtils.copy(file.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}

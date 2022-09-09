package com.dekra.coviddata.FileUpload.controller;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dekra.coviddata.service.CovidDataService;



@RestController
public class FileUploadController {
	
	
	@Autowired
	CovidDataService service;
	
	
	@PostMapping("/upload")
	 public boolean uploadData(@RequestParam("File") MultipartFile file) throws Exception{
		 boolean isFlag = false;
		 String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		 if(extension.equalsIgnoreCase("xls")) {
			 isFlag = service.readDataFromExcel(file);
		 }else if(extension.equalsIgnoreCase("csv")) {
			 isFlag = service.readDataFromCSV(file);
		 }else if(extension.equalsIgnoreCase("json")) {
			 isFlag = service.readDataFromJson(file);
		 }else if(extension.equalsIgnoreCase("html")) {
			 isFlag = service.readDataFromHtml(file);
		 }else if(extension.equalsIgnoreCase("pk")) {
			 isFlag = service.readDataFromPk(file);
		 }
		 return isFlag;
 
	}
}

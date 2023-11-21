package dev.bhargavparmar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.bhargavparmar.helper.Helper;
import dev.bhargavparmar.model.FileData;
import dev.bhargavparmar.service.FileService;

/*
 * 1. Upload file
 * 2. Check Progress
 */
@RestController
@RequestMapping("/api/v1")
public class ExcelController {
	
	private FileService fileService;
	
	public ExcelController(FileService fileService) {
		this.fileService=fileService;
	}
	
	@PostMapping("/upload-excel")
	public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file){
		if(Helper.checkExcelFormat(file)) {
			this.fileService.saveFile(file);
			
			return new ResponseEntity<String>("Done", HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getproducts")
	public ResponseEntity<List<FileData>> getAllProducts(){
		return new ResponseEntity<List<FileData>>( fileService.getAllProducts(), HttpStatus.OK);
	}
}

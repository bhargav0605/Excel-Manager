package dev.bhargavparmar.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import dev.bhargavparmar.model.FileData;

public interface FileService {
	
	void saveFile(MultipartFile file);
	
	List<FileData> getAllProducts();

}

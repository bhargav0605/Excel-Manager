package dev.bhargavparmar.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.bhargavparmar.helper.Helper;
import dev.bhargavparmar.model.FileData;
import dev.bhargavparmar.repository.FileDataRepository;
import dev.bhargavparmar.repository.FileDetailsRepository;

@Service
public class FileServiceImpl implements FileService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);

	private FileDataRepository fileDataRepository;
	private FileDetailsRepository fileDetailsRepository;
	
	public FileServiceImpl(FileDataRepository fileDataRepository,
			FileDetailsRepository fileDetailsRepository) {
		this.fileDataRepository=fileDataRepository;
		this.fileDetailsRepository=fileDetailsRepository;
	}

	@Override
	public void saveFile(MultipartFile file) {
		try {
			List<FileData> data = Helper.convertExcelToList(file.getInputStream());
			this.fileDataRepository.saveAll(data);
			LOGGER.info("Data: "+data);
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}
	}

	@Override
	public List<FileData> getAllProducts() {
		
		return this.fileDataRepository.findAll();
	}

}

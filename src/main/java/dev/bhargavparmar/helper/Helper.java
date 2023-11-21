package dev.bhargavparmar.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.multipart.MultipartFile;

import dev.bhargavparmar.model.FileData;


public class Helper {
	
	private static Logger LOGGER = LoggerFactory.getLogger(Helper.class);
	
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<FileData> convertExcelToList(InputStream is) {
    	List<FileData> data = new ArrayList<>();
    	try {
    		XSSFWorkbook workbook = new XSSFWorkbook(is);
    		XSSFSheet sheet = workbook.getSheet("data");
    		
    		int rowNumber = 0;
    		Iterator<Row> it = sheet.iterator();
    		
    		while(it.hasNext()) {
    			Row row = it.next();
    			
    			if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
    			
    			Iterator<Cell> cells = row.iterator();
                int cid = 0;
                
                FileData fileData = new FileData();
                
                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                        	fileData.setProduct_id((long)cell.getNumericCellValue());
                            break;
                        case 1:
                        	fileData.setProduct_name(cell.getStringCellValue());
                            break;
                        case 2:
                        	fileData.setProduct_description(cell.getStringCellValue());
                            break;
                        case 3:
                        	fileData.setProduct_price(cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                data.add(fileData);	
    		}
    		workbook.close();
    	} catch (Exception e) {
    		LOGGER.error(e.toString());
    	}
		return data;
    }
}

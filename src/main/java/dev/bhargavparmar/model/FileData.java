package dev.bhargavparmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file_data")
public class FileData {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long data_id;
	
	// Headers of file
	@Column
	private Long product_id;
	
	@Column
	private String product_name;
	
	@Column
	private String product_description;
	
	@Column
	private Double product_price;	
	
	@OneToOne
	@JoinColumn(name = "file_id")
	private FileDetails file_id;

	public FileData() {
		super();
	}
	



	public FileData(Long product_id, String product_name, String product_description,
			Double product_price, FileDetails file_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
		this.file_id = file_id;
	}




	public Long getProduct_id() {
		return product_id;
	}




	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}




	public Double getProduct_price() {
		return product_price;
	}




	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}




	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}



	public Long getData_id() {
		return data_id;
	}

	public void setData_id(Long data_id) {
		this.data_id = data_id;
	}

	public FileDetails getFile_id() {
		return file_id;
	}

	public void setFile_id(FileDetails file_id) {
		this.file_id = file_id;
	}

	@Override
	public String toString() {
		return "FileData [data_id=" + data_id + ", product_id=" + product_id + ", product_name=" + product_name
				+ ", product_description=" + product_description + ", product_price=" + product_price + ", file_id="
				+ file_id + "]";
	}
}

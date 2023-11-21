package dev.bhargavparmar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file_details")
public class FileDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long file_id;
	
	@Column(name = "file_name")
	private String file_name;
	
	@Column(name = "uploaded_date")
	private Date uploaded_date;
	
	// @Column(name = "uploaded_by")
	// private Long uploaded_by;

	public FileDetails() {
		super();
	}
	
	public FileDetails(Long file_id, String file_name, Date uploaded_date) {
		super();
		this.file_id = file_id;
		this.file_name = file_name;
		this.uploaded_date = uploaded_date;
	}


	public Long getFile_id() {
		return file_id;
	}


	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Date getUploaded_date() {
		return uploaded_date;
	}

	public void setUploaded_date(Date uploaded_date) {
		this.uploaded_date = uploaded_date;
	}

	@Override
	public String toString() {
		return "FileDetails [file_id=" + file_id + ", file_name=" + file_name + ", uploaded_date=" + uploaded_date
				+ "]";
	}
}

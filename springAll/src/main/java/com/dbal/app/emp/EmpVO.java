package com.dbal.app.emp;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
    
    MultipartFile[] uploadFile;
    String profile;
    String msg;
    
    @JsonProperty(value = "id") 
    String employeeId;
    
	String firstName;
	String lastName;
	String email;
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH")
	String hireDate;   //LocalDateTime  , Date
	
	@JsonIgnore 
	String jobId;
	
	@JsonIgnore 
	String departmentId;
	
	@JsonIgnore 
	Integer salary;
	
	@JsonIgnore 
	Integer[] employeeIds;
}

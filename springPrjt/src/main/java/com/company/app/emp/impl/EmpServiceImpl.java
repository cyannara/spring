package com.company.app.emp.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.emp.EmpService;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpDAO empDAO;
	public List<Map<String,Object>> getEmpList(){
		return empDAO.getEmpList();
	}
}

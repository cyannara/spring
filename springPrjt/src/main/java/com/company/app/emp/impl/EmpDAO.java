package com.company.app.emp.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	public List<Map<String,Object>> getEmpList(){
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getEmpList");
	}
}

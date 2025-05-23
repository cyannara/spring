package com.dbal.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.dbal.app.emp.EmpVO;

public interface EmpMapper {

	public EmpVO getEmp(EmpVO empVO);
	public List<EmpVO> getEmpList(EmpVO empVO);
	public void empInsert(EmpVO empVO);
	public void insertEmpProc(EmpVO empVO);
	public String getName(Integer id);
	public List<Map<String, Object>> getEmpMap();
	public List<Map<String, Object>> getDeptEmpCnt();
}


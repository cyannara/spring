package com.company.app.emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	//목록조회
	List<Map<String, Object>> getEmpList();
	
	//목록조회
	List<Map<String, Object>> getEmpListMap();
	
	//부서별 인원수
	public List<Map<String, Object>> getDeptCnt();
}

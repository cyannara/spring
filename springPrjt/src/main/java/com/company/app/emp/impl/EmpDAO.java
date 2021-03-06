package com.company.app.emp.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.app.emp.EmpVO;

@Repository
public class EmpDAO {
	
	@Autowired SqlSessionTemplate mybatis;   //쓰레드 처리,커넥션관리 기능 추가
	
	public List<Map<String,Object>> getEmpList(EmpVO empVO){
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getEmpList", empVO);
	}
	
	
	public List<Map<String,Object>> getEmpListMap(EmpVO empVO){
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getEmpListMap", empVO);
	}
	
	public EmpVO getEmp(String id) {
		return (EmpVO)mybatis.selectOne("com.yedam.web.emp.EmpDAO.getEmp", id);
	}
	public void insertEmp(EmpVO empVO) {
		mybatis.insert("com.yedam.web.emp.EmpDAO.insertEmp", empVO);
	}
	public void updateEmp(EmpVO empVO) {
		mybatis.update("com.yedam.web.emp.EmpDAO.updateEmp", empVO);
	}
	public void deleteEmp(String id) {
		mybatis.delete("com.yedam.web.emp.EmpDAO.deleteEmp", id);
	}
	//부서다건삭제
	public void deleteDeptList(List<String> list) {
		mybatis.delete("com.yedam.web.emp.EmpDAO.deleteDeptList", list);
	}
	
	//부서별 인원수
	public List<Map<String, Object>> getDeptCnt(){
		return mybatis.selectList("com.yedam.web.emp.EmpDAO.getDeptCnt");
	}
}








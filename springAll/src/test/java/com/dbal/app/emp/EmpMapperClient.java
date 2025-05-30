package com.dbal.app.emp;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbal.app.emp.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {
    @Autowired EmpMapper empMapper;
    
    @Test
    public void insertEmp() {
        EmpVO vo = new EmpVO();
        vo.setFirstName("sam");
        vo.setLastName("유신");
        vo.setEmail("bb@bb.bb");
        vo.setHireDate("2020/01/01");
        vo.setJobId("IT_PROG");
        empMapper.insertEmpProc(vo);
        System.out.println(vo.getMsg());
    }
    
    @Ignore @Test
    public void getEmp() {
        EmpVO vo = new EmpVO();
        //String first_name = empMapper.getName(100);
        //System.out.println(first_name);
        List<Map<String, Object>> list 
               = empMapper.getEmpMap();
        //첫번째 사원의 이름만 출력
        System.out.println("첫번째이름"  );
    }
}

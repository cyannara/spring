package com.company.app.emp.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.EmpService;

@Controller
public class Empcontroller {
	@Autowired
	EmpService empService;
	
	@RequestMapping("/getEmpList")
	public String getEmpList(Model model) {
		model.addAttribute("empList", empService.getEmpList());
		return "emp/getEmpList";
	}
}

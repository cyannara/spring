package com.dbal.app.emp.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dbal.app.common.FileRenamePolicy;
import com.dbal.app.emp.EmpVO;
import com.dbal.app.emp.service.EmpService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
public class EmpController {

    @Autowired
    EmpService empService;
    
    @Autowired
    @Qualifier("dataSourceSpied")
    DataSource datasource;

    // 다운로드
    @RequestMapping("download")
    public ModelAndView download(@RequestParam String name) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("download");
        mv.addObject("downloadFile", new File("d:/upload", name));
        return mv;
    }

    // 등록폼
    @RequestMapping("insertFormEmp")
    public String insertFormEmp(EmpVO vo) {
        return "emp/insertEmp";
    }

    /*
     * loging(LoginVO pVO) { //1. id로 단건조회해서 dbVO //2. id 가 null id가 없으므로 로그인 페이지 //3. pVO의 패스워드와
     * dbVO의 패스워드 비교해서 같으면 로그인 처리(세션에 저장 main 페이지로 이동) //4. 아니면 패스워드 맞지않으므로 로그인 페이지로 }
     */
    // 등록처리
    @RequestMapping("insertEmp")
    public String insertEmp(@ModelAttribute("evo") EmpVO vo, // 1. 커맨트 객체
            Model model, @RequestParam String firstName, // 2. String
            HttpServletRequest request,
                                                         // ln=request.getParameter("firstName")
            @RequestParam(required = false, defaultValue = "kim", value = "lastName") String ln,
            @RequestParam Map map // 3. 모든 파라미터 맵으로 받기
    ) throws IOException {
        //업로드 경로
        String path = request.getSession().getServletContext().getRealPath("resources/download");
        System.out.println(path);
        // 첨부파일 처리
        MultipartFile[] files = vo.getUploadFile();
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            if (file != null && file.getSize() > 0) {
                File upFile = FileRenamePolicy.rename(new File("d:/upload", filename));
                filename = upFile.getName();
                file.transferTo(upFile);
            }
            vo.setProfile(filename);
            // fileService.insert()
        }
        // 서비스호출
        empService.empInsert(vo);
        System.out.println(vo.getMsg());
        // System.out.println(vo.getFirstName() +":" + vo.getLastName());
        // System.out.println("parameter: " + firstName + ":" + ln);
        // System.out.println("map " + map.get("firstName") + ":" + map.get("lastName"));
        // model.addAttribute("evo", vo);

        return "home";
    }

    // 단건조회   getEmp?employeeId=100
    @RequestMapping("getEmp/{employeeId}") // getEmp?employeeId=aaaa
    public String getEmp(@PathVariable String employeeId
                        , Model model, EmpVO empVO) {
        empVO.setEmployeeId(employeeId);
        model.addAttribute("emp", empService.getEmp(empVO));
        return "empty/emp/getEmp";
    }

    // 목록조회
    @RequestMapping("empList")
    public String empList(Model model, EmpVO empVO) {
        model.addAttribute("empList", empService.getEmpList(empVO));
        return "emp/empList";
    }

    // emp관리
    @RequestMapping("empClient")
    public String empClient() {
        return "admin/emp/empClient";
    }

    // ajax :목록
    @RequestMapping("ajaxEmpList")
    public @ResponseBody List<EmpVO> ajaxEmpList(EmpVO empVO) {
        return empService.getEmpList(empVO);
    }

    // 수정폼

    // 수정처리

    // 삭제처리

    // 차트데이터


    // 레포트 출력
    @RequestMapping("report.do")
    public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection conn = datasource.getConnection();
        //InputStream jasperStream = getClass().getResourceAsStream("/reports/emplist.jasper");
        //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        InputStream stream = getClass().getResourceAsStream("/reports/emplist.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(stream);
        //파라미터 맵
        HashMap<String,Object> map = new HashMap<>();
        map.put("p_departmentId", request.getParameter("dept"));
        
        JasperPrint jasperPrint = 
                JasperFillManager.fillReport(jasperReport, map, conn);
        JasperExportManager.exportReportToPdfStream(
                jasperPrint, response.getOutputStream());
    }
    
    @RequestMapping("getEmpAjax")
    @ResponseBody
    public EmpVO getEmpAjax(EmpVO empVO) {
        return empService.getEmp(empVO);
    }
}



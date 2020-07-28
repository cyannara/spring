package com.dbal.app.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

@Component("commonExcelView")
public class CommonExcelView extends AbstractXlsxView  {
	 
	private static final Logger LOGGER  = LoggerFactory.getLogger(CommonExcelView.class);
 
	@Override
	   protected void buildExcelDocument(Map<String, Object> model, Workbook wb, 
               HttpServletRequest request,HttpServletResponse response) throws Exception {

        Cell cell = null;
        Sheet sheet = wb.createSheet("User List");
        sheet.setDefaultColumnWidth(12);  
        List<Map<String, Object>> list = (List<Map<String, Object>>) model.get("datas");
		Row row;
		
        for (int i = 0; i < list.size(); i++) { 
			row = sheet.createRow(i);
			Map map = list.get(i);
			Iterator<String> iter = map.keySet().iterator();
			int j=0;
			while(iter.hasNext()) {
				cell = row.createCell(j++);
				cell.setCellValue(map.get(iter.next()).toString());
			}
       }
    }

  
}
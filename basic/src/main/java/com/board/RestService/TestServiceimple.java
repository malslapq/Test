package com.board.RestService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.DAO.TestDAO;
import com.board.Model.TestDTO;
import com.board.Model.UserDTO;

@Service
@Transactional
public class TestServiceimple implements TestService{	
	
	@Autowired
	private TestDAO dao;
	
	@Override
	public int insertUser(TestDTO dto) {
		return dao.insertUser(dto);
	}

	@Override
	public List<UserDTO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Map<String, Object>> selectAllmap() {
		return dao.selectAllmap();
	}

	@Override
	public List<Map<String, Object>> selectColumn() {
		return dao.selectColumn();
	}
	
	@Override
	public void ExcelDown(HttpServletResponse response) {
		//데이터 가져오기
		List<UserDTO> list = dao.selectAll();
		//워크북 생성
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("테스트");
		XSSFRow row = null;
		XSSFCell cell = null;
		int rowNo = 0;
		// cell style 설정
		XSSFCellStyle headStyle = wb.createCellStyle();
		XSSFCellStyle bodyStyle = wb.createCellStyle();
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		//헤더 생성
		String[] headName = SetHeadColumn(dao.selectColumn());
		row = sheet.createRow(rowNo);
		for (int i = 0; i < headName.length; i++) {
			sheet.autoSizeColumn(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+3500);
			cell = row.createCell(i);
			cell.setCellStyle(headStyle);
			cell.setCellValue(headName[i]);			
		}
		//데이터 생성
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i+1);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getNum());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getName());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getPhone());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			SimpleDateFormat simpladate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cell.setCellValue(simpladate.format(list.get(i).getRegdate()));
		}
		//컨텐츠 타입 및 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
		//엑셀 출력
		try {
			wb.write(response.getOutputStream());
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void SXSSFtset(HttpServletResponse response) {
		//데이터 가져오기
		List<UserDTO> list = dao.selectAll();
		//컨텐츠 타입 및 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=UserData.xlsx");
		SXSSFWorkbook wb = new SXSSFWorkbook();
		SXSSFSheet sheet = wb.createSheet();
		SXSSFRow row = null;
		SXSSFCell cell = null;
		// cell style 설정
		XSSFCellStyle headStyle = (XSSFCellStyle) wb.createCellStyle();
		XSSFCellStyle bodyStyle = (XSSFCellStyle) wb.createCellStyle();
		headStyle.setAlignment(HorizontalAlignment.CENTER);
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.index);
		headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		//헤더에 들어갈 column 값 가져옴
		String[] headName = SetHeadColumn(dao.selectColumn());
		//0번째 row 생성
		row = sheet.createRow(0);
		//만들어진 row로 headName만큼의 헤더 값 넣기
		for(int i = 0; i < headName.length; i++) {
			cell = row.createCell(i);
			sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+3500);
			cell.setCellStyle(headStyle);
			cell.setCellValue(headName[i]);
		}
		//바디 값 넣어주기
		for(int i = 0; i < list.size(); i++) {
			int cellcount = 0;
			row = sheet.createRow(i+1);
			cell = row.createCell(cellcount++);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getNum());
			cell = row.createCell(cellcount++);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getName());
			cell = row.createCell(cellcount++);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(list.get(i).getPhone());
			cell = row.createCell(cellcount++);
			cell.setCellStyle(bodyStyle);
			SimpleDateFormat simpladate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cell.setCellValue(simpladate.format(list.get(i).getRegdate()));
		}
		//파일 생성 및 저장
		try {
			wb.write(response.getOutputStream());
			wb.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String[] SetHeadColumn(List<Map<String, Object>> columnMaplist) {
		String[] headname = new String[columnMaplist.size()];  
		for (int i = 0; i < columnMaplist.size(); i++) {
			String column = (String) columnMaplist.get(i).get("COLUMN_NAME");
			headname[i] = column;
		}
		return headname;
	}
	
	

}

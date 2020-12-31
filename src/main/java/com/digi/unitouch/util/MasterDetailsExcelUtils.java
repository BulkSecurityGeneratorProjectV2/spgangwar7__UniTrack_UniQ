package com.digi.unitouch.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import com.digi.unitouch.vo.ArticleTaskDetailsVO;
import com.digi.unitouch.vo.TaskTime;

public class MasterDetailsExcelUtils {
	
	private static void setExcelHeading(HSSFSheet hssfSheet, HSSFWorkbook hssfWorkbook, String reportName) {
		HSSFRow hssfRow = hssfSheet.createRow(0);
		CellStyle style = hssfWorkbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.ALIGN_FILL);
		Font font = hssfWorkbook.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		style.setFont(font);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		hssfRow.createCell(0).setCellStyle(style);
		hssfRow.getCell(0).setCellValue(reportName);
	}
	
	public static void downloadMasterReports(HttpServletResponse response, List<ArticleTaskDetailsVO> taskManagementVoli) throws ParseException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 43));
		String reportName = "Master Reports";
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeaderMasterAdmin(hssfSheet,taskManagementVoli);
		setExcelRowsMasteradmin(hssfSheet, taskManagementVoli);
		hssfSheet.setColumnWidth(0, 6000);
		hssfSheet.setColumnWidth(1, 6000);
		hssfSheet.setColumnWidth(2, 6000);
		hssfSheet.setColumnWidth(3, 10000);
		hssfSheet.setColumnWidth(4, 7000);
		hssfSheet.setColumnWidth(5, 6000);
		hssfSheet.setColumnWidth(6, 8000);
		hssfSheet.setColumnWidth(7, 6000);
		hssfSheet.setColumnWidth(8, 7000);
		hssfSheet.setColumnWidth(9, 5000);
		hssfSheet.setColumnWidth(10, 5000);
		hssfSheet.setColumnWidth(11, 3000);
		hssfSheet.setColumnWidth(12, 5000);
		hssfSheet.setColumnWidth(13, 6000);
		hssfSheet.setColumnWidth(14, 5000);
		hssfSheet.setColumnWidth(15, 6000);
		hssfSheet.setColumnWidth(16, 6000);
		hssfSheet.setColumnWidth(17, 6000);
		hssfSheet.setColumnWidth(18, 6000);
		hssfSheet.setColumnWidth(19, 6000);
		hssfSheet.setColumnWidth(20, 6000);
		hssfSheet.setColumnWidth(21, 6000);
		hssfSheet.setColumnWidth(22, 6000);
		hssfSheet.setColumnWidth(23, 6000);
		hssfSheet.setColumnWidth(24, 6000);
		hssfSheet.setColumnWidth(25, 6000);
		hssfSheet.setColumnWidth(26, 6000);
		hssfSheet.setColumnWidth(27, 6000);
		hssfSheet.setColumnWidth(28, 6000);
		hssfSheet.setColumnWidth(29, 6000);
		hssfSheet.setColumnWidth(30, 6000);
		hssfSheet.setColumnWidth(31, 6000);
		hssfSheet.setColumnWidth(32, 6000);
		hssfSheet.setColumnWidth(33, 6000);
		hssfSheet.setColumnWidth(34, 6000);
		hssfSheet.setColumnWidth(35, 6000);

		hssfSheet.setColumnWidth(36, 6000);
		hssfSheet.setColumnWidth(37, 6000);
		hssfSheet.setColumnWidth(38, 6000);
		hssfSheet.setColumnWidth(39, 6000);
		hssfSheet.setColumnWidth(40, 6000);
		hssfSheet.setColumnWidth(41, 6000);
		hssfSheet.setColumnWidth(42, 6000);
		hssfSheet.setColumnWidth(43, 6000);

		
		response.setContentType("application/vnd.ms-excel");
		
		String fName = "attachment; filename="; fName = fName + "MasterRecords.xls";
		response.setHeader("Content-Disposition", fName);
		
		try {
			hssfWorkbook.write(response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void setExcelRowsMasteradmin(HSSFSheet hssfSheet, List<ArticleTaskDetailsVO> taskManagementVoli) throws ParseException {
		int record = 2;
		for (ArticleTaskDetailsVO data : taskManagementVoli) {
			HSSFRow hssfRow = hssfSheet.createRow(record++);
		
			hssfRow.createCell(0).setCellValue(data.getJournalName());
			hssfRow.createCell(1).setCellValue(data.getJournalAbbrName());
			hssfRow.createCell(2).setCellValue(data.getAid());
		    hssfRow.createCell(3).setCellValue(data.getArticle_title());
		    hssfRow.createCell(4).setCellValue(data.getArticle_doi());
		    hssfRow.createCell(5).setCellValue(data.getUserName());
		    hssfRow.createCell(6).setCellValue(data.getUseremail());
		    hssfRow.createCell(7).setCellValue(data.getArticle_type_cd());
		    hssfRow.createCell(8).setCellValue(data.getTaskName());
		    hssfRow.createCell(9).setCellValue(data.getCurrentPhaseDate());
		    hssfRow.createCell(10).setCellValue(data.getDuePhaseDate());
			hssfRow.createCell(11).setCellValue(data.getAge());
			hssfRow.createCell(12).setCellValue(data.getAccepted_date());
			hssfRow.createCell(13).setCellValue(data.getNoOfPages());
			hssfRow.createCell(14).setCellValue(data.getReportsDate());	
			hssfRow.createCell(15).setCellValue(data.getIssue());
			int i = 16;
			for (Entry<String, TaskTime> entry : data.getTaskMap().entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				hssfRow.createCell(i).setCellValue(entry.getValue().getStartTime() );
				i++;
				if (entry.getValue().getEndTime() == null) {
					hssfRow.createCell(i).setCellValue(" ");
					i++;
				} else {
					hssfRow.createCell(i).setCellValue(entry.getValue().getEndTime());
					i++;
				}
			}

		}
	}

	private static void setExcelHeaderMasterAdmin(HSSFSheet hssfSheet,List<ArticleTaskDetailsVO> taskManagementVoli) {
		HSSFRow hssfRow = hssfSheet.createRow(1);

		hssfRow.createCell(0).setCellValue("Journal Name");
		hssfRow.createCell(1).setCellValue("Journal Short Name");
		hssfRow.createCell(2).setCellValue("Manuscript ID");
		hssfRow.createCell(3).setCellValue("Article Title");
		hssfRow.createCell(4).setCellValue("Article DOI");
		hssfRow.createCell(5).setCellValue("Author Name");
		hssfRow.createCell(6).setCellValue("Author Email ID");
		hssfRow.createCell(7).setCellValue("Article Type");
		hssfRow.createCell(8).setCellValue("Current Phase");
		hssfRow.createCell(9).setCellValue("Current Phase Date");
		hssfRow.createCell(10).setCellValue("Due Date");
		hssfRow.createCell(11).setCellValue("Age Days");
		hssfRow.createCell(12).setCellValue("Accepted Date");
		hssfRow.createCell(13).setCellValue("No Of Pages");
		hssfRow.createCell(14).setCellValue("Reports Run Date");
		hssfRow.createCell(15).setCellValue("Issue");
		int i = 16;
		for (String taskName : taskManagementVoli.get(0).getTaskArray()) {
			hssfRow.createCell(i).setCellValue(taskName+" -Start-Time");
			i++;
			hssfRow.createCell(i).setCellValue(taskName+" -End-Time");
			i++;
		}

	}

}

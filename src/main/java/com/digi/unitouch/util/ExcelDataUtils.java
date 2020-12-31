package com.digi.unitouch.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import com.digi.unitouch.model.ArticleDetail;
import com.digi.unitouch.vo.ArticleDetailsVO;
import com.digi.unitouch.vo.IssueSequenceVo;
import com.digi.unitouch.vo.TaskManagementVo;

public class ExcelDataUtils {

	public static void downloadAttendance(HttpServletResponse response, List<IssueSequenceVo> issueSequenceList)
			throws IOException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));
		String reportName = issueSequenceList.get(0).getIssueName();
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeader(hssfSheet);
		setExcelRows(hssfSheet, issueSequenceList);
		hssfSheet.setColumnWidth(0, 10000);
		hssfSheet.setColumnWidth(1, 7000);
		hssfSheet.setColumnWidth(2, 4000);
		hssfSheet.setColumnWidth(3, 8000);
		hssfSheet.setColumnWidth(4, 8000);
		hssfSheet.setColumnWidth(5, 3000);
		hssfSheet.setColumnWidth(6, 3000);
		hssfSheet.setColumnWidth(7, 3000);
		hssfSheet.setColumnWidth(8, 4000);
		hssfSheet.setColumnWidth(9, 3000);
		hssfSheet.setColumnWidth(10, 2000);
		hssfSheet.setColumnWidth(11, 6000);
		hssfSheet.setColumnWidth(12, 5000);
		hssfSheet.setColumnWidth(13, 5000);
		//hssfSheet.setColumnWidth(9, 6000);

		response.setContentType("application/vnd.ms-excel");

		String fName = "attachment; filename=";
		fName = fName + issueSequenceList.get(0).getIssueName()+"_Issue_Excel.xls";
		response.setHeader("Content-Disposition", fName);
		hssfWorkbook.write(response.getOutputStream());

		/*
		 * FileOutputStream outputStream = new
		 * FileOutputStream("C:\\Users\\digiscape\\Desktop\\JavaExcel.xlsx");
		 * hssfWorkbook.write(outputStream);
		 */
		response.getOutputStream().close();
	}

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

	private static void setExcelHeader(HSSFSheet hssfSheet) {
		HSSFRow hssfRow = hssfSheet.createRow(1);

		hssfRow.createCell(0).setCellValue("Article Title");
		hssfRow.createCell(1).setCellValue("Article DOI");
		hssfRow.createCell(2).setCellValue(" ArticleID");
	//	hssfRow.createCell(3).setCellValue("Article Title");
		hssfRow.createCell(3).setCellValue("Journal Name");
		hssfRow.createCell(4).setCellValue("Issue Name");
		hssfRow.createCell(5).setCellValue("Page Form");
		hssfRow.createCell(6).setCellValue("Page To");
		hssfRow.createCell(7).setCellValue("BW image");
		hssfRow.createCell(8).setCellValue("Color Image");
		hssfRow.createCell(9).setCellValue("Page Number");
		//hssfRow.createCell(8).setCellValue("Workflow Name");
	//	hssfRow.createCell().setCellValue("File Flag");
		hssfRow.createCell(10).setCellValue("Sequence");
		hssfRow.createCell(11).setCellValue("Article Type");
		hssfRow.createCell(12).setCellValue("Journal Volume");
		hssfRow.createCell(13).setCellValue("Issue Volume");
		
	}

	private static void setExcelRows(HSSFSheet hssfSheet, List<IssueSequenceVo> issueSequenceList) {
		int record = 2;
		for (IssueSequenceVo data : issueSequenceList) {
			HSSFRow hssfRow = hssfSheet.createRow(record++);
			hssfRow.createCell(0).setCellValue(data.getArticletitle());
			hssfRow.createCell(1).setCellValue(data.getArticleDoi());
		
			hssfRow.createCell(2).setCellValue(data.getCoverArticleId());
		//	hssfRow.createCell(3).setCellValue(data.getArticletitle());
			hssfRow.createCell(3).setCellValue(data.getJournalName());
			hssfRow.createCell(4).setCellValue(data.getIssueName());
			hssfRow.createCell(5).setCellValue(data.getPage_from());
			hssfRow.createCell(6).setCellValue(data.getTo_page());
			hssfRow.createCell(7).setCellValue(data.getBwimage());
			hssfRow.createCell(8).setCellValue(data.getColorimage());
			hssfRow.createCell(9).setCellValue(data.getPages());
			hssfRow.createCell(10).setCellValue(data.getSequenceNo());
			hssfRow.createCell(11).setCellValue(data.getArticleType());
			hssfRow.createCell(12).setCellValue(data.getJournalVN());
			hssfRow.createCell(13).setCellValue(data.getIssueVN());
			/*
			 * if (data.getCategory() != null)
			 * hssfRow.createCell(3).setCellValue(Util.checkString(data.getCategory()));
			 * else hssfRow.createCell(3).setCellValue(Util.checkString(""));
			 */
		}
	}

//	public static void downloadExcelAdmin(HttpServletResponse response, List<ArticleDetail> taskManagementVoList)
//			throws FileNotFoundException {
//		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
//		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
//		String reportName = "WIP Reports";
//		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
//		setExcelHeaderAdmin(hssfSheet);
//		setExcelRowsadmin(hssfSheet, taskManagementVoList);
//		hssfSheet.setColumnWidth(0, 10000);
//		hssfSheet.setColumnWidth(1, 10000);
//		hssfSheet.setColumnWidth(2, 5000);
//		hssfSheet.setColumnWidth(3, 20000);
//		hssfSheet.setColumnWidth(4, 5000);
//		hssfSheet.setColumnWidth(5, 9000);
//		hssfSheet.setColumnWidth(6, 5000);
//		hssfSheet.setColumnWidth(7, 4000);
//
//		response.setContentType("application/vnd.ms-excel");
//
//		// String fName = "attachment; filename="; fName = fName + "AllRecords.xls";
//		// response.setHeader("Content-Disposition", fName);
////		 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\digiscape\\Desktop\\WipReportsExcel.xlsx");
////		 try {
////			hssfWorkbook.write(outputStream);
////		} catch (IOException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
//		try {
//			hssfWorkbook.write(response.getOutputStream());
//			response.getOutputStream().close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// response.getOutputStream().close()
//
//	}
//
//	private static void setExcelHeaderAdmin(HSSFSheet hssfSheet) {
//		HSSFRow hssfRow = hssfSheet.createRow(1);
//
//		hssfRow.createCell(0).setCellValue("Journal Name");
//		hssfRow.createCell(1).setCellValue("Journal AbbrName");
//		hssfRow.createCell(2).setCellValue("ManuScript ID");
//		hssfRow.createCell(3).setCellValue("Article Title");
//		hssfRow.createCell(4).setCellValue("Article Page");
//		hssfRow.createCell(5).setCellValue("Article Status");
//		hssfRow.createCell(6).setCellValue("Article Type");
//		hssfRow.createCell(7).setCellValue("Accepted Date");
//
//	}
//
//	private static void setExcelRowsadmin(HSSFSheet hssfSheet, List<ArticleDetail> taskManagementVoList) {
//		int record = 2;
//		for (ArticleDetail data : taskManagementVoList) {
//			HSSFRow hssfRow = hssfSheet.createRow(record++);
//			hssfRow.createCell(0).setCellValue(data.getJournals().getJournalName());
//			hssfRow.createCell(1).setCellValue(data.getJournals().getJournalAbbrName());
//			hssfRow.createCell(2).setCellValue(data.getAid());
//			hssfRow.createCell(3).setCellValue(data.getArticle_title());
//			hssfRow.createCell(4).setCellValue(data.getArticle_pages());
//			hssfRow.createCell(5).setCellValue(data.getArticle_status());
//			hssfRow.createCell(6).setCellValue(data.getArticle_type_cd());
//			hssfRow.createCell(7).setCellValue(data.getAccepted_date());
//
//		}
//
//	}

	public static void downloadExcelAdmin(HttpServletResponse response, List<ArticleDetailsVO> taskManagementVoli) throws FileNotFoundException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
		String reportName = "WIP Reports";
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeaderAdmin(hssfSheet);
		setExcelRowsadmin(hssfSheet, taskManagementVoli);
		hssfSheet.setColumnWidth(0, 6000);
		hssfSheet.setColumnWidth(1, 4000);
		hssfSheet.setColumnWidth(2, 10000);
		hssfSheet.setColumnWidth(3, 7000);
		hssfSheet.setColumnWidth(4, 6000);
		hssfSheet.setColumnWidth(5, 7000);
		hssfSheet.setColumnWidth(6, 3000);
		hssfSheet.setColumnWidth(7, 5000);
		hssfSheet.setColumnWidth(8, 5000);
		

		response.setContentType("application/vnd.ms-excel");
		
		String fName = "attachment; filename="; fName = fName + "AllRecords.xls";
		response.setHeader("Content-Disposition", fName);
		// FileOutputStream outputStream = new FileOutputStream("C:\\Users\\digiscape\\Desktop\\WipReportsExcel.xlsx");
		
		//hssfWorkbook.write(outputStream);
		
		try {
			hssfWorkbook.write(response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void setExcelHeaderAdmin(HSSFSheet hssfSheet) {
		HSSFRow hssfRow = hssfSheet.createRow(1);

		hssfRow.createCell(0).setCellValue("Journal Name");
		hssfRow.createCell(1).setCellValue("Manuscript ID");
		hssfRow.createCell(2).setCellValue("Article Title");
		hssfRow.createCell(3).setCellValue("Article DOI");
		hssfRow.createCell(4).setCellValue("Article Type");
		hssfRow.createCell(5).setCellValue("Current Phase");
		hssfRow.createCell(6).setCellValue("Age Days");
		hssfRow.createCell(7).setCellValue("Accepted Date");
		hssfRow.createCell(8).setCellValue("Reports Run Date");
		
		
	}

	private static void setExcelRowsadmin(HSSFSheet hssfSheet, List<ArticleDetailsVO> taskManagementVoli) {
		int record = 2;
		for (ArticleDetailsVO data : taskManagementVoli) {
			HSSFRow hssfRow = hssfSheet.createRow(record++);
		
			hssfRow.createCell(0).setCellValue(data.getJournalName());
			hssfRow.createCell(1).setCellValue(data.getAid());
		    hssfRow.createCell(2).setCellValue(data.getArticle_title());
		    hssfRow.createCell(3).setCellValue(data.getArticle_doi());
		    hssfRow.createCell(4).setCellValue(data.getArticle_type_cd());
		    hssfRow.createCell(5).setCellValue(data.getTaskName());
			hssfRow.createCell(6).setCellValue(data.getAge());
			hssfRow.createCell(7).setCellValue(data.getAccepted_date());
			hssfRow.createCell(8).setCellValue(data.getReportsDate());	
		}	
	}
	
	
	
	public static void downloadExcelUser(HttpServletResponse response, List<TaskManagementVo> taskManagementVoList)
			throws FileNotFoundException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		String reportName = "WIP Reports";
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeaderUser(hssfSheet);
		setExcelRowsUser(hssfSheet, taskManagementVoList);
	//	hssfSheet.setColumnWidth(0, 10000);
		hssfSheet.setColumnWidth(0, 5000);
		hssfSheet.setColumnWidth(1, 5000);
		hssfSheet.setColumnWidth(2, 20000);
		hssfSheet.setColumnWidth(3, 5000);
		hssfSheet.setColumnWidth(4, 5000);
		hssfSheet.setColumnWidth(5, 4000);

		response.setContentType("application/vnd.ms-excel");

		// String fName = "attachment; filename="; fName = fName + "AllRecords.xls";
		// response.setHeader("Content-Disposition", fName);
//		 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\digiscape\\Desktop\\WipReportsExcel.xlsx");
//		 try {
//			hssfWorkbook.write(outputStream);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			hssfWorkbook.write(response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// response.getOutputStream().close()

	}

	private static void setExcelHeaderUser(HSSFSheet hssfSheet) {
		HSSFRow hssfRow = hssfSheet.createRow(1);

//		hssfRow.createCell(0).setCellValue("Journal Name");
		hssfRow.createCell(0).setCellValue("Journal AbbrName");
		hssfRow.createCell(1).setCellValue("ManuScipt ID");
		hssfRow.createCell(2).setCellValue("Article Title");
		hssfRow.createCell(3).setCellValue("Article Status");
		hssfRow.createCell(4).setCellValue("Article Type");
		hssfRow.createCell(5).setCellValue("Accepted Date");

	}

	private static void setExcelRowsUser(HSSFSheet hssfSheet, List<TaskManagementVo> taskManagementVoList) {
		int record = 2;
		for (TaskManagementVo data : taskManagementVoList) {
			HSSFRow hssfRow = hssfSheet.createRow(record++);
		//	hssfRow.createCell(0).setCellValue(data.getJournalName());
			hssfRow.createCell(0).setCellValue(data.getJournalAbbrName());
			hssfRow.createCell(1).setCellValue(data.getAid());
			hssfRow.createCell(2).setCellValue(data.getArticle_title());
			hssfRow.createCell(3).setCellValue(data.getTaskName());
			hssfRow.createCell(4).setCellValue(data.getArticle_type_cd());
			hssfRow.createCell(5).setCellValue(data.getAccepted_date());

		}

	}
	
	public static void downloadTotalCountExcelAdmin(HttpServletResponse response, Integer articleCount,
			Integer issueCount, Integer tPage){
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		String reportName = "Total All Records";
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeaderTotal(hssfSheet);
		setExcelRowsTotalCount(hssfSheet, articleCount,issueCount,tPage);
		hssfSheet.setColumnWidth(0, 3000);
		hssfSheet.setColumnWidth(1, 3000);
		hssfSheet.setColumnWidth(2, 4000);
		
		response.setContentType("application/vnd.ms-excel");
		//String fName = "attachment; filename="; fName = fName + "AllRecords.xls";
		//response.setHeader("Content-Disposition", fName);
	   
		try {
			FileOutputStream outputStream = new FileOutputStream("C:\\Users\\digiscape\\Desktop\\AllRecordsCount.xlsx");
			hssfWorkbook.write(outputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			hssfWorkbook.write(response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void setExcelHeaderTotal(HSSFSheet hssfSheet) {
		HSSFRow hssfRow = hssfSheet.createRow(1);
		hssfRow.createCell(0).setCellValue("Total Article");
		hssfRow.createCell(1).setCellValue("Total Issue");
		hssfRow.createCell(2).setCellValue("Total No of Page");
		
	}

	private static void setExcelRowsTotalCount(HSSFSheet hssfSheet,Integer articleCount ,
			Integer issueCount, Integer tPage) {
	
		int record = 2;
		HSSFRow hssfRow = hssfSheet.createRow(record);
		hssfRow.createCell(0).setCellValue(articleCount);
		hssfRow.createCell(1).setCellValue(issueCount);
		hssfRow.createCell(2).setCellValue(tPage);
		
	}
	
	
	
	////////////////////
	public static void downloadExcelRejected(HttpServletResponse response, List<ArticleDetail> statusRejectCount) throws FileNotFoundException {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet();
		hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		String reportName = "Withdraw Articles Reports";
		setExcelHeading(hssfSheet, hssfWorkbook, reportName);
		setExcelHeadeRejected(hssfSheet);
		setExcelRowsrejected(hssfSheet, statusRejectCount);
		hssfSheet.setColumnWidth(0, 10000);
		hssfSheet.setColumnWidth(1, 4000);
		hssfSheet.setColumnWidth(2, 14000);
		hssfSheet.setColumnWidth(3, 5000);
		hssfSheet.setColumnWidth(4, 5000);
		hssfSheet.setColumnWidth(5, 6000);
		hssfSheet.setColumnWidth(6, 8000);

		response.setContentType("application/vnd.ms-excel");
		
		//String fName = "attachment; filename="; fName = fName + "AllRecords.xls";
		//response.setHeader("Content-Disposition", fName);
	//	 FileOutputStream outputStream = new FileOutputStream("C:\\Users\\digiscape\\Desktop\\RejectedArticleExcel.xlsx");
		 try {
		//	hssfWorkbook.write(outputStream);
			hssfWorkbook.write(response.getOutputStream());
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void setExcelRowsrejected(HSSFSheet hssfSheet, List<ArticleDetail> statusRejectCount) {
		int record = 2;
		for (ArticleDetail data : statusRejectCount) {
			HSSFRow hssfRow = hssfSheet.createRow(record++);
			hssfRow.createCell(0).setCellValue(data.getJournals().getJournalName());
			hssfRow.createCell(1).setCellValue(data.getAid());
		    hssfRow.createCell(2).setCellValue(data.getArticle_title());
		    hssfRow.createCell(3).setCellValue(data.getJournals().getJournalAbbrName());
		    hssfRow.createCell(4).setCellValue(data.getArticle_type_cd());
		    hssfRow.createCell(5).setCellValue(data.getArticle_status());
			hssfRow.createCell(6).setCellValue(data.getRejectedDate().toString());
			
		}
	}

	private static void setExcelHeadeRejected(HSSFSheet hssfSheet) {
		HSSFRow hssfRow = hssfSheet.createRow(1);

		hssfRow.createCell(0).setCellValue("Journal Name");
		hssfRow.createCell(1).setCellValue("Manuscript ID");
		hssfRow.createCell(2).setCellValue("Article Title");
		hssfRow.createCell(3).setCellValue("Journal AbbrName");
		hssfRow.createCell(4).setCellValue("Article Type");
		hssfRow.createCell(5).setCellValue("Article Status");
		hssfRow.createCell(6).setCellValue("Rejected Date");
		
	}
}
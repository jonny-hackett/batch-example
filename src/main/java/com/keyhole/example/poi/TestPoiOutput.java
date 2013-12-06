package com.keyhole.example.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class TestPoiOutput {

	private static final String FILE_NAME = "/data/example/excel/TestPoi.xlsx";

	private static final String[] HEADERS = { "TICKER", "FIELD NAME",
			"LEGACY VALUE", "PACE VALUE", "SIMCORP VALUE" };

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		createWorkbook();
	}

	private static void createWorkbook() throws IOException {

		Workbook wb = new SXSSFWorkbook(100);
		Sheet sheet = wb.createSheet("Testing");
		sheet.createFreezePane(0, 4, 0, 4);
		sheet.setDefaultColumnWidth(20);

		addTitleToSheet(sheet);
		addSubTitleToSheet(sheet);
		addHeaders(sheet);

		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		for (int i = 4; i < 200000; i++) {
			if (i %1000 ==0) {
				System.out.println("Row: " + i);
			}
			addDataRow(sheet, i, style);
		}

		FileOutputStream out = new FileOutputStream(FILE_NAME);
		wb.write(out);
		out.close();

	}

	private static void addHeaders(Sheet sheet) {

		Workbook wb = sheet.getWorkbook();

		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		Row row = sheet.createRow(3);
		int col = 0;

		for (String header : HEADERS) {
			Cell cell = row.createCell(col);
			cell.setCellValue(header);
			cell.setCellStyle(style);
			col++;
		}

	}

	private static void addDataRow(Sheet sheet, int rowNum, CellStyle style) {

		Row row = sheet.createRow(rowNum);
		for (int i = 0; i < 5; i++) {

			Cell cell = row.createCell(i);
			cell.setCellValue("Row " + rowNum + "; Cell " + i);
			cell.setCellStyle(style);
		}

	}

	private static void addTitleToSheet(Sheet sheet) {

		Workbook wb = sheet.getWorkbook();

		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 18);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		Row row = sheet.createRow(0);
		row.setHeight((short) 20);

		Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
		cell.setCellValue("Report Title");
		cell.setCellStyle(style);

		CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
		sheet.addMergedRegion(range);

	}

	private static void addSubTitleToSheet(Sheet sheet) {

		Workbook wb = sheet.getWorkbook();

		CellStyle leftStyle = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 12);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		leftStyle.setAlignment(CellStyle.ALIGN_LEFT);
		leftStyle.setFont(font);

		Row row = sheet.createRow(1);
		row.setHeightInPoints(20);

		Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
		String date = DateFormatUtils.format(Calendar.getInstance(),
				DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());
		cell.setCellValue("Date : " + date);
		cell.setCellStyle(leftStyle);

		CellStyle rightStyle = wb.createCellStyle();
		rightStyle.cloneStyleFrom(leftStyle);
		rightStyle.setAlignment(CellStyle.ALIGN_RIGHT);

		Cell cell2 = row.createCell(4, Cell.CELL_TYPE_STRING);
		cell2.setCellValue("Results: 32987");
		cell2.setCellStyle(rightStyle);

		CellRangeAddress range1 = new CellRangeAddress(1, 1, 0, 3);
		sheet.addMergedRegion(range1);

		CellRangeAddress range2 = new CellRangeAddress(1, 1, 4, 7);
		sheet.addMergedRegion(range2);

	}

}

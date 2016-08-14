package com.keyhole.example.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("stockDataExcelWriter")
public class StockDataExcelWriter implements ItemWriter<StockData> {

	private static final String FILE_NAME = "/data/example/excel/StockData";
	private static final String[] HEADERS = { "Symbol", "Name", "Last Sale", "Market Cap", "ADR TSO", "IPO Year",
			"Sector", "Industry", "Summary URL" };

	private String outputFilename;
	private Workbook workbook;
	private CellStyle dataCellStyle;
	private int currRow = 0;

	private void addHeaders(Sheet sheet) {

		Workbook wb = sheet.getWorkbook();

		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		Row row = sheet.createRow(2);
		int col = 0;

		for (String header : HEADERS) {
			Cell cell = row.createCell(col);
			cell.setCellValue(header);
			cell.setCellStyle(style);
			col++;
		}
		currRow++;
	}

	private void addTitleToSheet(Sheet sheet) {

		Workbook wb = sheet.getWorkbook();

		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();

		font.setFontHeightInPoints((short) 14);
		font.setFontName("Arial");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setFont(font);

		Row row = sheet.createRow(currRow);
		row.setHeightInPoints(16);

		String currDate = DateFormatUtils.format(Calendar.getInstance(),
				DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());

		Cell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
		cell.setCellValue("Stock Data as of " + currDate);
		cell.setCellStyle(style);

		CellRangeAddress range = new CellRangeAddress(0, 0, 0, 7);
		sheet.addMergedRegion(range);
		currRow++;

	}

	@AfterStep
	public void afterStep(StepExecution stepExecution) throws IOException {
		FileOutputStream fos = new FileOutputStream(outputFilename);
		workbook.write(fos);
		fos.close();
	}

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("Calling beforeStep");

		String dateTime = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd_HHmmss");
		outputFilename = FILE_NAME + "_" + dateTime + ".xlsx";

		workbook = new SXSSFWorkbook(100);
		Sheet sheet = workbook.createSheet("Testing");
		sheet.createFreezePane(0, 3, 0, 3);
		sheet.setDefaultColumnWidth(20);

		addTitleToSheet(sheet);
		currRow++;
		addHeaders(sheet);
		initDataStyle();

	}

	private void initDataStyle() {
		dataCellStyle = workbook.createCellStyle();
		Font font = workbook.createFont();

		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		dataCellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		dataCellStyle.setFont(font);
	}

	@Override
	public void write(List<? extends StockData> items) throws Exception {

		Sheet sheet = workbook.getSheetAt(0);

		for (StockData data : items) {
			// commented out for blog article showing multiple format item
			// writer.
			// for (int i = 0; i < 300; i++) {
			currRow++;
			Row row = sheet.createRow(currRow);
			createStringCell(row, data.getSymbol(), 0);
			createStringCell(row, data.getName(), 1);
			createNumericCell(row, data.getLastSale().doubleValue(), 2);
			createStringCell(row, data.getMarketCap(), 3);
			createStringCell(row, data.getAdrTso(), 4);
			createStringCell(row, data.getIpoYear(), 5);
			createStringCell(row, data.getSector(), 6);
			createStringCell(row, data.getIndustry(), 7);
			createStringCell(row, data.getSummaryUrl(), 8);
			// }
		}
	}

	private void createStringCell(Row row, String val, int col) {
		Cell cell = row.createCell(col);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(val);
	}

	private void createNumericCell(Row row, Double val, int col) {
		Cell cell = row.createCell(col);
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
		cell.setCellValue(val);
	}

}

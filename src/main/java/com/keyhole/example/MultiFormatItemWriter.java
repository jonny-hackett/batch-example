package com.keyhole.example;

import java.io.IOException;
import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.keyhole.example.poi.StockData;
import com.keyhole.example.poi.StockDataExcelWriter;

@Component("multFormatItemWriter")
@Scope("step")
public class MultiFormatItemWriter implements ItemStreamWriter<StockData> {
	
	@Autowired
	private StockDataExcelWriter stockDataExcelWriter;
	
	@Autowired
	@Qualifier("pipeDelimitedExtractFile")
	private FlatFileItemWriter<StockData> extractWriter;

	@Override
	public void write(List<? extends StockData> items) throws Exception {
		stockDataExcelWriter.write(items);
		extractWriter.write(items);
	}
	
	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		stockDataExcelWriter.beforeStep(stepExecution);
	}
	
	@AfterStep
	public void afterStep(StepExecution stepExecution) throws IOException {
		stockDataExcelWriter.afterStep(stepExecution);
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		extractWriter.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		extractWriter.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		extractWriter.close();
	}

	

}

package com.keyhole.example.partition;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("logItemWriter")
@Scope("step")
public class LogItemWriter implements ItemWriter<Object> {

	private static final Logger LOG = Logger.getLogger(LogItemWriter.class);
	private StepExecution stepExecution;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	public void write(List<? extends Object> items) throws Exception {
		LOG.info("Executing: " + stepExecution.getStepName());
		for (Object o : items) {
			LOG.info(o.toString());
		}
	}

}

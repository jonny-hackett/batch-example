package com.keyhole.example;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("tickerWriter")
public class LogItemWriter implements ItemWriter<Object> {
	
	private static final Logger LOG = Logger.getLogger(LogItemWriter.class);
	
	public void write(List<? extends Object> items) throws Exception {
		for (Object o: items) {
			LOG.info(o.toString());
		}
	}

}

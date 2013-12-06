package com.keyhole.example;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("tickerWriter")
public class LogItemWriter implements ItemWriter<TickerData> {
	
	private static final Logger LOG = Logger.getLogger(LogItemWriter.class);
	
	public void write(List<? extends TickerData> items) throws Exception {
		for (TickerData ticker: items) {
			LOG.info(ticker.toString());
		}
	}

}

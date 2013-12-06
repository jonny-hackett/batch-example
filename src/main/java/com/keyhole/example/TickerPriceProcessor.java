package com.keyhole.example;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tickerPriceProcessor")
public class TickerPriceProcessor implements ItemProcessor<TickerData, TickerData> {
	
	@Autowired
	private CurrencyConversionService conversionService;

	@Override
	public TickerData process(TickerData ticker) throws Exception {
		
		BigDecimal openGBP = conversionService.convertCurrency(ticker.getOpen(), Currency.USD, Currency.GBP);
		BigDecimal lastTradeGBP = conversionService.convertCurrency(ticker.getLastTrade(), Currency.USD, Currency.GBP);
		
		ticker.setOpenGBP(openGBP);
		ticker.setLastTradeGBP(lastTradeGBP);
		
		return ticker;
	}

}

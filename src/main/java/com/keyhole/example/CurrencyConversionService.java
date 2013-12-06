package com.keyhole.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {
	
	private static final BigDecimal GBP_RATE = new BigDecimal("0.638365784");
	
	public BigDecimal convertCurrency(BigDecimal amt, Currency from, Currency to) {
		return  amt.multiply(GBP_RATE).setScale(2, RoundingMode.HALF_EVEN);
	}

}

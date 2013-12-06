package com.keyhole.example;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component("tickerMapper")
public class TickerFieldSetMapper implements FieldSetMapper<TickerData> {

	public TickerData mapFieldSet(FieldSet fieldSet) throws BindException {
		TickerData data = new TickerData();
		data.setSymbol(fieldSet.readString(0));
		data.setName(fieldSet.readString(1));
		data.setLastTradeDate(fieldSet.readDate(2, "mm/DD/yyyy"));
		data.setOpen(fieldSet.readBigDecimal(3));
		data.setLastTrade(fieldSet.readBigDecimal(4));
		data.setChangePct(fieldSet.readString(5));
		return data;
	}
}

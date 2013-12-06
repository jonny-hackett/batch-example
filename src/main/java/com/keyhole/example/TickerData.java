package com.keyhole.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TickerData implements Serializable {

	private static final long serialVersionUID = 6463492770982487812L;
	private String symbol;
	private String name;
	private Date lastTradeDate;
	private BigDecimal open;
	private BigDecimal lastTrade;
	private String changePct;
	private BigDecimal openGBP;
	private BigDecimal lastTradeGBP;

	@Override
	public String toString() {
		return "TickerData [symbol=" + symbol + ", name=" + name
				+ ", lastTradeDate=" + lastTradeDate + ", open=" + open
				+ ", lastTrade=" + lastTrade + ", changePct=" + changePct
				+ ", openGBP=" + openGBP + ", lastTradeGBP=" + lastTradeGBP
				+ "]";
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastTradeDate() {
		return lastTradeDate;
	}

	public void setLastTradeDate(Date lastTradeDate) {
		this.lastTradeDate = lastTradeDate;
	}

	public BigDecimal getOpen() {
		return open;
	}

	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public BigDecimal getLastTrade() {
		return lastTrade;
	}

	public void setLastTrade(BigDecimal lastTrade) {
		this.lastTrade = lastTrade;
	}

	public String getChangePct() {
		return changePct;
	}

	public void setChangePct(String changePct) {
		this.changePct = changePct;
	}

	public BigDecimal getLastTradeGBP() {
		return lastTradeGBP;
	}

	public void setLastTradeGBP(BigDecimal lastTradeGBP) {
		this.lastTradeGBP = lastTradeGBP;
	}

	public BigDecimal getOpenGBP() {
		return openGBP;
	}

	public void setOpenGBP(BigDecimal openGBP) {
		this.openGBP = openGBP;
	}

}

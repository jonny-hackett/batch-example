package com.keyhole.example.poi;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4383231542218565966L;
	private String symbol;
	private String name;
	private BigDecimal lastSale;
	private String marketCap;
	private String adrTso;
	private String ipoYear;
	private String sector;
	private String industry;
	private String summaryUrl;

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

	public BigDecimal getLastSale() {
		return lastSale;
	}

	public void setLastSale(BigDecimal lastSale) {
		this.lastSale = lastSale;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public String getAdrTso() {
		return adrTso;
	}

	public void setAdrTso(String adrTso) {
		this.adrTso = adrTso;
	}

	public String getIpoYear() {
		return ipoYear;
	}

	public void setIpoYear(String ipoYear) {
		this.ipoYear = ipoYear;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSummaryUrl() {
		return summaryUrl;
	}

	public void setSummaryUrl(String summaryUrl) {
		this.summaryUrl = summaryUrl;
	}

}

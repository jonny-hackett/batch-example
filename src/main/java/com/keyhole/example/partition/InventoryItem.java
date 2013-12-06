package com.keyhole.example.partition;

import java.io.Serializable;

public class InventoryItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String category;
	private String subCategory;
	private String description;
	private String catalogNum;
	private String color;
	private String size;
	private double price;
	private int qty;
	public String getCatalogNum() {
		return catalogNum;
	}

	public String getCategory() {
		return category;
	}

	public String getColor() {
		return color;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public String getSize() {
		return size;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setCatalogNum(String catalogNum) {
		this.catalogNum = catalogNum;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "InventoryItem [category=" + category + ", subCategory="
				+ subCategory + ", description=" + description
				+ ", catalogNum=" + catalogNum + ", color=" + color + ", size="
				+ size + ", price=" + price + ", qty=" + qty + "]";
	}

}

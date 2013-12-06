package com.keyhole.example.partition;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component("inventoryFieldMapper")
public class InventoryItemFieldSetMapper implements FieldSetMapper<InventoryItem> {

	@Override
	public InventoryItem mapFieldSet(FieldSet fieldSet) throws BindException {
		InventoryItem item = new InventoryItem();
		item.setCategory(fieldSet.readString(0));
		item.setSubCategory(fieldSet.readString(1));
		item.setDescription(fieldSet.readString(2));
		item.setCatalogNum(fieldSet.readString(3));
		item.setColor(fieldSet.readString(4));
		item.setSize(fieldSet.readString(5));
		item.setPrice(fieldSet.readDouble(6));
		item.setQty(fieldSet.readInt(7));		
		return item;
	}

}

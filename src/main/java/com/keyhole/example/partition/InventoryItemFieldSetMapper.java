package com.keyhole.example.partition;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component("inventoryFieldMapper")
public class InventoryItemFieldSetMapper implements FieldSetMapper<InventoryItem> {

	@Override
	public InventoryItem mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		return null;
	}

}

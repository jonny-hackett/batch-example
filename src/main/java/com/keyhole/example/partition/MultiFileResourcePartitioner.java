package com.keyhole.example.partition;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.core.io.FileSystemResource;

public class MultiFileResourcePartitioner implements Partitioner {

	private String inboundDir;

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		
		Map<String, ExecutionContext> partitionMap = new HashMap<String, ExecutionContext>();
		File dir = new File(inboundDir);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				ExecutionContext context = new ExecutionContext();
				context.put("fileResource", file.toURI().toString());
				partitionMap.put(file.getName(), context);
			}
		}
		return partitionMap;
	}

	public String getInboundDir() {
		return inboundDir;
	}

	public void setInboundDir(String inboundDir) {
		this.inboundDir = inboundDir;
	}

}

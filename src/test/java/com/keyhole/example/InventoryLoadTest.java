package com.keyhole.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/launch-context.xml")
public class InventoryLoadTest {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier(value = "InventoryLoader")
	private Job job;

	@Test
	public void testJob() throws Exception {
		JobParametersBuilder builder = new JobParametersBuilder();
		JobExecution jobExecution = jobLauncher.run(job,
				builder.toJobParameters());
		assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());
	}
}

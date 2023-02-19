package com.example.demo;

import com.example.demo.data.InternalObj;
import com.example.demo.data.ModifiableRecord;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static RecordService recordService;

	@Autowired
	public void setRecordService(RecordService recordService) {
		DemoApplication.recordService = recordService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}


}

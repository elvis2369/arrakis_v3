package com.db.grad.javaapi;

import com.db.grad.javaapi.etlcsv.CreateDataSqlFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) throws IOException {




		CreateDataSqlFile.main();



		SpringApplication.run(JavaApiApplication.class, args);
	}

}

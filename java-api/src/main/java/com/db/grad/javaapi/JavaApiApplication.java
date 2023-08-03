package com.db.grad.javaapi;

import com.db.grad.javaapi.etlcsv.CreateDataSqlFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) {

		String filePath_dataSql = new File("src\\main\\resources\\data.sql").getAbsolutePath();
		String filePath_dataCsv = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

		try {
//			CreateDataSqlFile.main(filePath_dataCsv, filePath_dataSql);
			checkFile(filePath_dataSql);
		}
		catch(Exception e) {
			//  Block of code to handle errors
		}

		SpringApplication.run(JavaApiApplication.class, args);

	}

	public static void checkFile(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			if ((line = reader.readLine()) != null) {
				System.out.println("File found");
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
		}
	}

}

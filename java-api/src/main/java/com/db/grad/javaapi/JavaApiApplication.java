package com.db.grad.javaapi;

import com.db.grad.javaapi.etlcsv.Security;
import com.db.grad.javaapi.etlcsv.Trade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.db.grad.javaapi.etlcsv.CreateDataSqlFile.writeQueriesIntoFile;
import static com.db.grad.javaapi.etlcsv.ReadCsv.createSecuritiesFromTrades;
import static com.db.grad.javaapi.etlcsv.ReadCsv.readTradesFromCSV;

@SpringBootApplication
public class JavaApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaApiApplication.class, args);
    }

    //@PostConstruct
    public static void initDatabase() {
        String filePath_dataSql = new File("src\\main\\resources\\data.sql").getAbsolutePath();
        String filePath_dataCsv = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

        try {
            System.out.println("----------Creating data.sql----------");
            System.out.println("Path of CSV file -> " + filePath_dataCsv);

            List<Trade> trades = readTradesFromCSV(filePath_dataCsv);
            List<Security> securities = createSecuritiesFromTrades(trades);

            writeQueriesIntoFile(trades, securities, filePath_dataSql);

            checkFile(filePath_dataSql);
            System.out.println("----------data.sql created----------");
        } catch (Exception e) {
            //  Block of code to handle errors
        }
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
            System.out.println("Error trying to read the file: " + e.getMessage());
        }
    }

}

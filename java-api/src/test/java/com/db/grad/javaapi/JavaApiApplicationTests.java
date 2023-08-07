package com.db.grad.javaapi;

import com.db.grad.javaapi.etlcsv.ReadCsv;
import com.db.grad.javaapi.etlcsv.ReadCsvTest;
import com.db.grad.javaapi.etlcsv.Security;
import com.db.grad.javaapi.etlcsv.Trade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.db.grad.javaapi.etlcsv.CreateDataSqlFile.writeQueriesIntoFile;
import static com.db.grad.javaapi.etlcsv.ReadCsv.createSecuritiesFromTrades;
import static com.db.grad.javaapi.etlcsv.ReadCsv.readTradesFromCSV;

@SpringBootTest
class JavaApiApplicationTests {
    static String filePath_dataSql = "";
    static String filePath_dataCsv = "";

    @BeforeAll
    static void setUp() {
        SpringApplication.run(JavaApiApplication.class);

        filePath_dataSql = new File("src\\main\\resources\\data.sql").getAbsolutePath();
        filePath_dataCsv = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

        try {
            System.out.println("----------Creating data.sql----------");
            System.out.println("Path of CSV file -> " + filePath_dataCsv);

            List<Trade> trades = readTradesFromCSV(filePath_dataCsv);
            List<Security> securities = createSecuritiesFromTrades(trades);

            writeQueriesIntoFile(trades, securities, filePath_dataSql);

            System.out.println("----------data.sql created----------");

        } catch (Exception e) {
        }

    }

    @Test
    void contextLoads() {
        System.out.println("test");
        //ReadCsvTest.readTradesFromCSV(filePath_dataCsv);
    }


}

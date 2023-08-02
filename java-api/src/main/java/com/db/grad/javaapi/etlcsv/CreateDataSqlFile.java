package com.db.grad.javaapi.etlcsv;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

import static com.db.grad.javaapi.etlcsv.ReadCsv.readTradesFromCSV;

public class CreateDataSqlFile {


    public static void main(String... args) throws IOException {
        System.out.println("----------Creating data.sql----------");

        String filePath = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

        System.out.println("FilePath of CSV -> "+filePath);

        List<Trade> trades = readTradesFromCSV(filePath);

        // print all the trades read from CSV file
        for (Trade t : trades) {
            System.out.println(t);
        }
        whenWriteStringUsingBufferedWritter_thenCorrect(trades);


        System.out.println("----------data.sql created----------");
    }
    public static void whenWriteStringUsingBufferedWritter_thenCorrect(List<Trade> trades)
            throws IOException {
        String filePathOfDataSql = new File("src\\main\\resources\\data.sql").getAbsolutePath();
        String str = "INSERT INTO trades (currency, trade_type, quantity) VALUES ("+"'"+trades.get(1).getTrade_currency()+"'"+", "+"'"+trades.get(1).getTrade_type()+"'"+", "+"'"+trades.get(1).getQuantity()+"'"+");";



        BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOfDataSql));
        writer.write(str);

        writer.close();
        System.out.println("CREATED FILE -> "+filePathOfDataSql);
    }
}

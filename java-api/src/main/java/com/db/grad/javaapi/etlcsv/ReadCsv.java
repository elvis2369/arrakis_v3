package com.db.grad.javaapi.etlcsv;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv
{
    public static void main(String... args) {

        String filePath = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

        System.out.println("FilePath of CSV -> "+filePath);

        List<Trade> trades = readTradesFromCSV(filePath);

        // let's print all the person read from CSV file
        for (Trade t : trades) {
            System.out.println(t);
        }
    }

    public static List<Trade> readTradesFromCSV(String fileName) {
        List<Trade> trades = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Trade trade = createTrade(attributes);

                // adding book into ArrayList
                trades.add(trade);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return trades;
    }

    private static Trade createTrade(String[] metadata) {
        String trade_type = metadata[0];
        String trade_currency = metadata[1];
        String quantity = metadata[2];
        String trade_settlement_date = metadata[3];
        String trade_status = metadata[4];
        String trade_date = metadata[5];
        String unit_price = metadata[6];
        String coupon_percent = metadata[7];
        String bond_currency = metadata[8];
        String cusip = metadata[9];
        String face_value = metadata[10];
        String isin = metadata[11];
        String issuer_name = metadata[12];
        String bond_maturity_date = metadata[13];
        String status = metadata[14];
        String type = metadata[15];
        String book_name = metadata[16].substring(0, 1).toUpperCase() + metadata[16].substring(1);
        String bond_holder = metadata[17];

        //int price = Integer.parseInt(metadata[1]);
        //String author = metadata[2];

        // create and return trade of this metadata
        return new Trade(trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity_date, status, type, book_name, bond_holder
        );
    }

}

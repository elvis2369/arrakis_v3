package com.db.grad.javaapi.etlcsv;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

import static com.db.grad.javaapi.etlcsv.ReadCsv.readTradesFromCSV;

public class CreateDataSqlFile {


    public static void main(String filePath_dataCsv) throws IOException {
        System.out.println("----------Creating data.sql----------");

        //String filePath = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();

        System.out.println("FilePath of CSV -> "+filePath_dataCsv);

        List<Trade> trades = readTradesFromCSV(filePath_dataCsv);

        // print all the trades read from CSV file
        //for (Trade t : trades) {
            //System.out.println(t);
        //}

        System.out.println("TEST maturity date:"+trades.get(1).getBond_maturity_date());
        System.out.println(trades.get(1));
        whenWriteStringUsingBufferedWritter_thenCorrect(trades);


        System.out.println("----------data.sql created----------");
    }
    public static void whenWriteStringUsingBufferedWritter_thenCorrect(List<Trade> trades)
            throws IOException {

        java.util.Date date = new Date("13/05/2021");
        Object param = new java.sql.Date(date.getTime());

        String filePathOfDataSql = new File("src\\main\\resources\\data.sql").getAbsolutePath();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePathOfDataSql));
        for (int i=1;i<trades.size();i++) {
            String query_security = "INSERT INTO security (id, isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) " +
                    "VALUES (" +
                    "'" + i + "'"
                    + ", " +
                    "'" + trades.get(i).getIsin() + "'"
                    + ", " +
                    "'" + trades.get(i).getCusip() + "'"
                    + ", " +
                    "'" + trades.get(i).getIssuer_name() + "'"
                    + ", " +
                    "'" + convertDate(trades.get(i).getBond_maturity_date()) + "'"
                    + ", " +
                    "'" + trades.get(i).getCoupon_percent() + "'"
                    + ", " +
                    "'" + trades.get(i).getType() + "'"
                    + ", " +
                    "'" + trades.get(i).getFace_value() + "'"
                    + ", " +
                    "'" + trades.get(i).getTrade_currency() + "'"
                    + ", " +
                    "'" + trades.get(i).getStatus() + "'"
                    + ");\n";

            String query_book = "INSERT INTO book (id, name) " +
                    "VALUES (" +
                    "'" + i + "'"
                    + ", " +
                    "'" + trades.get(i).getBook_name() + "'" + ");\n";


            String query_counterparty = "INSERT INTO counterparty (id, name) " +
                    "VALUES (" +
                    "'" + i +
                    "'" + ", " +
                    "'" + trades.get(i).getIssuer_name() + "'" + ");\n";

            String query_trade = "INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) " +
                    "VALUES (" +
                    "'" + 1 + "'"
                    + ", " +
                    "'" + 1 + "'"
                    + ", " +
                    "'" + 1 + "'"
                    + ", " +
                    "'" + trades.get(i).getTrade_currency() + "'"
                    + ", " +
                    "'" + trades.get(i).getStatus() + "'"
                    + ", " +
                    "'" + trades.get(i).getQuantity() + "'"
                    + ", " +
                    "'" + trades.get(i).getUnit_price() + "'"
                    + ", " +
                    "'" + trades.get(i).getTrade_type() + "'"
                    + ", " +
                    "'" + param + "'"
                    + ", " +
                    "'" + param + "'"
                    + ");";

            writer.write(query_security);
            writer.write(query_book);
            writer.write(query_counterparty);
            writer.write(query_trade);
        }
        writer.close();
        System.out.println("CREATED FILE -> "+filePathOfDataSql);
    }

    public static String convertDate(String inputDate){

        //String inputDate = "05/08/2021";
        String outputFormat = "yyyy-MM-dd";

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);

        try {
            Date date = inputDateFormat.parse(inputDate);
            String formattedDate = outputDateFormat.format(date);
            //System.out.println("Umgewandeltes Datum: " + formattedDate);
            return formattedDate;
        } catch (ParseException e) {
            System.out.println("Fehler beim Umwandeln des Datums: " + e.getMessage());
            return e.getMessage();
        }
    }

}

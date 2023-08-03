package com.db.grad.javaapi.etlcsv;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

import static com.db.grad.javaapi.etlcsv.ReadCsv.readTradesFromCSV;

public class CreateDataSqlFile {


    public static void main(String filePath_dataCsv, String filePath_dataSql) throws IOException {

        System.out.println("----------Creating data.sql----------");
        System.out.println("Path of CSV file -> "+filePath_dataCsv);

        List<Trade> trades = readTradesFromCSV(filePath_dataCsv);

        writeQueriesIntoFile(trades, filePath_dataSql);

        System.out.println("----------data.sql created----------");
    }
    public static void writeQueriesIntoFile(List<Trade> trades, String filePath_dataSql)
            throws IOException {


        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath_dataSql));
        String[] booksArray = createBooksArray(trades);
        createQueryBook(writer, booksArray);

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


            String query_counterparty = "INSERT INTO counterparty (id, name) " +
                    "VALUES (" +
                    "'" + i +
                    "'" + ", " +
                    "'" + trades.get(i).getIssuer_name() + "'" + ");\n";

            String query_trade = "INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) " +
                    "VALUES (" +
                    "'" + findMatchingBook(booksArray, trades.get(i).getBook_name()) + "'"
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
                    "'" + convertDate(trades.get(i).getTrade_date()) + "'"
                    + ", " +
                    "'" + convertDate(trades.get(i).getTrade_settlement_date()) + "'"
                    + ");";

            writer.write(query_security);
            //writer.write(query_book);
            writer.write(query_counterparty);
            writer.write(query_trade);

        }
        writer.close();
        System.out.println("Path of data.sql file -> "+filePath_dataSql);


    }

    public static String convertDate(String inputDate){

        String outputFormat = "yyyy-MM-dd";

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);

        try {
            Date date = inputDateFormat.parse(inputDate);
            String formattedDate = outputDateFormat.format(date);

            return formattedDate;
        } catch (ParseException e) {
            System.out.println("Error while converting the date: " + e.getMessage());

            return e.getMessage();
        }
    }

    public static void createQueryBook(Writer writer, String[] booksArray) throws IOException {

        int x = 1;
        for (int i=0;i<booksArray.length;i++) {

        String query_book = "INSERT INTO book (id, name) " +
                "VALUES (" +
                "'" + x + "'"
                + ", " +
                "'" + booksArray[i].toString() + "'" + ");\n";
        x++;
        writer.write(query_book);
    }}

    public static String[] createBooksArray(List<Trade> trades){
        String[] booksArray = new String[trades.size()];

        for (int i=0;i<trades.size();i++) {
            if(trades.get(i).getBook_name() != null && !trades.get(i).getBook_name().equals("Book_name")){
                booksArray[i] = trades.get(i).getBook_name();
            } }

        // Konvertiere das Array in ein Set, um Duplikate zu entfernen
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(booksArray));
        uniqueSet.remove(null);

        // Konvertiere das Set zurück in ein Array
        String[] resultArray = uniqueSet.toArray(new String[0]);

        // Ausgabe des Ergebnisarrays ohne Duplikate
        //System.out.println("Ergebnisarray ohne Duplikate: " + Arrays.toString(resultArray));

        // Erstelle ein neues Array mit derselben Größe
        String[] reversedArray = new String[resultArray.length];

        // Kopiere die Elemente in umgekehrter Reihenfolge in das neue Array
        for (int i = 0; i < resultArray.length; i++) {
            reversedArray[resultArray.length - 1 - i] = resultArray[i];
        }

        return reversedArray;
    }
    public static int findMatchingBook(String[] booksArray, String bookName){
        int indexOfBook = ArrayUtils.indexOf(booksArray, bookName)+1;

        return indexOfBook;
    }
}

package com.db.grad.javaapi.etlcsv;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CreateDataSqlFile {

    public static void writeQueriesIntoFile(List<Trade> trades, List<Security> securities, String filePath_dataSql)
            throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath_dataSql));

        String[] booksArray = createBooksArray(trades);
        String[] counterpartiesArray = createCounterpartyArray(trades);
        List<Security> securitiesList = removeDuplicatesOfSecuritiesList(securities);

        createQueriesForBooks(writer, booksArray);
        createQueriesForCounterparties(writer, counterpartiesArray);
        createQueriesForSecurities(writer, securitiesList);
        createQueriesForTrades(writer, trades, booksArray, counterpartiesArray, securitiesList);

        writer.flush();
        writer.close();

        System.out.println("Path of data.sql file -> " + filePath_dataSql);
    }

    private static void createQueriesForSecurities(BufferedWriter writer, List<Security> securitiesList) throws IOException {

        for (Security s : securitiesList) {
            String query_security = "INSERT INTO security (isin, cusip, issuer_name, maturity_date, coupon, type, face_value, currency, status) " +
                    "VALUES (" +
                    "'" + s.getIsin() + "'"
                    + ", " +
                    "'" + s.getCusip() + "'"
                    + ", " +
                    "'" + s.getIssuer_name() + "'"
                    + ", " +
                    "'" + convertDate(s.getBond_maturity_date()) + "'"
                    + ", " +
                    "'" + s.getCoupon_percent() + "'"
                    + ", " +
                    "'" + s.getType() + "'"
                    + ", " +
                    "'" + s.getFace_value() + "'"
                    + ", " +
                    "'" + s.getBond_currency() + "'"
                    + ", " +
                    "'" + s.getStatus() + "'"
                    + ");\n";
            writer.write(query_security);
        }


    }

    private static void createQueriesForTrades(BufferedWriter writer, List<Trade> trades, String[] booksArray, String[] counterpartiesArray, List<Security> securitiesList) throws IOException {

        for (int i = 1; i < trades.size(); i++) {

            String query_trade = "INSERT INTO trade (book_id, security_id, counterparty_id, currency, status, quantity, unit_price, buy_sell, trade_date, settlement_date) " +
                    "VALUES (" +
                    "'" + findMatch(booksArray, trades.get(i).getBook_name()) + "'"
                    + ", " +
                    "'" + findMatchList(securitiesList, trades.get(i)) + "'"
                    + ", " +
                    "'" + findMatch(counterpartiesArray, trades.get(i).getIssuer_name()) + "'"
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
                    + ");\n";

            writer.write(query_trade);
        }


    }

    public static String convertDate(String inputDate) {

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

    public static List<Security> removeDuplicatesOfSecuritiesList(List<Security> securities) {
        List<Security> listWithoutDuplicates = new ArrayList<>(
                new LinkedHashSet<>(securities));

        return listWithoutDuplicates;
    }

    public static String[] createCounterpartyArray(List<Trade> trades) {
        String[] counterpartiesArray = new String[trades.size()];

        for (int i = 0; i < trades.size(); i++) {
            if (trades.get(i).getIssuer_name() != null) {
                counterpartiesArray[i] = trades.get(i).getIssuer_name();
            }
        }

        // Konvertiere das Array in ein Set, um Duplikate zu entfernen
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(counterpartiesArray));
        uniqueSet.remove(null);

        // Konvertiere das Set zurück in ein Array
        String[] resultArray = uniqueSet.toArray(new String[0]);

        return resultArray;
    }

    public static void createQueriesForCounterparties(Writer writer, String[] counterpartiesArray) throws IOException {

        int x = 1;
        for (int i = 0; i < counterpartiesArray.length; i++) {

            String query_counterparty = "INSERT INTO counterparty (id, name) " +
                    "VALUES (" +
                    "'" + x + "'"
                    + ", " +
                    "'" + counterpartiesArray[i].toString() + "'" + ");\n";
            x++;
            writer.write(query_counterparty);
        }
    }

    public static void createQueriesForBooks(Writer writer, String[] booksArray) throws IOException {

        int x = 1;
        for (int i = 0; i < booksArray.length; i++) {

            String query_book = "INSERT INTO book (id, name) " +
                    "VALUES (" +
                    "'" + x + "'"
                    + ", " +
                    "'" + booksArray[i].toString() + "'" + ");\n";
            x++;
            writer.write(query_book);
        }
    }

    public static String[] createBooksArray(List<Trade> trades) {
        String[] booksArray = new String[trades.size()];

        for (int i = 0; i < trades.size(); i++) {
            if (trades.get(i).getBook_name() != null && !trades.get(i).getBook_name().equals("Book_name")) {
                booksArray[i] = trades.get(i).getBook_name();
            }
        }

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

    public static int findMatch(String[] array, String identifier) {
        int indexOfArray = ArrayUtils.indexOf(array, identifier) + 1;

        return indexOfArray;
    }

    public static int findMatchList(List<Security> list, Trade identifier) {

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsin().equals(identifier.getIsin())) {
                index = i + 1;
            }
        }

        return index;
    }

}

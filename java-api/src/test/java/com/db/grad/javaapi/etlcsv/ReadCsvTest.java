package com.db.grad.javaapi.etlcsv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReadCsvTest {
    private String filePath_dataCsv = new File("src\\main\\resources\\db-bonds-data.csv").getAbsolutePath();
    String trade_type = "buy";
    String trade_currency = "USD";
    String quantity = "50";
    String trade_settlement_date = "04/08/2021";
    String trade_status = "open";
    String trade_date = "13/05/2021";
    String unit_price = "90";
    String coupon_percent = "4.37";
    String bond_currency = "USD";
    String cusip = "";
    String face_value = "1000";
    String isin = "XS1988387210";
    String issuer_name = "BNPParibas";
    String bond_maturity_date = "05/08/2021";
    String status = "active";
    String type = "CORP";
    String book_name = "Trading_book_1";
    String bond_holder = "AZ Holdings Inc";
    Trade testTrade = new Trade(trade_type, trade_currency, quantity, trade_settlement_date, trade_status, trade_date, unit_price, coupon_percent, bond_currency, cusip, face_value, isin, issuer_name, bond_maturity_date, status, type, book_name, bond_holder);
    Trade testTradeNegative = new Trade("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

    public ArrayList<Trade> trades = new ArrayList<>();


    @Test
    @DisplayName("Test readTradesFromCSV positive")
    public void testReadTradesFromCSVPositive() {
        List<Trade> trades = ReadCsv.readTradesFromCSV(filePath_dataCsv);

        assertEquals(trades.get(1).toString().compareTo(testTrade.toString()), 0);
    }

    @Test
    @DisplayName("Test readTradesFromCSV negative")
    public void testReadTradesFromCSVNegative() {
        List<Trade> trades = ReadCsv.readTradesFromCSV(filePath_dataCsv);

        assertEquals(trades.get(1).toString().compareTo(testTradeNegative.toString()), 59);
    }

    @Test
    @DisplayName("Test createSecuritiesFromTrades positive")
    public void testCreateSecuritiesFromTradesPositive() {
        trades.add(testTrade);
        trades.add(testTrade);
        List<Security> securities = ReadCsv.createSecuritiesFromTrades(trades);

        assertEquals(securities.get(0).getIsin().compareTo("XS1988387210"), 0);
    }

    @Test
    @DisplayName("Test createSecuritiesFromTrades negative")
    public void testCreateSecuritiesFromTradesNegative() {
        trades.add(testTradeNegative);
        trades.add(testTradeNegative);
        List<Security> securities = ReadCsv.createSecuritiesFromTrades(trades);

        assertEquals(securities.get(0).getIsin().compareTo("XS1988387210"), -12);
    }


}

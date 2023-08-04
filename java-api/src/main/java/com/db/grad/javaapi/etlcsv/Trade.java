package com.db.grad.javaapi.etlcsv;

public class Trade {

    private String trade_type;
    private String trade_currency;
    private String quantity;
    private String trade_settlement_date;
    private String trade_status;
    private String trade_date;
    private String unit_price;
    private String coupon_percent;
    private String bond_currency;
    private String cusip;
    private String face_value;
    private String isin;
    private String issuer_name;
    private String bond_maturity_date;
    private String status;
    private String type;
    private String book_name;
    private String bond_holder;


    public Trade(String trade_type, String trade_currency, String quantity, String trade_settlement_date, String trade_status, String trade_date, String unit_price, String coupon_percent, String bond_currency, String cusip, String face_value, String isin, String issuer_name, String bond_maturity_date, String status, String type, String book_name, String bond_holder) {
        this.trade_type = trade_type;
        this.trade_currency = trade_currency;
        this.quantity = quantity;
        this.trade_settlement_date = trade_settlement_date;
        this.trade_status = trade_status;
        this.trade_date = trade_date;
        this.unit_price = unit_price;
        this.coupon_percent = coupon_percent;
        this.bond_currency = bond_currency;
        this.cusip = cusip;
        this.face_value = face_value;
        this.isin = isin;
        this.issuer_name = issuer_name;
        this.bond_maturity_date = bond_maturity_date;
        this.status = status;
        this.type = type;
        this.book_name = book_name;
        this.bond_holder = bond_holder;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_currency() {
        return trade_currency;
    }

    public void setTrade_currency(String trade_currency) {
        this.trade_currency = trade_currency;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTrade_settlement_date() {
        return trade_settlement_date;
    }

    public void setTrade_settlement_date(String trade_settlement_date) {
        this.trade_settlement_date = trade_settlement_date;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(String coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getFace_value() {
        return face_value;
    }

    public void setFace_value(String face_value) {
        this.face_value = face_value;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIssuer_name() {
        return issuer_name;
    }

    public void setIssuer_name(String issuer_name) {
        this.issuer_name = issuer_name;
    }

    public String getBond_maturity_date() {
        return bond_maturity_date;
    }

    public void setBond_maturity_date(String bond_maturity_date) {
        this.bond_maturity_date = bond_maturity_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBond_holder() {
        return bond_holder;
    }

    public void setBond_holder(String bond_holder) {
        this.bond_holder = bond_holder;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "trade_type='" + trade_type + '\'' +
                ", trade_currency='" + trade_currency + '\'' +
                ", quantity='" + quantity + '\'' +
                ", trade_settlement_date='" + trade_settlement_date + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", trade_date='" + trade_date + '\'' +
                ", unit_price='" + unit_price + '\'' +
                ", coupon_percent='" + coupon_percent + '\'' +
                ", bond_currency='" + bond_currency + '\'' +
                ", cusip='" + cusip + '\'' +
                ", face_value='" + face_value + '\'' +
                ", isin='" + isin + '\'' +
                ", issuer_name='" + issuer_name + '\'' +
                ", bond_maturity_date='" + bond_maturity_date + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", book_name='" + book_name + '\'' +
                ", bond_holder='" + bond_holder + '\'' +
                '}';
    }
}

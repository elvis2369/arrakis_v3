package com.db.grad.javaapi.etlcsv;

public class Security {

    private int id;
    private String isin;
    private String cusip;
    private String issuer_name;
    private String bond_maturity_date;
    private String coupon_percent;
    private String type;
    private String face_value;
    private String bond_currency;
    private String status;


    public Security(int id, String isin, String cusip, String issuer_name, String bond_maturity_date, String coupon_percent, String type, String face_value, String bond_currency, String status) {
        this.id = id;
        this.isin = isin;
        this.cusip = cusip;
        this.issuer_name = issuer_name;
        this.bond_maturity_date = bond_maturity_date;
        this.coupon_percent = coupon_percent;
        this.type = type;
        this.face_value = face_value;
        this.bond_currency = bond_currency;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
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

    public String getCoupon_percent() {
        return coupon_percent;
    }

    public void setCoupon_percent(String coupon_percent) {
        this.coupon_percent = coupon_percent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFace_value() {
        return face_value;
    }

    public void setFace_value(String face_value) {
        this.face_value = face_value;
    }

    public String getBond_currency() {
        return bond_currency;
    }

    public void setBond_currency(String bond_currency) {
        this.bond_currency = bond_currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", isin='" + isin + '\'' +
                ", cusip='" + cusip + '\'' +
                ", issuer_name='" + issuer_name + '\'' +
                ", bond_maturity_date='" + bond_maturity_date + '\'' +
                ", coupon_percent='" + coupon_percent + '\'' +
                ", type='" + type + '\'' +
                ", face_value='" + face_value + '\'' +
                ", bond_currency='" + bond_currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

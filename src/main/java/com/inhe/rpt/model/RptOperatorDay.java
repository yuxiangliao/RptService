package com.inhe.rpt.model;

import java.math.BigDecimal;
import java.util.Date;

public class RptOperatorDay extends RptOperatorDayKey {
    private String branchCode;

    private BigDecimal netKwh;

    private BigDecimal netAmt;

    private BigDecimal stampTax;

    private BigDecimal tvaAmt;

    private BigDecimal kwhAmt;

    private BigDecimal feeAmt;

    private BigDecimal feeTva;

    private BigDecimal fee1;

    private BigDecimal fee1Tva;

    private BigDecimal fee2;

    private BigDecimal fee2Tva;

    private BigDecimal fee3;

    private BigDecimal fee3Tva;

    private BigDecimal fee4;

    private BigDecimal fee4Tva;

    private BigDecimal fee5;

    private BigDecimal fee5Tva;

    private BigDecimal arrearAmt;

    private BigDecimal arrearTva;

    private Integer buyTimes;

    private String field1;

    private String field2;

    private Date udate;

    private String field3;

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public BigDecimal getNetKwh() {
        return netKwh;
    }

    public void setNetKwh(BigDecimal netKwh) {
        this.netKwh = netKwh;
    }

    public BigDecimal getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
    }

    public BigDecimal getStampTax() {
        return stampTax;
    }

    public void setStampTax(BigDecimal stampTax) {
        this.stampTax = stampTax;
    }

    public BigDecimal getTvaAmt() {
        return tvaAmt;
    }

    public void setTvaAmt(BigDecimal tvaAmt) {
        this.tvaAmt = tvaAmt;
    }

    public BigDecimal getKwhAmt() {
        return kwhAmt;
    }

    public void setKwhAmt(BigDecimal kwhAmt) {
        this.kwhAmt = kwhAmt;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public BigDecimal getFeeTva() {
        return feeTva;
    }

    public void setFeeTva(BigDecimal feeTva) {
        this.feeTva = feeTva;
    }

    public BigDecimal getFee1() {
        return fee1;
    }

    public void setFee1(BigDecimal fee1) {
        this.fee1 = fee1;
    }

    public BigDecimal getFee1Tva() {
        return fee1Tva;
    }

    public void setFee1Tva(BigDecimal fee1Tva) {
        this.fee1Tva = fee1Tva;
    }

    public BigDecimal getFee2() {
        return fee2;
    }

    public void setFee2(BigDecimal fee2) {
        this.fee2 = fee2;
    }

    public BigDecimal getFee2Tva() {
        return fee2Tva;
    }

    public void setFee2Tva(BigDecimal fee2Tva) {
        this.fee2Tva = fee2Tva;
    }

    public BigDecimal getFee3() {
        return fee3;
    }

    public void setFee3(BigDecimal fee3) {
        this.fee3 = fee3;
    }

    public BigDecimal getFee3Tva() {
        return fee3Tva;
    }

    public void setFee3Tva(BigDecimal fee3Tva) {
        this.fee3Tva = fee3Tva;
    }

    public BigDecimal getFee4() {
        return fee4;
    }

    public void setFee4(BigDecimal fee4) {
        this.fee4 = fee4;
    }

    public BigDecimal getFee4Tva() {
        return fee4Tva;
    }

    public void setFee4Tva(BigDecimal fee4Tva) {
        this.fee4Tva = fee4Tva;
    }

    public BigDecimal getFee5() {
        return fee5;
    }

    public void setFee5(BigDecimal fee5) {
        this.fee5 = fee5;
    }

    public BigDecimal getFee5Tva() {
        return fee5Tva;
    }

    public void setFee5Tva(BigDecimal fee5Tva) {
        this.fee5Tva = fee5Tva;
    }

    public BigDecimal getArrearAmt() {
        return arrearAmt;
    }

    public void setArrearAmt(BigDecimal arrearAmt) {
        this.arrearAmt = arrearAmt;
    }

    public BigDecimal getArrearTva() {
        return arrearTva;
    }

    public void setArrearTva(BigDecimal arrearTva) {
        this.arrearTva = arrearTva;
    }

    public Integer getBuyTimes() {
        return buyTimes;
    }

    public void setBuyTimes(Integer buyTimes) {
        this.buyTimes = buyTimes;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }
}
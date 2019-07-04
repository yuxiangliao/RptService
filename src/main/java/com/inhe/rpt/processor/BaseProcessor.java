package com.inhe.rpt.processor;

import com.inhe.rpt.exception.DateConvertException;

import java.util.ArrayList;
import java.util.Date;

public abstract class BaseProcessor {
    private Date dFrom;

    protected ArrayList<String> meterList;

    protected ArrayList<String> branchList;

    protected ArrayList<String> operatorList;

    public void processTask() throws InterruptedException, DateConvertException {}

    public Date getdFrom() {
        return dFrom;
    }

    public void setdFrom(Date dFrom) {
        this.dFrom = dFrom;
    }

}

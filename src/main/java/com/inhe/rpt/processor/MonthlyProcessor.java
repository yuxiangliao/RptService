package com.inhe.rpt.processor;

import com.inhe.rpt.common.DateUtil;
import com.inhe.rpt.exception.DateConvertException;
import com.inhe.rpt.service.RptMonthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MonthlyProcessor extends BaseProcessor{

    private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyProcessor.class);

    private Date lastDay;

    private final RptMonthService rptMonthService;

    @Value("${jade.supplyMonth}")
    private Integer supplyMonth;

    @Autowired
    public MonthlyProcessor(RptMonthService rptMonthService){
        this.rptMonthService = rptMonthService;
    }

    public void processTask() throws InterruptedException, DateConvertException {
        LOGGER.info("daily data start!");

        lastDay = DateUtil.rollByMonth(this.getdFrom(),supplyMonth);
        String sLastDay = DateUtil.dateToString(lastDay,DateUtil.DATE_WITHOUT_DAY);
        String sCurrDay = DateUtil.dateToString(this.getdFrom(),DateUtil.DATE_WITHOUT_DAY);
        this.getHandleList(sLastDay,sCurrDay);

        while (lastDay.getTime()<=this.getdFrom().getTime()){
            String dFrom = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITH_NOTHING);
            String dTo = DateUtil.dateToString(DateUtil.rollByMonth(lastDay,1),DateUtil.DATE_WITH_NOTHING);
            //如果日统计表不存在前30天的数据则计算前30天的日数据
            if(!this.meterList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITHOUT_DAY))) {
                rptMeterMonth(dFrom,dTo);
            }
            if(!this.branchList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITHOUT_DAY))){
                rptBranchMonth(dFrom,dTo);
            }
            if(!this.operatorList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITHOUT_DAY))){
                rptOperatorMonth(dFrom,dTo);
            }
            lastDay = DateUtil.rollByMonth(lastDay,1);
        }

        LOGGER.info("daily data end!");
    }


    public void rptMeterMonth(String dFrom,String dTo) throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITHOUT_DAY);
        this.rptMonthService.deleteMonthData("rpt_meter_month",dataPeriod);
        this.rptMonthService.insertRptMeterMonth(dFrom,dTo);
    }

    public void rptBranchMonth(String dFrom,String dTo) throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITHOUT_DAY);
        this.rptMonthService.deleteMonthData("rpt_branch_month",dataPeriod);
        this.rptMonthService.insertRptBranchMonth(dFrom,dTo);
    }

    public void rptOperatorMonth(String dFrom,String dTo) throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITHOUT_DAY);
        this.rptMonthService.deleteMonthData("rpt_operator_month",dataPeriod);
        this.rptMonthService.insertRptOperatorMonth(dFrom,dTo);
    }

    public void getHandleList(String dFrom,String dTo){
        this.meterList = this.rptMonthService.getLastMonth("rpt_meter_month",dFrom,dTo);
        this.branchList = this.rptMonthService.getLastMonth("rpt_branch_month",dFrom,dTo);
        this.operatorList = this.rptMonthService.getLastMonth("rpt_operator_month",dFrom,dTo);
    }
}

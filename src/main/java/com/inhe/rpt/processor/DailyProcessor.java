package com.inhe.rpt.processor;

import com.inhe.rpt.common.DateUtil;
import com.inhe.rpt.exception.DateConvertException;
import com.inhe.rpt.service.RptDayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DailyProcessor extends BaseProcessor{
    private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyProcessor.class);

    private Date lastDay;

    @Value("${jade.supplyDay}")
    private Integer supplyDay;

    public void processTask() throws InterruptedException, DateConvertException {
        LOGGER.info("daily data start!");

        lastDay = DateUtil.rollByDay(this.getdFrom(),supplyDay);
        String sLastDay = DateUtil.dateToString(lastDay,DateUtil.DATE_WITH_NOTHING);
        String sCurrDay = DateUtil.dateToString(this.getdFrom(),DateUtil.DATE_WITH_NOTHING);
        this.getHandleList(sLastDay,sCurrDay);

        while (lastDay.getTime()<=this.getdFrom().getTime()){
            //如果日统计表不存在前30天的数据则计算前30天的日数据
            if(!this.meterList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITH_NOTHING))) {
                rptMeterDay();
            }
            if(!this.branchList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITH_NOTHING))){
                rptBranchDay();
            }
            if(!this.operatorList.contains(DateUtil.dateToString(lastDay,DateUtil.DATE_WITH_NOTHING))){
                rptOperatorDay();
            }
            lastDay = DateUtil.rollByDay(lastDay,1);
        }

        LOGGER.info("daily data end!");
    }

    private final RptDayService rptDayService;

    public void rptMeterDay() throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITH_NOTHING);
        this.rptDayService.deleteDayData("rpt_meter_day",dataPeriod);
        this.rptDayService.insertRptMeterDay(lastDay,DateUtil.rollByDay(lastDay,1));
    }

    public void rptBranchDay() throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITH_NOTHING);
        this.rptDayService.deleteDayData("rpt_branch_day",dataPeriod);
        this.rptDayService.insertRptBranchDay(lastDay,DateUtil.rollByDay(lastDay,1));
    }

    public void rptOperatorDay() throws DateConvertException {
        String dataPeriod = DateUtil.dateToString(this.lastDay,DateUtil.DATE_WITH_NOTHING);
        this.rptDayService.deleteDayData("rpt_operator_day",dataPeriod);
        this.rptDayService.insertRptOperatorDay(lastDay,DateUtil.rollByDay(lastDay,1));
    }

    public void getHandleList(String dFrom,String dTo){
        this.meterList = this.rptDayService.getLastDay("rpt_meter_day",dFrom,dTo);
        this.branchList = this.rptDayService.getLastDay("rpt_branch_day",dFrom,dTo);
        this.operatorList = this.rptDayService.getLastDay("rpt_operator_day",dFrom,dTo);
    }

    @Autowired
    public DailyProcessor(RptDayService rptDayService) {
        this.rptDayService = rptDayService;
    }
}

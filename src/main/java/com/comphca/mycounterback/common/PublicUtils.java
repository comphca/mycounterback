package com.comphca.mycounterback.common;

import com.comphca.mycounterback.dao.CustInfoMppper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created by comphca
 * @Date 2022/3/19 21:52
 * @Description TODO
 */
@Component
public class PublicUtils {
    @Autowired
    private CustInfoMppper custInfoMppper;
    public String getRequestNo(){
        //申请编号当前日期8位数字+申请序列6位数字（不足位补0）：20220319000001
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String date = df.format(new Date());
        return date+String.format("%06d",custInfoMppper.getRequestNoSeq());
    }

}

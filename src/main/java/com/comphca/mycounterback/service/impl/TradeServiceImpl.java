package com.comphca.mycounterback.service.impl;

import com.comphca.mycounterback.common.PublicUtils;
import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.CustInfoMppper;
import com.comphca.mycounterback.dao.TradeMapper;
import com.comphca.mycounterback.pojo.CustInfo;
import com.comphca.mycounterback.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Created by comphca
 * @Date 2022/4/3 23:47
 * @Description TODO
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeMapper tradeMapper;
    @Autowired
    private CustInfoMppper custInfoMppper;

    @Autowired
    private PublicUtils publicUtils;
    @Override
    public ServerResponse allotService(String custno,String code,String direction,Long requestBalance) {
        /*获取申请编号*/
        String requestNo = publicUtils.getRequestNo();
        /*根据客户编号获取客户名称*/
        System.out.println("---------------");
        System.out.println(custno);
        System.out.println("---------------");
        CustInfo custInfo = custInfoMppper.getCustInfoByCustNo(custno);
        System.out.println(custInfo.toString());
        String customname = custInfo.getSCustName();
        String status = "0";
        String explain = "";

        int count = tradeMapper.insertTradeInfo(requestNo,custno,code,  customname,  direction,
                 requestBalance, status, explain);
        if (count > 0) {
            return ServerResponse.cerateBySuccessMessage("申购成功");

        }
        return ServerResponse.createByErrorMessage("申购失败");
    }
}

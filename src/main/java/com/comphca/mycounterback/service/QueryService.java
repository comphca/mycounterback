package com.comphca.mycounterback.service;

import com.comphca.mycounterback.common.ServerResponse;

/**
 * @Created by comphca
 * @Date 2022/4/4 15:24
 * @Description TODO
 */
public interface QueryService {
    ServerResponse queryCurrentDateTrade();

    ServerResponse queryHisTrade(String fundcode,String startdate, String enddate);

    ServerResponse quertFundMarketByCode(String code);
}

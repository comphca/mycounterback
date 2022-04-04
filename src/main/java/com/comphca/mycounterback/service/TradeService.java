package com.comphca.mycounterback.service;

import com.comphca.mycounterback.common.ServerResponse;

/**
 * @Created by comphca
 * @Date 2022/4/3 23:46
 * @Description TODO
 */

public interface TradeService {
    ServerResponse allotService(String custno,String code,String direction,Long requestBalance);
}

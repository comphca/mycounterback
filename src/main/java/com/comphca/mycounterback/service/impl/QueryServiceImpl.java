package com.comphca.mycounterback.service.impl;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.TradeMapper;
import com.comphca.mycounterback.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by comphca
 * @Date 2022/4/4 15:25
 * @Description TODO
 */
@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private TradeMapper tradeMapper;
    @Override
    public ServerResponse queryCurrentDateTrade() {
        return ServerResponse.createBySuccess(tradeMapper.selectCurrentDateTrade());
    }
}

package com.comphca.mycounterback.controller.front;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Created by comphca
 * @Date 2022/4/23 15:40
 * @Description TODO
 */
@RestController
public class FundMarketController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/dofundmarket")
    public ServerResponse doFundMarket(String code){
        return queryService.quertFundMarketByCode(code);
    }
}

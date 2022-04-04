package com.comphca.mycounterback.controller;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.service.QueryService;
import com.comphca.mycounterback.service.impl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by comphca
 * @Date 2022/4/4 15:19
 * @Description TODO
 */
@RestController
public class QueryController {
    @Autowired
    private QueryService queryService;

    @RequestMapping("/queryCurrentDateTrade")
    public ServerResponse queryCurrentDateTrade(){
        return queryService.queryCurrentDateTrade();
    }
}

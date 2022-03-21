package com.comphca.mycounterback.controller.front;

import com.comphca.mycounterback.cache.StockCache;
import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.service.CustService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by comphca
 * @Date 2022/3/20 22:46
 * @Description TODO
 */
@RestController
public class Allot {

    @Autowired
    private CustService custService;

    @Autowired
    private StockCache stockCache;

    @RequestMapping("/checkAcco")
    public ServerResponse checkAcco(String custno,String pwd){
        //交易的时候先判断
        System.out.println("111111");
        if (StringUtils.isAnyBlank(custno,pwd)){
            return ServerResponse.createByErrorMessage("客户编号和密码为空");
        }
        return custService.queryCustInfoBuyCustNoAndPwd(custno,pwd);
    }



    //终端输入框输入股票代码、简称的时候调用的接口
    @RequestMapping("/code")
    public ServerResponse sotckQuery(@RequestParam String key) {
        System.out.println("code controller");
        return stockCache.getStock(key);
    }
}

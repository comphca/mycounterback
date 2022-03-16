package com.comphca.mycounterback.dao;

import com.comphca.mycounterback.pojo.CustInfo;
import org.springframework.stereotype.Repository;


/**
 * @Created by comphca
 * @Date 2022/3/5 19:31
 * @Description TODO
 */
@Repository
public interface CustInfoMppper {
    CustInfo getCustInfoByTradeAcco(String sTradeAcco);
}

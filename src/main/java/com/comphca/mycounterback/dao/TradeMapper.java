package com.comphca.mycounterback.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Created by comphca
 * @Date 2022/4/3 23:49
 * @Description TODO
 */
@Repository
public interface TradeMapper {
    int insertTradeInfo(@Param("requestno") String requestno, @Param("custno") String custno, @Param("code") String code,
                        @Param("customname") String customname, @Param("direction") String direction,
                        @Param("requestBalance") Long requestBalance,
                        @Param("status") String status, @Param("explain") String explain);

    String getTradeInfo(String sCustNo);
}



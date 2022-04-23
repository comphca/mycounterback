package com.comphca.mycounterback.dao;

import com.comphca.mycounterback.vo.TradeInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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


    /*查询当日委托数据*/
    List<TradeInfoVo> selectCurrentDateTrade();

    List<TradeInfoVo> queryHisTrade(@Param("fundcode") String fundcode, @Param("begindate") String begindate, @Param("enddate") String enddate);

    List<Map<String,Float>> queryFundMarket(String code);
}



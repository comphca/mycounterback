package com.comphca.mycounterback.vo;

import lombok.*;

/**
 * @Created by comphca
 * @Date 2022/4/4 15:29
 * @Description TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeInfoVo {
    private String sTradeDate;
    private String sFundCode;
    private String sFundName;
    private Long enBalance;
    private String sDirection;
    private String sStatus;
}

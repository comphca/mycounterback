package com.comphca.mycounterback.pojo;

import lombok.*;

/**
 * @Created by comphca
 * @Date 2022/4/3 23:54
 * @Description TODO
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeInfo {
    private String custno;
    private String custName;
    private String code;
    private String direction;

    private Long requestBalance;
    private Long requestShare;
    private String status;

    private String requestDate;
    private String requestTime;
    private String explain;


}

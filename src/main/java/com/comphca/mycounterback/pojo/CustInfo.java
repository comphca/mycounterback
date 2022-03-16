package com.comphca.mycounterback.pojo;

import lombok.*;

/**
 * @Created by comphca
 * @Date 2022/3/5 19:31
 * @Description TODO
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustInfo {
    private String sCustNo;
    private String sCustName;
    private String cIdentityType;
    private String sIdentityNo;
    private String sBirthDay;
    private String sTradeAcco;
    private String sBankAcco;
    private String sBankName;
    private String sNameInBank;
    private String sMobilePhone;
    private String sEmail;
    private String sAddress;
    private String sDealPwd;
    private String sOpenDate;
}

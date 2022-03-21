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
@NoArgsConstructor
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
    private long balance;


    public CustInfo(String sCustNo, String sCustName, String cIdentityType, String sIdentityNo, String sBirthDay,
                    String sBankAcco, String sBankName, String sNameInBank, String sMobilePhone, String sEmail,
                    String sAddress, String sDealPwd){
        this.sCustNo = sCustNo;
        this.sCustName = sCustName;
        this.cIdentityType = cIdentityType;
        this.sIdentityNo = sIdentityNo;
        this.sBirthDay = sBirthDay;
        this.sBankAcco = sBankAcco;
        this.sBankName = sBankName;
        this.sNameInBank = sNameInBank;
        this.sMobilePhone = sMobilePhone;
        this.sEmail = sEmail;
        this.sAddress = sAddress;
        this.sDealPwd = sDealPwd;
    }

    public CustInfo(String sCustNo, Long balance,String sCustName){
        this.sCustNo = sCustNo;
        this.balance = balance;
        this.sCustName = sCustName;
    }
}

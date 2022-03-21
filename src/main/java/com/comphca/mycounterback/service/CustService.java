package com.comphca.mycounterback.service;

import com.comphca.mycounterback.common.ServerResponse;

/**
 * @Created by comphca
 * @Date 2022/3/16 23:01
 * @Description TODO
 */
public interface CustService {
    ServerResponse newFundAcco(String custName, String sIdentityType, String sIdentityNo, String vaildate
            , String namaInBank, String bankname, String bankacco
            , String mobilphone, String address, String email);

    ServerResponse InsertCustInfo(String custNo,String pwd);

    ServerResponse queryCustInfoBuyCustNoAndPwd(String custno, String pwd);
}

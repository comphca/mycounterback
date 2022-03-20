package com.comphca.mycounterback.dao;

import com.comphca.mycounterback.pojo.CustInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @Created by comphca
 * @Date 2022/3/5 19:31
 * @Description TODO
 */
@Repository
public interface CustInfoMppper {
    CustInfo getCustInfoByTradeAcco(String sTradeAcco);

    int isExistInByIdTypeAndIdNo(@Param("sIdentityType") String sIdentityType, @Param("sIdentityNo") String sIdentityNo);

    //序列test
    int getCustNoSeq();
    int getRequestNoSeq();


    int InsertAccoRequest(@Param("requestno") String requestNo,@Param("sCustno") String sCustno,
                           @Param("requestData") String requestData,
                           @Param("custName") String custName, @Param("sIdentityType") String sIdentityType,
                           @Param("sIdentityNo") String sIdentityNo, @Param("vaildate") String vaildate,
                           @Param("namaInBank") String namaInBank, @Param("bankname") String bankname,
                           @Param("bankacco") String bankacco, @Param("mobilphone") String mobilphone,
                           @Param("address") String address, @Param("email") String email);


    CustInfo getCustInfoByCustNoFormAccoRequest(String custNo);

    int insertCustInfo(CustInfo custInfo);

    int updateAccoRequestPwdByCustNo(@Param("custNo") String custNo, @Param("pwd") String pwd);

    void deleteFromAccoRequestByCustNo(String custNo);
}

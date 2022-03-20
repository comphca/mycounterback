package com.comphca.mycounterback.controller.front;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.CustInfoMppper;
import com.comphca.mycounterback.service.CustService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by comphca
 * @Date 2022/3/5 17:19
 * @Description TODO
 */
@RestController
public class OpenFundAcco {
    @Autowired
    private CustInfoMppper custInfoMppper;

    @Autowired
    private CustService custService;

    /*
    * IDType : this.IDType,
        custName : this.custname,
        identityno : this.identityno,
        vaildate : this.vaildate
        *
        *
        * namainbank : this.namainbank,//银行户名
        bankname : this.bankname,//银行名称
        bankacco : this.bankacco,//银行账号


        //联系信息
        mobilphone : this.mobilphone,//联系电话
        address : this.address,//地址
        email : this.email//邮箱
    * */
    @RequestMapping("/doOpenFundAcco")
    public ServerResponse doOpenFundAcco(String custNo,String custName,String IDType, String identityno, String vaildate
                                        ,@RequestParam("namainbank") String namaInBank, String bankname, String bankacco
                                        ,String mobilphone, String address, String email){

        System.out.println(IDType+"---"+custName+"----"+identityno+"-----"+vaildate+"---"+namaInBank+"--"+bankname+"--"+bankacco+"--"+mobilphone
        +"---"+address+"---"+email);


        //直接调用开户service
        return custService.newFundAcco( custName, IDType,  identityno,  vaildate
                , namaInBank,  bankname,  bankacco
                , mobilphone,  address,  email);


    }

    @RequestMapping("/doInsertCustinfo")
    public ServerResponse doInsertCustinfo(String custNo,String pwd){
        if (StringUtils.isAnyBlank(custNo,pwd)){
            return ServerResponse.createByErrorMessage("客户编号或者密码为空");
        }
        return custService.InsertCustInfo(custNo,pwd);
    }







    @RequestMapping("/test")
    public ServerResponse test(String pwd){
        System.out.println(pwd);
        int custno = custInfoMppper.getCustNoSeq();
        System.out.println(custno);
        return null;
    }


}

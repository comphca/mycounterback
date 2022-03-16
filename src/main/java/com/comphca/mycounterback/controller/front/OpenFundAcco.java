package com.comphca.mycounterback.controller.front;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.CustInfoMppper;
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
    public ServerResponse doOpenFundAcco(String custName,String IDType, String identityno, String vaildate
                                        ,@RequestParam("namainbank") String namaInBank, String bankname, String bankacco
                                        ,String mobilphone, String address, String email){

        System.out.println(IDType+"---"+custName+"----"+identityno+"-----"+vaildate+"---"+namaInBank+"--"+bankname+"--"+bankacco+"--"+mobilphone
        +"---"+address+"---"+email);

        //通过证件号码和证件类别判断是否已经开过户

        return null;
    }


}

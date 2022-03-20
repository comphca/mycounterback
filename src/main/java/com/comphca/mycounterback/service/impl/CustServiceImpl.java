package com.comphca.mycounterback.service.impl;

import com.comphca.mycounterback.common.PublicUtils;
import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.CustInfoMppper;
import com.comphca.mycounterback.pojo.CustInfo;
import com.comphca.mycounterback.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by comphca
 * @Date 2022/3/16 23:01
 * @Description TODO
 */
@Service
public class CustServiceImpl implements CustService {

    @Autowired
    private CustInfoMppper custInfoMppper;

    @Autowired
    private PublicUtils publicUtils;


    @Override
    public ServerResponse newFundAcco(String custName, String sIdentityType, String sIdentityNo, String vaildate
            , String namaInBank, String bankname, String bankacco
            , String mobilphone, String address, String email) {
        int count = 0;
        //判断该证件类型的证件号码是否已经开户
        count = custInfoMppper.isExistInByIdTypeAndIdNo(sIdentityType,sIdentityNo);
        System.out.println("检查是否存在已有的用户"+count);
        if (count > 0){
            return ServerResponse.createByErrorMessage("该类型的证件号码已开户");
        }

        //生成一个客户编号,客户编号通过一个模拟序列获取
        String sCustno = String.valueOf(generatorCustNo());

        //获取申请编号
        String requestNo = publicUtils.getRequestNo();
        //通过申请编号截取前面8位的申请日期
        String requestData = requestNo.substring(0,8);


        System.out.println(custName+"-------------");

        //插入数据到账户申请表
        count = custInfoMppper.InsertAccoRequest(requestNo,sCustno,requestData,custName, sIdentityType,
                sIdentityNo,  vaildate,  namaInBank,  bankname,  bankacco
                ,  mobilphone,  address,  email);

        if (count == 0){
            return ServerResponse.createByErrorMessage("插入账户申请表失败");
        }


        /*
        * 第一次申请过来先存申请表，前端设置交易密码之后再存客户信息表
        * */
        return ServerResponse.createBySuccess(sCustno);





    }

    /*
    * 校验完毕再账户申请表中已经存在记录，加上这次用户输入的密码插入到客户信息表中
    * */
    @Override
    public ServerResponse InsertCustInfo(String custNo, String pwd) {
        int count = 0;
        //先把密码更新到申请表中
        count = custInfoMppper.updateAccoRequestPwdByCustNo(custNo,pwd);
        if (count == 0){
            custInfoMppper.deleteFromAccoRequestByCustNo(custNo);
            return ServerResponse.createByErrorMessage("更新申请表密码失败");
        }

        CustInfo custInfo = custInfoMppper.getCustInfoByCustNoFormAccoRequest(custNo);

        count = custInfoMppper.insertCustInfo(custInfo);
        if (count == 0){
            /*
            * 数据插入客户信息表异常，需要把申请表中对应的数据删除
            * */
            custInfoMppper.deleteFromAccoRequestByCustNo(custNo);
        }
        return ServerResponse.cerateBySuccessMessage("开户成功");
    }


    public int generatorCustNo(){
        return custInfoMppper.getCustNoSeq();
    }


}

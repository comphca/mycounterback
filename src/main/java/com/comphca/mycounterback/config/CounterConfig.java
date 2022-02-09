package com.comphca.mycounterback.config;


import io.vertx.core.Vertx;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Created by comphca
 * @Date 2021/10/17 15:58
 * @Description TODO
 */

@Getter
@Component
@Log4j2
public class CounterConfig {
    //配置读取yml中的值

    ///////////会员号///////////
    @Value("${counter.id}")
    private short id;

    /////////////////////UUID 相关配置////////////////////////////////
    @Value("${counter.dataCenterId}")
    private long dataCenterId;

    @Value("${counter.workerId}")
    private long workerId;
/////////////////////////////////////////////////////

    /////////////编码相关///////
    //这种直接new出来也能用但是不能体现定义了这两个接口的优势
//    private ICheckSum cs = new ByteCheckSum();
//
//    private IBodyCodec bodyCodec = new BodyCodec();
   /* @Value("${counter.checksum}")
    private String checkSumClass;

    @Value("${counter.bodycodec}")
    private String bodyCodecClass;

    @Value("${counter.msgdecodec}")
    private String msgCodecClass;

    private ICheckSum cs;

    private IBodyCodec bodyCodec;

    private IMsgCodec msgCodec;

    @Value("${counter.gatewayid}")
    private short Gatewayid;

    private Vertx vertx = Vertx.vertx();

    @PostConstruct
    private void init(){
        Class<?> clz;

        try {
            clz = Class.forName(checkSumClass);
            cs = (ICheckSum) clz.getDeclaredConstructor().newInstance();

            clz = Class.forName(bodyCodecClass);
            bodyCodec = (IBodyCodec) clz.getDeclaredConstructor().newInstance();


            clz = Class.forName(msgCodecClass);
            msgCodec = (IMsgCodec) clz.getDeclaredConstructor().newInstance();

        }catch (Exception e){
            log.error("init config error");
        }
    }

    @Value("${counter.sendip}")
    private String sendip;

    @Value("${counter.sendport}")
    private int sendport;*/
}

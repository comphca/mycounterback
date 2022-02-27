package com.comphca.mycounterback;

import com.comphca.mycounterback.config.CounterConfig;
import com.comphca.mycounterback.utils.myuuid;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.comphca.mycounterback.dao")
public class MycounterbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycounterbackApplication.class, args);
    }


    @Autowired
    private CounterConfig counterConfig;

    @PostConstruct
    private void init(){
        System.out.println("*************************glj***********************");
        myuuid.getInstance().init(counterConfig.getDataCenterId(),
                counterConfig.getWorkerId());

    }

}

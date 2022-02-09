package com.comphca.mycounterback.utils;

import com.comphca.mycounterback.utils.SnowflakeIdWorker;

/**
 * @Created by comphca
 * @Date 2021/10/17 15:57
 * @Description TODO
 */
public class myuuid {
    private static myuuid ourInstance = new myuuid();

    public static myuuid getInstance() {
        return ourInstance;
    }

    private myuuid() {
    }

    public void init(long centerId, long workerId) {
        idWorker = new SnowflakeIdWorker(workerId, centerId);
    }

    private SnowflakeIdWorker idWorker;

    public long getUUID() {
        return idWorker.nextId();
    }


    public static void main(String[] args) {
        System.out.println(myuuid.getInstance().getUUID());
    }
}

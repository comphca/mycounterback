package com.comphca.mycounterback.cache.dictionary;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.DictionaryMppper;
import com.google.common.collect.HashMultimap;
import javafx.util.converter.ShortStringConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.krb5.internal.KDCRep;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Created by comphca
 * @Date 2022/3/5 19:25
 * @Description 初始化的时候需要把系统中的字典项缓存起来，前台用到这类控件的时候就直接从缓存中取
 */

@Component
@Slf4j
public class IDTypeCache {
    @Autowired
    private DictionaryMppper dictionaryMppper;

    private HashMultimap<String,String> dictionaryMultiMap = HashMultimap.create();
    private List<Map<String,String>> res;

    private List<Map<String,String>> res1 = new ArrayList<>();

    Map<String,List<Map<String,String>>> dicVo = new HashMap<String,List<Map<String,String>>>();

    /*
    * 提供给controller使用触发检索
    * */
    public ServerResponse getDictionary (String key){
//        class dicVO{
//            private String keytValue;
//            private String describe;
//
//            public dicVO(String keytValue, String describe) {
//                this.keytValue = keytValue;
//                this.describe = describe;
//            }
//        }
        log.info("后台缓存获取字典项信息");



        return ServerResponse.createBySuccess(dicVo.get(key));
    };


    @PostConstruct
    private void createDictionMap(){
        log.info("load dictionary from db");
        log.info("check dictionaryno from db");
        //获取到字典表中所有字典项，通过字典项，全部读到内存中
        List<String> list = dictionaryMppper.getDictionaryNoList();

        for (int i = 0; i < list.size(); i++) {
            res = dictionaryMppper.getDictionaryInfoByNo(list.get(i));
            for (int j = 0; j < res.size(); j++){
                res1.add(res.get(j));
            }
        }

        //数据库中字典项全部加载到res1内存中之后，需要对字典项进行分片，前台传一个字典编号就可以获取对应编号的字典全部值

        //获取所有字典项，去重
        Set<String> dicNo = dictionaryMppper.getAllDicNoDistinct();
//        Map<String,List<Map<String,String>>> dicVo = new HashMap<String,List<Map<String,String>>>();

        Iterator iterator = dicNo.iterator();
        while (iterator.hasNext()){
            dicVo.put((String) iterator.next(),new ArrayList<>());
        }

        for (Map<String,String> map : res1){
            String s = map.get("L_KEYNO");
            List<Map<String,String>> tmplist = dicVo.get(s);
            tmplist.add(map);
            dicVo.put(s,tmplist);
        }

        System.out.println(dicVo);



//        res = dictionaryMppper.getDictionaryInfoByNo("1001");
//        for (Map<String, String> r: res) {
//            Iterator<String> iter = r.keySet().iterator();
//            while(iter.hasNext()){
//                String key=iter.next();
//                log.info(key);
//                log.info(r.get(key));
//            }
//        }
        System.out.println("11111");
    }
}

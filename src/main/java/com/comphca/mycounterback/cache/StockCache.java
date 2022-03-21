package com.comphca.mycounterback.cache;


import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.StockMapper;
import com.comphca.mycounterback.pojo.Stock;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Created by comphca
 * @Date 2021/11/15 21:16
 * @Description 在项目启动的时候缓存股票名称、代码到一个集合中，通过倒排列表，快速相应前端输入时的一个相关提示
 * 例如：平安银行  600025   payh
 *      前端在输入6...   或者 p.. 的时候提示框就会开始提示平安银行
 */

@Component
@Slf4j
public class StockCache {
    @Autowired
    private StockMapper stockMapper;


    private HashMultimap<String, Stock> stockinfoHashMultimap = HashMultimap.create();

    public ServerResponse getStock (String key){
        log.info("后台获取倒排列表的股票信息："+stockinfoHashMultimap.get(key).toString());
        return ServerResponse.createBySuccess(stockinfoHashMultimap.get(key));
    }

    @PostConstruct
    private void createInvertIndex() {

        log.info("load stock from db");
        long st = System.currentTimeMillis();

        //1.加载股票数据
        //存放的数据格式时{{code:**,abbrName:**,name:**}，{code:**,abbrName:**,name:**}，{code:**,abbrName:**,name:**}}
        List<Map<String, Object>> res = stockMapper.getAllStockInfo();

        log.info("------------------------start------------------------");
        for (Map<String, Object> r: res) {
            Iterator<String> iter = r.keySet().iterator();
            while(iter.hasNext()){
                String key=iter.next();
                log.info(key);
            }
        }
        log.info("------------------------end------------------------");

        if (CollectionUtils.isEmpty(res)) {
            log.error("no stock find in db");
            return;
        }
        //2.建立倒排索引
        for (Map<String, Object> r : res) {
            log.info(r.toString());
            String code = String.valueOf(r.get("vc_code"));//Integer.parseInt(r.get("code").toString());
            String name = r.get("vc_fundname").toString();
            String abbrname = r.get("vc_abbrName").toString();
            Stock stock = new Stock(code, name, abbrname);
            //  000001 平安银行 payh
            List<String> codeMetas = splitData
                    (String.format("%06d", Integer.parseInt(code)));
            List<String> abbrNameMetas = splitData
                    (abbrname);
            codeMetas.addAll(abbrNameMetas);

            for (String key : codeMetas) {
                //限制索引数据列表长度
                Collection<Stock> stockInfos = stockinfoHashMultimap.get(key);
                if (!CollectionUtils.isEmpty(stockInfos)
                        && stockInfos.size() > 10) {
                    continue;
                }
                stockinfoHashMultimap.put(key, stock);
            }
        }
        log.info("load stock finish,take :" +
                (System.currentTimeMillis() - st) + "ms");
    }

    private List<String> splitData(String code) {
        // payh -->
        // p pa pay payh
        // a ay ayh
        // y yh
        // h
        List<String> list = Lists.newArrayList();
        int outLength = code.length();
        for (int i = 0; i < outLength; i++) {
            int inLength = outLength + 1;
            for (int j = i + 1; j < inLength; j++) {
                list.add(code.substring(i, j));
            }
        }
        return list;
    }
}

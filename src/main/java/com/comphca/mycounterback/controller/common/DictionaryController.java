package com.comphca.mycounterback.controller.common;

import com.comphca.mycounterback.cache.dictionary.IDTypeCache;
import com.comphca.mycounterback.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by comphca
 * @Date 2022/3/8 0:30
 * @Description TODO
 */
@RestController
@RequestMapping("/dic")
public class DictionaryController {

    @Autowired
    private IDTypeCache idTypeCache;

    @RequestMapping("/queryDic")
    public ServerResponse queryDic(String dicItem){
        return idTypeCache.getDictionary(dicItem);
    }
}

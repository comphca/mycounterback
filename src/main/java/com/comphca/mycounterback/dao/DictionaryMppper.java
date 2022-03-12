package com.comphca.mycounterback.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Created by comphca
 * @Date 2022/3/5 19:31
 * @Description TODO
 */
@Repository
public interface DictionaryMppper {
    List<Map<String,String>> getDictionaryInfoByNo(String DictionaryNo);

    List<String> getDictionaryNoList();

    Set<String> getAllDicNoDistinct();
}

package com.comphca.mycounterback.pojo;

import lombok.*;

/**
 * @Created by comphca
 * @Date 2022/3/5 19:31
 * @Description TODO
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Dictionary {
    private String sKeyValue;
    private String sKeyItem;
    private String sDescribe;
    private String sMemo;
}

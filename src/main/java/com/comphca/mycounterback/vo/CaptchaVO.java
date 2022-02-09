package com.comphca.mycounterback.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Created by comphca
 * @Date 2021/10/17 16:06
 * @Description TODO
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CaptchaVO {

    private String id;

    private String imageBase64;

}

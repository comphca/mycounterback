package com.comphca.mycounterback.controller;

import com.comphca.mycounterback.cache.CacheType;
import com.comphca.mycounterback.cache.RedisStringCache;
import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.vo.CaptchaVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import com.comphca.mycounterback.utils.CaptchaUtils;
import com.comphca.mycounterback.utils.myuuid;

/**
 * @Created by comphca
 * @Date 2022/1/29 13:26
 * @Description TODO
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /***********************获取验证码***************************/
    @RequestMapping("/captcha")
    public ServerResponse Captcha(){
        System.out.println("glj");
        //1.生成验证码  120 40 4个字符，一些线条和干扰点
        //2.验证码放到redis，实际放的是验证码的id  <id,验证码数值>
        //3.使用base64编码图片，将生成的验证码返回给前台
        CaptchaUtils captcha = new CaptchaUtils(120,40,4,10);
        //2
        System.out.println("glj1");
        System.out.println("myuuid.getInstance().getUUID()"+myuuid.getInstance().getUUID());
        String uuid = String.valueOf(myuuid.getInstance().getUUID());
        System.out.println("glj1");
        RedisStringCache.cache(uuid,captcha.getCode(), CacheType.CAPTCHA);

        //3
        CaptchaVO captchaVO = null;
        try {
            captchaVO = new CaptchaVO(uuid,captcha.getBase64ByteStr());
        } catch (IOException e) {
            e.printStackTrace();
        }



        return ServerResponse.cerateBySuccess("成功返回验证码",captcha);
    }
}

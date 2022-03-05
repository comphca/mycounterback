package com.comphca.mycounterback.service;

import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.pojo.User;

/**
 * @Created by comphca
 * @Date 2022/2/28 0:36
 * @Description TODO
 */
public interface UserService {
    ServerResponse<User> login(long uid, String password, String captcha, String captchaId);

    //根据uid来更新操作员登录的时间
    void updatLoginDate(long uid);
}

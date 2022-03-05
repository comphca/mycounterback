package com.comphca.mycounterback.service.impl;

import com.comphca.mycounterback.cache.CacheType;
import com.comphca.mycounterback.cache.RedisStringCache;
import com.comphca.mycounterback.common.ServerResponse;
import com.comphca.mycounterback.dao.UserMapper;
import com.comphca.mycounterback.pojo.User;
import com.comphca.mycounterback.service.UserService;
import com.comphca.mycounterback.utils.JsonUtils;
import com.comphca.mycounterback.utils.myuuid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by comphca
 * @Date 2022/2/28 0:37
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(long uid, String password, String captcha, String captchaId) {
        /*
        * 1.先校验用户名和密码为空的情况直接拦截
        * 2.判断验证码：a.从缓存中获取验证码，没有超时；b.校验验证码
        * */
        if (StringUtils.isAnyBlank(String.valueOf(uid),password)){
            return ServerResponse.createByErrorMessage("用户名或密码为空");
        }

        //校验验证码
        String captchaCache = RedisStringCache.get(captchaId, CacheType.CAPTCHA);
        if (StringUtils.isEmpty(captchaCache)){
            return ServerResponse.createByErrorMessage("缓存的验证码超时");
        }
        if (!StringUtils.equalsIgnoreCase(captcha,captchaCache)){
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        //检查完验证码从缓存中清空验证码
        RedisStringCache.remove(captchaId,CacheType.CAPTCHA);
        //查询数据库判断
        User user = userMapper.selectUserByIdAndPwd(uid,password);
        if (user == null){
            System.out.println("没有查到对应的用户");
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        else {
            //校验成功
            //1.先生成一个uuid唯一标志
            user.setToken(String.valueOf(myuuid.getInstance().getUUID()));
            //2.id放入缓存
            //这里放入缓存的需要放整个对象，后面通过json进行序列化和反序列化
            RedisStringCache.cache(user.getToken(), JsonUtils.obj2String(user),CacheType.ACCOUNT);
            //3.更新登录时间
            updatLoginDate(uid);
        }

        return ServerResponse.cerateBySuccess("登录成功",user);
    }

    @Override
    public void updatLoginDate(long uid) {
        userMapper.updateLoginDate(uid);
    }
}

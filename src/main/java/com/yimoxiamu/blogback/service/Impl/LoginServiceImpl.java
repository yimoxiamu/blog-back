package com.yimoxiamu.blogback.service.Impl;

import com.yimoxiamu.blogback.dao.UserMapper;
import com.yimoxiamu.blogback.entity.User;
import com.yimoxiamu.blogback.service.LoginService;
import com.yimoxiamu.blogback.tools.CodeMsg;
import com.yimoxiamu.blogback.tools.Result;
import com.yimoxiamu.blogback.util.DateUtil;
import com.yimoxiamu.blogback.util.StringUtils;
import com.yimoxiamu.blogback.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public Result<String> doRegist(User user) {
        User retUser = userMapper.selectByUserName(user.getUser_name());
        if(retUser != null){
            return Result.error(CodeMsg.USER_IS_HAS);
        }else{
            userMapper.insertSelective(user);
            return Result.success("注册成功！");
        }
    }

    @Override
    public Result<Map<String, String>> doLogin(User user) {
        User retUsr = userMapper.selectByUserName(user.getUser_name());
        if(retUsr.getPass_word().equals(user.getPass_word())){
            Map<String,Object> jwtMap = new HashMap<>(16);
            jwtMap.put("userName",retUsr.getUser_name());
            jwtMap.put("userId",retUsr.getId());
            String token = TokenUtil.getJWTString(String.valueOf(retUsr.getId()),jwtMap);
            Map<String,String> tokenData = new HashMap<>(16);
            tokenData.put("token",token);
            tokenData.put("time",DateUtil.getTokenExpireTime());
            return Result.success(tokenData);
        }else{
            log.info("===================账号密码验证失败===================");
            return Result.error(CodeMsg.PASS_WORD_ERROR);
        }
    }
}

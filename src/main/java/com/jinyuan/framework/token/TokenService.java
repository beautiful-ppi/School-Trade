package com.jinyuan.framework.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jinyuan.framework.redis.RedisCache;
import com.jinyuan.project.domain.TManager;
import com.jinyuan.project.domain.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * @author Aaron
 * @description : tokenService
 * @Date 2020/6/1
 */
@Service
public class TokenService {
    @Autowired
    RedisCache redisCache;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;
    /*
     * @Author: Aaron
     * @Param:
     * @Description: 管理员登录token
     *
     * @Date: 13:39 2020/6/1
     **/
    private static final Logger log= LoggerFactory.getLogger(TokenService.class);


    @Cacheable(value = "managerToken",keyGenerator = "TokenkeyGenerator")
    public String getTokenManager(TManager tManager) {
        String token= JWT.create().withExpiresAt(new Date(System.currentTimeMillis()+60*60)).withAudience(tManager.get_id().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(tManager.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

    /*
     * @Author: Aaron
     * @Param:
     * @Description: 删除redis中的token
     * @Return:
     * @Date: 1:11 2020/6/4
     **/
    public boolean deleteToken(String token){

        Set<String> keys= stringRedisTemplate.keys("managerToken::com.jinyuan.framework.token.TokenServicegetTokenManager:com.jinyuan.project.domain.TManager*");
        String uToken=stringRedisTemplate.opsForValue().get("userToken");

        for (String key:keys){

            String mToken= String.valueOf(redisTemplate.opsForValue().get(key));


            if (token.equals(mToken)) {
                if (stringRedisTemplate.delete(key)){
                    return true;
                }
            }
        }

        return false;
    }

    /*
     * @Author: Aaron
     * @Param:
     * @Description: 验证登录Token
     * @return
     * @Date: 23:08 2020/6/1
     **/
    public boolean verifyManagerToken(String token){
        Set<String> keys= stringRedisTemplate.keys("managerToken::com.jinyuan.framework.token.TokenServicegetTokenManager:com.jinyuan.project.domain.TManager*");
        for (String key:keys){
            String mToken= String.valueOf(redisTemplate.opsForValue().get(key));
            if (token.equals(mToken)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyUserToken(String token){
        Set<String> keys= stringRedisTemplate.keys("managerToken::com.jinyuan.framework.token.TokenServicegetTokenManager:com.jinyuan.project.domain.TManager*");
        for (String key:keys){
            String mToken= String.valueOf(redisTemplate.opsForValue().get(key));
            if (token.equals(mToken)) {
                return true;
            }
        }
        return false;
    }


    /*
     * @Author: Aaron
     * @Param:
     * @Description: 用户登录token
     *
     * @Date: 13:43 2020/6/1
     **/
    @Cacheable(value = "userToken",keyGenerator = "TokenkeyGenerator")
    public String getTokenUser(TUser tUser) {
        String token="";
        token= JWT.create().withAudience(tUser.get_id().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(tUser.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }

}

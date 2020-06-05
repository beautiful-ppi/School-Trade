package com.jinyuan.framework.interceptor;


import com.jinyuan.framework.annotation.ManagerLogin;
import com.jinyuan.framework.annotation.PassToken;
import com.jinyuan.framework.token.TokenService;
import com.jinyuan.project.service.impl.TManegerServiceImpl;
import com.jinyuan.project.service.impl.TUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * @author Aaron
 * @description :
 * @Date 2020/6/1
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    TokenService tokenService;
    @Autowired
    TManegerServiceImpl tManegerService;
    @Autowired
    TUserServiceImpl tUserService;

    private static final Logger log= LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要管理员权限的注解
        if (method.isAnnotationPresent(ManagerLogin.class)) {
            ManagerLogin managerLogin = method.getAnnotation(ManagerLogin.class);
            if (managerLogin.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录！");
                }

                if (!tokenService.verifyToken(token)) {
                    throw new RuntimeException("token验证错误！");
                }
                return true;
            }
        }
        return true;
    }
        //检查有没有需要用户权限的注解
        /*if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                TUser user = tUserService.selectUserByAccountAndPassword(userId);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }
        return true;
    }*/

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

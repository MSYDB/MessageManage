package com.db.message.interceptor;

import com.db.message.anno.AuthString;
import com.db.message.common.context.QcbyContext;
import com.db.message.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author DB
 * @title: LoginInterceptor
 * @projectName message
 * @description: TODO
 * @date 2022/2/28  16:46
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录拦截：
        /**
         * 如果不是controller的方法则不拦截
         */
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        String token = request.getHeader("token");

        /**
         * 如果没有找到用户信息则进行拦截
         */
        if (QcbyContext.getUser(token) == null){
            log.info("验证失败");
            return false;
        }


        //权限验证
        SysUser user = QcbyContext.getUser(token);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AuthString authString = handlerMethod.getMethodAnnotation(AuthString.class);


        /**
         * 空权限字符串不拦截
         */
        if (authString == null){
            log.info("验证通过");
                return true;
        }

        /**
         * 若用户的权限没有此方法， 那么拦截
         * 使用user.getAuthList()获取用户所拥有的权限
         */
        if (!user.getAuthList().contains(authString.value())) {
            log.info("您无权限");
            return false;
        }

        log.info("验证通过");
        return true;
    }
}

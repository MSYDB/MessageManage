package com.db.message.config;

import com.db.message.interceptor.LoginInterceptor;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.format.DateTimeFormatter;

/**
 * @author DB
 * @title: MvcConfig
 * @projectName message
 * @description: mvc配置类
 * @date 2022/2/28  15:49
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册自定义拦截器
        registry.addInterceptor(loginInterceptor())
                //定拦截哪些路径，/**代表所有
                .addPathPatterns("/**")
                //哪些路径不拦截
                .excludePathPatterns();
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer(){
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

    //允许跨域
    @Override
    public void addCorsMappings(CorsRegistry registry){
        //允许跨域访问资源定位：所有资源
        registry.addMapping("/**")
                //只允许本地的指定端口号跨域访问
                .allowedOrigins("http://localhost:8081")
                //允许发送凭证，前端如果配置改属性为true之后，则必须同步配置
                .allowCredentials(true)
                //允许所有方法
                .allowedMethods("*");
    }
}

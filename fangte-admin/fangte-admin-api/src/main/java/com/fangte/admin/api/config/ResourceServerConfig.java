package com.fangte.admin.api.config;
/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.config
 * @ClassName: ResourceServerConfig
 * @Author: xuchao
 * @Description: **
 * @Date: 2020/1/7 22:41
 * @Version: 1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:41
 * @updateDate 2020/1/7 22:41     
 * @version 1.0
 **/
@Slf4j
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        log.info("加载了 >> ResourceServerConfig...");
        http
                //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
                .headers()
                .frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,
                        "/upload/**",
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/v2/api-docs/**")
                .permitAll()

                .antMatchers("/actuator/**", "/user/info/*", "/storage/local/upload")
                .permitAll()

                .anyRequest()
                .authenticated()

                .and()
                .csrf().disable();
    }
}

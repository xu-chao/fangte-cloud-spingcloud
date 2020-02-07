package com.fangte.admin.api.annotation;
/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.annotation
 * @ClassName: EnableResourceServer
 * @Author: xuchao
 * @Description: **
 * @Date: 2020/1/7 22:40
 * @Version: 1.0
 */

import com.fangte.admin.api.config.ResourceServerConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.lang.annotation.*;

/**
  * 参数 null
  * @author xuchao
  * @description
  * 扩展资源服务注解
  * @Inherited 该注解阐述被标记的类型是被继承的
  * @Retention(RetentionPolicy.RUNTIME) 生命周期最大的注解类型，不仅被保存在Class中，在JVM中加载Class之后仍让存在
  * @date 2020/1/7 22:46
  * @Version     1.0
  */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Import({ResourceServerConfig.class})
public @interface EnableResourceServer {
}

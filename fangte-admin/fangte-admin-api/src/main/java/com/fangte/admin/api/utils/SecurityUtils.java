package com.fangte.admin.api.utils;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.utils
 * @ClassName: SecurityUtils
 * @Author: xuchao
 * @Description:
 * @Date: 2020/1/7 22:45
 * @Version: 1.0
 */

import com.fangte.admin.api.config.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:45
 * @updateDate 2020/1/7 22:45     
 * @version 1.0
 **/
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public User getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户名
     *
     * @return
     */
    public String getUsername() {
        Authentication authentication = getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof User)) {
            return (String) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public User getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (User) principal;
        }
        return null;
    }
}

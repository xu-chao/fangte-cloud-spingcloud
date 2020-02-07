package com.fangte.admin.api.config;
/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.config
 * @ClassName: User
 * @Author: xuchao
 * @Description: 管理用户
 * @Date: 2020/1/7 22:40
 * @Version: 1.0
 */

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser 用于封装UserDetails的User扩展信息
 * @createDate 2020/1/7 22:40
 * @updateDate 2020/1/7 22:40     
 * @version 1.0
 **/
public class User extends org.springframework.security.core.userdetails.User {
    /**
     * 用户ID
     */
    @Getter
    private Long id;

    public User(Long id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }
}

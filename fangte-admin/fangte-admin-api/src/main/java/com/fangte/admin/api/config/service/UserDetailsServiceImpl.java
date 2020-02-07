package com.fangte.admin.api.config.service;
/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.config.service
 * @ClassName: UserDetailsServiceImpl
 * @Author: xuchao
 * @Description: 管理用户扩展类
 * @Date: 2020/1/7 22:42
 * @Version: 1.0
 */

import com.fangte.admin.api.config.User;
import com.fangte.admin.api.entity.SysUser;
import com.fangte.admin.api.feign.RemoteUserService;
import com.fangte.fangte.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:42
 * @updateDate 2020/1/7 22:42     
 * @version 1.0
 **/
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 加载用户信息
     *
     * @param username 传递username值
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername >> username = {}", username);
        Result<SysUser> result = remoteUserService.info(username);
        return getUserDetails(result);
    }

    /**
     * 构造包含用户信息的UserDetails对象。本项目仅提供用户信息，其他数据模拟
     * 应该包括：用户信息、角色信息、权限信息，这些数据都应该从数据库中查询。
     *
     * @param result
     * @return
     */
    private UserDetails getUserDetails(Result<SysUser> result) {
        if (result == null || result.getData() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        SysUser user = result.getData();

        // 模拟构造包含用户角色列表的`List<GrantedAuthority>`对象
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ADMIN");

        return new User(user.getId(), user.getUsername(), user.getPassword(), true, true, true, true, authorityList);
    }
}

package com.fangte.admin.biz.service;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.biz.service
 * @ClassName: SysUserService
 * @Author: xuchao
 * @Description:
 * @Date: 2020/1/7 23:21
 * @Version: 1.0
 */

import com.fangte.admin.api.entity.SysUser;
import com.fangte.fangte.common.service.BaseService;

import java.util.List;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 23:21
 * @updateDate 2020/1/7 23:21     
 * @version 1.0
 **/
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    SysUser findByName(String username);

    /**
     * 条件查询用户
     *
     * @param user
     * @return
     */
    List<SysUser> list(SysUser user);

    /**
     * 新增用户
     *
     * @param user
     */
    void create(SysUser user);

    /**
     * 更新用户
     *
     * @param user
     */
    void update(SysUser user);

    /**
     * 修改密码
     *
     * @param user
     */
    void changePass(SysUser user);
}

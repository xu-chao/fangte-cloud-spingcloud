package com.fangte.admin.biz.service.impl;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.biz.service.impl
 * @ClassName: SysUserServiceImpl
 * @Author: xuchao
 * @Description:
 * @Date: 2020/1/7 23:06
 * @Version: 1.0
 */

import com.fangte.admin.api.entity.SysUser;
import com.fangte.admin.api.utils.SecurityUtils;
import com.fangte.admin.biz.mapper.SysUserMapper;
import com.fangte.admin.biz.service.SysUserService;
import com.fangte.fangte.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 23:06
 * @updateDate 2020/1/7 23:06     
 * @version 1.0
 **/
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public SysUser findByName(String username) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andCondition("username=", username);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SysUser> list(SysUser user) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            criteria.andCondition("username=", user.getUsername());
        }
        return this.selectByExample(example);
    }

    @Override
    public void create(SysUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.save(user);
    }

    @Override
    public void update(SysUser user) {
        user.setPassword(null);
        this.updateNotNull(user);
    }

    @Override
    public void changePass(SysUser user) {
        SysUser entity = new SysUser();
        SysUser sysUser = this.findByName(SecurityUtils.getUsername());
        if (sysUser != null) {
            entity.setId(sysUser.getId());
            entity.setPassword(passwordEncoder.encode(user.getPassword()));
            this.updateNotNull(entity);
        }
    }
}

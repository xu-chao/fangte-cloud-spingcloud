package com.fangte.admin.api.feign.fallback;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.feign.fallback
 * @ClassName: RemoteUserServiceFallbackImpl
 * @Author: xuchao
 * @Description: 远程用户服务实现类
 * @Date: 2020/1/7 22:44
 * @Version: 1.0
 */

import com.fangte.admin.api.entity.SysUser;
import com.fangte.admin.api.feign.RemoteUserService;
import com.fangte.fangte.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:44
 * @updateDate 2020/1/7 22:44     
 * @version 1.0
 **/
@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

    @Override
    public Result<SysUser> info(String username) {
        log.error("查询用户信息失败，username >> {}", username);
        return null;
    }
}

package com.fangte.admin.api.feign;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.feign
 * @ClassName: RemoteUserService
 * @Author: xuchao
 * @Description: 远程用户服务
 * @Date: 2020/1/7 22:43
 * @Version: 1.0
 */

import com.fangte.admin.api.entity.SysUser;
import com.fangte.admin.api.feign.fallback.RemoteUserServiceFallbackImpl;
import com.fangte.fangte.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:43
 * @updateDate 2020/1/7 22:43     
 * @version 1.0
 **/
@FeignClient(value = "fangte-admin-biz", fallback = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {

    /**
     * 根据用户名查找用户信息
     *
     * @return
     */
    @GetMapping("/user/info/{username}")
    Result<SysUser> info(@PathVariable("username") String username);
}

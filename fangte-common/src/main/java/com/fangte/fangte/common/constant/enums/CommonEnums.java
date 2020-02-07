package com.fangte.fangte.common.constant.enums;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.constant.enums
 * @ClassName: CommonConstants
 * @Author: xuchao
 * @Description: 公共枚举实现类
 * @Date: 2020/1/7 22:07
 * @Version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:07
 * @updateDate 2020/1/7 22:07     
 * @version 1.0
 **/
@Getter
@AllArgsConstructor
public enum CommonEnums {

    LOGIN_ERROR(500, "用户名或密码错误"),
    PARAM_ERROR(401, "参数错误"),
    USER_ERROR(500, "获取用户信息失败"),
    LOGOUT_ERROR(500, "退出失败"),
    SYSTEM_ERROR(500, "系统内部错误");

    private final int code;
    private final String msg;

}

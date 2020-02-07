package com.fangte.fangte.common.utils;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.utils
 * @ClassName: Result
 * @Author: xuchao
 * @Description: 基础结果
 * @Date: 2020/1/7 22:13
 * @Version: 1.0
 */

import com.fangte.fangte.common.constant.CommonConstants;
import com.fangte.fangte.common.constant.enums.CommonEnums;
import lombok.*;

import java.io.Serializable;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:13
 * @updateDate 2020/1/7 22:13     
 * @version 1.0
 **/
@Builder
@ToString
@AllArgsConstructor
public class Result<T> implements Serializable {

    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;

    @Getter
    @Setter
    private Object msg = "success";

    @Getter
    @Setter
    private T data;

    public Result() {
        super();
    }

    public Result(T data) {
        super();
        this.data = data;
    }

    public Result(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public Result(CommonEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public Result(Throwable e) {
        super();
        this.code = CommonConstants.ERROR;
        this.msg = e.getMessage();
    }
}

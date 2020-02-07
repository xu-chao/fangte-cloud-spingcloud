package com.fangte.fangte.common.exception;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.exception
 * @ClassName: GlobalExceptionHandler
 * @Author: xuchao
 * @Description: 全局异常捕获
 * @Date: 2020/1/7 22:09
 * @Version: 1.0
 */

import com.fangte.fangte.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:09
 * @updateDate 2020/1/7 22:09     
 * @version 1.0
 **/
@Slf4j
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception(Exception e) {
        log.error("全局异常处理，error >> {}", e.getMessage());
        return new Result(e);
    }
}

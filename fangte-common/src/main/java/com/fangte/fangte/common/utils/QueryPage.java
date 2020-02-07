package com.fangte.fangte.common.utils;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.utils
 * @ClassName: QueryPage
 * @Author: xuchao
 * @Description: 基础分页服务
 * @Date: 2020/1/7 22:12
 * @Version: 1.0
 */

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:12
 * @updateDate 2020/1/7 22:12     
 * @version 1.0
 **/
@Data
@ToString
public class QueryPage implements Serializable {

    private int pageCode; //当前页
    private int pageSize; //每页显示的记录数
}

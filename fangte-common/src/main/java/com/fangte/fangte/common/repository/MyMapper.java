package com.fangte.fangte.common.repository;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.repository
 * @ClassName: MyMapper
 * @Author: xuchao
 * @Description: 基础Mapper
 * @Date: 2020/1/7 22:10
 * @Version: 1.0
 */

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:10
 * @updateDate 2020/1/7 22:10     
 * @version 1.0
 **/
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}

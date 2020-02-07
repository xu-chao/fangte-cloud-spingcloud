package com.fangte.fangte.common.service;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.service
 * @ClassName: BaseService
 * @Author: xuchao
 * @Description: 基础服务
 * @Date: 2020/1/7 22:11
 * @Version: 1.0
 */

import java.util.List;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:11
 * @updateDate 2020/1/7 22:11     
 * @version 1.0
 **/
public interface BaseService<T> {

    List<T> selectAll();

    T selectByKey(Object key);

    void save(T entity);

    void delete(Object key);

    void batchDelete(List<Long> ids, String property, Class<T> clazz);

    void updateAll(T entity);

    void updateNotNull(T entity);

    List<T> selectByExample(Object example);
}

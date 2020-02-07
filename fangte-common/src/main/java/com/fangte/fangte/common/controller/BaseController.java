package com.fangte.fangte.common.controller;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.fangte.common.controller
 * @ClassName: BaseController
 * @Author: xuchao
 * @Description: 基础Controller
 * @Date: 2020/1/7 22:08
 * @Version: 1.0
 */

import com.fangte.fangte.common.utils.QueryPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:08
 * @updateDate 2020/1/7 22:08     
 * @version 1.0
 **/
public class BaseController {

    private Map<String, Object> getData(PageInfo<?> pageInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("rows", pageInfo.getList());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    /**
     * Supplier是JDK8新特性
     * 特点：只有返回值，没有输入参数
     * 如：Supplier<User> user = User::new;
     * 此时并没有构造User对象，当调用`user.get()`方法才获取一个新的User构造对象
     * <p>
     * QueryPage 是封装分页条件的entity，如果没有指定默认查询所有
     */
    public Map<String, Object> selectByPageNumSize(QueryPage page, Supplier<?> s) {
        PageHelper.startPage(page.getPageCode(), page.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getData(pageInfo);
    }
}

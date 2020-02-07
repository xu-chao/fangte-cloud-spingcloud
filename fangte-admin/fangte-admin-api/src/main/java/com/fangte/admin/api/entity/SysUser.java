package com.fangte.admin.api.entity;/**
 * @ProjectName: fangte-cloud
 * @Package: com.fangte.admin.api.entity
 * @ClassName: SysUser
 * @Author: xuchao
 * @Description: 系统用户
 * @Date: 2020/1/7 22:42
 * @Version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * @updateRemark
 * @author xuchao
 * @updateUser
 * @createDate 2020/1/7 22:42
 * @updateDate 2020/1/7 22:42     
 * @version 1.0
 **/
@Data
@Table(name = "sys_user")
public class SysUser implements Serializable {

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;
}

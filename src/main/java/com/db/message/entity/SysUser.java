package com.db.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author DB
 * @title: SysUser
 * @projectName message
 * @description: TODO
 * @date 2022/2/28  15:19
 */
@Data
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;
    private String password;
    private String nickName;
    private String email;
    private String phone;
    private String code;
    private int flag;
    private int sex;
    private LocalDateTime startDate;
    private LocalDateTime overDate;
    private LocalDateTime birthday;
    private String nation;
    private Long collegeId;
    private Long majorId;
    private String dormFloor;
    private String dorm;
    private Long classId;
    private Long teacherId;
    private String degree;
    private String photo;
    private String idCard;
    private String religion;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private List<String> authList;
}

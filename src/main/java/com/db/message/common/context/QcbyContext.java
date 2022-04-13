package com.db.message.common.context;

import com.db.message.entity.SysUser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DB
 * @title: QcbyContext
 * @projectName message
 * @description: 全局上下文
 * @date 2022/2/28  15:28
 */
public class QcbyContext {
    /**
     * userMap 的 k 是 token， v 是用户信息
     * tokenMap 的 k 是 token， v 是用户id
     */
    private static Map<String, SysUser> userMap = new HashMap<>();
    private static Map<String, Long> tokenMap = new HashMap<>();


    /**
     * 向userMap中添加信息
     */
    public static void add(SysUser user){
        if (user == null){
            return;
        }
        userMap.put(user.getToken(), user);
    }


    /**
     * 根据token获取用户信息
     */
    public static SysUser getUser(String token){
        if (token == null){
            return null;
        }
        return userMap.get(token);
    }

    /**
     * 向tokenMap中添加数据
     */
    public static void add (String token, Long val){
        tokenMap.put(token, val);
    }


    /**
     * 根据token获取用户id
     */
    public static Long get(String token){
        return tokenMap.get(token);
    }

    public static void remove(String token){
        Long userId = get(token);
        //删除token信息和用户信息
        userMap.remove(userId);
        tokenMap.remove(token);
    }

}

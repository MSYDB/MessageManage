package com.db.message.common.constant;

/**
 * @author DB
 * @title: GLobalConstant
 * @projectName message
 * @description: TODO
 * @date 2022/3/4  16:49
 */
public class GlobalConstant {
    //增
    public static final int INSERT = 0;
    //删
    public static final int DELETE = 1;
    //改
    public static final int UPDATE = 2;
    //查
    public static final int SELECT = 3;

    //统一接口路径
    public static final String SERVER_URL_PREFIX = "/message/";

    //token
    public static final String TOKEN = "token";

    //五分钟过期时间
    public static final int EXPIRE_TIME_SECOND = 300;
    public static final int EXPIRE_TIME_MINUTE = 5;

    //常数1
    public static final int AFFECT_ROWS_SINGLE = 1;

    /**
     * 菜单类型：0 ： 菜单    1 ：按钮
     */
    public static final int MENU_TYPE_ME = 0;
    public static final int MENU_TYPE_BT = 1;
}

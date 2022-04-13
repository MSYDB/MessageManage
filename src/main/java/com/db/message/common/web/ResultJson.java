package com.db.message.common.web;

import com.db.message.common.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DB
 * @title: ResultJson
 * @projectName message
 * @description: TODO
 * @date 2022/3/4  16:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson<T> {
    //返回状态码
    private Integer code;
    //返回提示信息
    private String message;
    //返回结果集
    private T date;

    public static ResultJson isOk(boolean r){
        if (r){
            return success();
        } else{
            return failure();
        }
    }

    /**
     * 成功返回结果集
     * @return
     */
    public static ResultJson success() {
        return success(Constant.SUCCESS_MESSAGE, null);
    }

    public static ResultJson success(Object data) {
        return success(Constant.SUCCESS_MESSAGE, data);
    }
    public static ResultJson success(String message, Object data) {
        return new ResultJson(Constant.SUCCESS_CODE, message, data);
    }

    /**
     * 失败返回结果集
     * @return
     */
    public static ResultJson failure() {
        return success(Constant.FAILURE_MESSAGE, null);
    }

    public static ResultJson failure(Object data) {
        return success(Constant.FAILURE_MESSAGE, data);
    }
    public static ResultJson failure(String message, Object data) {
        return new ResultJson(Constant.FAILURE_CODE, message, data);
    }


}

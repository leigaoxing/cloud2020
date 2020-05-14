package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义返回前端交互的实体类，一般用于前后端分离的项目
 *
 * @param <T>
 * @author gaoxinglei
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}

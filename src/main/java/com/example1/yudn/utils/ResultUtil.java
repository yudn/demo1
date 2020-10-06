package com.example1.yudn.utils;

import com.example1.yudn.domain.Result;

import java.util.Objects;

/**
 * Created by Administrator on 2017/7/29.
 */
public class ResultUtil {
    public static  Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public  static Result success(){
        return success(null);
    }

    public static  Result error(Integer code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}

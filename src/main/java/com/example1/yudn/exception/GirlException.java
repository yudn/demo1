package com.example1.yudn.exception;


import com.example1.yudn.enums.ResultEnum;

/**
 * Created by Administrator on 2017/7/30.
 */

public class GirlException extends RuntimeException {
    private  Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

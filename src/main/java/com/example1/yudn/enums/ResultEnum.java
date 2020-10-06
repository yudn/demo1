package com.example1.yudn.enums;

/**
 * 枚举类型
 * Created by Administrator on 2017/8/1.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE(101,"你可能还在上初中"),
    DELETE_ERROR(102,"没有这个ID的女生"),
    FINDBYAGE_ERROR(103,"没有这个年龄的女孩")
    ;
    private  Integer code;
    private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

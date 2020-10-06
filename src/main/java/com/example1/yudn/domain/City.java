package com.example1.yudn.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/28.
 */
public class City implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    protected City() {
        // JPA规范要求的no-args构造函数
        //这个被保护，因为它不应该被直接使用
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}


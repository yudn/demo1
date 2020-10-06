package com.example1.yudn.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/26.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段比传")
    private  String cpuSize;

    @Min(value = 18, message="未成年少女禁止入内")
    private  Integer age;

    @NotNull(message = "金额必须传递")
    private  Double Money;

    public Girl(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpuSize() {
        return cpuSize;
    }

    public void setCpuSize(String cpuSize) {
        this.cpuSize = cpuSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(Double money) {
        this.Money = money;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cpuSize='" + cpuSize + '\'' +
                ", age=" + age +
                ", Money=" + Money +
                '}';
    }
}

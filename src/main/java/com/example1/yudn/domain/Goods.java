package com.example1.yudn.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/1.
 */
@Entity
@Table(name="t_goods")
public class Goods {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Integer price;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name="modified_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}

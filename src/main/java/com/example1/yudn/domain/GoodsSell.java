package com.example1.yudn.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/3/1.
 */
@Entity
@Table(name="t_goods_sells")
public class GoodsSell {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Goods goods;
    @OneToOne
    private Order order;
    @ManyToOne
    private User user;
    private int count;
    //0:待付款 1:已付款 2:未付款
    private int status;

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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

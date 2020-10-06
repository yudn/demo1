package com.example1.yudn.repository;

import com.example1.yudn.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);

}

package com.example1.yudn.repository;

import com.example1.yudn.domain.Goods;
import com.example1.yudn.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/1.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    //根据用id查询用户信息，关联商品销售
    @Query(value="SELECT * FROM t_user t  WHERE t.user_id=?1",nativeQuery = true)
    User findOne(Long userId);
}

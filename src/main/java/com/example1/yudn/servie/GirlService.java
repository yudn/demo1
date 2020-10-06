package com.example1.yudn.servie;

import com.example1.yudn.domain.Girl;
import com.example1.yudn.enums.ResultEnum;
import com.example1.yudn.exception.GirlException;
import com.example1.yudn.repository.GirlRepository;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Administrator on 2017/7/26.
 */
@Service

public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    //使用事务进行批处理如果失败则回滚操作
    @Transactional
    public void  insertTwo() {
        Girl girlA = new Girl();
       // girlA.setId(1);
        girlA.setCpuSize("A");
        girlA.setAge(18);
        girlA.setMoney(13131.00);
        girlRepository.save(girlA);

       /* Girl girlB = new Girl();
        girlB.setCpuSize("B");
        girlB.setAge(18);
        girlB.setMoney(2222222.443);
        girlRepository.save(girlB);*/
    }

    public  void getAge(Integer id) throws Exception {
         Girl girl = girlRepository.findOne(id);
         Integer age = girl.getAge();
         if(age<10) {
             //返回“你好在上小学吧"  code =100
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
         }
         else if (age>10 && age<16)
         {
             //返回 "你还在上初中 "  code = 101
             throw  new GirlException(ResultEnum.MIDDLE);
         }

    }

    /**
     * 通过ID查询一个女生的信息
     * @param id
     * @return  Girl
    * */
    public Girl findOne(Integer id) {
        return  girlRepository.findOne(id);
    }

    /**
    * 通过ID删除一个女生的信息
     * @param  id
     * @return Msg
     * */
    public String deleteOne(Integer id)throws Exception {
        if(id==null){
            //返回 “没有这个ID的女生”
            throw new GirlException(ResultEnum.DELETE_ERROR);
        }
        String msg= "删除成功";
        return msg;
    }

    public List<Girl> findByAge(Integer age) throws  Exception {
        if (age == null) {
            //返回 “没有这个ID的女生”
            throw new GirlException(ResultEnum.DELETE_ERROR);
        }
        return girlRepository.findByAge(age);
    }
}


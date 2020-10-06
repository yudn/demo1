package com.example1.yudn.web;

import com.example1.yudn.aspect.HttpAspect;
import com.example1.yudn.domain.Girl;
import com.example1.yudn.domain.Result;
import com.example1.yudn.repository.GirlRepository;
import com.example1.yudn.servie.GirlService;
import com.example1.yudn.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@RestController
public class GirlController {
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
    * 查询所有女生列表
     * @return
     * */
    @GetMapping(value="/girls")
    public Result<Girl> girlList(){
        //System.out.println("girlList");
        logger.info("girlList");
        return ResultUtil.success(girlRepository.findAll());
    }
    /*
    * 使用post方法添加一个女生
    * @requestparam cpuSize
    * @requestparam age
    * */
   /* @PostMapping(value="/girls")
    public Girl girlAdd(@RequestParam("cpuSize") String cpuSize, @RequestParam("age") Integer age ){
        Girl girl = new Girl();
        girl.setCpuSize(cpuSize);
        girl.setAge(age);
        return  girlRepository.save(girl);
    }*/
   //优化上面代码结构，禁止18岁未成年少女入内。
    @PostMapping(value="/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
           // return null;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        else{
            girl.setCpuSize(girl.getCpuSize());
            girl.setAge(girl.getAge());
            girl.setMoney(girl.getMoney());
            return ResultUtil.success(girlRepository.save(girl));
        }
    }

    //查询一个女生
    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新一个女生
    @PutMapping(value = "/girls/{id}")
    public Result<Girl> girlUpdate(@PathVariable("id") Integer id, @RequestParam("cpuSize") String cpuSize, @RequestParam("age") Integer age,@RequestParam("money") Double money){
      Girl girl = new  Girl();
      girl.setId(id);
      girl.setCpuSize(cpuSize);
      girl.setAge(age);
      girl.setMoney(money);
      return ResultUtil.success(girlRepository.save(girl));
    }

    // 删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public String girlDelete(@PathVariable("id") Integer id){
       girlRepository.delete(id);
        String msg= "删除成功";
        return msg;
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public Result<Girl> girlListByAge(@PathVariable("age") Integer age) throws Exception{
        if(ResultUtil.success(girlService.findByAge(age))==null){
            String msg= "没有这个年龄的女生";
            return null;
        }
       return ResultUtil.success(girlService.findByAge(age));
    }

    //通过调用service添加两个女生
    @PostMapping(value="/girls/two")
    public  String  girlTwo(){
        girlService.insertTwo();
        return "添加成功";
    }
    //查询年龄小于10岁的 和大于10岁小于16岁的女孩
    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}

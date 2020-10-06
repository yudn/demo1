package com.example1.yudn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建AOP抽象切面类简化重复工作
 * Created by Administrator on 2017/7/29.
 *
 */

@Aspect
@Component
public class HttpAspect {

    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution(public  * com.example1.yudn.web.GirlController.*(..))")
    public  void log(){

    }
    @Before("log()")
    public  void doBefor(JoinPoint joinPoint){
        //System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        logger.info("11111111111111111111111111111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //port
        logger.info("port={}", request.getRemotePort());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("arg={}", joinPoint.getArgs());
    }
    @After("log()")
    public  void doAfter(){
       // System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        logger.info("222222222222222222222222222222222");
    }
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
       /* if (object==null) {
            logger.info("对象为空");
        } else {
            logger.info("response={}", object.toString());
        }*/
       logger.info("response={}", object.toString());
    }
}

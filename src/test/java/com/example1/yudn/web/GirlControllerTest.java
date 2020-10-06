package com.example1.yudn.web;

import com.example1.yudn.aspect.HttpAspect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by Administrator on 2017/8/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Before
    public void setUp() throws Exception {
        logger.info("GirlController开始测试");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("GirlController测试结束");
    }
    @Autowired
    private  MockMvc mvc;

    @Test
    public void girlList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlAdd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlFindOne() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/5")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlUpdate() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlDelete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/girls/55")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlListByAge() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/age/10")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlTwo() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/girls/two")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getAge() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/getAge/5")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
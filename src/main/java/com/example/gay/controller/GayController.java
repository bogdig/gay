package com.example.gay.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.gay.aspect.HttpAspect;
import com.example.gay.domain.Gay;
import com.example.gay.domain.Result;
import com.example.gay.repository.GayRepository;
import com.example.gay.service.GayService;
import com.example.gay.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GayController {

    private final static Logger logger = LoggerFactory.getLogger(GayController.class);

    @Autowired
    private GayRepository gayRepository;

    @Autowired
    private GayService gayService;

    /**
     * 查询所有基佬列表
     * @return
     */
    @GetMapping(value = "/gays")
    public List<Gay> gayList() {

        logger.info("girlList");

        return gayRepository.findAll();
    }


    /**
     * 添加一个基佬
     * @return
     */
    @PostMapping(value = "/gays")
    public Object gayAdd(@Valid Gay gay, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
//            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        gay.setCupSize(gay.getCupSize());
        gay.setAge(gay.getAge());

        return ResultUtil.success(gayRepository.save(gay));
    }

    /**
     * 通过ID查询一个基佬
     * @param id
     * @return
     */
    @GetMapping(value = "/gays/{id}")
    public Gay gayFindOne(@PathVariable("id") Integer id){
        return gayRepository.findById(id).get();
    }

    /**
     * 更新一个基佬
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/gays/{id}")
    public Gay gayUpdate(@PathVariable("id") Integer id,
                         @RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){
        Gay gay = new Gay();
        gay.setId(id);
        gay.setAge(age);
        gay.setCupSize(cupSize);

        return gayRepository.save(gay);
    }

    /**
     * 删除一个基佬
     * @param id
     */
    @DeleteMapping(value = "/gays/{id}")
    public void gayDelete(@PathVariable("id") Integer id){
         gayRepository.deleteById(id);
    }

    /**
     * 通过年龄来查询基佬
     * @param age
     * @return
     */
    @GetMapping(value = "/gays/age/{age}")
    public List<Gay> gayListByAge(@PathVariable("age") Integer age){
        return gayRepository.findByAge(age);
    }

    @PostMapping(value = "/gays/two")
    public void gayTwo(){
        gayService.insertTwo();
    }

    @GetMapping(value = "/gays/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        gayService.getAge(id);
    }

}

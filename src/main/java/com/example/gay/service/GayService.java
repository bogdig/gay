package com.example.gay.service;

import com.example.gay.domain.Gay;
import com.example.gay.enums.ResultEnum;
import com.example.gay.exception.GayException;
import com.example.gay.repository.GayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GayService {

    @Autowired
    private GayRepository gayRepository;

    @Transactional
    public void insertTwo(){
        Gay gayA = new Gay();
        gayA.setCupSize("A");
        gayA.setAge(18);
        gayRepository.save(gayA);

        Gay gayB = new Gay();
        gayB.setCupSize("B");
        gayB.setAge(19);
        gayRepository.save(gayB);
    }

    public void getAge(Integer id) throws GayException{
        Gay gay = gayRepository.findById(id).get();
        Integer age = gay.getAge();
        if (age < 10){
            //返回"你还在上小学吧"
            throw new GayException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            //返回"你可能在上初中"
            throw new GayException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过ID查询一个基佬信息
     * @param id
     * @return
     */
    public Gay findOne(Integer id){
        return gayRepository.findById(id).get();
    }
}

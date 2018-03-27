package com.example.gay.repository;

import com.example.gay.domain.Gay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GayRepository extends JpaRepository<Gay, Integer> {

    //通过年龄来查询
    List<Gay> findByAge(Integer age);

}

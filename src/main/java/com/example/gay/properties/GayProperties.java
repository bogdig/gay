package com.example.gay.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gay")
public class GayProperties {

    private String cupSize;

    private Integer age;

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {

        return cupSize;
    }

    public Integer getAge() {
        return age;
    }
}

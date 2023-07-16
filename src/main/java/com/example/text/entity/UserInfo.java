package com.example.text.entity;

import java.math.BigDecimal;

public class UserInfo {

    private  String name="test";

    private  Integer age=18;

    BigDecimal  money = new BigDecimal(9999999.99);

    public void other(){
        System.out.println(Thread.currentThread().getName()+": 玩命计算中.......");
    }
}

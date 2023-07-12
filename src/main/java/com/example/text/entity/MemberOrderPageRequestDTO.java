package com.example.text.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class MemberOrderPageRequestDTO implements Serializable {


    private Integer size;

    private  Integer current;

    private  String startTime;

    private  String endTime;


}

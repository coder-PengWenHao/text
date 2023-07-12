package com.example.text.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.text.entity.MemberOrderPageRequestDTO;
import com.example.text.util.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/pwh/test")
public class OrderTestContrller {

    @RequestMapping(value = "/get/1", method = RequestMethod.GET)
    public ResponseResult<?> test1(String str) {
        Map<String, Object> map = new HashMap<>();
        map.put("str", str);
        map.put("a", "1");
        return ResponseResult.buildSuccessResponse(map);
    }


    @RequestMapping(value = "/post/1", method = RequestMethod.POST)
    public ResponseResult<?> test2(String str, String code, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("str", str);
        map.put("code", code);
        map.put("msg", msg);
        return ResponseResult.buildSuccessResponse(map);
    }


    @RequestMapping(value = "post/2", method = RequestMethod.POST)
    public ResponseResult<?> test3(@RequestBody MemberOrderPageRequestDTO request) {
        log.info("request:{}", JSON.toJSONString(request));

        MemberOrderPageRequestDTO re = new MemberOrderPageRequestDTO();
        re.setSize(request.getSize());
        re.setCurrent(request.getCurrent());
        re.setStartTime("2022-11-18");
        re.setEndTime("2022-11-20");
        return ResponseResult.buildSuccessResponse(re);
    }

    @RequestMapping(value = "post/4", method = RequestMethod.GET)
    public ResponseResult<?> test4() {
        String str = "{\n" +
                "    \"label\": \"yss\",\n" +
                "    \"cid\": \"411************340\",\n" +
                "    \"cidtype\": \"1000\",\n" +
                "    \"name\": \"刘*\",\n" +
                "    \"phone\": \"138******97\",\n" +
                "    \"encode\": \"cBLMCF7ZwZh0cC6kBPRoFMZpl+Q1CYBTqubIoUg+ydgMU6PKepZ+Cuu/Kealo8uL\",\n" +
                "    \"c\": \"Y\",\n" +
                "    \"t\": 1668561507,\n" +
                "    \"v\": 3,\n" +
                "    \"s\": \"fg+yr9FmBAFStuYWnn8bjU11015wEdiDczyPD81oax43cizxZFz+8lKeaG6o9HU/vaq/Wd8Cm10HD1/EDkk+Gg==\"\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(str);

        String cid = jsonObject.getString("cid");

        byte[] decode = Base64.getDecoder().decode(cid);

        System.out.println(new String(decode));


        return ResponseResult.buildSuccessResponse("");
    }


}

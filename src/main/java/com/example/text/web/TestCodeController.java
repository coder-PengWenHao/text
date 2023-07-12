package com.example.text.web;


import com.example.text.entity.MemberOrderPageRequestDTO;
import com.example.text.util.HttpBaseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/coderpwh/")
public class TestCodeController {


    @Autowired
    private HttpBaseUtil httpBaseUtil;


    @RequestMapping(value = "/http1", method = RequestMethod.GET)
    public void http1() {

        String url = "http://127.0.0.1:8081/pwh/test/get/1?str=hello";

        String str = "hello world";
        Map<String, Object> map = new HashMap<>();
        map.put("str", str);
        ResponseEntity result = httpBaseUtil.getForEntity(url);
        log.info("result:{}", result);
    }


    @RequestMapping(value = "/http2", method = RequestMethod.GET)
    public void http2() {
        String url = "http://127.0.0.1:8081/pwh/test/post/1";
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.put("str", Collections.singletonList("hello"));
        map.put("code", Collections.singletonList("200"));
        map.put("msg", Collections.singletonList("This is spring restTemplate"));

        ResponseEntity result = httpBaseUtil.postForEntity(url, map, String.class);

        log.info("post 请求方式,result:{}", result);
    }


    @RequestMapping(value = "/http3", method = RequestMethod.GET)
    public void htt3() {
        String url = "http://127.0.0.1:8081/pwh/test/post/2";


        MemberOrderPageRequestDTO request = new MemberOrderPageRequestDTO();
        request.setCurrent(1);
        request.setSize(5);

        Object r = httpBaseUtil.postForObject(url, request, MemberOrderPageRequestDTO.class);

        log.info("post 请求方式,结果为:{}", r);

    }


}

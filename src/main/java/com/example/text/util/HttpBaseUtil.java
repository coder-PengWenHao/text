package com.example.text.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * http基础工具使用
 *
 * @author coderpwh
 * @date 2022/11/18 15:39
 */
@Configuration
public class HttpBaseUtil {

    public static Logger logger = LoggerFactory.getLogger(HttpBaseUtil.class);

    @Autowired
    private RestTemplate restTemplate;


    /***
     *  post请求方式(application/json)
     * @param url
     * @param request
     * @param response
     * @return
     */
    public Object postForObject(String url, Object request, Object response) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        String stu = JSON.toJSONString(request);
        HttpEntity<String> formEntity = new HttpEntity<String>(stu, headers);

        logger.info("请求url为：\n" + JSONObject.toJSONString(url));
        logger.info("请求报文：\n" + JSONObject.toJSONString(formEntity));
        response = restTemplate.postForObject(url, formEntity,Object.class);

        logger.info("响应报文：\n" + JSONObject.toJSONString(response));
        return response;
    }


    /***
     *  post请求 form-data请求
     * @param url
     * @param paramMap
     * @param response
     * @return
     */
    public ResponseEntity postForEntity(String url, MultiValueMap<String,Object> paramMap, Object response) {
        HttpHeaders headers = new HttpHeaders();


        HttpEntity<MultiValueMap<String,Object>> formEntity = new HttpEntity<MultiValueMap<String,Object>>(paramMap, headers);

        logger.info("请求url为：\n" + JSONObject.toJSONString(url));
        logger.info("请求报文：\n" + JSONObject.toJSONString(formEntity));
        ResponseEntity result = restTemplate.postForEntity(url, formEntity,Object.class);
        logger.info("响应报文：\n" + JSONObject.toJSONString(result));
        return result;
    }


    /**
     * Get 请求方式
     *
     * @param url
     * @return
     */
    public ResponseEntity getForEntity(String url) {
        logger.info("请求url为：\n" + JSONObject.toJSONString(url));
        ResponseEntity result = restTemplate.getForEntity(url, String.class);
        logger.info("响应报文：\n" +JSON.toJSONString(result.getBody()));
        return result;
    }


    /***
     *   GET 请求方式
     * @param url
     * @param request
     */
    public ResponseEntity getForEntity(String url, Object request) {
        logger.info("请求url为：\n" + JSONObject.toJSONString(url));
        logger.info("请求报文：\n" + JSONObject.toJSONString(request));
        ResponseEntity result = restTemplate.getForEntity(url, String.class, request);
        logger.info("响应报文：\n" + JSONObject.toJSONString(result));
        return result;
    }


}
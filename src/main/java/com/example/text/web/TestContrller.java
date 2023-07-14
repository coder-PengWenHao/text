package com.example.text.web;


import com.example.text.entity.OOMObject;
import com.example.text.service.ImageService;
import com.example.text.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestContrller {


    @Resource
    private TestService testService;


    @Resource
    private ImageService imageService;


    /***
     * 验证文本
     * @param text
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public Object test1(String text) throws UnsupportedEncodingException {
        return testService.test1(text);
    }


    /***
     * 文本错误校验
     * @param text
     * @return
     */
    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public Object test(String text) {
        return testService.test2(text);
    }

    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public Object imagesTest(String text) {

        return imageService.imagestest(text);
    }


    @RequestMapping(value = "/test_jvm", method = RequestMethod.GET)
    public void testJava(String text) throws Exception {
        log.info("oom开始.....");
        log.error("oom开始与结束");
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < 80000; i++) {
            new OOMObject();
            new OOMObject();
            list.add(new OOMObject());
        }
        log.info("oom结束.....");
    }


}

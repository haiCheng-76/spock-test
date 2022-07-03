package com.example.spock.controller;

import com.example.spock.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/3 18:47
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/get")
    public Map<String, Object> get() {
        String uuid = testService.uuid();
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 200);
        map.put("data", uuid);
        return map;
    }

    @GetMapping(value = "/list")
    public Map<String, Object> list() {
        List<String> list = testService.list();
        Map<String, Object> map = new HashMap<>(2);
        map.put("code", 200);
        map.put("data", list);
        return map;
    }
}

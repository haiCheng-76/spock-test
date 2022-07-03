package com.example.spock.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 582895699@qq.com
 * @Desctription:
 * @Date: Created in 2022/7/3 18:46
 */
@Service
public class TestService {

    public String uuid() {
        return UUID.randomUUID().toString();
    }

    public List<String> list() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}

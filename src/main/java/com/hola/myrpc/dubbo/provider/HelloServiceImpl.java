package com.hola.myrpc.dubbo.provider;


import com.hola.myrpc.dubbo.api.HelloServiceProvider;
import org.springframework.stereotype.Service;


@Service("helloService")
public class HelloServiceImpl implements HelloServiceProvider {
    @Override
    public String hello() {
        return "hello，这是一条通过dubbo协议传输的消息";
    }

    @Override
    public String goodBye() {
        return "goodBye";
    }
}

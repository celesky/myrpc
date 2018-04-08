package com.hola.myrpc.thrift.service;


import com.hola.myrpc.thrift.api.HelloService;

public class HelloServiceImpl implements HelloService.Iface {
    public String hello(String name) {
        return "hello : "+name;
    }
}

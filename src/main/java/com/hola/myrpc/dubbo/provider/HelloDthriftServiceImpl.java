package com.hola.myrpc.dubbo.provider;

import com.hola.myrpc.dubbo.api.dthrift.HelloDthriftApi;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service("helloThriftServiceImpl")
public class HelloDthriftServiceImpl implements HelloDthriftApi.Iface{
    @Override
    public String hello(String name) throws TException {
        return "hello:"+name;
    }

    @Override
    public String helloBool(boolean boo) throws TException {
        return "helloBool:"+boo;
    }
}

package com.hola.myrpc;


import com.hola.myrpc.dubbo.api.HelloServiceProvider;
import com.hola.myrpc.dubbo.api.dthrift.HelloDthriftApi;
import com.hola.myrpc.dubbo.api.dthrift.SearchMoviePersonResultDto;
import com.hola.myrpc.dubbo.api.dthrift.SearchThriftProvider;
import com.hola.myrpc.dubbo.api.dthrift.ThriftApiProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:dubbo-test.xml"})
//@ImportResource({"dubbo-test.xml"})
public class ConsumerUnitTest {
    private static final int THREAD_NUM = 300;

    private static final int CALL_NUM = 10000;

    private static CountDownLatch startLatch = new CountDownLatch(1);

    private static CountDownLatch endLatch = new CountDownLatch(THREAD_NUM);

    private static ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo.xml"});
        context.start();

        //testMovieDataProvider(context);
        //testMoviePersonProvider(context);
//        testSearchProvider(context);
 //       testThriftApiProvider(context);

        //testArticleThriftProvider(context);
 //       testSearchThriftProvider(context);
        //tpsTest(context);

        System.in.read();
    }

    @Test
    public  void testThriftApiProvider() {
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-test.xml"});
            final ThriftApiProvider.Iface thriftApiService = (ThriftApiProvider.Iface)context.getBean("thriftApiService"); // get service invocation proxy
            String msg  = thriftApiService.hello("tom");
            System.out.println("msg = " + msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public  void testHelloProvider() {
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-test.xml"});
            final HelloServiceProvider helloService = (HelloServiceProvider)context.getBean("helloService"); // get service invocation proxy
            String msg  = helloService.hello();
            System.out.println("msg = " + msg);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public  void testHelloThriftApi() {
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-test.xml"});
            final HelloDthriftApi.Iface helloService = (HelloDthriftApi.Iface)context.getBean("helloThriftService"); // get service invocation proxy
            String msg  = helloService.hello("tom");
            System.out.println("msg = " + msg);

            String msg2  = helloService.helloBool(true);
            System.out.println("msg2 = " + msg2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public  void testSearchThriftProvider() {
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-test.xml"});
            final SearchThriftProvider.Iface searchThriftService = (SearchThriftProvider.Iface)context.getBean("searchThriftService"); // get service invocation proxy
//            String ping  = searchThriftService.ping();
//            System.out.println("ping = " + ping);
//
//            MoviePerson getMoviePerson  = searchThriftService.getMoviePerson(1);
//            System.out.println("getMoviePerson = " + getMoviePerson);
//
//            SearchMoviePersonResultDto dtoAll = searchThriftService.getMoviePersonAll(1);
//            System.out.println("dtoAll = " + dtoAll);
            //todo 参数有bool值问题
            SearchMoviePersonResultDto dtoALl2  = searchThriftService.searchMoviePerson(true,"1",1,1);
            System.out.println("dtoALl2 = " + dtoALl2);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

package com.hola.myrpc;

import com.hola.myrpc.dubbo.provider.SearchServiceThriftImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"dubbo.xml"})
public class MyrpcApplication {

    private static final Logger logger = LoggerFactory.getLogger(MyrpcApplication.class);

    public static void main(String[] args)throws Exception{
		SpringApplication.run(MyrpcApplication.class, args);
//        ApplicationContext ctx = new SpringApplicationBuilder()
////                .sources(MyrpcApplication.class)
////                .web(false)
////                .run(args);
        logger.error("123");

        System.in.read();

	}
}

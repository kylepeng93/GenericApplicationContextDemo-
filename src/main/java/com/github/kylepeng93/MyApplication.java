package com.github.kylepeng93;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-07-23 下午9:55
 */
@SpringBootApplication
public class MyApplication implements CommandLineRunner {
//
//    @Autowired
//    private GenericApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    /**
     * 将TimeService注入到上下文
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("myApp start OK");
    }
}

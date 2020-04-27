package com.jl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.*;

@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 多线程
     *
     * @return
     */
    @RequestMapping("/callable")
    @ResponseBody
    public String callable() throws ExecutionException, InterruptedException {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 5,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        System.out.println("c1---------之前");
        Callable<String> c1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                System.out.println("c1----finish");
                return "c1-----";
            }
        };
        System.out.println("c1---------之后");
        System.out.println("c2---------之前");
        Callable<String> c2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                System.out.println("c2----finish");
                return "c2-----";
            }
        };
        System.out.println("c2---------之后");

        Future<String> submit1 = pool.submit(c1);
        Future<String> submit2 = pool.submit(c2);
        String s1 = submit1.get();
        String s2 = submit2.get();
        System.out.println("main------------");
        return s1 + "\n" + s2;

    }

}

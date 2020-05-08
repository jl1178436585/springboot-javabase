package com.jl.thread.create;

/**
 * 同时复写thread的run和Runnable的run
 */
public class ThreadDemo1 {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable--------");
            }
        }){
            @Override
            public void run() {
                System.out.println("thread----------");
            }
        }.start();


    }

}

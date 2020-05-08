package com.jl.thread.waitnotify;

/**
 * 子线程循环10次，接着主线程循环100次，接着
 * 又回到子线程循环10次，主线程循环100次，如此循环50次
 */
public class Question1 {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    synchronized (Question1.class){
                        for (int j = 0; j < 10; j++) {
                            System.out.println(Thread.currentThread().getName()+" ："+ i + " ，"+ j);
                        }
                    }

                }

            }
        }).start();


        //主线程
        for (int i = 0; i < 50; i++) {
            synchronized (Question1.class){
                for (int j = 0; j < 100; j++) {
                    System.out.println(Thread.currentThread().getName()+" ："+ i + " ，"+ j);
                }
            }

        }
    }
}

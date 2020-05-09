package com.jl.thread.state;

/**
 * synchronized会使线程进入BLOCKED状态，下面是线程堆栈
 *
 * "my-2" #13 prio=5 os_prio=0 tid=0x000000001f97e000 nid=0x4af8 waiting for monitor entry [0x000000002068e000]
 *    java.lang.Thread.State: BLOCKED (on object monitor)
 * 	at com.jl.thread.state.MyThread.run(ThreadStateTest.java:27)
 * 	- waiting to lock <0x00000006c360a7b0> (a java.lang.String)
 * 	at java.lang.Thread.run(Thread.java:748)
 */
public class ThreadSyncBlockState {

    public static class MyThread implements Runnable {

        private String lock = "lcoktest";

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
            synchronized (lock) {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "my-1");
        Thread thread2 = new Thread(myThread, "my-2");
        thread1.start();
        thread2.start();

    }

}


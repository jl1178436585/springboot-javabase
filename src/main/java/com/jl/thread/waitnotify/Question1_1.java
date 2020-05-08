package com.jl.thread.waitnotify;

/**
 * 子线程循环10次，接着主线程循环100次，接着
 * 又回到子线程循环10次，主线程循环100次，如此循环50次
 *
 *  wait()一定要放在while循环中，防止死锁
 *
 */
public class Question1_1 {


    public static void main(String[] args) throws InterruptedException {
        Print1 print = new Print1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.sub(i);
                }

            }
        }).start();

        //主线程
        for (int i = 0; i < 50; i++) {
            print.main(i);
        }
    }
}

class Print1{

    public static volatile boolean sub = true;

    public synchronized void sub(int i){
        while(!sub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName()+" ："+ (i+1) + " ，"+ (j+1));
        }
        sub = false;
        this.notify();

    }

    public synchronized void main(int i){
        while(sub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName()+" ："+ (i+1) + " ，"+ (j+1));
        }
        sub = true;
        this.notify();

    }

}

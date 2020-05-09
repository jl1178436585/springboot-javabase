package com.jl.thread.waitnotify;

/**
 * 子线程循环10次，接着主线程循环100次，接着
 * 又回到子线程循环10次，主线程循环100次，如此循环50次
 * <p>
 * 此类有bug，但是不一定出现bug,多运行几次试试, 消费放在了else里面，会造成有的消费不了，
 * wait()一定要放在while循环中，防止两个线程都阻塞，无法唤醒
 *
 * 问题原因;
 *    由于wait和执行逻辑在if,else逻辑里面，是互斥的，
 *    当main进入等待，并且是第50次循环【之前】时候，
 *    sub也是第五十次但是sub进入了等待，从而什么也没输出，看控制台感觉还没执行完，其实已经循环完毕，sub线程退出了，
 *    然后main进入了等待
 */
public class Question1_1_bug {


    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        Thread sub = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    print.sub(i);
                }

            }
        });
        sub.setName("subThead");
        sub.start();
        Thread.sleep(1200);
        //主线程
        for (int i = 0; i < 50; i++) {
            print.main(i);
        }
    }
}

class Print {
    //是否是子线程调用
    public static volatile boolean sub = true;

    public synchronized void sub(int i) {
        if (!sub) {
            try {
                System.out.println("sub----进入等待---sub----" + sub+ ",i=" + (i+1));
                this.wait();
                System.out.println("sub----被唤醒---sub=" + sub + ",i=" + (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + " ：" + (i + 1) + " ，" + (j + 1));
            }
            sub = false;
            this.notify();
        }

    }

    public synchronized void main(int i) throws InterruptedException {
        if (sub) {
            try {
                System.out.println("main----进入等待---sub=" + sub+ ",i=" + (i+1));
                this.wait();
                System.out.println("main----被唤醒---sub=" + sub+ ",i=" + (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            for (int j = 0; j < 100; j++) {
                System.out.println(Thread.currentThread().getName() + " ：" + (i + 1) + " ，" + (j + 1));
            }
            sub = true;
            this.notify();
        }




    }

}

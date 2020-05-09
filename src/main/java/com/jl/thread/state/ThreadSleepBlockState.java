package com.jl.thread.state;

/**
 * Thread.Sleep(0)的作用，就是触发操作系统立刻重新进行一次CPU竞争，竞争的结果也许是当前线程仍然获得CPU控制权，也许会换成别的线程获得CPU控制权
 *
 * synchronized会使线程进入BLOCKED状态，下面是线程堆栈
 *
 * my-2先进入sync代码块，所以获取了lock锁，导致my-1无法进入sync代码块，所以my-1处于BLOCKED状态
 * my-2调用了sleep(time)方法，导致my-2处于java.lang.Thread.State: TIMED_WAITING (sleeping) 状态
 *
     "my-2" #13 prio=5 os_prio=0 tid=0x000000001f835000 nid=0x5520 waiting on condition [0x00000000204ff000]
         java.lang.Thread.State: TIMED_WAITING (sleeping)
         at java.lang.Thread.sleep(Native Method)
         at com.jl.thread.state.ThreadSleepBlockState$MyThread.run(ThreadSleepBlockState.java:19)
         - locked <0x000000076c01ad58> (a com.jl.thread.state.StudentLock)
         at java.lang.Thread.run(Thread.java:748)

     "my-1" #12 prio=5 os_prio=0 tid=0x000000001f834800 nid=0x7ce4 waiting for monitor entry [0x00000000203ff000]
         java.lang.Thread.State: BLOCKED (on object monitor)
         at com.jl.thread.state.ThreadSleepBlockState$MyThread.run(ThreadSleepBlockState.java:19)
         - waiting to lock <0x000000076c01ad58> (a com.jl.thread.state.StudentLock)
         at java.lang.Thread.run(Thread.java:748)
 */
public class ThreadSleepBlockState {

    public static class MyThread implements Runnable {

        private StudentLock lock = new StudentLock();

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
            synchronized (lock) {
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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


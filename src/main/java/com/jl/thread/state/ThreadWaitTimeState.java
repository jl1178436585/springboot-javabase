package com.jl.thread.state;

/**
 * wait(1000)表示将锁释放1000毫秒，到时间后如果锁没有被其他线程占用，则再次得到锁，然后wait方法结束，执行后面的代码，
 * 如果锁被其他线程占用，则等待其他线程释放锁。
 * 注意，设置了超时时间的wait方法一旦过了超时时间，并不需要其他线程执行notify也能自动解除阻塞，
 * 但是如果没设置超时时间的wait方法必须等待其他线程执行notify或者被中断
 * ————————————————
 *
 *
 "my-2" #13 prio=5 os_prio=0 tid=0x000000001f733000 nid=0x8d8c in Object.wait() [0x00000000203df000]
     java.lang.Thread.State: TIMED_WAITING (on object monitor)
     at java.lang.Object.wait(Native Method)
     - waiting on <0x000000076c01ac98> (a com.jl.thread.state.StudentLock)
     at com.jl.thread.state.ThreadWaitTimeState$MyThread.run(ThreadWaitTimeState.java:25)
     - locked <0x000000076c01ac98> (a com.jl.thread.state.StudentLock)
     at java.lang.Thread.run(Thread.java:748)

 "my-1" #12 prio=5 os_prio=0 tid=0x000000001f72e800 nid=0x9cb4 in Object.wait() [0x00000000202de000]
     java.lang.Thread.State: TIMED_WAITING (on object monitor)
     at java.lang.Object.wait(Native Method)
     - waiting on <0x000000076c01ac98> (a com.jl.thread.state.StudentLock)
     at com.jl.thread.state.ThreadWaitTimeState$MyThread.run(ThreadWaitTimeState.java:25)
     - locked <0x000000076c01ac98> (a com.jl.thread.state.StudentLock)
     at java.lang.Thread.run(Thread.java:748)

 *
 *
 */
public class ThreadWaitTimeState {

    public static class MyThread implements Runnable {

        private StudentLock lock = new StudentLock();

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
                try {
                    lock.wait(200000);
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

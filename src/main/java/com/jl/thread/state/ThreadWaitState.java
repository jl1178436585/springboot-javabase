package com.jl.thread.state;

/**
 *
 *  "my-2" #13 prio=5 os_prio=0 tid=0x000000001ff12800 nid=0xafdc in Object.wait() [0x0000000020bae000]
 *      java.lang.Thread.State: WAITING (on object monitor)
 * 	    at java.lang.Object.wait(Native Method)
 * 	    - waiting on <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
 * 	    at java.lang.Object.wait(Object.java:502)
 * 	    at com.jl.thread.state.ThreadWaitState$MyThread.run(ThreadWaitState.java:19)
 * 	    - locked <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
 * 	    at java.lang.Thread.run(Thread.java:748)
 *
 * "my-1" #12 prio=5 os_prio=0 tid=0x000000001ff11800 nid=0xa258 in Object.wait() [0x0000000020aae000]
 *       java.lang.Thread.State: WAITING (on object monitor)
 *  	at java.lang.Object.wait(Native Method)
 * 	    - waiting on <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
 * 	    at java.lang.Object.wait(Object.java:502)
 * 	    at com.jl.thread.state.ThreadWaitState$MyThread.run(ThreadWaitState.java:19)
 * 	    - locked <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
 * 	    at java.lang.Thread.run(Thread.java:748)
 *
 */
public class ThreadWaitState {

    public static class MyThread implements Runnable {

        private StudentLock lock = new StudentLock();

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getState());
                try {
                    lock.wait();
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

这是 ThreadWaitState 运行的线程堆栈，
```
2020-05-09 15:48:53
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):

"DestroyJavaVM" #14 prio=5 os_prio=0 tid=0x0000000003059000 nid=0xaa54 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"my-2" #13 prio=5 os_prio=0 tid=0x000000001ff12800 nid=0xafdc in Object.wait() [0x0000000020bae000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
	at java.lang.Object.wait(Object.java:502)
	at com.jl.thread.state.ThreadWaitState$MyThread.run(ThreadWaitState.java:19)
	- locked <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
	at java.lang.Thread.run(Thread.java:748)

"my-1" #12 prio=5 os_prio=0 tid=0x000000001ff11800 nid=0xa258 in Object.wait() [0x0000000020aae000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
	at java.lang.Object.wait(Object.java:502)
	at com.jl.thread.state.ThreadWaitState$MyThread.run(ThreadWaitState.java:19)
	- locked <0x000000076c01a9b0> (a com.jl.thread.state.StudentLock)
	at java.lang.Thread.run(Thread.java:748)

"Service Thread" #11 daemon prio=9 os_prio=0 tid=0x000000001fdb4000 nid=0xba50 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #10 daemon prio=9 os_prio=2 tid=0x000000001fd02800 nid=0xbd6c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x000000001fd02000 nid=0xbb60 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001fcdc800 nid=0xb0ac waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001fcdc000 nid=0xb840 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001fcf9000 nid=0xb370 runnable [0x00000000203ae000]
   java.lang.Thread.State: RUNNABLE
	at java.net.SocketInputStream.socketRead0(Native Method)
	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
	at java.net.SocketInputStream.read(SocketInputStream.java:171)
	at java.net.SocketInputStream.read(SocketInputStream.java:141)
	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	- locked <0x000000076c10f658> (a java.io.InputStreamReader)
	at java.io.InputStreamReader.read(InputStreamReader.java:184)
	at java.io.BufferedReader.fill(BufferedReader.java:161)
	at java.io.BufferedReader.readLine(BufferedReader.java:324)
	- locked <0x000000076c10f658> (a java.io.InputStreamReader)
	at java.io.BufferedReader.readLine(BufferedReader.java:389)
	at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001e5ba000 nid=0xb884 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001e566000 nid=0xb8d0 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001ce66000 nid=0xbfb0 in Object.wait() [0x000000001f8af000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076bd08ed8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
	- locked <0x000000076bd08ed8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x000000001e543000 nid=0xa7fc in Object.wait() [0x000000001f7af000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076bd06c00> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x000000076bd06c00> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=2 tid=0x000000001ce56000 nid=0xb428 runnable 

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x000000000306d800 nid=0xbb9c runnable 

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x000000000306f000 nid=0xbea8 runnable 

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000003071000 nid=0xbf8c runnable 

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000003072800 nid=0xbb04 runnable 

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000003075800 nid=0xb7dc runnable 

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000003077000 nid=0xa860 runnable 

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x000000000307a000 nid=0xb7b0 runnable 

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x000000000307b000 nid=0xbd90 runnable 

"GC task thread#8 (ParallelGC)" os_prio=0 tid=0x000000000307c800 nid=0xbb8c runnable 

"GC task thread#9 (ParallelGC)" os_prio=0 tid=0x000000000307d800 nid=0xb230 runnable 

"VM Periodic Task Thread" os_prio=2 tid=0x000000001fdfa800 nid=0xb450 waiting on condition 

JNI global references: 12


```

这是 ThreadWaitState 运行的线程堆栈，
```
2020-05-09 15:51:11
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):

"DestroyJavaVM" #14 prio=5 os_prio=0 tid=0x0000000002949000 nid=0x65f8 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

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

"Service Thread" #11 daemon prio=9 os_prio=0 tid=0x000000001f5fb000 nid=0xb40c runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #10 daemon prio=9 os_prio=2 tid=0x000000001f537000 nid=0xb9b4 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x000000001f536800 nid=0xbec8 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001f535800 nid=0xbf70 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001f533000 nid=0xb1d0 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001f50c800 nid=0xbd88 runnable [0x000000001fbde000]
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

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001ddfa800 nid=0xbadc waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001dda4800 nid=0xacd8 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001c6c4800 nid=0x9598 in Object.wait() [0x000000001f0df000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076bd08ed8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
	- locked <0x000000076bd08ed8> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x000000001dd83000 nid=0x7b4c in Object.wait() [0x000000001efdf000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x000000076bd06c00> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x000000076bd06c00> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=2 tid=0x000000001dd62800 nid=0x8e54 runnable 

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x000000000295d800 nid=0x110 runnable 

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x000000000295f000 nid=0xb4a4 runnable 

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002961000 nid=0x6990 runnable 

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002962800 nid=0xb084 runnable 

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000002965800 nid=0xbb98 runnable 

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000002967000 nid=0x24d4 runnable 

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x000000000296a000 nid=0xaf40 runnable 

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x000000000296b000 nid=0xaa04 runnable 

"GC task thread#8 (ParallelGC)" os_prio=0 tid=0x000000000296c800 nid=0x2dd0 runnable 

"GC task thread#9 (ParallelGC)" os_prio=0 tid=0x000000000296d800 nid=0x644c runnable 

"VM Periodic Task Thread" os_prio=2 tid=0x000000001f662800 nid=0xb5c0 waiting on condition 

JNI global references: 12


```

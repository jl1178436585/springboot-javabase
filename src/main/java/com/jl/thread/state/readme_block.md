这是ThreadBlockState运行的线程堆栈，

2020-05-08 17:36:01
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.231-b11 mixed mode):

"DestroyJavaVM" #14 prio=5 os_prio=0 tid=0x0000000002b69000 nid=0x219c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"my-2" #13 prio=5 os_prio=0 tid=0x000000001f97e000 nid=0x4af8 waiting for monitor entry [0x000000002068e000]
   java.lang.Thread.State: BLOCKED (on object monitor)
	at com.jl.thread.state.MyThread.run(ThreadStateTest.java:27)
	- waiting to lock <0x00000006c360a7b0> (a java.lang.String)
	at java.lang.Thread.run(Thread.java:748)

"my-1" #12 prio=5 os_prio=0 tid=0x000000001f97c000 nid=0x35d8 runnable [0x000000002058f000]
   java.lang.Thread.State: RUNNABLE
	at java.io.FileOutputStream.writeBytes(Native Method)
	at java.io.FileOutputStream.write(FileOutputStream.java:326)
	at java.io.BufferedOutputStream.flushBuffer(BufferedOutputStream.java:82)
	at java.io.BufferedOutputStream.flush(BufferedOutputStream.java:140)
	- locked <0x00000006c36360c8> (a java.io.BufferedOutputStream)
	at java.io.PrintStream.write(PrintStream.java:482)
	- locked <0x00000006c360c190> (a java.io.PrintStream)
	at sun.nio.cs.StreamEncoder.writeBytes(StreamEncoder.java:221)
	at sun.nio.cs.StreamEncoder.implFlushBuffer(StreamEncoder.java:291)
	at sun.nio.cs.StreamEncoder.flushBuffer(StreamEncoder.java:104)
	- locked <0x00000006c3612760> (a java.io.OutputStreamWriter)
	at java.io.OutputStreamWriter.flushBuffer(OutputStreamWriter.java:185)
	at java.io.PrintStream.newLine(PrintStream.java:546)
	- eliminated <0x00000006c360c190> (a java.io.PrintStream)
	at java.io.PrintStream.println(PrintStream.java:807)
	- locked <0x00000006c360c190> (a java.io.PrintStream)
	at com.jl.thread.state.MyThread.run(ThreadStateTest.java:27)
	- locked <0x00000006c360a7b0> (a java.lang.String)
	at java.lang.Thread.run(Thread.java:748)

"Service Thread" #11 daemon prio=9 os_prio=0 tid=0x000000001f896000 nid=0x7ef8 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #10 daemon prio=9 os_prio=2 tid=0x000000001f7e0800 nid=0x7e18 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #9 daemon prio=9 os_prio=2 tid=0x000000001f7e0000 nid=0x6540 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001f7df000 nid=0x6fb4 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001f7dc800 nid=0x77b4 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001f74e800 nid=0x7e78 runnable [0x000000001fe8e000]
   java.lang.Thread.State: RUNNABLE
	at java.net.SocketInputStream.socketRead0(Native Method)
	at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
	at java.net.SocketInputStream.read(SocketInputStream.java:171)
	at java.net.SocketInputStream.read(SocketInputStream.java:141)
	at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
	at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
	at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
	- locked <0x00000006c3610528> (a java.io.InputStreamReader)
	at java.io.InputStreamReader.read(InputStreamReader.java:184)
	at java.io.BufferedReader.fill(BufferedReader.java:161)
	at java.io.BufferedReader.readLine(BufferedReader.java:324)
	- locked <0x00000006c3610528> (a java.io.InputStreamReader)
	at java.io.BufferedReader.readLine(BufferedReader.java:389)
	at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x000000001dfe9000 nid=0x7938 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x000000001dfe8000 nid=0x72cc runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001c8e4800 nid=0x7054 in Object.wait() [0x000000001f32f000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000006c3612470> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
	- locked <0x00000006c3612470> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x000000001dfc3000 nid=0x7920 in Object.wait() [0x000000001f22e000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000006c360c3e0> (a java.lang.ref.Reference$Lock)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x00000006c360c3e0> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=2 tid=0x000000001dfa2000 nid=0x791c runnable 

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002b7d800 nid=0x500 runnable 

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002b7f000 nid=0x6d30 runnable 

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002b81000 nid=0x7f58 runnable 

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002b82800 nid=0x3710 runnable 

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000002b85800 nid=0x7bb0 runnable 

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000002b87000 nid=0x6144 runnable 

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x0000000002b8a000 nid=0x7a30 runnable 

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x0000000002b8b000 nid=0x74f8 runnable 

"GC task thread#8 (ParallelGC)" os_prio=0 tid=0x0000000002b8c800 nid=0x7b58 runnable 

"GC task thread#9 (ParallelGC)" os_prio=0 tid=0x0000000002b8d800 nid=0x7ddc runnable 

"VM Periodic Task Thread" os_prio=2 tid=0x000000001f8ec800 nid=0x6398 waiting on condition 

JNI global references: 12


package TradeWeb;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Make 3 threads t1, t2 & t3 print A, B and C in that order
 */
public class ThreadSequencing {
    private volatile int currentRunningThread = 1;
    private Thread t1 = new Thread(new AThread(1, this));
    private Thread t2 = new Thread(new AThread(2, this));
    private Thread t3 = new Thread(new AThread(3, this));

    public static void main(String[] args) {
        new ThreadSequencing().launchThreads();

    }

    public void launchThreads() {
        t1.start();
        t2.start();
        t3.start();
    }





    class AThread implements Runnable {
        private int threadId;
        private ThreadSequencing lockObject;

        public AThread(int threadId, ThreadSequencing lockObject) {
            this.threadId = threadId;
            this.lockObject = lockObject;
        }

        @Override
        public void run() {
            synchronized (lockObject) {
                while (true) {
                    while (lockObject.currentRunningThread != threadId) {
                        try {
                            lockObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(threadId + " ");
                    if (lockObject.currentRunningThread >= 3) {
                        lockObject.currentRunningThread = 1;
                    } else {
                        lockObject.currentRunningThread++;
                    }
                    lockObject.notifyAll();
                }
            }

        }
    }
}

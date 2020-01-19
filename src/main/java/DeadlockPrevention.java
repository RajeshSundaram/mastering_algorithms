import java.util.concurrent.TimeUnit;

public class DeadlockPrevention {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomThread(1), "1");
        Thread t2 = new Thread(new CustomThread(1), "2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class CustomThread implements  Runnable {

    private Integer lock = 0;
    public CustomThread(Integer lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println(getClass().getName() + " locks Integer");
            try {
                TimeUnit.MINUTES.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
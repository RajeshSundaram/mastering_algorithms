



public class DeadlockSample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new CustomThread1(), "1");
        Thread t2 = new Thread(new CustomThread2(), "2");
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


class CustomThread1 implements  Runnable {

    @Override
    public void run() {
        synchronized (Integer.class) {
            System.out.println(getClass().getName() + " locks Integer");
            synchronized (String.class) {
                System.out.println(getClass().getName() + " locks String");
            }
        }
    }
}

class CustomThread2 implements  Runnable {

    @Override
    public void run() {
        synchronized (String.class) {
            System.out.println(getClass().getName() + " locks String");
            synchronized (Integer.class) {
                System.out.println(getClass().getName() + " locks Integer");
            }
        }
    }
}
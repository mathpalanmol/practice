package concurrency;

public class ThreadConcurrent  {
    int []array=new int[]{0,1,2,3,4,5,6,7,8,9,10};
    volatile int i=0;

public  void checkSum() {
    synchronized (this) {
        for(;i<array.length;){
            System.out.println("thread name "+Thread.currentThread().getName()+ "  : "+array[i]);
            i++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

public static void main(String[] args) {

    final ThreadConcurrent er=new ThreadConcurrent();       
    Thread t1=new Thread(new Runnable() {

        @Override
        public void run() {
            er.checkSum();

        }
    }, "T1");
    Thread t21=new Thread(new Runnable() {

        @Override
        public void run() {
            er.checkSum();

        }
    }, "T2");
    t1.start();
    t21.start();
}}

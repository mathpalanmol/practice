package dummy;

public class Controller {

	public static void main(String[] args) throws InterruptedException {
	 Test test = new Test();
     Producer producer = new Producer(test);
 //    producer.setName("Producer");
     Thread threada = new Thread(producer);
     threada.start();
     Consumer consumer = new Consumer(test);
     consumer.setName("Consumer");
    
     consumer.start();
     Thread.currentThread().sleep(2000);
//     producer.start();
     
     
     Thread.sleep(10000);
     System.out.println(Thread.currentThread().getName());
	}

}

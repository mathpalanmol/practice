package dummy;

import java.util.ArrayList;
import java.util.List;

public class Test {
	List<Integer> list = new ArrayList<Integer>();

	public void populater() throws InterruptedException {
		synchronized (list) {
			for (int i = 0; i < 10; i++) {
				
				
				list.add(i);
				Thread.currentThread().sleep(2000);
				System.out.println("produce " + list.get(i));
				list.notify();
				list.wait();
				
				
			}
		}
	}

	public void print() throws InterruptedException {
		synchronized (list) {
			for (int i = 0; i < 10; i++) {
				if(list.size()==0)
					list.wait();
				list.get(0);
				Thread.currentThread().sleep(2000);
				System.out.println("consume " + list.get(i));
				list.notify();
				if(i < 9)
				list.wait();
			}
		}
	}

}

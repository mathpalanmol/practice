package patter.observer;

import java.util.ArrayList;

public class Observable implements IObserable {

	ArrayList<IObserver> list = new ArrayList<IObserver>();

	@Override
	public void addObserver(IObserver observer) {
		list.add(observer);

	}

	@Override
	public void removeObserver(IObserver observer) {
		list.remove(observer);

	}

	@Override
	public void notifyObserver() {
		for (IObserver observer : list)
			observer.update();

	}
	
	

}

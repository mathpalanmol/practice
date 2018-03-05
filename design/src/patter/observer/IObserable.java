package patter.observer;

public interface IObserable {

	public void addObserver(IObserver observer);

	public void removeObserver(IObserver observer);

	public void notifyObserver();

}

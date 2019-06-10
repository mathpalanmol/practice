package restaurant;

public class Slot{

	private int to;

	public Slot(int to, int from) {
		super();
		this.to = to;
		this.from = from;
	}

	private int from;

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "Slot [to=" + to + ", from=" + from + "]";
	}

	

}

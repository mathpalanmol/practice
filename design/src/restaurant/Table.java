package restaurant;

import java.util.HashMap;
import java.util.Map;

public class Table {
	int id;
	int capacity;
	//key day as string
	// value map contain key as hour and value as Slot
	Map<String, Map<Integer, Slot>> resBydateMap = new HashMap<String, Map<Integer, Slot>>();

	public Table(int id, int capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Map<Integer, Slot> getSlots(String date) {
		return resBydateMap.get(date);
	}

	public void setSlots(Map<String, Map<Integer, Slot>> resBydateMap) {
		this.resBydateMap = resBydateMap;
	}

	@Override
	public String toString() {
		return "Table [id=" + id + ", capacity=" + capacity + ", resBydateMap=" + resBydateMap + "]";
	}

}

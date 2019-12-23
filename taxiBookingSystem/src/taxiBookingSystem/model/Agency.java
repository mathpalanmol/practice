package taxiBookingSystem.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taxiBookingSystem.enums.Category;

public class Agency {
	private long id;
	private String name;

	private Map<Category, List<Vechile>> availableCabMap = new HashMap<Category, List<Vechile>>();
	private Map<Category, List<Vechile>> busyCabMap = new HashMap<Category, List<Vechile>>();

	private Map<Category, Integer> priceMappings = new HashMap<Category, Integer>();

	public Agency(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void registerVechile(Vechile vechile) {
		List<Vechile> vechileList = availableCabMap.get(vechile.getVechileType());
		if (vechileList == null) {
			List<Vechile> list = new ArrayList<Vechile>();
			list.add(vechile);
			availableCabMap.put(vechile.getVechileType(), list);
		} else {
			vechileList.add(vechile);
		}
	}
	// busy yet to be implemented.

	void setPrice(Category cabType, Integer fare) {
		priceMappings.put(cabType, fare);
	}

	public long getId() {
		return id;
	}

	public Map<Category, Integer> getPriceMappings() {
		return priceMappings;
	}

	public void setPriceMappings(Map<Category, Integer> priceMappings) {
		this.priceMappings = priceMappings;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Category, List<Vechile>> getAvailableCabMap() {
		return availableCabMap;
	}

	public void setAvailableCabMap(Map<Category, List<Vechile>> availableCabMap) {
		this.availableCabMap = availableCabMap;
	}

	public Map<Category, List<Vechile>> getBusyCabMap() {
		return busyCabMap;
	}

	public void setBusyCabMap(Map<Category, List<Vechile>> busyCabMap) {
		this.busyCabMap = busyCabMap;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", availableCabMap=" + availableCabMap + ", busyCabMap="
				+ busyCabMap + "]";
	}

}

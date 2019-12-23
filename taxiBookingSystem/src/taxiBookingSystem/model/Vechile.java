package taxiBookingSystem.model;

import taxiBookingSystem.enums.Category;

public class Vechile {
	long id;
	Category vechileType;
	int rate;
	Agency agency; // will be used later to get totol revenue per agency,

	public Vechile(long id, Category vechileType, Agency agency) {
		super();
		this.id = id;
		this.vechileType = vechileType;
		this.agency = agency;
	}

	public Vechile(long id, Category vechileType, int rate) {
		super();
		this.id = id;
		this.vechileType = vechileType;
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Category getVechileType() {
		return vechileType;
	}

	public void setVechileType(Category vechileType) {
		this.vechileType = vechileType;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return "Vechile [id=" + id + ", vechileType=" + vechileType + "]";
	}

}

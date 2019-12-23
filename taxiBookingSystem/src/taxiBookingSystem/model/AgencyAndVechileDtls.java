package taxiBookingSystem.model;

import java.util.List;

import taxiBookingSystem.enums.Category;

public class AgencyAndVechileDtls implements Comparable<AgencyAndVechileDtls> {
	Agency agency;
	List<Vechile> vechile;
	Category cabType;

	public AgencyAndVechileDtls(Agency agency, List<Vechile> vechile, Category cabType) {
		super();
		this.agency = agency;
		this.vechile = vechile;
		this.cabType = cabType;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public List<Vechile> getVechile() {
		return vechile;
	}

	public void setVechile(List<Vechile> vechile) {
		this.vechile = vechile;
	}

	public Category getCabType() {
		return cabType;
	}

	public void setCabType(Category cabType) {
		this.cabType = cabType;
	}

	@Override
	public int compareTo(AgencyAndVechileDtls agencyAndVechileDtls) {
		return this.agency.getPriceMappings().get(cabType)
				- agencyAndVechileDtls.agency.getPriceMappings().get(cabType);
	}

}

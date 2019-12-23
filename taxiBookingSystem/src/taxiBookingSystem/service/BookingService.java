package taxiBookingSystem.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taxiBookingSystem.enums.Category;
import taxiBookingSystem.model.Agency;
import taxiBookingSystem.model.AgencyAndVechileDtls;
import taxiBookingSystem.model.DistanceTime;
import taxiBookingSystem.model.Point;
import taxiBookingSystem.model.UserManagement;
import taxiBookingSystem.model.Vechile;
import taxiBookingSystem.model.VechileAvailabiltyDetails;

public class BookingService {

	Map<Long, Agency> agencies;
	UserManagement userManagement;

	public BookingService() {
		super();
		this.agencies = new HashMap<Long, Agency>();
	}

	public int getFare(Point p1, Point p2, Category cabType) {
		DistanceTime distanceTime = getDistance(p1, p2);
		List<Vechile> vechileList = getAvailableVechiles(cabType);
		int rate = 0;
		if (null == vechileList) {
			return 0;
		} else {
			rate = vechileList.get(0).getRate();
		}
		int distance = distanceTime.getDistance();
		// int time = distanceTime.getTime(); // these will be considered if supply is
		// greater than demand.
		// int activeUsersFactor = (int) (userManagement.getActiveUserCount() * .1);
		return (rate * distance);
	}

	public VechileAvailabiltyDetails getVechilesAvailability(Category cabType) {
		List<Agency> agencyList = new ArrayList<Agency>(agencies.values());
		int availableVCount = 0;
		int busyVCount = 0;
		for (Agency agency : agencyList) {
			Map<Category, List<Vechile>> availableCabMap = agency.getAvailableCabMap();
			Map<Category, List<Vechile>> busyCabMap = agency.getBusyCabMap();
			List<Vechile> availableVechileList = availableCabMap.get(cabType);
			List<Vechile> busyVechileList = busyCabMap.get(cabType);
			availableVCount = availableVechileList != null ? availableVechileList.size() : 0;
			busyVCount = availableVechileList != null ? busyVechileList.size() : 0;

		}
		return new VechileAvailabiltyDetails(availableVCount, busyVCount);

	}

	private List<Vechile> getAvailableVechiles(Category cabType) {
		List<Agency> agencyList = new ArrayList<Agency>(agencies.values());
		for (Agency agency : agencyList) {
			Map<Category, List<Vechile>> availableCabMap = agency.getAvailableCabMap();
			List<Vechile> vechileList = availableCabMap.get(cabType);
			if (vechileList != null)
				return vechileList;
		}
		return null;
	}

	// TODO
	public int dummyCalculateFare(Point p1, Point p2, Category cabType) {
		List<AgencyAndVechileDtls> cabAgenciesList = getAvailableCabs(cabType);
		Collections.sort(cabAgenciesList);
		DistanceTime distanceTime = getDistance(p1, p2);
		int distance = distanceTime.getDistance();
		int baseFair = 0;
		if (cabAgenciesList != null && cabAgenciesList.size() > 0) {
			baseFair = cabAgenciesList.get(0).getAgency().getPriceMappings().get(cabType);
			return baseFair * distance;
		}
		return 0;

	}

	public List<AgencyAndVechileDtls> getAvailableCabs(Category cabType) {
		List<AgencyAndVechileDtls> resList = new ArrayList<AgencyAndVechileDtls>();
		for (Agency agncy : agencies.values()) {
			List<Vechile> vechileList = getAvailableVechiles(cabType, agncy);
			resList.add(new AgencyAndVechileDtls(agncy, vechileList, cabType));
		}
		return resList;
	}

	private List<Vechile> getAvailableVechiles(Category cabType, Agency agency) {
		Map<Category, List<Vechile>> availableCabMap = agency.getAvailableCabMap();
		return availableCabMap.get(cabType);

	}

	// assumed method
	private DistanceTime getDistance(Point p1, Point p2) {
		return new DistanceTime(2, 3);
	}

	public void registerAgency(Agency agency) {
		agencies.put(agency.getId(), agency);
	}

	public UserManagement getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(UserManagement userManagement) {
		this.userManagement = userManagement;
	}

}

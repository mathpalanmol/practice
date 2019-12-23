package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CabFinder {

	static Map<Location, Map<CabType, List<Cab>>> availablecabsByLocation = new HashMap<Location, Map<CabType, List<Cab>>>();
	static Map<Location, Map<CabType, List<Cab>>> buyscabsByLocation = new HashMap<Location, Map<CabType, List<Cab>>>();
	static HashMap<Point, Location> locationList = new HashMap<Point, Location>();
	public static int resultSetSize = 5;

//	private List<CabDistance> getNearestCab(Passenger passenger, List<Cab> cabList) {
//		PriorityQueue<CabDistance> q = new PriorityQueue<CabDistance>(new Comparator<CabDistance>() {
//
//			@Override
//			public int compare(CabDistance d1, CabDistance d2) {
//				return d2.distance - d1.distance;
//			}
//		});
//		Cordinates pasCord = passenger.getCordinates();
//		int count = 0;
//		for (Cab cabByLocation : cabList) {
//			Cordinates cabCord = cabByLocation.getCordinates();
//			int currentDist = calculateDistance(pasCord, cabCord);
//			CabDistance cabDistance = new CabDistance(cabByLocation, currentDist);
//			if (count < resultSetSize) {
//				q.offer(cabDistance);
//				count++;
//			} else {
//				CabDistance cabdist = q.peek();
//				if (currentDist < cabdist.getDistance()) { // max heap
//					q.poll();
//					q.offer(cabDistance);
//				}
//			}
//		}
//		
//
//		return new ArrayList<CabDistance>(q);
//	}

	private int getDistanceTime(Point p1, Point p2) {
		return 0;
	}

}

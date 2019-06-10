package cabfinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.event.PopupMenuListener;

//24 hr format
//Given an array of meetings, find out the minimum number of conference rooms required. 
//
//class Meeting 
//{ 
//long startTime; 
//long endTime; 
//}; 
public class MeetingRoom {
	// static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static Map<String, List<Integer>> daySlots = new HashMap<String, List<Integer>>();
	static int roomCount = 0;

	static class Meeting {
		int sTime;
		int eTime;
		String day;
		List<Integer> slots = null;

		Meeting(String day, int sTime, int eTime) throws InterruptedException {
			this.day = day;
			this.sTime = sTime;
			this.eTime = eTime;
			slots = new ArrayList<Integer>();
			populateSlots(sTime, eTime);
		}

		private void populateSlots(Integer sTime, Integer eTime) throws InterruptedException {
			if (eTime <= sTime)
				return;
			slots.add(sTime);
			Integer temp = sTime;
			while (temp < eTime) {
				temp = temp + 15;

				String str = temp.toString().substring(2, 4);
				int mint = Integer.parseInt(str);
				if (mint > 0 && mint % 60 == 0) {
					temp += 40;
					if (!temp.equals(eTime)) {
						slots.add(temp);
					}
				} else {
					if (temp != eTime)
						slots.add(temp);
				}

			}
			System.out.println(slots);
		}

		public int getsTime() {
			return sTime;
		}

		public void setsTime(int sTime) {
			this.sTime = sTime;
		}

		public int geteTime() {
			return eTime;
		}

		public void seteTime(int eTime) {
			this.eTime = eTime;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public List<Integer> getSlots() {
			return slots;
		}

		public void setSlots(List<Integer> slots) {
			this.slots = slots;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Meeting m1 = new Meeting("22/07/1988", 1300, 1500);
		// Meeting m2 = new Meeting("23/07/1988",1500, 1700);
		// Meeting m3 = new Meeting("24/07/1988",1200, 1700);
		// Meeting m4 = new Meeting("23/07/1988",1500, 1700);
		// Meeting m5 = new Meeting("26/07/1988",1600, 1700);
		Meeting[] mArry = new Meeting[5];
		mArry[0] = m1;
		// mArry[1] = m2;
		// mArry[2] = m3;
		// mArry[3] = m4;
		// mArry[4] = m5;
		//
		// calculateRoom(mArry);
		// System.out.println(roomCount);
		getRoomCount(mArry);

	}
	// anmol.m one more with diff approach

	static int getRoomCount(Meeting[] mArry) {
		int count = 0;

		for (Meeting meeting : mArry) {
			List<Integer> slots = meeting.getSlots();
			List<Integer> daySlotlist = daySlots.get(meeting.getDay());
			if (daySlotlist != null && daySlotlist.size() > 0) {
				for (Integer val : slots) {
					boolean flag = false;
					for (Integer val1 : slots) {
						if (daySlotlist.contains(val)) {
							count++;
							flag = true;
							break;
						}
					}
					if (flag)
						break;
					else {
						for (Integer slt : slots) {
							daySlotlist.add(slt);
						}
					}
				}
			} else {
				daySlots.put(meeting.getDay(), slots);
				count++;
			}
		}
		System.out.println("count: " + count);
		return count;

	}

	// Map contains starTime as key and time difference as value
	// private static void calculateRoom(Meeting[] mArry) {
	// Map<Integer, Integer> map = null;
	// for (int i = 0; i < mArry.length; i++) {
	// if (days.containsKey(mArry[i].day))
	// map = days.get(mArry[i].day);
	// else {
	// map = new HashMap<Integer, Integer>();
	// days.put(mArry[i].day, map);
	// }
	// int sTime = mArry[i].sTime;
	// int eTime = mArry[i].eTime;
	// int diff = eTime - sTime;
	// if (map.containsKey(sTime)) {
	// if (map.get(sTime) == diff)
	// ;
	// continue;
	// }
	//
	// map.put(sTime, diff);
	// roomCount++;
	//
	// }
	// }

}

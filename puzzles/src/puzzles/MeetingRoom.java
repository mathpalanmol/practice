package puzzles;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//24 hr format
//Given an array of meetings, find out the minimum number of conference rooms required. 
//
//class Meeting 
//{ 
//long startTime; 
//long endTime; 
//}; 
public class MeetingRoom {
//	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static Map<String,Map<Integer, Integer>> days = new HashMap<String,Map<Integer, Integer>>();
	static int roomCount = 0;

	static class Meeting {
		int sTime;
		int eTime;
		String day;

		Meeting(String day, int sTime, int eTime) {
			this.day = day;
			this.sTime = sTime;
			this.eTime = eTime;
		}
	}

	public static void main(String[] args) {
		Meeting m1 = new Meeting("22/07/1988",13, 15);
		Meeting m2 = new Meeting("23/07/1988",15, 17);
		Meeting m3 = new Meeting("24/07/1988",12, 17);
		Meeting m4 = new Meeting("23/07/1988",15, 17);
		Meeting m5 = new Meeting("26/07/1988",16, 17);
		Meeting[] mArry = new Meeting[5];
		mArry[0] = m1;
		mArry[1] = m2;
		mArry[2] = m3;
		mArry[3] = m4;
		mArry[4] = m5;

		calculateRoom(mArry);
		System.out.println(roomCount);

	}
// Map contains starTime as key and time difference as value
	private static void calculateRoom(Meeting[] mArry) {
		Map<Integer, Integer> map = null;
		for(int i=0; i<mArry.length; i++){
			if(days.containsKey(mArry[i].day))
				map = days.get(mArry[i].day);
			else{
				map = new HashMap<Integer, Integer>();
				days.put(mArry[i].day, map);
			}
			int sTime = mArry[i].sTime;
			int eTime =  mArry[i].eTime;
			int diff = eTime-sTime;
			if(map.containsKey(sTime)){
				if(map.get(sTime)==diff);
				continue;
			}
				
				map.put(sTime, diff);
				roomCount++;
		
			
			}
		}
		
		
	}



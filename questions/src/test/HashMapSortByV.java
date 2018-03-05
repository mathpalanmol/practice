package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashMapSortByV {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(3, 33);
		map.put(2, 11);
		map.put(5, 11);
		map.put(4, 44);
		map.put(1, 11);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\nSorted:");
		for (Map.Entry<Integer, Integer> entry : sortByValue(map).entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}

	}

	private static LinkedHashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map) {
		LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<Integer, Integer>();
		ArrayList<Integer> kList = new ArrayList(map.keySet());
		Collections.sort(kList);
		ArrayList<Integer> vList = new ArrayList(map.values());
		Collections.sort(vList);
//		Iterator<Integer> itr = kList.iterator();
		for (int value : vList) {	
			Iterator<Integer> itr = kList.iterator();
			while (itr.hasNext()) {
				int key = itr.next();
				int val = map.get(key);
				if (val == value) {
					lmap.put(key, value);
					itr.remove();
					break;
				}
			}
			
		}
		return lmap;
	}
	public static LinkedHashMap<Integer, Integer> sortHashMapByValues(
	        HashMap<Integer, Integer> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<Integer> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapValues);
	    Collections.sort(mapKeys);

	    LinkedHashMap<Integer, Integer> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<Integer> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        Integer val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            
	            Integer comp1 = passedMap.get(key);
	            Integer comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
}

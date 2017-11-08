package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//find permutation
public class SortMapByValue {

	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("anmol", "mathpal");
		hashMap.put("kunal", "singh");
		hashMap.put("gudia", "mathpal");
		hashMap.put("vibhor", "rastogi");
		hashMap.put("manoj", "mathpal");
		hashMap.put("ankur", "joshi");

		Map<String, String> map = reverse(hashMap);
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	private static Map<String, String> reverse(HashMap<String, String> hashMap) {
		Set<Entry<String, String>> entrySet = hashMap.entrySet();
		// create new list with set so that entries can be sorted
		ArrayList<Entry<String, String>> arrayList = new ArrayList<Entry<String, String>>(entrySet);
		Collections.sort(arrayList, new ValuesComparator()); // .sort is only available for list
	    // LinkedHashmap to maintain sorted order. It's a ordered map ie. maintains insertion order.
		// if you use hashmap; it doesn't not maintain order. so while printing elments will be printed in random order
		// TreeMap; can't use it as it sort the values based on key
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		for (Entry<String, String> entry : arrayList) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		return linkedHashMap;
	}

}

class ValuesComparator implements Comparator<Entry<String, String>> {

	@Override
	public int compare(Entry<String, String> o1, Entry<String, String> o2) {

		return o1.getValue().compareTo(o2.getValue()); // ascending order
	}

}
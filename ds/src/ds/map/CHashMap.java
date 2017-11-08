package ds.map;

import java.util.HashMap;
import java.util.Map;

public class CHashMap<k, v> {
	
	int capacity = 10;
	int count = 0;
	@SuppressWarnings("unchecked")
	Entry<k,v>[] table = (Entry<k,v>[])new Entry[capacity];
	class Entry<k, v> {
		k Key;
		v value;
		Entry<k, v> next;

		public Entry(k key, v value) {
			super();
			Key = key;
			this.value = value;
		}
	}
		@SuppressWarnings("unchecked")
		public void put(k key, v value){
			Entry<k,v> newEntry = new Entry<k,v>(key,value);
			int index = calculateIndex(key);
			Entry<k,v> entry = (Entry<k, v>) table[index];
			if(entry == null){
				table[index] = (Entry<k, v>)newEntry;
				return;}
			Entry<k,v> pre = entry;
			while(entry != null){
				if(entry.Key.equals(key)){
					entry.value = value;
					return;
				}
				pre = entry;
				entry = entry.next;
			}
			pre.next = newEntry;
		
		}
		
		
		public v get(k key){
			int index = calculateIndex(key);
			Entry<k,v> entry = (Entry<k,v>)table[index];
			while(entry != null){
				if(entry.Key.equals(key))
					break;
				else
					entry = entry.next;
			}
			return entry.value;
		}

		private int calculateIndex(k key) {
			return key.hashCode() % capacity;
		}
	
		
		public static void main(String[] args) {
	        Map map1 = new HashMap();
			CHashMap<Employee, String> map = new CHashMap<Employee, String>();
			Employee emp1 = new Employee("Anmol",29); 
			Employee emp2 = new Employee("Varsha",29);
			System.out.println(emp1.equals(emp2));
			map.put(emp1, "first Entry");
			map.put(emp2, "Second Entry");
			System.out.println(map.get(emp1));
			
		}

	
}

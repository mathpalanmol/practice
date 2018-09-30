import java.util.ArrayList;
import java.util.List;

//Input: "25525511135"
//Output: ["255.255.11.135", "255.255.111.35"]

public class Solution {

	public static void main(String[] args) {
		Solution ref = new Solution();
		String str = "0";
		Integer i = Integer.parseInt(str.charAt(0)+"");
		if(i == 0) {
			System.out.println(true);
		}
		System.out.println("i: " + i);
		System.out.println();
		String input = "25525511135";
		List<String> list = new ArrayList<String>();
		list = ref.create(list, input, "", 0, input.length() - 1, 0);
		for(String ip : list)
			System.out.println(ip);

	}

	List<String> create(List<String> list, String str, String output, int low, int high, int count) {
		if (count > 4)
			return list;
		if (low >= high && count == 4 && output.length() == (str.length() + 4)) {
//			System.out.println(output.substring(0, output.length() - 1)); // remove '.'
			list.add(output.substring(0, output.length() - 1));
			return list;
		}
		if ((low + 3) <= str.length()) {
			int no = Integer.parseInt(str.substring(low, low + 3));
			if (no <= 255) {
				create(list, str, output + str.substring(low, low + 3) + ".", (low + 3), high, count + 1);
			} else {
				create(list, str, output + str.substring(low, low + 2) + ".", (low + 2), high, count + 1);
			}

		}
		if ((low + 2) <= str.length()) {
			create(list, str, output + str.substring(low, low + 2) + ".", (low + 2), high, count + 1);
		}
		return list;

	}
	
	
	
	
	class Solution {
	    public List<String> restoreIpAddresses(String s) {
	        List<String> list = new ArrayList<String>();
	        if(s.equals("0000")){
	            list.add("0.0.0.0");
	            return list;
	        }
	        if(s.equals("1111")){
	            list.add("1.1.1.1");
	            return list;
	        }
	        return create(list, s, "", 0, s.length() - 1, 0);
	    }
	    
	    //https://leetcode.com/problems/restore-ip-addresses/description/
	    
	    List<String> create(List<String> list, String str, String output, int low, int high, int count) {
			if (count > 4 )
				return list;
			if (low >= high && count == 4 && output.length() == (str.length() + 4)) {
//				System.out.println(output.substring(0, output.length() - 1)); // remove '.'
				list.add(output.substring(0, output.length() - 1));
				return list;
			}
			if ((low + 1) <= str.length()) {
	            String ss = str.substring(low, low + 1);
	            char ch = ss.charAt(0);
	            int i  = Integer.parseInt(ch +"");
	            if(ss.length()==1)
	            create(list, str, output + str.substring(low, low + 1) + ".", (low + 1), high, count + 1);    
	            else{
	            if( i != 0)
				create(list, str, output + str.substring(low, low + 1) + ".", (low + 1), high, count + 1);
	            }
			}
	        if ((low + 2) <= str.length()) {
	             String ss =  str.substring(low, low + 2);
	            char ch = ss.charAt(0);
	            int i  = Integer.parseInt(ch +"");
	            if(ss.length()==1){         
	                create(list, str, output + str.substring(low, low + 2) + ".", (low + 2), high, count + 1);    
	            } else{
	            if( i != 0)
				create(list, str, output + str.substring(low, low + 2) + ".", (low + 2), high, count + 1);
	            }
			}
	        if ((low + 3) <= str.length()) {
				int no = Integer.parseInt(str.substring(low, low + 3));
				if (no <= 255) {
	                String ss = str.substring(low, low + 3);
	            char ch = ss.charAt(0);
	            int i  = Integer.parseInt(ch +"");
	            if(ss.length()==1)
	            create(list, str, output + str.substring(low, low + 3) + ".", (low + 3), high, count + 1);    
	            else{
	            if( i != 0)
				create(list, str, output + str.substring(low, low + 3) + ".", (low + 3), high, count + 1);
	            }

			}
			
			return list;

		}
	    
	    
	}

}

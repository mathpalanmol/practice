package ary;

import java.util.ArrayList;
import java.util.List;

public class IPAddress {

	List<String> list = new ArrayList<String>();

	public List<String> restoreIpAddresses(String s) {

		create(s, "", 0, s.length(), 0);
		return list;
	}

	void create(String str, String output, int low, int len, int count) {
		if (count > 4)
			return;
		if (output.length() == (len + 4) && count == 4) {
			list.add(output.substring(0, output.length() - 1));
			return;
		}
		if ((low + 1) <= str.length()) {
			create(str, output + str.substring(low, low + 1) + ".", (low + 1), len, count + 1);

		}
		if ((low + 2) <= str.length()) {

			if (str.substring(low, low + 2).charAt(0) != '0')
				create(str, output + str.substring(low, low + 2) + ".", (low + 2), len, count + 1);

		}
		if ((low + 3) <= str.length()) {
			if (Integer.parseInt(str.substring(low, low + 3)) <= 255) {
				if (str.substring(low, low + 3).charAt(0) != '0')
					create(str, output + str.substring(low, low + 3) + ".", (low + 3), len, count + 1);

			}

		}
	}

}
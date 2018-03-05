package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancySort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _exps_size = 0;
		_exps_size = Integer.parseInt(in.nextLine().trim());
		String[] _exps = new String[_exps_size];
		String _exps_item;
		for (int _exps_i = 0; _exps_i < _exps_size; _exps_i++) {
			try {
				_exps_item = in.nextLine();
			} catch (Exception e) {
				_exps_item = null;
			}
			_exps[_exps_i] = _exps_item;
		}

		fancySort(_exps);

	}

	static void fancySort(String[] exps) {
		List<String> listExps = new ArrayList<String>();
		TreeMap<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
		boolean skip = false;
		for (String exp : exps) {
			skip = false;
			String[] strAry = exp.split(",");
			String operation = strAry[0];
			int[] operands = new int[strAry.length - 1];
			for (int i = 1; i < strAry.length; i++) {
				try {
					Pattern p = Pattern.compile(">>");
					Matcher matcher = p.matcher(strAry[i]);
					if (matcher.find()) {
						skip = true;
						break;
					}
					operands[i - 1] = Integer.parseInt(strAry[i]);
				} catch (NumberFormatException ex) {
					skip = true;
				}
			}
			if (!skip) {
				Integer value = getValue(operation, operands);
				if (map.containsKey(value)) {
					List<String> list = map.get(value);
					list.add(exp);
					Collections.sort(list);
				} else {
					List list = new ArrayList<String>();
					list.add(exp);
					map.put(value, list);
				}
			}

		}
		print(map.values());

	}

	private static void print(Collection<List<String>> values) {
		for (List<String> exps : values) {
			for (String exp : exps)
				System.out.println(exp);
		}

	}

	private static int getValue(String operation, int[] operands) {
		Integer value = 0;
		switch (operation) {
		case "ADD":
			value = add(operands);
			break;
		case "DIVIDE":
			value = divide(operands);
			break;
		case "SUBTRACT":
			value = subtract(operands);
			break;
		case "MULTIPLY":
			value = multiply(operands);
			break;
		case "MIN":
			value = min(operands);
			break;
		case "MAX":
			value = max(operands);
			break;
		}
		return value;
	}

	private static int add(int[] ary) {
		int sum = 0;
		for (int i : ary) {
			sum += i;
		}
		return sum;
	}

	private static int subtract(int[] ary) {
		int sub = ary[0];
		for (int i = 1; i < ary.length; i++) {
			sub = sub - ary[i];
		}
		return sub;
	}

	private static int multiply(int[] ary) {
		int mul = 1;
		for (int i : ary) {
			mul *= i;
		}
		return mul;
	}

	private static int divide(int[] ary) {
		int div = ary[0];
		for (int i = 1; i < ary.length; i++) {
			div = div / ary[i];
		}
		return div;
	}

	private static int min(int[] ary) {
		int min = Integer.MAX_VALUE;
		for (int i : ary) {
			if (i < min)
				min = i;
		}
		return min;
	}

	private static int max(int[] ary) {
		int max = Integer.MIN_VALUE;
		for (int i : ary) {
			if (i > max)
				max = i;
		}
		return max;
	}

}

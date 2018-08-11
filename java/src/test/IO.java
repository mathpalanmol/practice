package test;

import java.text.ParseException;
import java.util.Scanner;
import java.util.TreeSet;

//3
//
//900 920
//
//910 950
//
//940 1000
public class IO {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		String line1 = scan.next() + scan.nextLine();
		String[] ary = line1.split(" ");
		System.out.println(ary.length);
		String line2 = scan.next() + scan.nextLine();
		String line3 = scan.next() + scan.nextLine();
		System.out.println(line3);
	}
			public String sortStringChars(String str) {
				char[] chAry = str.toCharArray();
				TreeSet<Character> set = new TreeSet<Character>();
				for (char ch : chAry)
					set.add(ch);
				String output = "";
				for (char ch : set) {
					output = output + ch;
				}
				System.out.println(output);
				return output;
			}
			

	}

	
	
	
	
// Scan array
//Scanner in = new Scanner(System.in);
//int n = in.nextInt();
//int[] ary = new int[n];
//for(int i=0; i < n; i++){
//	ary[i] = in.nextInt();
//}

// scan 2-D array
//Scanner in = new Scanner(System.in);
//int row = in.nextInt();
//int col = in.nextInt();
//int grid[][] = new int[row][col];
//for(int i=0; i < row; i++){
//    for(int j=0; j < col; j++){
//        grid[i][j] = in.nextInt();
//    }
//}	
	
// Line by Line scanning
//Scanner scan = new Scanner(System.in);
//String line1 = scan.next() + scan.nextLine();
//String[] ary = line1.split(" ");
//System.out.println(ary.length);
//String line2 = scan.next() + scan.nextLine();
//String line3 = scan.next() + scan.nextLine();
//System.out.println(line3);
	
//	public String sortStringChars(String str) {
//		char[] chAry = str.toCharArray();
//		TreeSet<Character> set = new TreeSet<Character>();
//		for (char ch : chAry)
//			set.add(ch);
//		String output = "";
//		for (char ch : set) {
//			output = output + ch;
//		}
//		System.out.println(output);
//		return output;
//	}

//	String str = "";
//	// while(scan.hasNextLine())
//	str = scan.nextLine();
//	System.out.println(str);
//	String str1 = str.replaceAll("\\s+", "");
//	System.out.println(str1);
//	// System.out.println(str1);
//	 String revString = new StringBuilder(str1).reverse().toString();
//	// System.out.println(revString);
//	// if(revString.equalsIgnoreCase(str1))
//	// System.out.println("Y");
//	// else
	// System.out.println("N");
	
	// train

	// Scanner scan = new Scanner(System.in);
	// Integer trainCount = scan.nextInt();
	// int count = 0;
	// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	// map.put(scan.nextInt(), scan.nextInt());
	// count++;
	// for (int i = 0; i < trainCount - 1; i++) {
	// Integer arrival = scan.nextInt();
	// Integer departure = scan.nextInt();
	// boolean bt = true;
	// for (Entry<Integer, Integer> set : map.entrySet()) {
	// HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
	// temp.put(set.getKey(), set.getValue());
	// if (arrival < set.getValue()) {
	// if(bt){
	// count++;
	// bt = false;}
	// temp.put(arrival, departure);
	//// break;
	// }else{
	// count --;
	// }
	// map = temp;
	// }
	// }
	// System.out.println(count);
//}

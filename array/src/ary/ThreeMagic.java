package ary;


//A number ending with 3 will have a multiple which is all 1. Eg­ multiple of 3 is 111 and of
//
//13 is 111111. Given a number ending with 3 find its least multiple which is all 1. The
//
//2 multiple of the given number can be beyond the range of int,long etc. Optimize for time

import java.math.BigInteger;

public class ThreeMagic {

	public static void main(String[] args) {
		BigInteger output = compute(11113);
		System.out.println(output.toString());

	}

	public static BigInteger compute(Integer n) {
		BigInteger val = new BigInteger("1");
		BigInteger no = new BigInteger(n.toString());
		while (true) {
			if (val.mod(no).equals(new BigInteger("0"))) {
				return val;
			}
			val = new BigInteger(val.toString() + "1");
		}

	}

}

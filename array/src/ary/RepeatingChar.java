package ary;


// Given a string, the task is to find maximum consecutive repeating character in string. 
// Note : We do not need to consider overall count, but the count of repeating that appear at one place.
// Input : str = "lleeeji" Output : e

public class RepeatingChar {

	public static void main(String [] args){
        char ch = '\u0000';
        System.out.println((int)ch);
        int max = Integer.MIN_VALUE;
        char[] ary = args[0].toCharArray();
        for(int i=0; i< ary.length-1; i++){
            int j = i+1;
            int count =0;
            while(ary[i] == ary[j]){
                count ++;
                j++;
            }
            if(count > max){
                ch = ary[i];
                max = count;
            }
            i = j;
        }
        System.out.println(ch);
      }

}

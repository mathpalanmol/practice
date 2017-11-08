package questions.array;

//1,1,2,3,5,8,13,21,34,55,89,144,...
//0,1,1,2,3,5,8,13,21,34,55,89,144,...
//the first two numbers in the Fibonacci sequence are either 1 and 2, or 0 and 1, depending on the chosen starting point of the sequence, and each subsequent number is the sum of the previous two
public class Fibonacci {
	static int[] ary;
	
	void generateFibo(int[] ary, int index, int len){
		if(index == len )
			return;
		ary[index] = ary[index-1] + ary[index-2];
		generateFibo(ary, index+1, len);
	}
	void print(){
		for(int value: ary)
			System.out.print(value + " ");
	}
	public static void main(String[] args) {
		Fibonacci ref = new Fibonacci();
		int size = 7;
		ary = new int[size];
//		ary[0] = 0;
//		ary[1] = 1;
		ary[0] = 1;
		ary[1] = 2;
		ref.generateFibo(ary, 2, 7);
		ref.print();
		
	}

}

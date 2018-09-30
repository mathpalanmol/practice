package problem;
//O(2^n*n)-- this solution
// with brute force it is n!

//https://www.youtube.com/watch?v=JE0JE8ce1V0  (Travelling Salesman Problem using Dynamic Programming - Easiest Approach with Code)
public class TSP {
	static int dist[][] = { 
			{ 0, 20, 42, 25 }, 
			{ 20, 0, 30, 34 }, 
			{ 42, 30, 0, 10 }, 
			{ 25, 34, 10, 0 } 
			};
	static int n = 4;
	static int[][] dp = new int[1<<n][n];
	//1<<n means adding n zero towards right. left shift alwasy double the number.
	static int VISITED_ALL = (1 << n) - 1; // 1<<4--> 10000 - 00001 -->X1111
   
	public static void main(String[] args) {

		// initialize dp array with -1.
	//		for(int i=0;i<(1<<n);i++){
	//	        for(int j=0;j<n;j++){
	//	            dp[i][j] = -1;
	//	        }
	//	    }
		int cost = tsp(1, 0);
		System.out.println(cost);
	}

	static int tsp(int mask, int pos) {

		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
//		if (dp[mask][pos] != -1) {
//			return dp[mask][pos];
//		}

		// Now from current node, we will try to go to every other node and take the min
		// ans
		int ans = Integer.MAX_VALUE;

		// Visit all the unvisited cities and take the best route
		for (int city = 0; city < n; city++) {

			if ((mask & (1 << city)) == 0) {

				int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
				ans = Math.min(ans, newAns);
			}

		}
//		return dp[mask][pos] = ans;
		return ans;
	}
}

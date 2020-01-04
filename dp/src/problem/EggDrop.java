package problem;

//        Objec­tive:  There are n number of eggs and building which has k floors.
//        Write an algorithm to find the minimum number of drops is required to know the floor from which if egg is dropped, it will break.

//…..An egg that survives a fall can be used again.
//        …..A broken egg must be discarded.
//        …..The effect of a fall is the same for all eggs.
//        …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
//        …..If an egg survives a fall then it would survive a shorter fall.
//        …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.


// A Dynamic Programming based Java Program for the Egg Dropping Puzzle
public class EggDrop {
    // A utility function to get maximum of two integers
    static int max(int a, int b) { return (a > b) ? a : b; }

    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    static int eggDrop(int n, int k)
    {
		/* A 2D table where entery eggFloor[i][j] will represent minimum
	number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
    }

    /* Driver program to test to pront printDups*/
    public static void main(String args[])
    {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in "+
                "worst case with "
                + n + " eggs and " + k + " floors is " + eggDrop(n, k));
    }
}
/*This code is contributed by Rajat Mishra*/


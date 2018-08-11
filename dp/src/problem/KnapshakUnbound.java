package problem;

import java.util.Arrays;

//Time complexity = O(i*(c+1)) // c is total weight - sack capacity and i is the items.
//Space complexity = O(c+1)


public class KnapshakUnbound {
    public static void main(String[] args) {
        item[] items = {
            new item(1, 1),
            new item(3, 4),
            new item(4, 5),
            new item(5, 7)
        };
        int capacity = 7;
        // capacityList will hold the max 'value' of weights that can be formed by given weight(given weight is the index of array.)
        int[] capacityList = new int[capacity + 1];// 0th index is for maxsum=0, required in further computation, 
                                                   // in dp we usually keep 0 as base solution.  
        // Outerloop runs through capacity-Total weight and inner one for each item weight.
        // cap = 0, i.e W=0 so outcome will be zero
        // cap = 1, i.e W=1, so total weight=1 and we need to calculate max value with given items.
        // for rest items (weight <= cap) this will be false;
        // let take an example when cap = 5
        // so first we'll take item with w=1,v=1, W=5-1, 
        // we will check if something is there in capacitylist for current index that we are going to fill. for first iteration it will be 0 always.
        // then we will find sum of current weight value ie. v1 + value of (totalweight i.e 5 - current weight i.e 1)-->4
        // now as we are keeping maxvalue of each weight-W. so we have to lookup for 4th index in capacityList to get max value for remaing weight
        // get the maxof [capacitylist[5] and above computed sum ] and put this computation in  capacitylist[5] = Max(capacitylist[5],currentvalue(v)+remaining weight value]
        // similarly do it for next iteration i.e w=3 and v=4
        for (int cap = 0; cap <= capacity; cap++) {
            for (item i: items) {
                if (i.weight <= cap) {
                    capacityList[cap] = Math.max(capacityList[cap], i.value + capacityList[cap - i.weight]);
                }
            }
        }
        System.out.println("Print array: " + Arrays.toString(capacityList));
        System.out.println(capacityList[capacity]);
    }
}


class item {
   public int weight;
   public int value;
   public item(int weight, int value) {
       this.weight = weight;
       this.value = value;
   }
}
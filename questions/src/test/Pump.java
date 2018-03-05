package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//4
//4 6
//6 5
//7 3
//4 5

//Find the first circular tour that visits all petrol pumps
//Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
//1. The amount of petrol that every petrol pump has.
//2. Distance from that petrol pump to the next petrol pump.
//Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity). Expected time complexity is O(n). Assume for 1 litre petrol, the truck can go 1 unit of distance.
//For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).

public class Pump {
	static class PetrolPump {
		int capacity;
		int distance;

		public PetrolPump(int capacity, int distance) {
			super();
			this.capacity = capacity;
			this.distance = distance;
		}

	}

	public static void main(String[] args) {
		Queue<PetrolPump> q = new LinkedList<PetrolPump>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		populateList(scan, q, count);
		PetrolPump start = process(q);
		System.out.println("Starting pump: " + start.capacity + " " + start.distance);
	}

	private static PetrolPump process(Queue<PetrolPump> q) {
		Queue<PetrolPump> q1 = new LinkedList<PetrolPump>();
		PetrolPump start = null;
		int buffer = 0;
		while (!q.isEmpty()) {
			PetrolPump pump = q.poll();
			start = pump;
			q1.add(pump);
			if (!((buffer = (buffer + pump.capacity) - pump.distance) >= 0)) {
				PetrolPump first = q1.poll();
				while (!q.isEmpty()) {
					q1.offer(q.poll());
				}
				
				q1.offer(first);
				q.addAll(q1);//q=q1 will not work because we are clearing q1
				q1.clear();
			}

		}
		return start;
	}

	private static void populateList(Scanner scan, Queue<PetrolPump> q, int count) {
		for (int i = 0; i < count; i++) {
			q.offer(new PetrolPump(scan.nextInt(), scan.nextInt()));
		}
	}
}

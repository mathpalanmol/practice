package ds.tree.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NearestToOrigin {

	public static void main(String[] args) {
		int pointsCount = 3; // k
		Point[] ary = new Point[10];
		populate(ary);
		PriorityQueue<Point> q = findMinPoints(ary, pointsCount);
		for (Point p : q) {
			System.out.println("x: " + p.x1 + " y :" + p.y1 + " distance: " + p.distance);
		}

	}

	
	// if you need only one nearest point then heap is not that effective.
	// but if your are looking for k nearest points it's very effective.
	private static PriorityQueue<Point> findMinPoints(Point[] ary, int pointsCount) {
		PriorityQueue<Point> q = new PriorityQueue<Point>(new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return p1.distance - p2.distance;
			}
		});
		int i = 0;
		for (; i < pointsCount; i++) {
			q.add(ary[i]);
		}
		while (i < ary.length) {
			Point p = q.peek();
			if (ary[i].distance < p.distance) { // if (== or < ... just ignore)
				q.poll();
				q.offer(p);
			}
			i++;
		}

		return q;
	}

	private static void populate(Point[] ary) {
		for (int i = 0; i < ary.length; i++) {
			ary[i] = new Point(i, i + 1);
		}

	}

	static class Point {
		int x1;
		int y1;
		int distance;

		Point(int x1, int y1) {
			this.x1 = x1;
			this.y1 = y1;
			this.distance = calculateDistance();
		}

		private int calculateDistance() {
			int x = x1 * x1;
			int y = y1 * y1;

			return (int) Math.sqrt(x + y); // distance from origion (x -0)2 + (y-0)2
		}
	}

}

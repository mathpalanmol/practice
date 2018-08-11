package ary;


import java.util.Arrays;
import java.util.Comparator;

public class ShortestDistance {

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	// A utility function to find the distance between two points
	float dist(Point p1, Point p2) {
		return (float) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	// A Brute Force method to return the smallest distance between two points
	// in P[] of size n
	float bruteForce(Point[] P, int n) {
		float min = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j)
				if (dist(P[i], P[j]) < min)
					min = dist(P[i], P[j]);
		return min;
	}

	// A utility function to find minimum of two float values
	float min(float x, float y) {
		return (x < y) ? x : y;
	}

	// A utility function to find the distance between the closest points of
	// strip of given size. All points in strip[] are sorted according to
	// y coordinate. They all have an upper bound on minimum distance as d.
	// Note that this method seems to be a O(n^2) method, but it's a O(n)
	// method as the inner loop runs at most 6 times
	float stripClosest(Point[] strip, int size, float d) {
		float min = d; // Initialize the minimum distance as d

		// qsort(strip, size, sizeof(Point), compareY);
		Arrays.sort(strip, new YComparator());
		// Pick all points one by one and try the next points till the
		// difference
		// between y coordinates is smaller than d.
		// This is a proven fact that this loop runs at most 6 times
		for (int i = 0; i < size; ++i)
			for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j)
				if (dist(strip[i], strip[j]) < min)
					min = dist(strip[i], strip[j]);

		return min;
	}

	// A recursive function to find the smallest distance. The array P contains
	// all points sorted according to x coordinate
	float closestUtil(Point[] P, int low, int high) {
		// If there are 2 or 3 points, then use brute force
		if (high - low <= 3)
			return bruteForce(P, high - low);

		// Find the middle point
		int mid = low + high / 2;
		Point midPoint = P[mid];

		// Consider the vertical line passing through the middle point
		// calculate the smallest distance dl on left of middle point and
		// dr on right side
		float dl = closestUtil(P, low, mid);
		float dr = closestUtil(P, mid, high);
		// float dl = closestUtil(P, mid);
		// float dr = closestUtil(P + mid, n-mid);
		// Find the smaller of two distances
		float d = min(dl, dr);

		// Build an array strip[] that contains points close (closer than d)
		// to the line passing through the middle point
		Point[] strip = (Point[]) new Point[high - low];
		int j = 0;
		for (int i = 0; i < high - low; i++)
			if (Math.abs(P[i].x - midPoint.x) < d) {
				strip[j] = P[i];
				j++;
			}

		// Find the closest points in strip. Return the minimum of d and closest
		// distance is strip[]
		return min(d, stripClosest(strip, j, d));
	}

	// The main functin that finds the smallest distance
	// This method mainly uses closestUtil()
	float closest(Point[] p, int low, int high) {
		// qsort(P, n, sizeof(Point), compareX);
		Arrays.sort(p, new XComparator());
		// Use recursive function closestUtil() to find the smallest distance
		return closestUtil(p, low, high);
	}

	class XComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.x - o2.x;
		}

	}

	class YComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			return o1.y - o2.y;
		}

	}

	public static void main(String[] args) {
		Point p1 = new ShortestDistance().new Point(2, 3);
		Point p2 = new ShortestDistance().new Point(12, 30);
		Point p3 = new ShortestDistance().new Point(40, 50);
		Point p4 = new ShortestDistance().new Point(5, 1);
		Point p5 = new ShortestDistance().new Point(12, 10);
		Point p6 = new ShortestDistance().new Point(3, 4);
		Point[] ary = { p1, p2, p3, p4, p5, p6 };

		ShortestDistance ref = new ShortestDistance();
		ref.closest(ary, 0, ary.length - 1);

	}

}

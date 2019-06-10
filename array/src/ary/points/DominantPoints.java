package ary.points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//From an initial set S of 2D points, how to efficiently compute a minimum(-size) dominating subset M ?
//Point d(xd,yd) is dominating point p(xp,yp) iff xp≤xd and yp≤yd. Also easy to see that this relation is tramsitive, i.e. if a dominating b and b dominating c, then a dominating c.
//O(NlogN)

public class DominantPoints {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}

	// First sort the points according to x coordinates (for points with same x
	// coordinates, sort according to y).
	// Then, go through all the points from bigger x to smaller x, add a point to M
	// if
	// and only if its y coordinate is strictly bigger than any y coordinate you've
	// seen before it.
	private static List<Point> getDominantPoints(List<Point> points) {
		List<Point> srtedList = new ArrayList<Point>(points); // keeping points list in orignal order. for now no use of
																// keep it as it is.
		sortByXYCord(srtedList);
		System.out.println(srtedList);
		
		//put first element in the list and add it's y coordinate as ref for other comparision.
		List<Point> domList = new ArrayList<Point>();
		domList.add(srtedList.get(0)); // Farthest point always dominating
		int yMax = srtedList.get(0).getY();
		for (int i = 1; i < srtedList.size(); i++) {
			if (srtedList.get(i).getY() > yMax) {
				yMax = srtedList.get(i).getY();
				domList.add(srtedList.get(i));
			}
		}

		return domList;
	}

	/*
	 * @author: Anmol Mathpal Sort based on x coordinate in desc order and for every
	 * x, sort based on desc order.
	 */

	private static void sortByXYCord(List<Point> srtedList) {

		Collections.sort(srtedList, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() == o2.getX())
					return o2.getY() - o1.getY();
				else
					return o2.getX() - o1.getX();
			}

		});

	}

	public static void main(String[] args) {

		List<Point> points = populate();
		List<Point> domList = getDominantPoints(points);
		System.out.println("Output: \n" + domList);

	}

	private static List<Point> populate() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 0));
		points.add(new Point(1, 1));
		points.add(new Point(2, 0));
		points.add(new Point(0, 2));
		points.add(new Point(1, 3));
		points.add(new Point(3, 2));
		points.add(new Point(2, 4));
		points.add(new Point(1, 5));
		points.add(new Point(3, 3));
		points.add(new Point(4, 4));
		return points;
	}

}

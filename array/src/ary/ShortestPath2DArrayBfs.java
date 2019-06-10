package ary;


import java.util.LinkedList;
import java.util.Queue;

//Given two points in the matrix find the shortest path 
//between these points 

public class ShortestPath2DArrayBfs {
	static class Node {
		char ch;
		int sRow;
		int sCol;

		public Node(char ch, int sRow, int sCol) {
			super();
			this.ch = ch;
			this.sRow = sRow;
			this.sCol = sCol;
		}

	}

	static char[][] chAry = {{'1', '1', '1', '1', '1'}, 
							{'S', '1', 'X', '1', '1'}, 
							{'1', '1', '1', '1', '1'},
							{'X', '1', '1', '1', '1'}, 
							{'E', '1', '1', '1', '1'}};
	
	

	static int bfs(int sr, int sc, int tr, int tc, boolean[][] bolAry) {
		int rowLength = chAry.length;
		int colLength = chAry[0].length;
		if (sr >= rowLength || sc >= colLength || sr < 0 || sc < 0 || chAry[sr][sc] == 'X') {
			return -1;
		}
		if(sr==tr && sc==tc)// this is required because we are marking count = 1
			return 0;
		//after this we make sure the first node in q is not destination node.
		int count = 1; // level 1 by default. if we do so we are pointing to the node children not poped node in q.
		Queue<Node> q = new LinkedList<Node>();
		Node node = new Node(chAry[sr][sc], sr, sc);
		q.add(node);
		bolAry[sr][sc] = true;
		q.add(null);
		while (!q.isEmpty()) {
			Node nod = q.poll();//root element is popped and count is 1 by default, 
			//it didn't seems right at first place but it's all about in which level we are traversing after popping because 
			//if we find element there we need to return the count and no time to increment as per below logic. 
			//ie poped node.children which are if any one step ahead. that's why count = 1; 
			if (nod == null){//level end; Imp#; here we increment the level after traversing, that's why we marked count = 1;
				q.add(null);//add end to the q; this null will be added after the neighbours of level just ended.
				count++;//count will be advanced before moving to next level. so that if we find target element, we need not to increment the count. 
				//first level is considered zero and it's logically correct. if you are at source coordinates then the level should be zero.
				continue;
				
			}else {
				sr = nod.sRow;
				sc = nod.sCol;
				if (sc + 1 < colLength && !bolAry[sr][sc + 1] && chAry[sr][sc + 1] != 'X') {// right

					if (sr == tr && (sc+1) == tc) {
						System.out.println("Min Distance: " + count);
						return count;
					}
					q.add(new Node(chAry[sr][sc + 1], sr, (sc + 1)));
					bolAry[sr][sc + 1] = true;
				}
				if (sc - 1 >= 0 && !bolAry[sr][sc - 1] && chAry[sr][sc - 1] != 'X') {// left
					if (sr == tr && (sc-1) == tc) {
						System.out.println("Min Distance: " + count);
						return count;
					}
					q.add(new Node(chAry[sr][sc - 1], sr, (sc - 1)));
					bolAry[sr][sc - 1] = true;
				}
				if (sr - 1 >= 0 && !bolAry[sr - 1][sc] && chAry[sr - 1][sc] != 'X') {// up
					if ((sr-1) == tr && sc == tc) {
						System.out.println("Min Distance: " + count);
						return count;
					}
					q.add(new Node(chAry[sr - 1][sc], (sr-1), sc));
					bolAry[sr - 1][sc] = true;
				}
				if (sr + 1 < rowLength && !bolAry[sr + 1][sc] && chAry[sr + 1][sc] != 'X') {// down
					if ((sr+1) == tr && sc == tc) {
						System.out.println("Min Distance: " + count);
						return count;
					}
					q.add(new Node(chAry[sr + 1][sc], (sr+1), sc));
					bolAry[sr + 1][sc] = true;
				}
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int rowLength = chAry.length;
		int colLength = chAry[0].length;
		boolean[][] bolAry = new boolean[rowLength][colLength];
		System.out.println(bfs(1, 0, 3, 3, bolAry));
	}

}

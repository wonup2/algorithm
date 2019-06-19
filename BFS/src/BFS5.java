import java.util.*;

//7576 Tomato  -- Adjacency Graph

public class BFS5 {

	static Scanner in;
	static int[][] a;
	static int c,r;
	static Queue<Integer> q;
	static int[] dx= {-1,1,0,0}, dy= {0,0,-1,1};
	
	public static void main(String[] args) {	
		in = new Scanner(System.in);
		init();
		System.out.println(solve());
		in.close();
	}
	static void init() {
		c = in.nextInt();
		r = in.nextInt();
		a = new int[r][c];
		q = new LinkedList<Integer>();

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				a[i][j] = in.nextInt();
				if(a[i][j]==1) {
					q.add(i);
					q.add(j);
				}
			}
		}
	}
	
	static int solve() {
	    bfs();
	    return check();
	}
	static void bfs() {
		while (!q.isEmpty()) {
			   int y=q.poll();
			   int x=q.poll();
	           for (int i = 0; i < 4; i++) {
	        	   int ny = y + dy[i], nx = x + dx[i];
			       if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
			       if (a[ny][nx] == 0) {
			    	   a[ny][nx] = a[y][x] + 1;
			    	   q.add(ny);
			    	   q.add(nx);
			       }
			   }
		}
	}

	static int check() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < r; i++) {
		   for (int j = 0; j < c; j++) {
			   if (a[i][j]==0) return -1;
		       max = Math.max(max, a[i][j]);
		   }
	    }
		return max-1;
	}
}

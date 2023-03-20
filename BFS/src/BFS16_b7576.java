//7576 Tomato  -- Adjacency Graph
import java.util.*;
public class BFS16_b7576 {

	static Scanner in;
	static int n, m, a[][];
	static Queue<Integer> q;
	static int[] dx= {-1,1,0,0}, dy= {0,0,-1,1};
	
	public static void main(String[] args) {	
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	static void init() {
		m = in.nextInt();
		n = in.nextInt();
		a = new int[n][m];
		q = new LinkedList<Integer>();

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = in.nextInt();
				if(a[i][j]==1) {
					q.add(i);
					q.add(j);
				}
			}
		}
	}
	
	static void solve() {
	    bfs();
	    System.out.println(check());
	}
	static void bfs() {
		while (!q.isEmpty()) {
			   int y=q.poll();
			   int x=q.poll();
	           for (int i = 0; i < 4; i++) {
	        	   int nx = x + dx[i];
	        	   int ny = y + dy[i];	 
	        	   
			       if (ny < 0 || ny >= m || nx < 0 || nx >= n || a[ny][nx] != 0 ) continue;
			  
			       a[ny][nx] = a[y][x] + 1;
			       q.add(ny);
			       q.add(nx);			       
			   }	         
		}
		  //print(a);
	}
	
	static int check() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
		   for (int j = 0; j < m; j++) {
			   if (a[i][j]==0) return -1;
		       max = Math.max(max, a[i][j]);
		   }
	    }
		return max-1;
	}	

	static void print(int[][] a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}System.out.println();
		}
	}
		
}

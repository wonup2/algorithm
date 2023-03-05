/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
*/

import java.util.*;

public class BFS11 {

	static Scanner in;
	static int n, m, a[][], b[][], dx[] = {0, 0, -1, 1}, dy[] = {-1, 1, 0, 0}, ans;
	static Queue<Integer> q;
	static HashSet<Integer> set;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}

	static void init() {
		n = in.nextInt();
		
		a = new int[n][n];
		b = new int[n][n];
		set = new HashSet<Integer>();
		for(int i=0; i<n; i++) { 
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				b[i][j] = a[i][j];
				set.add(a[i][j]);
			}
		}
				
		q = new LinkedList<Integer>();		


	}
	
	static void solve() {

		for(int h: set) {
			reset();

			int cnt=0; 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(a[i][j]>=h) {
						bfs(i,j,h);
						
						cnt++; 
					}
				}
			}
			ans = Math.max(cnt, ans);
		}		
		
		System.out.println(ans);
	}
	
	static void bfs(int x, int y, int h) {
		
		q.add(x); q.add(y); 
		a[x][y]=0;
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
		
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || ny<0 || nx >=n || ny>=n || a[nx][ny]<h) continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny]=0;
			}				
		}
	}
	
	static void reset() {
		for(int i=0; i<n; i++) a[i] = b[i].clone();
	}
}

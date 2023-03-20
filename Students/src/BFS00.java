//Find the number of islands 

import java.util.*;

public class BFS00 {

	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();			
	}
	
	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = in.nextInt();
			}
		}
	}
	

	static int n, m, a[][];
	static Queue<Integer> q;
	static Scanner in;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	static int solve() {
		int cnt = 0;
		q = new LinkedList<Integer>();
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void dfs(int x, int y) {
		
		a[x][y]=0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m||a[nx][ny]==0) continue;
				
			a[nx][ny]=0;
			dfs(nx, ny);
		}		
	}
}


/*
5 5
0 0 0 1 1
0 0 0 0 0 
0 1 1 0 0 
0 1 0 1 1
0 0 0 0 1


answer: 3
*/
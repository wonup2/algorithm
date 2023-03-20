//유기농 배추
//https://www.acmicpc.net/problem/1012

import java.util.*;

public class DFS33_b1012 {	
	static Scanner in;
	static int t, m, n, k, a[][];
	static int dx[] = {0, 0, -1, 1}, dy[] = {-1, 1, 0, 0};
	public static void main(String[] args) {

		in = new Scanner(System.in);
		t = in.nextInt();
		
		while(t-->0) {
			init();
			solve();
		}
	}

	static void init() {

		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		a = new int[n][m];
		
		for(int i=0; i<k; i++)
			a[in.nextInt()][in.nextInt()] = 1;		
	}
	
	static void solve() {
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int x, int y) {
		a[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m||a[nx][ny]==0) continue;
			dfs(nx, ny);
		}
	}
}

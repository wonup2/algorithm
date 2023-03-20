//Baek Joon 2468 - Adjacency graph

import java.util.*;
public class BFS11_b2468 {

	static int n, a[][], b[][], ans;
	static Set<Integer> set;
	static Queue<Integer> q;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) {

		try {			
			init();
			solve();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	static void init() {
		Scanner in = new Scanner(System.in);
		q = new LinkedList<Integer>();

		set = new HashSet<Integer>();
		set.add(0);
		
		n=in.nextInt();
		a=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				set.add(a[i][j]);
			}
		}
	}
	
	static void solve() {
		
		b=new int[n][n];
		
		for(int k: set) {
			reset_b(k);
			//-----------
			int count=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(b[i][j]==1) {
						bfs(i,j);
						count++;
					}
				}
			}
			//-----------
			ans = Math.max(ans,count);
		}		
		System.out.println(ans);
	}
	
	static void reset_b(int k) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				b[i][j] = a[i][j]>k? 1:0;
			}
		}
		
	}

	static void bfs(int x, int y) {
		q.add(x); q.add(y);
		b[x][y]=0;
		while(!q.isEmpty()) {
			x=q.poll(); y=q.poll();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n||b[nx][ny]==0) continue;
				q.add(nx); q.add(ny);
				b[nx][ny]=0;
			}
		}
	}
		
	
}

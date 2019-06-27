//Baek Joon 2583 - Adjacency graph

import java.util.*;
public class BFS07 {

	static int n, m, k, cnt, a[][], r[];
	static Queue<Integer> q;

	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	public static void init() {
		n=in.nextInt();
		m=in.nextInt();
		k=in.nextInt();
		a=new int[n][m];
		r=new int[k];
		for(int i=0; i<k; i++) {
			int c1=in.nextInt();
			int r1=in.nextInt();
			int c2=in.nextInt();
			int r2=in.nextInt();
			for(int row=r1; row<r2; row++) {
				for(int col=c1; col<c2; col++) {
					a[row][col]=1;
				}
			}
		}
		
		System.out.println(Arrays.deepToString(a));
	}
	
	static void solve() {
		cnt=0;
		q=new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(Arrays.toString(r));
	}
	
	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);	
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m) continue;
				if(a[nx][ny]==0) {
					q.add(nx); 
					q.add(ny);
					a[nx][ny]=1;	
					r[cnt]++;
				}
			}
		}
	}
}

//백준 2146 다리 만들기 
import java.util.*;

public class BFS17_b2146{
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};
	static int[][] a, b;
	static Queue<Integer> q1, q2;
	static int n;
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	static void init() {
		n = in.nextInt();
		a = new int[n][n];
		b = new int[n][n];
		
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				b[i][j] = a[i][j];
				if(a[i][j]==1) { 
					q1.add(i); q1.add(j); 
					q2.add(i); q2.add(j); 
				}
			}
		}
	}
	
	static void solve() {
		int cnt = 2;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]==1) { 
					bfs(i,j, cnt);
					cnt++;
				}
			}
		}
			
		distance();		
		border();		
		//print(a); print(b);
		
		int ans = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (0 > x || x >= n || 0 > y || y >= n) continue;
                    if (a[i][j] != a[x][y]) ans = Math.min(ans, b[i][j] + b[x][y]);
                }
            }
        }
        
		System.out.println(ans);
		
	}
	
	static void bfs(int h, int k, int cnt) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(h); q.add(k);
		a[h][k] = cnt;
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>=n||ny<0||ny>=n||a[nx][ny]!=1) continue;
				a[nx][ny] = cnt;
				q.add(nx); q.add(ny);
			}
		}
	}
	
	static void distance() {
		while(!q1.isEmpty()) {
			int x = q1.poll();
			int y = q1.poll();
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(b[nx][ny]==0) {
					b[nx][ny] = b[x][y] + 1;
					q1.add(nx); q1.add(ny);
				}
			}
		}
		change();
	}
	
	static void change() {
		for(int i=0; i<n; i++) {
			for(int j=0;j<n; j++) {
				b[i][j] = b[i][j]-1;
			}
		}
	}
	
	
	
	static void border() {
		while(!q2.isEmpty()) {
			int x = q2.poll();
			int y = q2.poll();
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n)continue;
				if(a[nx][ny]==0) {
					a[nx][ny] = a[x][y];
					q2.add(nx); q2.add(ny);
				}
			}
		}
	}
	
	static void print(int[][]a) {
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}

/*
5
1 1 1 0 1
1 1 0 0 1
1 0 0 1 1
0 0 0 0 0
1 1 1 1 1
*/
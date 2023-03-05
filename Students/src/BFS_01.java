import java.util.*;

public class BFS_01 {

	static Scanner in;
	static int n, m, a[][], b[][], ans;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	static Queue<Integer> q;
	static HashSet<Integer> rain;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt();
		a = new int[n][n];
		b = new int[n][n];
		rain = new HashSet<Integer>();
		rain.add(0);
		
		for(int i=0;i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();
				b[i][j] = a[i][j];
				rain.add(a[i][j]);
			}
		}
		
		q = new LinkedList<Integer>();		
	}
	
	static void solve() {
		
		for(int r: rain) { //<--------------
		
			int cnt = 0;   //<--------------
			for(int k=0; k<n; k++) a[k] = b[k].clone();  //<-----
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(a[i][j]>= r) {
						bfs(i, j, r);
						cnt++;
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int x, int y, int r) {
		
		q.add(x); q.add(y);
		a[x][y] = -1;
		
		while(!q.isEmpty()) {
			
			x = q.poll();
			y = q.poll();
			a[x][y] = -1;
			
			for(int k=0; k<4; k++) {
		
				int nx = x+dx[k];
				int ny = y+dy[k];
			
				if(nx<0 || ny<0 || nx >=n || ny >=n || a[nx][ny] < r) continue;
				
				q.add(nx); q.add(ny);				
			}			
		}		
	}
}


/*

5 5
1 0 0 1 1
1 0 0 0 0
0 0 1 1 1
1 1 1 0 0
0 0 0 1 1

4

*/


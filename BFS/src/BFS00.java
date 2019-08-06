import java.util.*;

public class BFS00 {

	static int n, m, a[][];
	static Queue<Integer> q;
	static Scanner in;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			System.out.println(solve());
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	
	static int solve() {
		int cnt = 0;
		q = new LinkedList<Integer>();
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		a[x][y]=0;
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m||a[nx][ny]==0) continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny]=0;
			}
		}
	}

}


/*
4 5
1 0 0 0 1
1 0 1 0 0
0 0 1 1 0 
0 0 1 0 0 
*/
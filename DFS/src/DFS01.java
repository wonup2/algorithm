//Adjacency Graph - How many islands?
/*
4 5
1 1 1 0 0
1 1 0 0 1
1 0 0 1 1
0 0 1 0 0

3
*/
import java.util.*; 
public class DFS01 {
	
	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { -1,1,0,0 };
	static int a[][], n, m;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
		int ans=0;
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
		a[x][y]=0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m) continue;
			if(a[nx][ny]==1) {
				dfs(nx, ny);
			}
		}
	}
}

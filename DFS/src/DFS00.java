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
public class DFS00{
	
	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { -1,1,0,0 };
	static int a[][], n, m, cnt;
	static Scanner in;
	
	public static void main(String[] args) {
		
		try {			
			in = new Scanner(System.in);
			init();
			System.out.println(solve());
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = in.nextInt();
			}
		}
		
	}
	
	private static int solve() {
	
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
					dfs(i,j);					
					ans++;					
				}
			}
		}
		
		return ans;
	}
		
	static void dfs(int x, int y) {
		a[x][y]=0;  System.out.println(x+" "+y);
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>=n||ny>=m ||a[nx][ny] == 0) continue;
			dfs(nx, ny);			
		}
	}
}


/*
5 5
0 0 0 0 0 
0 0 1 0 0 
0 1 1 1 0 
0 1 0 1 1
0 0 0 0 1

*/
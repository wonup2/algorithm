import java.util.*;

public class DFS3 {
	static int t, n, m, x;
	static boolean a[][];
	static int[] dr= {0,0,-1,1};
	static int[] dc= {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		t=in.nextInt();
		while(t-->0) {
			n=in.nextInt();
			m=in.nextInt();
			x=in.nextInt();
			a=new boolean[n][m];
			
			for(int i=0; i<x; i++) a[in.nextInt()][in.nextInt()]=true;				
			
			int ans=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(a[i][j]) { dfs(i,j); ans++; }
				}
			}
			System.out.println(ans);
		}
	}
	
	static void dfs(int r, int c) {
		a[r][c] = false;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr<0||nr>=n||nc<0||nc>=m) continue;
			if(a[nr][nc]) dfs(nr, nc);
		}		
	}
}

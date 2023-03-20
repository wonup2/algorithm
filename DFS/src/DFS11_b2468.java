import java.util.*;
import java.io.*;

public class DFS11_b2468 {
	
	static Scanner in;
	static int n, m, a[][];
	static boolean b[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};

	static int result;
	static Set<Integer> set;
	
	public static void main(String[] args){
		try {
			init();
			System.out.println(solve());
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = n;
		a = new int[n][m];

		result = 0;
		set = new HashSet<Integer>();
		
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				a[r][c] = in.nextInt();
				set.add(a[r][c]);
			}
		}
	}
	
	public static int solve() {
		for(int q : set) {
			int count = 0;
			b = new boolean[n][m];
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					if(a[r][c] > q) b[r][c]=true;					
				}
			}
					   
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {				
					if(b[r][c]) {
						dfs(r, c);
						count++;						
					}						
				}
			}
			
			result=Math.max(result, count);	
		}

		return result==0? 1:result;
	}
	
	public static void dfs(int x, int y) {
		b[x][y] = false;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m || !b[nx][ny]) continue;
			dfs(nx, ny);	
		}
	}	
}

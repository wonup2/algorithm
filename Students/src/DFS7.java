import java.util.*;
import java.io.*;

public class DFS7 {
	
	static Scanner in;
	static int n, m, a[][], bin[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static ArrayList<Integer> arr;
	static int maxval;
	static int tempcount = 0;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException{
		
		init();
		System.out.println(solve());
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = n;
		a = new int[n][m];
		bin = new int[n][m];
		arr = new ArrayList<Integer>();
		maxval = 0;
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
			bin = new int[n][m];
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					if(a[r][c]<=q) {
						bin[r][c]=0;
					}
					else {
						bin[r][c]=1;
					}
				}
			}
		   
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {				
					if(bin[r][c]==1) {
						dfs(r, c);
						count++;						
					}						
				}
			}
			arr.add(count);			
		}
		int result = arr.get(arr.size()-1);
		return result==0? 1:result;
	}
	
	public static void dfs(int x, int y) {
		bin[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m)
				continue;
			if(bin[nx][ny]==1) {
				dfs(nx, ny);
			}
		}
	}
	
}

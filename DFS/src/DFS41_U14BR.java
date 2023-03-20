import java.util.*;
import java.io.*;

public class DFS41_U14BR {

	static Scanner in;
	static PrintWriter out;
	
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static int n;
	static char[][] a, b;
	static String file = "cowart";
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		
		in.close();
		out.close();
	}

	static void init() {
		n = in.nextInt();
		a = new char[n][];
		b = new char[n][n];
		for(int i=0; i<n; i++) a[i] = in.next().toCharArray();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				b[i][j] = a[i][j];
				if(a[i][j]=='G') b[i][j]='R';
			}
		}

		out.println(solve(a)+" "+solve(b));
	}
	
	static int solve(char a[][]) {
		
		int g = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]!='-') {
					dfs(i, j, a[i][j], a);
					g++;
				}
			}
		}
		
		return g;
	}
	
	static void dfs(int x, int y, char c, char a[][]) {
		a[x][y] = '-';
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=n||ny>=n||c!=a[nx][ny]) continue;
			dfs(nx, ny, c, a);
		}
	}
	
	static void print(char[][]a) {
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}

//B2667 - numbering blocks

import java.util.*;
import java.io.*;

public class DFS10 {

	static char a[][];
	static int n, cnt;
	static List<Integer> num;
	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { 1,-1,0,0 };
	static Scanner in;
	
	public static void main(String[] args) {
	    in = new Scanner (System.in);
	    init();
	    solve();
	    in.close();
	}
	static void init() {
		n=in.nextInt(); in.nextLine();
	    a = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			a[i] = in.nextLine().toCharArray();
		}	
	}
	    
	static void solve() {
		num=new ArrayList<Integer>();
		cnt=1;
		for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (a[i][j]=='1') {
	            	dfs(i, j);
	            	num.add(cnt);
	            	cnt=1;
	            }
	        }
	    }
		
	    System.out.println(num.size());
	    Collections.sort(num);
	    for (int i : num) System.out.println(i);
	}
	
	static void dfs(int x,int y) {
	    a[x][y] = '0';
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (0 > nx || nx >= n || 0 > ny || ny >= n || a[nx][ny] == '0') continue;
	        dfs(nx, ny);
	        cnt++;
	    }
	}
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000


3
7
8
9
*/

//백준 2667 - 단지번호붙이기  Adjacency graph

import java.util.*;
import java.io.*;

public class BFS12_b2667 {

	static char a[][];
	static int n, cnt1, cnt2;

	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { 1,-1,0,0 };
	
	static List<Integer> num;
	
	public static void main(String[] args) {	    
	    init();
	    solve();
	}
	
	static void init() {
		
		Scanner in = new Scanner (System.in);
		n=in.nextInt(); in.nextLine();
	    a = new char[n][n];
		num=new ArrayList<Integer>();

		for(int i = 0; i < n; i++) {
			a[i] = in.nextLine().toCharArray();
		}	
	}
	    
	static void solve() {
		for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	            if (a[i][j]=='1') {
	            	bfs(i, j);
	            	num.add(cnt2);   //<-----------
	            	cnt1++;
	            }
	        }
	    }
		
	    System.out.println(cnt1);

	    Collections.sort(num);
	    for (int i : num) System.out.println(i);
	}
	
	static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		q.add(y);
		a[x][y]='0';
		cnt2=1;  //<------------
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n || a[nx][ny]=='0') continue;

				q.add(nx);
				q.add(ny);
				a[nx][ny] = '0';		
				cnt2++;    //<--------
			}
		}
	}
}

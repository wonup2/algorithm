//Baek Joon 2178 - Adjacency graph - maze
/*
4 6
101111
101010
101011
111011
*/
//If you done, do B2667 - numbering blocks

import java.util.*;
public class BFS02 {

	static int n, m, a[][];
	static Queue<Integer> q;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		System.out.println(solve());
		in.close();
	}
	public static void init() {
		n=in.nextInt();
		m=in.nextInt();
		a=new int[n][m];
		char t[][]=new char[n][m];
		for(int i=0; i<n; i++) 
			t[i]=in.next().toCharArray();
		
		
		
		
		
		
		
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++) 
				a[i][j] = t[i][j]-'0';
		
		
		
		
	}
	
	static int solve() {
		q=new LinkedList<Integer>();
		a[0][0]=2;	
		bfs(0,0);
		return (a[n-1][m-1]-1);
	}
	
	
	
	
	
	static void bfs(int r, int c) {
		q.add(r);
		q.add(c);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m || a[nx][ny]!=1) continue;
		
				q.add(nx); 
				q.add(ny);
				a[nx][ny]=a[x][y]+1;				
			}
		}
	}
}

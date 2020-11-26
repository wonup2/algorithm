//유형1. 동시에 진행되는 탐색이 1개뿐인 것


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
public class BFS10 {

	static int n, m, a[][];
	static Queue<Integer> q;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Scanner in;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			System.out.println(solve());
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		in.close();
	}

	static void init() {
		n=in.nextInt();
		m=in.nextInt();
		a=new int[n][m];
		q=new LinkedList<Integer>();
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) 
				a[i][j]=in.nextInt();
	}
	
	static int solve() {
		int count=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]==1) {
					bfs(i,j); 
					count++;
				}
			}
		}
			
		return count;
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
				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
				if(a[nx][ny]==0) continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny] = 0;				
			}
		}
	}
}

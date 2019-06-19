//2178 - Adjacency graph
/*
4 6
101111
101010
101011
111011
 */
import java.util.*;
public class BFS3 {

	static Scanner in;
	static int[][] a;
	static int n,m;
	static Queue<Integer> q;
	static int[] dx= {-1,1,0,0}, dy= {0,0,-1,1};
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
		q=new LinkedList<Integer>();
	}
	
	static String solve() {
		a[0][0]=2;	
		bfs(0,0);
		return (a[n-1][m-1]-1)+"";
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
				if(nx<0||nx>=n||ny<0||ny>=m) continue;
				if(a[nx][ny]==1) {
					q.add(nx); q.add(ny);
					a[nx][ny]=a[x][y]+1;
				}
			}
		}
	}
}

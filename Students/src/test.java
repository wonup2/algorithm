/*
5 5
0 0 0 1 1
0 0 0 0 0 
0 1 1 0 0 
0 1 0 1 1
0 0 0 0 1


answer: 3
*/

import java.util.*;

public class test {

	static Scanner in;
	static int n, cnt, dx[] = {0, 0, -1, 1}, dy[] = {-1, 1, 0, 0};
	static char a[][];
	static Queue<Integer> q;
	static ArrayList<Integer> ans;
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();		
	}

	static void init() {
		n = in.nextInt(); in.nextLine();
		
		a = new char[n][];
		for(int i=0; i<n; i++) 
			a[i] = in.nextLine().toCharArray();
		
		q = new LinkedList<Integer>();	
		ans = new ArrayList<Integer>();
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]=='1') {
					cnt=1;
					bfs(i,j);
					ans.add(cnt);
				}
			}
		}
		Collections.sort(ans);
		System.out.println(ans);
	}
	
	static void bfs(int x, int y) {
		
		q.add(x); q.add(y);
		a[x][y]='0';
		
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
		
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || ny<0 || nx >=n || ny>=n || a[nx][ny]=='0') continue;
				q.add(nx);
				q.add(ny);
				a[nx][ny]='0';
				cnt++;
			}				
		}
	}
}

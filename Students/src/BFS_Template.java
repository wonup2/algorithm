import java.util.*;

public class BFS_Template {

	static Scanner in;
	static int n,  cnt;
	static char a[][];
	static ArrayList<Integer> ans;
	static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
	static Queue<Integer> q;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		n = in.nextInt(); in.nextLine();
		a = new char[n][];
		
		for(int i=0;i<n; i++)
			a[i] = in.nextLine().toCharArray();
		
		q = new LinkedList<Integer>();		
		ans = new ArrayList<Integer>();
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]=='1') {
					cnt = 1; //<-----
					bfs(i, j);
					ans.add(cnt); //<---
				}
			}
		}
		
		Collections.sort(ans);		
		System.out.println(ans.size());		
		for(int i:ans) System.out.println(i);		
	}
	
	static void bfs(int i, int j) {
		
		q.add(i); q.add(j);
		a[i][j] = '0';
		
		while(!q.isEmpty()) {
			
			int x = q.poll();
			int y = q.poll();
		
			for(int k=0; k<4; k++) {
		
				int nx = x+dx[k];
				int ny = y+dy[k];
			
				if(nx<0 || ny<0 || nx >=n || ny >=n || a[nx][ny] == '0') continue;
				
				q.add(nx); q.add(ny);
				cnt++;
				a[nx][ny]='0';
			}			
		}		
	}
}


/*

5 5
1 0 0 1 1
1 0 0 0 0
0 0 1 1 1
1 1 1 0 0
0 0 0 1 1

4

*/


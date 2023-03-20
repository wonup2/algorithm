//Adjacency List 
//https://www.acmicpc.net/problem/11724
//연결 요소의 개수

import java.util.*;
public class BFS20_b11724 {

	static Scanner in;
	static boolean v[];
	static Queue<Integer> q;
	static ArrayList<Integer>[] a;
	static int n,m;
	static int ans;
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		init();
		solve();				
	}
	static void init() {
		n=in.nextInt();
		m=in.nextInt();

		v=new boolean[n+1];		
		q=new LinkedList<Integer>();
		
		a=new ArrayList[n+1];
		for(int i=0; i<n+1; i++) 			
			a[i]=new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {	
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}		
		System.out.println(Arrays.toString(a));
	}

	static void solve() {
		
		int group=0;
		for(int i=1; i<=n; i++) {
			if(!v[i]) {
				bfs(i);
				group++;
			}
		}		
		System.out.println(group);
	}
	
	static void bfs(int s) {
		v[s]=true;
		q.add(s);
		
		while(!q.isEmpty()) {
			
			int n=q.poll();
			
			for(int i:a[n]) {
				if(v[i]) continue;
				v[i]=true;
				q.add(i);				
			}
		}
	}
}

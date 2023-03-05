//Adjacency List 
//https://www.acmicpc.net/problem/11724

import java.util.*;
public class BFS20 {

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
		a=new ArrayList[n+1];
		q=new LinkedList<Integer>();
		for(int i=0; i<n+1; i++) 			
			a[i]=new ArrayList<Integer>();
		
		for(int i=1; i<=n; i++) {			
			int y=in.nextInt();
			a[i].add(y);
			a[y].add(i);
		}
	}

	static String solve() {
		return bfs(s-1);
	}
	
	static String bfs(int s) {
		v[s]=true;
		String result="";
		q.add(s);
		
		while(!q.isEmpty()) {
			int n=q.poll();
			result+=(n+1)+" ";
			for(int i:a[n]) {
				if(v[i]) continue;
				v[i]=true;
				q.add(i);				
			}
		}
		return result;
	}
}

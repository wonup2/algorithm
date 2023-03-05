//B11724 - Adjacency List

import java.io.*;
import java.util.*;
public class DFS22 {
	
	static Scanner in;
	static int n, m, ans;
	static ArrayList<Integer>[] a;
	static boolean[] v;

	public static void main(String[] args){
		
		in = new Scanner(System.in);
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		
		n = in.nextInt();
		m = in.nextInt();
		
		a = new ArrayList[n];		
		for(int i=0; i<n; i++) a[i]=new ArrayList<Integer>();		
					
		for(int i=0; i<m; i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);			
		}		
		
		v = new boolean[n];	
		
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		ans = 0;
		
		dfs(0);
		
		System.out.println(ans-1);
	}
	
	static void dfs(int i){
		v[i]=true; ans++;
		for(int next:a[i]) 
			if(!v[next]) dfs(next);
	}	
}
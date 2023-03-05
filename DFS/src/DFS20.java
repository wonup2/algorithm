//https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;
public class DFS20 {
	
	static Scanner in;
	static int n, m;
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
		
		a = new ArrayList[n+1];		
		for(int i=0; i<n+1; i++) a[i]=new ArrayList<Integer>();		
					
		for(int i=0; i<m; i++){
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);			
		}		
		
		v = new boolean[n+1];	
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=1; i<=n; i++){
			if(!v[i]){
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int i){
		v[i]=true;
		for(int next:a[i]) 
			if(!v[next]) dfs(next);
	}	
}
//B11724 - Adjacency List

import java.io.*;
import java.util.*;
public class DFS4 {
	static int n;
	static int m;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	static String result;
	
	public static void main(String[] args){
		try {		
			init();
			System.out.println(solve());
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static void init() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new ArrayList[n+1];
			v = new boolean[n+1];
			for(int i=0; i<n+1; i++){
				a[i]=new ArrayList<Integer>();
			}
					
			for(int i=0; i<m; i++){
				st = new StringTokenizer(in.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				a[n1].add(n2);
				a[n2].add(n1);			
			}
			in.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static String solve() {
		int ans = 0;
		for(int i=1; i<=n; i++){
			if(!v[i]){
				dfs(i);
				ans++;
			}
		}
		return ans+"";
	}
	
	static void dfs(int s){
		if(v[s]) return;
		v[s]=true;
		for(int i:a[s]){
			if(!v[i]) dfs(i);
		}
	}	
}
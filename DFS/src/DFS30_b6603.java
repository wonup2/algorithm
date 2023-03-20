//로또 
//https://www.acmicpc.net/problem/6603

import java.io.*;
import java.util.*;
public class DFS30_b6603 {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, a[];
	static ArrayList<Integer> l;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			init();
			solve();
		}
		
		in.close();
	}
	
	static void init() throws IOException {
		
		a = new int[n];
		for(int i=0; i<n; i++)a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);  
		
		l = new ArrayList<Integer>();
	}

	static void solve() {
		
		for(int i=0; i<n; i++) {
			dfs(i);
			
			l.clear();
		}
		System.out.println();
	}
	
	static void dfs(int x) {
		l.add(a[x]);  
		if(l.size()==6) 
			System.out.println(l);	
				
		for(int i=x+1; i<n; i++) {
			dfs(i);
			l.remove(l.size()-1);  //arrayList 라서 그래.
		}
	}
	
	//refer to 
	static void dfs(String s, int start) {
		s = s+a[start]; 
		if(s.length()==6) {
			System.out.println(s);			
		}
		for(int i=start+1; i<n; i++) {
			dfs(s, i);
		}		
	}
}

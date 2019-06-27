//codeforces 893C Rumor

import java.util.*;
import java.io.*;
public class DFS05 {
	static BufferedReader in;
	static int n, m, cost[];
	static boolean v[];
	static ArrayList<Integer>[] a;
	
    public static void main(String[] args) {
    	try {
    		init();
    		System.out.println(solve());
    		in.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}   	
    }
    
    @SuppressWarnings("unchecked")
	static void init() {
        try {
	    	in=new BufferedReader(new InputStreamReader(System.in));
	    	String[] input = in.readLine().split(" ");
	    	n = Integer.parseInt(input[0]);
	        m = Integer.parseInt(input[1]);
	        cost=new int[n+1];
	        v = new boolean[n + 1];		
	        input=in.readLine().split(" ");        
	        a=new ArrayList[n+1];
	        for (int i = 0; i < n; i++) {
	            cost[i+1] = Integer.parseInt(input[i]);            
	            a[i+1] = new ArrayList<>();
	        }
	        for (int i = 0; i < m; i++) {        
				input = in.readLine().split(" ");
	            int x = Integer.parseInt(input[0]);
	            int y = Integer.parseInt(input[1]);
	            a[x].add(y);
	            a[y].add(x);
	        }
	        
        }catch (IOException e) {
        	e.printStackTrace();
        }        
    }
    static long solve() {
    	long cost = 0;
	    for (int i = 1; i <=n; i++) 
	    	if (!v[i]) cost += dfs(i);
	        
	    return cost;
	}

	static long dfs(int i) {
		v[i] = true;
		long min = cost[i];
	    for (int c: a[i]) 
	    	if (!v[c]) min = Math.min(min, dfs(c));
	        
	    return min;	
	}	
}

/*
5 2
2 5 3 4 8
1 4
4 5

10
*/

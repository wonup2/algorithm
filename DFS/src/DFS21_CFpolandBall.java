//CodeForces 755 PolandBall and Forest
//https://codeforces.com/problemset/problem/755/C

import java.util.*;
import java.io.*;

public class DFS21_CFpolandBall{
	
	static BufferedReader br;
	
	static ArrayList<Integer> a[];
	static boolean v[];
	static int ans=0;
	public static void main (String[] args) throws java.lang.Exception	{	
		
		br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		a=new ArrayList[n+1];
		v=new boolean[n+1];
		
		for(int i=1;i<=n;i++) a[i]=new ArrayList<Integer>();
		
		String s[]=br.readLine().split(" ");		
		for(int i=1;i<=n;i++) {   
			int p=Integer.parseInt(s[i-1]);
		    a[i].add(p);
		    a[p].add(i);
		}
		
		for(int i=1;i<=n;i++){
		    if(!v[i]) {
		    	dfs(i);
		    	ans++;
		    }		    
		}
		System.out.println(ans);
	}
	
	static void dfs(int i){
	    
	    v[i]=true;    
	    
	    for(int p:a[i])
	        if(!v[p]) dfs(p);	    
	}
}
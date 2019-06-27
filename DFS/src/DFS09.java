//CodeForces 755 PolandBall and Forest

import java.util.*;
import java.io.*;

public class DFS09{
	static ArrayList<Integer> a[];
	static boolean v[];
	static int ans=0;;
	public static void main (String[] args) throws java.lang.Exception	{	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
		    if(v[i]==false) ans++;
		    dfs(i);
		}
		System.out.println(ans);
	}
	
	static void dfs(int index)
	{
	    if(v[index]==true) return;
	    
	    v[index]=true;    
	    
	    for(int p:a[index]){
	        if(v[p]==false) dfs(p);
	    }
	}
}
//USACO 2018 December Silver convention

import java.io.*;
import java.util.*;

public class BS_groupSum4 {

	static int a[], n, m, c;
	static boolean f(int l) {
	    int s = 0, start = a[0], bus = 1, cow = 0;
	    for (int i = 0; i < n; i++) {
	    	s = a[i]-start; 
	    	cow++;
	        if (cow > c || s > l) { start = a[i]; bus++; cow=1;}
	    }
	    return bus <= m ;
	} 
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("convention.in"));
		PrintWriter out = new PrintWriter(new FileWriter("convention.out"));
		
	    n=in.nextInt();
	    m=in.nextInt();
	    c=in.nextInt();
	    a=new int[n];    
	    
	    for (int i = 0; i < n; i++) a[i]=in.nextInt();
	    
	    Arrays.sort(a);
	  
	    int low = 0, up = a[n-1], mid = 0;
	    while (low <= up) {
	        mid = (up+low) / 2;	
	        if(f(mid)) up = mid-1;
	        else low = mid + 1;
	    	
	    }
	    
	   out.println(low);
	   out.close();
	   in.close();
	}
}
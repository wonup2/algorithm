//b 2613

import java.util.Arrays;
import java.util.Scanner;

//น้มุ 2613

import java.util.*;
public class BS_groupSum1 {
	
	static int a[], n, m;   //n--> number of all data, m--> group

	static boolean f(int l) {
	    int s = 0, c = 1;
	    for (int i = 0; i < n; i++) {
	        s += a[i];
	        if (s > l) {
	        	s = a[i]; 
	        	c++;
	        }
	    }
	    return c <= m;
	}
	
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    
	    n=in.nextInt();
	    m=in.nextInt();
	    
	    a = new int[n];

	    for (int i = 0; i < n; i++) {
	        a[i]=in.nextInt();	        
	    }
	    	    
	    //low, up, f
	    int low = 0, high = 0, mid;
	    low = 1;
        high = 30000;
	    
	    while (low <= high) {
	        mid = (low + high) / 2;
	    //	System.out.println(low+ " "+high+" "+mid);

	        if(f(mid)) high = mid-1; 
	        else low = mid + 1;
	    }
	    	    
	    System.out.println(low);
	    
	    
	    int i = 0, s = 0, t = 0;
	    for (; i < n; i++) {
	        s += a[i];
	        if (s > low) {
	            s = a[i];
	            m--;
	            System.out.print(t+" ");
	            t = 0;
	        }
	        t++;
	        if (n - i == m) break;
	    }
	    while (m-->0){
	    	System.out.print(t+" "); t = 1;
	    }
	    
	}
}
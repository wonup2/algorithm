//baekjoon 2805 나무자르기

import java.util.*;
public class BS_groupSum2 {
	
	static int a[], n, m;
	static boolean f(int l) {
	    int s = 0;
	    for (int i = n-1; i >= 0; i--) {
	    	s += (a[i]-l)>0? a[i]-l:0; 
	        if (s >= m) return true;
	    }
	    return false ;
	} 

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		a=new int[n];
		for(int i=0; i<n; i++) a[i]=in.nextInt();
		
		Arrays.sort(a);
		
		int low = 1;
		int up = a[n-1];
		int mid = 0;
		
		while(low<up){
			//System.out.println(mid+" "+ low+" "+up);
			mid=(up+low)/2;
			if(f(mid)) low = mid+1;  	//<----
			else up = mid-1;			//<----
			
		}
		
		System.out.println(up);			//<----
	}

}
//b2512
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BS_groupSum3 {
	
	static int a[], n, m;
	static boolean f(int l) {
	    long s = 0;
	    for (int i = 0; i <n; i++) {
	    	s += (a[i]<l)? a[i]:l; 
	    }
	    return m>=s ;
	} 

	
	static BufferedReader in;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
				
		//init
		n= Integer.valueOf(in.readLine());
		a=new int[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
			
		for(int i=0; i<n; i++)	a[i]=Integer.parseInt(st.nextToken());
		
		m=Integer.valueOf(in.readLine());		
				
		Arrays.sort(a);
		
		
		//solve
		int low = 0;
		int up = a[n-1];
		int mid = 0;
		int ans = 0;
		while(low<=up){
			mid=(up+low)/2;		
			if(f(mid)) {
				ans = mid;
				low = mid+1;  	//<----
			}
			else up = mid-1;	//<----
		}		
		System.out.println(ans);			//<----
	}
}

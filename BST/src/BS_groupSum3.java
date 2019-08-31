//b2512
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

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//get data
		n=in.nextInt();
		a=new int[n];
		for(int i=0; i<n; i++)	a[i]=in.nextInt();
		m=in.nextInt();

		Arrays.sort(a);
		
		int low = 0;
		int up = a[n-1];
		int mid = 0;
		
		while(low<=up){
			mid=(up+low)/2;		
			if(f(mid)) low = mid+1;  	//<----
			else up = mid-1;			//<----
		}
		
		System.out.println(up);			//<----
	}
}

package CF_ITMO;
import java.util.*;
 
public class BS_2A{
	static Scanner in;
	static long w, h, n;
	
    public static void main(String[] args) {
    	
    	in = new Scanner(System.in);
    	w = in.nextLong();
    	h = in.nextLong();
    	n = in.nextLong();
    	
    	solve();
    	
    }
    
    static void solve() {
    	
    	long low = 0;
    	long high = 100000000000000l;
    	long mid = 0;
    	long ans = 0;
    	while(low<=high) {
    		mid = (low+high)/2;
    		
    		if(check(mid)) {
    			ans = mid;
    			high = mid-1;
    		}
    		else low = mid+1;
    	}
    		
    	System.out.println(ans);
    }
    
    static boolean check(long mid) {
    	if ((mid/w) * (mid/h) < 0) return true;
    	return (mid/w) * (mid/h) >= n; 
    }
}
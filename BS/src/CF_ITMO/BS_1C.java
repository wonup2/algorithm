package CF_ITMO;
import java.util.*;
public class BS_1C {

	static Scanner in;
	static int n, k;
	static TreeMap<Integer, Integer> a;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
	}
	
	static void init() {
		
		n = in.nextInt();
		k = in.nextInt();
		a = new TreeMap<Integer, Integer>();
		for(int i=1; i<=n; i++) {
			int num = in.nextInt();
			if(!a.containsKey(num)) a.put(num, i);
		}
	}

	static void solve() {
		
		for(int i=0; i<k; i++) {
			int num = in.nextInt();
			if(a.containsKey(num)) System.out.println(a.get(num));
			else if(a.higherKey(num)==null) System.out.println(n+1);
			else System.out.println(a.get(a.higherKey(num)));
		}
	}
}

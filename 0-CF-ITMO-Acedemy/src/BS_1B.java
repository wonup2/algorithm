import java.util.*;
public class BS_1B {

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
		for(int i=1; i<=n; i++) a.put(in.nextInt(), i);
	}

	static void solve() {
		
		for(int i=0; i<k; i++) {
			int n = in.nextInt();
			if(a.containsKey(n)) System.out.println(a.get(n));
			else if(a.lowerKey(n)==null) System.out.println(0);
			else System.out.println(a.get(a.lowerKey(n)));
		}
	}
}
/*
5 5
3 3 5 8 9
2 4 8 1 10
0
2
4
0
5
*/
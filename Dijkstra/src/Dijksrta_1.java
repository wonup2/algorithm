import java.util.*;
public class Dijksrta_1 {
	static final int INF = 1000000000;
	static Map<Integer, Integer> a[], q;
	static int d[], s;
	public static void main(String[] args) {
		init();
		solve();
	}
	static void init() {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt()+1;
		int m = in.nextInt();
		int s = in.nextInt();
		a = new HashMap[n];
		d = new int[n];
		while(n-->0) {
			d[n] = INF;
			a[n] = new HashMap<Integer, Integer>();
		}
		while(m-->0) {
			int x = in.nextInt();
			int y = in.nextInt();
			int d = in.nextInt();
			a[x].put(y, d);
			a[y].put(x, d);
		}
		
		q = new HashMap<Integer, Integer>();
		q.put(s,0);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		while(!q.isEmpty()) {
			Iterator<Integer> key = q.keySet().iterator();
			int cur = key.next();
			key.remove();
			System.out.println(key);
		}		
	}
}
/*
6 10 1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 4 3
3 5 1
3 6 5
4 5 1
5 6 2
*/
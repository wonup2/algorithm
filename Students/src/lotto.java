
import java.util.*;


public class lotto {

	static Scanner in;
	static int n, a[];
	static LinkedList<Integer> list;
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		while(true) {
			n = in.nextInt();
			if(n==0) break;
			init();
			solve();
		}		
	}

	static void init() {
		
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		list = new LinkedList<Integer>();
		
		Arrays.sort(a);
		
	}
	
	static void solve() {
		
		for(int i = 0; i<n; i++) {
			dfs(i);
			list.clear();
		}
		
		System.out.println();
	}
	
	static void dfs(int start) {
		list.add(a[start]);
		
		if(list.size()==6) {
			for(int n:list)
				System.out.print(n+" ");
			
			System.out.println();
		}		
		
		for(int i=start+1; i<n; i++) {
			dfs(i);
			list.remove(list.size()-1);
		}
	}	
}

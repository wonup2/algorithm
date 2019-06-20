import java.util.*;
public class DFS5 {

	static Scanner in;
	static int n, e, s;
	static ArrayList<Integer>[] a;
	static boolean v[];
	
	public static void main(String[] args) {
		
	}
	
	static void init() {
		in = new Scanner(System.in);
		n=in.nextInt();
		e=in.nextInt();
		s=in.nextInt();
		v=new boolean[n+1];
		a=new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<e; i++) {
			int x=in.nextInt();
			int y=in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
	}

	static void solve() {
		dfs(s);
	}
	
	static void dfs(int s) {
		
	}
}

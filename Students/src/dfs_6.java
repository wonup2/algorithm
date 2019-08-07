import java.io.*;
import java.util.*;
public class dfs_6 {
	
	static int n, m, s;
	static ArrayList<Integer> [] a;
	static boolean[] v;
	static Queue<Integer> q;
	static Scanner in;
	static String result;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			solve();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		q = new LinkedList<Integer>();
		result = "";
		a = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		v = new boolean[n+1];
	}
	
	static void solve() {
		result = s +" ";
		dfs(s);
		System.out.println(result);
		v = new boolean[n+1];
		
		result = s+" ";
		bfs(s);
		System.out.println(result);
	}
	
	static void dfs(int x) {
		if (v[x])
			return;
		v[x] = true;
		for (int y: a[x]) {
			if (!v[y]) {
				result += y;
				dfs(y);
			}
		}
	}
	
	static void bfs(int x) {
		if (v[x])
			return;
		v[x] = true;
		q.add(x);
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i: a[t]) {
				if (v[i])
					continue;
				else {
					result += i;
					q.add(i);
					v[i]=true;
				}
			}
		}
	}
	
}


/*
6 5 1
1 2
2 5
2 3
3 4
5 6
*/

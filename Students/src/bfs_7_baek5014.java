import java.util.*;
import java.io.*;
public class bfs_7_baek5014 {

	static Scanner in;
	static int f, s, g, u, d;
	static int[] a;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			int result = solve();
			if (result < 0)
				System.out.println("use the stairs");
			else
				System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void init() {
		f = in.nextInt(); //total number of floors
		s = in.nextInt(); //starting position floor
		g = in.nextInt(); //goal floor
		u = in.nextInt(); //how many floors at a time you can go up
		d = in.nextInt(); //how many floors at a time you can go down
		q = new LinkedList<Integer>();
		a = new int[f + 1];
	}
	
	static int solve() {
		int count = bfs(s);
		return count;
	}
	
	static int bfs(int x) {
		q.add(s);
		a[x]=1;
		while (!q.isEmpty()) {
			System.out.println(q);
			x = q.poll();
			if (x == g)
				return a[x]-1;
		
			int nx1 = x + u;
			int nx2 = x - d;
			if (nx1 > 0 && nx1 <= f && a[nx1] == 0) {
				a[nx1] = a[x] + 1;
				q.add(nx1);
			}
			if (nx2 > 0 && nx2 <= f && a[nx2] == 0) {
				a[nx2] = a[x] + 1;
				q.add(nx2);
			}

		}
		return -1;
	}

}

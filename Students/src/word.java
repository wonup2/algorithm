import java.util.*;
import java.io.*;
public class word {
	
	static Scanner in;
	static int n;
	static String[] array;
	static ArrayList<Integer>[] a;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	
	static void init() {
		n = in.nextInt();
		in.nextLine();
		array = new String[n];
		for(int i = 0; i < n; i++) {
			array[i] = in.nextLine();
		}
		a = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(check(array[i],array[j]) && i != j) {
					a[i].add(j);
				}
			}
		}
	}
	
	static boolean check(String a, String b) {
		int d = 0;
		for(int i = 0; i < a.length(); i++) {
			if(d > 1)
				return false;
			if(a.charAt(i) != b.charAt(i)) {
				d++;
			}
		}
		return true;
	}
	
	static void solve() {
        boolean clear=false;
		for(int i = 0; i < n; i++) {
			v = new boolean[n];
			dfs(i);
			clear = true;
			for(boolean b: v) {
				if(!b)
					clear = false;
			}
			System.out.println(i+" "+Arrays.toString(v));
			if(clear) {
				System.out.println(1);
				break;	
            }
		}
          
        if(!clear)System.out.println(0);
	}

	static void dfs(int s) {
		if(v[s])
			return;
		v[s] = true;
		for(int i: a[s]) {
			if(!v[i])
				dfs(i);
		}
	}

}
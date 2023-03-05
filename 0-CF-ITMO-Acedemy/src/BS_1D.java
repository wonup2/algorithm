import java.io.*;
import java.util.*;
public class BS_1D {

	static BufferedReader in;
	static StringTokenizer st;
	static int n, k;
	static TreeMap<Integer, Integer> a, b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());

		int temp[] = new int[n];		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) temp[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(temp);
		
		a = new TreeMap<Integer, Integer>();
		for(int i=1; i<=n; i++)
			if(!a.containsKey(temp[i-1])) a.put(temp[i-1], i);
		
		b = new TreeMap<Integer, Integer>();
		for(int i=1; i<=n; i++) b.put(temp[i-1], i);
		
		k = Integer.parseInt(in.readLine());
		
		System.out.println(b);
		System.out.println(a);

		
	}

	static void solve() throws IOException {
		
		StringBuilder sb =new StringBuilder();
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
						
			l = left(l);
			r = right(r);
			
			sb.append(r-l+1).append(" ");			
		}
		
		System.out.println(sb.toString());
	}
	
	static int left(int l) {
		
		if(a.containsKey(l)) return a.get(l);
		else if(a.higherKey(l)==null) return n+1;
		else return a.get(a.higherKey(l));		
	}
	
	static int right(int r) {
		
		if(b.containsKey(r)) return(b.get(r));
		else if(b.lowerKey(r)==null) return 0;
		else return b.get(b.lowerKey(r));		
	}
}

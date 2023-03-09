import java.util.*;

public class CQA_money {
	
	static Scanner in;
	static int t, n;
	static String name;	
	static pair a[];
	
	static class pair implements Comparable<pair>{

		double income;
		int year;
		
		pair(double i, int y){
			income = i;
			year = y;
		}
		@Override
		public int compareTo(CQA_money.pair o) {
			if (this.income <= o.income) return -1;
			else return 1;
		}
	}
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		
		t = in.nextInt();
		while(t-->0) {
			init();
			solve();
		}		
	}
	
	static void init() {
		name = in.next();
		n = in.nextInt();
		
		a = new pair[n];
		for(int i=0; i<n; i++) 
			a[i] = new pair(in.nextDouble(), in.nextInt());		
		
		Arrays.sort(a);
	}
	
	static void solve() {
		
		System.out.println(name+":");
		for(int i=0; i<n; i++) {
			System.out.print(a[i].year+" ");
			
			int len = (int)a[i].income/1000;
			for(int j=0; j<len; j++)
				System.out.print("*");
			
			System.out.println();
		}
	}	
}

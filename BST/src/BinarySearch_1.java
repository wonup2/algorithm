import java.util.*;

public class BinarySearch_1 {
	static Scanner in;
	static int n, m, a[];
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			System.out.println(solve());
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		n=in.nextInt();
		m=in.nextInt();
		a=new int[n];
		for(int i=0; i<n; i++) a[i]=in.nextInt();	
		Arrays.sort(a);
	}
	
	public static boolean solve() {
		int low = 0;
		int up = n;
		int mid = 0;
		
		while(low<=up){
			mid=(up+low)/2;
			if(m>a[mid]) low=mid+1;
			else if (m<a[mid]) up=mid-1;
			else break; //m==mid
		}		
		
		return a[mid]==m;	
	}	
}

/*
input
10 3
9 6 2 10 7 3 4 1 5 8

1 2 3 4 5 6 7 8 9 10

output
true


input
10 11
20 6 12 18 7 3 14 13 5 8

output
false

*/


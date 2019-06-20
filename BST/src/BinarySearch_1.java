import java.util.*;

public class BinarySearch_1 {
	static Scanner in;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		//target
		int m=in.nextInt();
		
		//input data pile
		int n=in.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++) a[i]=in.nextInt();
		
		//sort data 
		Arrays.sort(a);
		
		int low = 0;
		int up = n;
		int mid = 0;
		
		//System.out.println(Arrays.toString(a));
		while(low<=up){
			mid=(up+low)/2;
			if(m>a[mid]) low=mid+1;
			else if (m<a[mid]) up=mid-1;
			else break; //m==mid
		}
		
		System.out.println(a[mid]);
	}
}




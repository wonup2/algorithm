
import java.util.*;
public class Fibonacci {
	
	static Scanner in;
	static long fibo[];
    static int t;
    
    public static void main(String[] args) {
    	in = new Scanner (System.in);
    	fibo = new long[91];
  		fibo[0] = 0;
  		fibo[1] = 1;
  	
  		for (int i=2; i<=90; i++)
  			fibo[i] = fibo[i-1] + fibo[i-2];
  			
  		t = in.nextInt();
  		while(t-->0) {
  			int num = in.nextInt();
  			System.out.println(num + " = " + fibo[num-1]);
  		}
    }
}

/*

7
1
5
8
11
13
21
40

*/
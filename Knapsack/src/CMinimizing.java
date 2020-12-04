import java.util.Arrays;
import java.util.Scanner;

//https://cses.fi/problemset/task/1634
public class CMinimizing {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int c[] = new int[n];
		long dp[] = new long[1000001];
		for(int i=0; i<n; i++)
			c[i] = in.nextInt();
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int j=0; j<n; j++) {
			for(int i=0; i<=x; i++) {
				if(i-c[j]>=0) {
					dp[i] = Math.min(dp[i], 1+dp[i-c[j]]);	
				}
			}
		}
		System.out.println(dp[x]==Integer.MAX_VALUE? -1:dp[x]);
	}

}

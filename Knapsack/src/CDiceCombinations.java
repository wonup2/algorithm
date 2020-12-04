import java.util.*;
//https://cses.fi/problemset/task/1633/

public class CDiceCombinations {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int dp[] = new int[n+1];
		
		dp[0]=1;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=6; j++) {
				if(i-j>=0) {
					dp[i] += dp[i-j];
					dp[i] %= 1000000007;
				}
			}
		}
		System.out.println(dp[n]);
	}

}

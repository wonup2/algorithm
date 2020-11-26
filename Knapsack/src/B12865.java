import java.util.*;

public class B12865 {
	static Scanner in;
	static int w[], p[], dp[][], n, t;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() {
		n = in.nextInt();
		t = in.nextInt();
		w = new int[n+1];
		p = new int[n+1];
		dp = new int[n+1][t+1];
		for(int i=1; i<=n; i++) {
			w[i] = in.nextInt();
			p[i] = in.nextInt();
		}
	}
	
	static void solve() {
		for(int i=1; i<=n; i++) 
			for(int j=1; j<=t; j++) 
				if(w[i]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], p[i]+dp[i-1][j-w[i]]);
		
		System.out.println(dp[n][t]);
	}
}

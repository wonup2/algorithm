import java.util.*;
public class B_11051 {
    static final int mod = 10007;
    static int[][] d = new int[1001][1001];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=0; i<=n; i++) {
            d[i][0] = d[i][i] = 1;
            for (int j=1; j<=i-1; j++) {
                d[i][j] = d[i-1][j-1] + d[i-1][j];
                d[i][j] %= mod;
            }
        }
        int ans = d[n][m];
        System.out.println(ans);
    }
}
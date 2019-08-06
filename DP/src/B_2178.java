
import java.util.*;
//타일채우기 4

public class B_2178 {
    static long[] f = new long[101];
    static long[] g = new long[101];
    static long[] h = new long[101];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        f[0] = 1;
        f[1] = 1;
        g[0] = 0;
        g[1] = 1;
        h[0] = 0;
        h[1] = 1;
        for (int i=2; i<=100; i++) {
            f[i] = f[i-1] + f[i-2] + g[i-1] + 2*h[i-1];
            g[i] = f[i-1] + g[i-2];
            h[i] = f[i-1] + h[i-1];
            if (f[i] >= 2147483647L) break;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(f[n]);
        }
    }
}
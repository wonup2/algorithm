//선물교환

import java.util.*;
public class B_1947 {
    static long mod = 1000000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[1] = 0;
        if (n >= 2) d[2] = 1;
        for (int i=3; i<=n; i++) {
            d[i] = (i-1)*(d[i-1]+d[i-2]);
            d[i] %= mod;
        }
        System.out.println(d[n]);
    }
}
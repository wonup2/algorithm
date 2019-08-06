//동전세기
import java.util.*;
public class B_9084 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] coin = new int[n];
            for (int i=0; i<n; i++) {
                coin[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] d = new int[m+1];
            d[0] = 1;
            for (int i=0; i<n; i++) {
                for (int j=coin[i]; j<=m; j++) {
                    d[j] += d[j-coin[i]];
                    System.out.println(j+" "+d[j]);
                }
            }
            System.out.println(d[m]);
        }
    }
}
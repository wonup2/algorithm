//커플만들기

import java.util.*;
public class B_1727 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        //점화식에 -1이 들어가니까 배열을 1부터 시작하자
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[m+1];
        for (int i=1; i<=m; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if (n > m) {
            int t = n;
            n = m;
            m = t;
            int[] t1 = Arrays.copyOf(b, b.length);
            int[] t2 = Arrays.copyOf(a, a.length);
            a = t1;
            b = t2;
        }
        int[][] d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=i; j<=m; j++) {
                d[i][j] = d[i-1][j-1] + Math.abs(a[i] - b[j]);
                //커플을 만들지 않는 경우
                //j-1 >= i 꼭지키자. 갯수가 달라지면 짝이 안맞아.
                if (j-1 >= i && d[i][j] > d[i][j-1]) {
                    d[i][j] = d[i][j-1];
                }
            }
        }
        System.out.println(d[n][m]);
    }
}
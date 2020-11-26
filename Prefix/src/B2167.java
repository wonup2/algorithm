//2차원 배열의 합

import java.util.*;
public class B2167 {
    static int[][] a = new int[5][5];
    static int[][] s = new int[5][5];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                a[i][j] = sc.nextInt();
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i][j];
            }
        }
        _2dPrint(a);
        _2dPrint(s);
        System.out.println();
        int k = sc.nextInt();
        while (k-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(s[x2][y2] +" "+s[x1-1][y2]  +" "+s[x2][y1-1]  +" "+s[x1-1][y1-1]);
            System.out.println(s[x2][y2] - s[x1-1][y2] - s[x2][y1-1] + s[x1-1][y1-1]);
        }
    }
    
    
    static void _2dPrint(int[][] a) {
    	System.out.println();
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a[0].length; j++) {
    			System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}

/*
4 4
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
*/

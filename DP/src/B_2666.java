//벽장문의 이동
import java.util.*;
public class B_2666 {
    static int n;
    static int[] door = new int[20];
    static int[][][] d = new int[20][21][21];
    static int go(int i, int door1, int door2) {
        if (i == n) {
            return 0;
        }
        int ans = d[i][door1][door2];
        if (ans != -1) return ans;
        ans = Math.min(go(i+1, door[i], door2) + Math.abs(door[i] - door1),
                go(i+1, door1, door[i]) + Math.abs(door[i] - door2));
        d[i][door1][door2] = ans;
        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int door1 = sc.nextInt();
        int door2 = sc.nextInt();
        n = sc.nextInt();
        for (int i=0; i<n; i++) {
            door[i] = sc.nextInt();
        }
        for (int i=0; i<20; i++) {
            for (int j=0; j<21; j++) {
                for (int k=0; k<21; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        System.out.println(go(0, door1, door2));
    }
}
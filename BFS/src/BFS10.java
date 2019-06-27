//B5014 StartLink 2point

import java.io.*;
import java.util.*;
 
public class BFS10 {
 
	static int f, s, g, u, d, v[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
 
        f = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        g = Integer.parseInt(str[2]);
        u = Integer.parseInt(str[3]);
        d = Integer.parseInt(str[4]);
        v = new int[f + 1];
        System.out.println(bfs());
 
    }
 
    public static String bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        v[s] = 1;
 
        while (!q.isEmpty()) {
        	System.out.println(Arrays.toString(v));
        	System.out.println(q);
            int current = q.poll();
            if (current == g) {
                return String.valueOf(v[current] - 1);
            }
            //다음 up 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current + u <= f) {
                if (v[current + u] == 0) {
                    v[current + u] = v[current] + 1;
                    q.add(current + u);
                }
 
            }
            //다음 down 이동할 위치가 최대값보다 작고 방문하지 않은 지점이여야 한다.
            if (current - d > 0) {
                if (v[current - d] == 0) {
                    v[current - d] = v[current] + 1;
                    q.add(current - d);
                }
            }
 
        }
        return "use the stairs";
    }
}

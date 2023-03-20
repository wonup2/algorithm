//USACO 2014 March Bronze
//http://www.usaco.org/index.php?page=viewproblem2&cpid=414
//B10026

import java.awt.Point;
import java.io.*;
import java.util.*;

public class BFS41_U14BR {
    
    static int n;
    static char[][] a;
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] v;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowart.in"));
        PrintWriter out = new PrintWriter(new File("cowart.out"));
        n = Integer.parseInt(br.readLine());
        a = new char[n][n];
        v = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = temp[j];
            }
        }
        
        int res1 = solve();
        
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j] == 'R')
                    a[i][j] = 'G';
            }
        }
        v = new boolean[n][n];
        int res2 = solve();
        
        
        out.println(res1+" "+res2);
        out.close();
        
    }
    
    static int solve() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(v[i][j]) continue;
                
                v[i][j] = true;
                q.add(new Point(i, j));
                
                while(!q.isEmpty()) {
                    
                    Point cur = q.poll();
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        
                        if(!isRange(nx, ny) || v[nx][ny] || a[nx][ny] != a[i][j]) continue;
                                                
                        v[nx][ny] = true;
                        q.add(new Point(nx, ny));                        
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
    
    static boolean isRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }
}

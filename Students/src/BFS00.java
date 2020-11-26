import java.util.*;
import java.io.*;


public class BFS00 {

    static Scanner in;
    
    static int N, M, a[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Integer> q = new LinkedList<Integer>();
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(System.in);
                
        init();
        solve();
        
        in.close();   
    }

    
    static void init() {
    	N = in.nextInt();
    	M = in.nextInt();
    	a = new int[N][M];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			a[i][j] = in.nextInt();
    		}
    	}
    	
    	System.out.println(Arrays.deepToString(a));
    }
    
    static void solve() {
        int count = 0;
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(a[i][j] == 1) {
        			bfs(i, j);
        			count++;
        		}
        	}
        }
        
        System.out.println(count);
    }
    
    static void bfs(int x, int y) {
    	q.add(x);
    	q.add(y);
    	a[x][y] = 0;
    	
    	
    	while(!q.isEmpty()) {
    		x = q.poll();
    		y = q.poll();

        	System.out.println(x + " " + y);
        	System.out.println(q);
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			System.out.println(nx + " " + ny);
    			
    			if(nx < 0 || ny < 0 || nx >= N || ny >= M || a[nx][ny] == 0) {
    				continue;
    			}
    			
    			q.add(nx);
    			q.add(ny);
    			a[x][y] = 0;
    		}
    	}
    }
}
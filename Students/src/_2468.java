import java.util.*;
import java.io.*;


public class _2468 {

    static BufferedReader in;
    
    static int N, maxHeight, a[][], acopy[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Integer> q = new LinkedList<Integer>();
    static HashSet<Integer> heights = new HashSet<Integer>();
    
    public static void main(String[] args) throws IOException {

    	in = new BufferedReader(new InputStreamReader(System.in));
                
        init();
        solve();
        
        in.close();   
    }

    
    static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	N = Integer.parseInt(st.nextToken());
    	
    	heights.add(0);
    	
    	a = new int[N][N];
    	acopy = new int[N][N];
    	for(int i = 0; i < N; i++) {
    		st = new StringTokenizer(in.readLine());
    		for(int j = 0; j < N; j++) {
    			a[i][j] = Integer.parseInt(st.nextToken());
    			heights.add(a[i][j]);
    		}
    	}
    	//System.out.println(Arrays.deepToString(a));
    }
    
    static void solve() {
        int maxAreas = 0;
        
        for(int k: heights) {
        	resetArray(k);
        	int areas = 0;
	        for(int i = 0; i < N; i++) {
	        	for(int j = 0; j < N; j++) {
	        		if(acopy[i][j] ==1) {
	        			bfs(i, j);
	        			areas++;
	        		}
	        	}
	        }
	        maxAreas = Math.max(maxAreas, areas);
        }
        
        System.out.println(maxAreas);
       // System.out.println(Arrays.deepToString(a));
    }
    
    static void bfs(int x, int y) {
    	q.add(x);
    	q.add(y);
    	acopy[x][y] = 0;    	
    	
    	while(!q.isEmpty()) {
    		x = q.poll();
    		y = q.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			
    			if(nx < 0 || ny < 0 || nx >= N || ny >= N || acopy[nx][ny] ==0) {
    				continue;
    			}
    			
    			q.add(nx);
    			q.add(ny);
    			acopy[nx][ny] = 0;
    		}
    	}
    }
    
    static void resetArray(int k) {
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(a[i][j]<=k) acopy[i][j] = 0;
    			else acopy[i][j] = 1;
    		}
    	}
    }
}
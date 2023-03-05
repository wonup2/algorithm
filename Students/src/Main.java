import java.util.*;


public class Main {

    static Scanner in;
    static int hmax, max, h, n, a[][], b[][], ans;
    static int[] dx = {0, 0, -1, 1}, dy = {-1, 1, 0, 0};
    static Queue<Integer> q;
    static HashSet<Integer> rain = new HashSet<Integer>();
    
    public static void main(String[] args) {

        in = new Scanner(System.in);
        init();
        solve();
    }
    
    static void init() {
        n = in.nextInt();
        a = new int[n][n];
        b = new int[n][n];
        max = 0;
        rain.add(0);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                a[i][j] = in.nextInt();               
                rain.add(a[i][j]);
            }
        } 
//        System.out.println(rain);
        q = new LinkedList<Integer>();        

    }
    
    static void solve() {
    	int max = 0;
      
        for(int l: rain) {
        	
        	reset_b(l);
  			ans = 0;
        	 for(int i=0; i<n; i++) {
                 for(int j=0; j<n; j++) {
                     if(b[i][j] ==1) {
                         bfs(i, j);
                         ans++;
                     }
                 }
             }
        	 max = Math.max(max, ans);
        }
       System.out.println(max);
        
    }
    
    static void bfs(int i, int j) {
        
        q.add(i); q.add(j);
        b[i][j] = 0;
        
        while(!q.isEmpty()) {
            
            int x = q.poll();
            int y = q.poll();
            b[x][y]= 0;
            for(int k=0; k<4; k++) {
        
                int nx = x+dx[k];
                int ny = y+dy[k];
            
                if(nx<0 || ny<0 || nx >=n || ny >=n || b[nx][ny] == 0) continue;
                
                q.add(nx); q.add(ny);                
            }            
        }        
    }
    
    static void reset_b (int k) {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			b[i][j] = a[i][j]>k ? 1:0;
    		}
    	}
    }
}
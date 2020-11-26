//2146 다리 만들기
import java.util.*;
public class BFS21 {

	static Scanner in;
	static int n, a[][], d[][], g[][], cnt;
	static Queue<pair> q;
	static int[] dx= {-1,1,0,0}, dy= {0,0,-1,1};
	
	public static void main(String[] args) {	
		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}
	static void init() {
		n = in.nextInt();
		a = new int[n][n];
		d = new int[n][n];
		g = new int[n][n];
		
		cnt=0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = in.nextInt();				
			}
		}
	}
	
	static void solve() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j] ==1 && g[i][j]==0) {
					g[i][j]=++cnt;
					bfs(i,j);
				}
			}
		}
		
		q = new LinkedList<pair>(); //큐 재생성
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1; //d에 우선 -1넣어둔다.
                if (a[i][j] == 1) { 
                    q.add(new pair(i,j)); //1인곳을 q에 넣어주고
                    d[i][j] = 0; //섬을 0으로 표시
                }
            }
        }

        while (!q.isEmpty()) {
        	pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) 
                    if (d[nx][ny] == -1) { //섬이 아닌곳이면
                        d[nx][ny] = d[x][y] + 1; //거리를 1증가
                        g[nx][ny] = g[x][y]; //섬의 영역도 섬을 표시한 같은 숫자로 확장시킨다. 
                        q.add(new pair(nx,ny)); //bfs
                    }
            }
        }
        int ans = -1; 
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<4; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];
                    if (0 <= x && x < n && 0 <= y && y < n) 
                        if (g[i][j] != g[x][y])  //인접한 섬의 영역이 다를 때
                            if (ans == -1 || ans > d[i][j] + d[x][y])  //인접한거리+현재거리 최소값 찾기
                                ans = d[i][j] + d[x][y];
                }
            }
        }
        System.out.println(ans);
    }
	
	static void bfs(int i, int j) {
		q = new LinkedList<pair>();
		q.add(new pair(i,j));
		while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) 
                    if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                        q.add(new pair(nx, ny));
                        g[nx][ny] = cnt; 
                    }
            }
		}
	}

	static void print(int[][] a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]+" ");
			}System.out.println();
		}
	}
	
	static class pair{
		int x, y;
		pair(int a, int b){
			x=a; y=b;
		}
	}
}

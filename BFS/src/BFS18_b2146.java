//백준 2146

import java.util.*;
public class BFS18_b2146 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n]; //입력받은 배열
        int[][] d = new int[n][n]; //섬과 섬사이 거리
        int[][] g = new int[n][n]; //섬 그룹
        
        for (int i=0; i<n; i++) //입력 받기
            for (int j=0; j<n; j++) 
                a[i][j] = scan.nextInt();
        
        int cnt = 0; //섬을 표시할 변수
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (a[i][j] == 1 && g[i][j] == 0) { //a가 1이고 g를 초기화 안했다면
                    Queue<Dot> q = new LinkedList<Dot>();
                    g[i][j] = ++cnt; //g를 초기화
                    q.add(new Dot(i, j));
                    while (!q.isEmpty()) {
                        Dot p = q.remove();
                        int x = p.x;
                        int y = p.y;
                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < n) 
                                if (a[nx][ny] == 1 && g[nx][ny] == 0) {
                                    q.add(new Dot(nx, ny));
                                    g[nx][ny] = cnt; //while문 안에서 돌기때문에 인접한 다른 곳들도 1이면 같은 숫자로 초기화 
                                }
                        }
                    }
                }
            }
        }
        
        print(g);

        
        Queue<Dot> q = new LinkedList<Dot>(); //큐 재생성
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                d[i][j] = -1; //d에 우선 -1넣어둔다.
                if (a[i][j] == 1) { 
                    q.add(new Dot(i,j)); //1인곳을 q에 넣어주고
                    d[i][j] = 0; //섬을 0으로 표시
                }
            }
        }
        print(d);
        
        while (!q.isEmpty()) {
            Dot p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) 
                    if (d[nx][ny] == -1) { //섬이 아닌곳이면
                        d[nx][ny] = d[x][y] + 1; //거리를 1증가
                        g[nx][ny] = g[x][y]; //섬의 영역도 섬을 표시한 같은 숫자로 확장시킨다. 
                        q.add(new Dot(nx,ny)); //bfs
                    }
            }
        }
        
        
        print(g);
        print(d);
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
    static void print(int[][]a) {
		System.out.println();
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
class Dot {
    int x;
    int y;
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
5

1 0 0 0 1
1 1 0 0 1
0 0 0 0 0
0 0 1 0 0
0 1 1 1 0


 
g배열에는

1 0 0 0 2
1 1 0 0 2
0 0 0 0 0
0 0 3 0 0
0 3 3 3 0


그후에는 d배열에 섬과 섬사의 거리를 bfs로 채워넣는다.
채워넣을 땐 거리만 채워넣을 것 이아니라 
g배열에서도 섬이 확장되는 것을 섬을 구분한 숫자로 채워넣는다.

 
d배열

0 1 2 1 0
0 0 1 1 0
1 1 1 2 1
2 1 0 1 2
1 0 0 0 1

 
이 들어가게 된다 여기서 0은 섬이다.
그리고 다시 g배열에는 bfs를 통해 확장한 것을 표시한다.
[0][0]쪽 부터 반복문이 시작하기 때문에 1쪽이 제일 빨리 bfs가 실행된다.

 
g배열

1 1 1 2 2
1 1 1 2 2
1 1 3 0 2
1 3 3 3 0
3 3 3 3 3

*/
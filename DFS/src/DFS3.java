import java.util.List;
import java.util.Scanner;

//b2583
import java.util.*;
public class DFS3 {
	
	static boolean a[][];
	static int n,m,t,cnt=1;
	static List<Integer> num;
	static int dx[] = { 0,0,-1,1 };
	static int dy[] = { 1,-1,0,0 };
	static Scanner in;
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		init();
		System.out.println(solve());
		in.close();		
	}
	
	public static void init() {
		n=in.nextInt();
		m=in.nextInt();
		t=in.nextInt();
		a=new boolean[n][m];
		
		for(int i=0; i<t; i++) {
			int c1=in.nextInt(), r1=in.nextInt(), c2=in.nextInt(), r2=in.nextInt();
			for(int row=r1; row<r2; row++) {
				for(int col=c1; col<c2; col++) {
					a[row][col]=true;
				}
			}
		}	
	}

	static String solve() {
		num=new ArrayList<Integer>();
		for(int row=0; row<n; row++) {
			for(int col=0; col<m; col++) {
				if(!a[row][col]) {
					dfs(row,col);
					num.add(cnt);
					cnt=1;
				}
			}
		}
		Collections.sort(num);
		String result=num.size()+"\n";
		for(int i:num) {
			result+=i+" ";
		}
		return result;
	}
		
	static void dfs(int x, int y) {
		a[x][y]=true;
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m||a[nx][ny]) continue;
			dfs(nx, ny);
			cnt++;		
		}
		//print(a);
	}
	
	
		public static void print(boolean a[][]) {
			System.out.println();
			for(int row=0; row<a.length; row++) {
				for(int col=0; col<a[0].length; col++) {
					System.out.print(a[row][col]? 1+" ":0 +" ");
				}
				System.out.println();
			}
		}
	}

/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

3
1 7 13
*/
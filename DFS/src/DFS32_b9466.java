//텀 프로젝트
//https://www.acmicpc.net/problem/9466
import java.util.*;
public class DFS32_b9466 {
	
	static int t, n, cnt, a[];
	static boolean v[], d[];
	static void dfs(int i) {
		v[i]=true;
		int next = a[i];
		if(!v[next]) dfs(next);
		else if(!d[next]) {
			cnt++;
			while(next!=i) {
				cnt++;
				next=a[next];				
			}		
		}
		d[i]=true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);  
		int t = in.nextInt();
		for (int j = 0; j < t; j++){
			n=in.nextInt();
			v=new boolean[n+1];
			d=new boolean[n+1];
			a=new int[n+1];
			for (int i = 1; i <= n; i++)
				a[i]=in.nextInt();
            cnt = 0;
            for (int i = 1; i <= n; i++)            
            	if (!v[i]) dfs(i);  

            System.out.println(n-cnt);
        }
	}
}

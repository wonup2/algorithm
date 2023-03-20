//숨바꼭질
//https://www.acmicpc.net/problem/1697
import java.util.*;

public class BFS40_b1697 {

	static Scanner in;
	static int v[] = new int[100001];
	static Queue<Integer> q;
	static int n,m;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		System.out.println(solve());
		in.close();
	}

	static void init() {
		n=in.nextInt();
		m=in.nextInt();
		q=new LinkedList<Integer>();
		q.add(n);
		v[n]=1;
	}
	
	static int solve() {
		int ans=0;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==m) {
				ans = v[x]-1; 
				break;
			}
			if(x-1>=0 && v[x-1]==0) {
				v[x-1] = v[x]+1;
				q.add(x-1);
			}
			if(x+1<=100000 && v[x+1]==0) {
				v[x+1] = v[x]+1;
				q.add(x+1);
			}
			if(x*2<=100000 && v[x*2]==0) {
				v[x*2] = v[x]+1;
				q.add(x*2);
			}
		}
		return ans;
	}
}


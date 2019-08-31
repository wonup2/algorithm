//Adjacency List 
//search order
/*
8 7 1
1 2
1 3
2 6
2 7
3 4
3 5
4 8
*/

import java.util.*;
public class BFS30 {

	static Scanner in;
	static boolean v[];
	static Queue<Integer> q;
	static ArrayList<Integer>[] a;
	static int n,m,s;
	static int ans;
	
	public static void main(String[] args) {
		try {
			in=new Scanner(System.in);
			init();
			System.out.println(solve());
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	static void init() {
		n=in.nextInt();
		m=in.nextInt();
		s=in.nextInt();
		v=new boolean[n];
		a=new ArrayList[n];
		q=new LinkedList<Integer>();
		for(int i=0; i<n; i++) {			
			a[i]=new ArrayList<Integer>();
		}
		
		for(int i=1; i<=n; i++) {
			
			int y=in.nextInt();
			a[i].add(y);
			a[y].add(i);
		}
	}

	static String solve() {
		return bfs(s-1);
	}
	
	static String bfs(int s) {
		v[s]=true;
		String result="";
		q.add(s);
		
		while(!q.isEmpty()) {
			int n=q.poll();
			result+=(n+1)+" ";
			for(int i:a[n]) {
				if(v[i]) continue;
				v[i]=true;
				q.add(i);				
			}
		}
		return result;
	}
}

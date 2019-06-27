import java.util.*;

//1260  -  Adjacency List
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
*/

public class BFS05 {
	
	static int n, m, s;
	static boolean[] v;
	static List<Integer> a[];
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ini();
		bfs(s);		
	}
	static void ini(){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		v=new boolean[n+1];
		a=new List[n+1];
		for(int i=0; i<=m; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++){
			int n1=in.nextInt();
			int n2=in.nextInt();
			a[n1].add(n2);
			a[n2].add(n1);			
		}
		in.close();
	}
	
	static void bfs(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		v[start] = true;
		while(!q.isEmpty()){
			int x = q.poll();
			v[x] = true;
			System.out.print(x+" ");
			for(int i=0; i<a[x].size(); i++){
				int y = a[x].get(i);
				if(!v[y]) {
					q.add(y);
					v[y] = true;
				}
			}
		}
	}	
}
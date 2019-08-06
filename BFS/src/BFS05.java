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
	static ArrayList<Integer> a[];
	static Queue<Integer> q;
	static Scanner in;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(System.in);
			init();
			System.out.println(bfs(s));
			in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}			
	}	
	
	@SuppressWarnings("unchecked")
	static void init(){
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		v = new boolean[n+1];
		a = new ArrayList[n+1];
		q = new LinkedList<Integer>();
		
		for(int i=0; i<=n; i++)
			a[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++){
			int n1=in.nextInt();
			int n2=in.nextInt();
			a[n1].add(n2);
			a[n2].add(n1);			
		}	
		
		//System.out.println(Arrays.toString(a));
	}
	
	static String bfs(int start){
		q.add(start);
		v[start] = true;
		String result="";
		
		while(!q.isEmpty()){
			int x = q.poll();
			result+=x+" ";
			for(int y:a[x]){			
				if(v[y]) continue;
				q.add(y);
				v[y] = true;				
			}
		}		
		return result;
	}	
}
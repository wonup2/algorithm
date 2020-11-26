import java.util.*;

public class Main {

	static int MAX = 10001;
	
	static int V[], C[], K[], dp[], N, M;
	static LinkedList <pair> things;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		V=new int[MAX];
		C=new int[MAX];
		K=new int[MAX];
		dp=new int[MAX];
		
	    for(int i = 0; i < N; i++) {
	        V[i] = in.nextInt();
	        C[i] = in.nextInt();
	        K[i] = in.nextInt();
	    }
	
	    things = new LinkedList<pair>();
	    for(int j = 0; j < N; j++) {
	        for(int i = K[j]; i > 0; i>>=1) {
	            int num = i-(i>>1);
	            things.add(new pair(V[j]*num, C[j]*num));
	    	    //System.out.println(i+" "+num+" "+things);
	        }
	    }
	    
	    System.out.println(things);
	    for(int i = 0; i < things.size(); i++) {
	        int c = things.get(i).c;
	        int v = things.get(i).v;
	        for(int j = M; j >= c; j--) {
	            dp[j] = Math.max(dp[j], dp[j-c]+v);
	        }
	        System.out.println(Arrays.toString(dp));
	    }
	    System.out.println(dp[M]);		
	}

	static class pair{
		int c;
		int v;
	
		pair(int a, int b){
			c = a;
			v = b;
		}
		
		public String toString() {
			return c+" "+v;
		}
	}	
}
	
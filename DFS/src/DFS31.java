//b 1987
import java.util.*;

public class DFS31 {

	static int dy[]={1,-1,0,0};
	static int dx[]={0,0,1,-1};
	static int R,C, ans=0;
	static char a[][];
	static boolean v[]; //A~Z
	static Scanner in;
	public static void main(String[] args){
	    try {
	    	init();
	    	solve();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }	    
	}
	
	static void init() {
		in = new Scanner(System.in);		
		R = in.nextInt();
		C = in.nextInt(); in.nextLine();
		a = new char[R][C];		
		for(int i=0;i<R;i++)
	       a[i] = in.nextLine().toCharArray();
		
		v = new boolean[26];
		
	}
	
	static void solve() {
			 
	    v[a[0][0]-65] = true;; //visited a[0][0]--->v[C] = true;
	    dfs(0,0,1);
	    
	    System.out.println(ans);	   
	}

	static void dfs(int y,int x,int cnt){
	    
	    ans=Math.max(ans,cnt);
	    
	    for(int i=0;i<4;i++){
	        int ny=y+dy[i];
	        int nx=x+dx[i];
	        
	        if(ny<0 || ny>=R || nx<0 || nx>=C) continue;	       
	        int l = a[ny][nx]-65;
	        if(v[l]) continue;
	        
	        v[l] = true;
	        dfs(ny,nx,cnt+1);
	        v[l] = false;	        
	    }
	}
}

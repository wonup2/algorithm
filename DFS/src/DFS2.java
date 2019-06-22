//B2667 - numbering blocks

import java.util.*;
import java.io.*;

public class DFS2 {
	
	static int n;
	static String a[][], result="";	

	static boolean set;
    static int temp;
    static Scanner in;
    
    static void init() {
    	n = in.nextInt(); in.nextLine();			
		a = new String[n][n];
		
		for(int i = 0; i < n; i++) 			
			a[i] = in.nextLine().split("");
    }
    
    
	public static void main(String[] args){
		
		try {
			in = new Scanner(System.in);	
			
			init();
			result = solve();
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static String solve() {
		int count = 0;
        temp = 0;
        ArrayList<Integer> hmm = new ArrayList<Integer>();
        
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < n; c++) {
				dfs(r, c);
				if(set) {
					set = false;
                    hmm.add(temp);
					count++;
                    temp = 0;
				}
			}
		}
		result = count+"\n";
        Collections.sort(hmm);
        for(int i = 0; i < count; i++)
            result+=hmm.get(i)+"\n";        
        
        return result;
	}
	
	
	public static void dfs (int x, int y) {
		if(y<0 || y>=n || x<0 || x>=n) return;      
        if(a[x][y].equals("0")) return;     
        if(a[x][y].equals("$")) return;

        a[x][y]="$";
        temp++;
        dfs(x, y+1);
        dfs(x, y-1);
        dfs(x+1, y);
        dfs(x-1, y);
        
        set = true;
        return ;
    }
	
}

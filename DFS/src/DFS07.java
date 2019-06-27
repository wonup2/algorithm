//Baek Joon 6603 Lotto

import java.util.*;
public class DFS07 {
	static int a[]=new int[13], k;
	static ArrayList<Integer> v;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
			k=in.nextInt();
			if(k==0) break;
			for(int i=0; i<k; i++) a[i] = in.nextInt();
		    for(int i=0; i<k; i++) { 
		    	System.out.println("return "+i);
		    	v=new ArrayList<Integer>();
		    	dfs(i); 
		    }            
		    System.out.println();
		}		
	}
	static void dfs(int start) {
	    v.add(a[start]);
	    System.out.println("1");
	    if(v.size() == 6) {   
		    System.out.println("2");

	        for(int i=0; i<6; i++) {
	            System.out.print(v.get(i)+" ");  
	        }
	        System.out.println();
	        return;
	    }
	                                        
	    for(int i=start+1; i<k; i++) {   
		    System.out.println("3");

	        dfs(i);
		    System.out.println("4");

	        v.remove(v.size()-1);
	        System.out.println(start+" "+i+" "+v);
	    }	    
	}
}

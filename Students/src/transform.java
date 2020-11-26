/*
ID: wonup21
LANG: JAVA
TASK: transform
*/

import java.util.*;
import java.io.*;

public class transform {
	static Scanner in;
    static PrintWriter out;

    //original Variables
    static int n;
    static char[][] original;
    static char[][] output;
    
    public static void main(String[] args) {

        try {

            //Initialize in & out
            in = new Scanner(new File("transform.in"));
            out = new PrintWriter(new File("transform.out"));

            init();
            //Write out file
            solve();
            System.out.println(Arrays.deepToString(reflection(original)));
            out.close();
            in.close();

        }catch(Exception e) {
            e.printStackTrace();
        }



    }

    private static void init() {
    	n = in.nextInt();
    	original = new char[n][n];
    	output = new char[n][n];
    	in.nextLine();


    	for(int j = 0; j < n; j++) {
    	 String temp = in.nextLine();
    		for(int i = 0; i < n; i++) {
    			original[j][i] = temp.charAt(i);
        	}
    	}
    	
    	for(int j = 0; j < n; j++) {
       	 String temp = in.nextLine();
       		for(int i = 0; i < n; i++) {
       			output[j][i] = temp.charAt(i);
           	}
       	}

    }

    private static void solve() {
    	if(Arrays.deepEquals(_90(original), output)) {
    		out.print("1");
    	}else if(Arrays.deepEquals(_90(_90(original)), output)) {
    		out.print("2");
    	}else if (Arrays.deepEquals(_90(_90(_90(original))), output)){
    		out.print("3");
    	}else if(Arrays.deepEquals(reflection(original), output)) {
    		out.print("4");
    	}else if (   (Arrays.deepEquals(reflection(_90(original)), output)) 
    		||       (Arrays.deepEquals(reflection(_90(_90(original))), output)) 
            ||       (Arrays.deepEquals(reflection(_90(_90(_90(original)))), output))) {
          out.println(5);
      } else if (Arrays.deepEquals(original, output)) {
          out.println(6);
      } else {
          out.println(7);
      }

    }
    
    private static char[][] _90(char[][] a) {
    	char[][] ret = new char[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ret[j][n-1-i] = original[i][j];
			}
		}
    		
    	return ret;
    }
    private static char[][] reflection(char[][] a){
    	char[][] ret = new char[n][n];
    	for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ret[j][n-1-i] = original[i][n-j-1];
			}
    	}
    	return ret;
    }
}


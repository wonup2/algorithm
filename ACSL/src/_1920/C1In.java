package _1920;

import java.util.*;
import java.io.*;


public class C1In {
	
	static Scanner in;
	static char a[];
	static String N;
	static int P;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("c1in.in"));
		init();
		solve();
		in.close();
	}
	
	static void init() {
		N = in.next();
		P = in.nextInt();
		a = N.toCharArray();
	}
	static void solve() {
		
		P = N.length()-P;
		int key = a[P]-'0';		
		
		for(int i=0; i<P; i++) {
			int num = (a[i]-'0' + key)%10;
			System.out.print(num);
		}
		System.out.print(key);
		for(int i=P+1; i<N.length(); i++) {
			int num = Math.abs(a[i]-'0'-key);
			System.out.print(num);
		}		
		System.out.println(Double.MAX_VALUE);
	}
}

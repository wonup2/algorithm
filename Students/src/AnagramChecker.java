

import java.util.*;

public class AnagramChecker {

	static Scanner in = new Scanner(System.in);
	static int testcase;
	static String s[], og, temp;
	
	public static void main(String[] args) {
		testcase = in.nextInt(); in.nextLine();
		
		for (int i = 0; i < testcase; i++){
			init();
			solve();
		}
	}
	
	public static void init() {
		og = in.nextLine();
		s = og.split("\\|");		
	}
	
	public static void solve() {
		
		char[] a = s[0].toCharArray();
		char[] b = s[1].toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		if(s[0].equals(s[1])) 			
			System.out.println(og + " = NOT AN ANAGRAM");

		else if(Arrays.equals(a, b)) 
			System.out.println(og + " = ANAGRAM");
		
		else System.out.println(og + " = NOT AN ANAGRAM");		
	}
}

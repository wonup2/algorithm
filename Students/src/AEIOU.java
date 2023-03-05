import java.util.*;
public class AEIOU {

	static Scanner in = new Scanner(System.in);
	static int testcase, count;
	static String sen;
	
	public static void main(String[] args) {
		testcase = in.nextInt(); in.nextLine();		
		
		for (int i = 0; i <= testcase; i++){
			init();
			solve();
			print();
		}
	}
	
	public static void init() {
		sen = in.nextLine();
	}
	
	public static void solve() {
		count = 0;
		for (int n = 0; n < sen.length(); n++) {
			if (sen.charAt(n) == 'a' || sen.charAt(n) == 'e' || sen.charAt(n) == 'i' || sen.charAt(n) == 'o' || sen.charAt(n) == 'u') {
				count++;
			}
		}
	}

	public static void print() {
		System.out.println(count);
	}
}

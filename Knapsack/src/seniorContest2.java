import java.util.*;
import java.io.*;
public class seniorContest2 {

	static Scanner in;
	static PrintWriter out;
	static String s1;
	static String s2;
	static String[] s2split, s1split;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(new File("seniorContest2.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("seniorContest2.out")));
		//for (int rep = 0; rep < 5; rep++) {
			init();
			solve();
		//}
	}
	
	public static void init() {
		s1 = in.nextLine();
		s2 = in.nextLine();
		s1 = s1.toUpperCase();
		s2 = s2.toUpperCase();
		s1split = s1.split(" ");
		s2split = s2.split(" ");
//		s1 = "";
//		s2 = "";
//		for (int i = 0; i < s1split.length; i++) {
//			s1 += s1split[i];
//		}
//		for (int i = 0; i < s2split.length; i++) {
//			s2 += s2split[i];
//		}
		System.out.println(s1);
		System.out.println(s2);
		list = new ArrayList<String>();
	}
	
	public static void solve() {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ' ')
				continue;
			for (int j = i + 1; j < s1.length(); j++) {
				if (s1.charAt(j) == ' ')
					break;
				String sub = s1.substring(i, j); 
				if (s2.contains(sub))
					list.add(sub);
			}
			System.out.println(list.toString());

		}
	}
}




//for (int x = 0; x < s.length; x++) {
//	String word = s[x];
//	System.out.println(word);
//	for (int i = 0; i < word.length(); i++) {
//		for (int j = i + 1; j < word.length(); j++) {
//			String temp = word.substring(i, j);
//			if (s1.contains(temp))
//				list.add(temp);
//		}
//	}
//	System.out.println(list.toString());
//}

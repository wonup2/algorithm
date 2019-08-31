import java.util.*;

public class LeterCount {

	public static void main(String[] args) {

		String s = "HELLOJAVAWORLDHIEVERIONE";
		
		Map <Character, Integer> m = new TreeMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(m.containsKey(c)) {
				m.put(c, m.get(c)+1);
			}
			else {
				m.put(c, 1);
			}
		}
		
		for(char c:m.keySet())
			System.out.println(c+" : "+m.get(c));
		
	}

}

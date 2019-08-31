import java.util.*;

public class Nations {

	public static void main(String[] args) {

		//HashMap, LinkedHashMap, TreeMap
		
		Map<Integer, String> m = new TreeMap<Integer, String>();
		m.put(1, "United State");
		m.put(3, "Mexico");
		m.put(2, "Spain");
		
//		System.out.println(m.get(1));
//		if(m.containsKey(4)) {
//			System.out.println(m.get(4));
//		}
//		else System.out.println("There is no 4");
		
		for(int k:m.keySet()) {
			System.out.println(k +" "+m.get(k));
		}
		
		m.remove(2);
		
		for(int k:m.keySet()) {
			System.out.println(k +" "+m.get(k));
		}
		
		
	}

}

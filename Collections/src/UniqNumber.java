import java.util.*;

public class UniqNumber {

	public static void main(String[] args) {

		int[] a = {61, 31, 40, 6, 2, 4, 1, 5, 4, 6, 1, 2, 3, 1, 3, 5};
		
		Set<Integer> s = new TreeSet<Integer>();
		
		for(int i:a)
			s.add(i);
		
		System.out.println(s);
	}

}

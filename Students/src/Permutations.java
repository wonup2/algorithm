
public class Permutations {

	static String s;
	static int a[] = {1, 2, 3, 4, 5, 6, 7};
	public static void main(String[] args) {
		
		
		//permutation("");
		

		for(int i=0; i<7; i++)
			permutation("", i);
	}

	static void permutation(String s, int start) {
		s = s+a[start];
		if(s.length()==6) {
			System.out.println(s);
			
		}
		for(int i=start+1; i<7; i++) {
			permutation(s, i);
		}
		
	}
	
	
	static void permutation(String s) {
		
		//System.out.println(s);
		if(s.length()==3) {
			System.out.println("3 :" + s);	
		}
		
		for(int i=0; i<a.length; i++) {			
			if(!s.contains(a[i]+"")) {
				//System.out.println(s);
				permutation(s+a[i]);
			}
		}
	}
}

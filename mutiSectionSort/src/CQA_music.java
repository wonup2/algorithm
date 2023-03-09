import java.util.*;

public class CQA_music {

	static Scanner in;
	static int T, N;
	static pair a[];
	
	static class pair implements Comparable<pair>{

		String song, singer1, singer2;
		pair(String s1, String s2){
			song = s1;
			singer1 = s2;
			singer2 = singer1.toLowerCase();
			
			if(singer2.startsWith("the "))
				singer2 = singer2.substring(4);
		}
		
		public String toString() {
			return song + " - " + singer1;
		}
		
		@Override
		public int compareTo(CQA_music.pair o) {
			
			if(this.singer2.equals(o.singer2)) {
				return this.song.compareTo(o.song);
			}
			else return this.singer2.compareTo(o.singer2);
		}		
	}
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		T = in.nextInt();
		
		while(T-->0) solve();		
	}
	
	static void solve() {
		
		N = in.nextInt(); in.nextLine();
		
		a = new pair[N];
		
		for(int i=0; i<N; i++) {
			String s[] = in.nextLine().split(" - ");
			a[i] = new pair(s[0], s[1]);
		}
		
		Arrays.sort(a);		
		
		for(pair p:a)System.out.println(p);
	}	
}


/*

2
5
Hello - Adele
Yesterday - The Beatles
Love Me Like You Do - Ellie Goulding
Hey Jude - The Beatles
Istanbul - They Might Be Giants
4
Red Hands - Walk Off The Earth
Speeches - Walk Off The Earth
R.E.V.O. - WOTE
Sometimes - Walk Off The Earth

*/

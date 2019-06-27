
public class Prints {

	public static void print(boolean a[][]) {
		for(int row=0; row<a.length; row++) {
			for(int col=0; col<a[0].length; col++) {
				System.out.print(a[row][col]? 1+" ":0 +" ");
			}
			System.out.println();
		}
	}

}

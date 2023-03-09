//b1913
import java.util.*;
public class BinarySearch_3{

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    double a = in.nextDouble();
		double b = in.nextDouble();
		double v = in.nextDouble();

		int count = (int) Math.ceil((v-b)/(a-b));
		
				
		System.out.println(count);
	}
}
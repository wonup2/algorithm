import java.util.*;
public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		String s[] = in.nextLine().split("\\|"); // abc|def
		
		System.out.println(Arrays.toString(s));
	}

}

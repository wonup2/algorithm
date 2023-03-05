
public class B11650 implements Comparable<B11650> {

	int x, y;
	B11650(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(B11650 o) {
		if(this.x==o.x) return this.y-o.y;
		return this.x-o.x;
	}
	
	public String toString() {
		return x+" "+y;
	}

	
	public static void main(String[] args) {

		B11650 a[][];
		
	}


	
}

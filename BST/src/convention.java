import java.util.*;
import java.io.*;
public class convention{
  static BufferedReader in;
  static PrintWriter out;
  static int cows, buses, load;
  static int[] array;
  public static void main(String[] args) throws IOException {
    in = new BufferedReader(new FileReader(new File("convention.in")));
    out = new PrintWriter(new File("convention.out")); 
    init();
    solve();
  }

  static void init() throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    cows = Integer.parseInt(st.nextToken());
    buses = Integer.parseInt(st.nextToken());
    load = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());
    array = new int[cows];
    for(int i = 0; i < cows; i++){
      array[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(array);
  }

  static void solve(){
    int low = 0;
    int ans = 0;
    int high = array[array.length - 1];
    while(low <= high) {
        int mid = (high + low) / 2;
        if(check(mid)) {
            high = mid - 1;
            ans = mid;
        } else {
            low = mid + 1;
        }
    }
    out.println(ans);
  }

  static boolean check(int mid){
    int start = array[0], cow = 0, bus = 1;
    for(int i = 0; i < array.length; i++){
      int s = array[i] - start;
      cow++;
      if(cow > mid || s > mid){
        bus++;
        start = array[i];
        cow = 1;
      }
    }
    return bus <= buses;
  }
}
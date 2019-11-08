import java.time.LocalDate;
 
public class Test {
    public static void main(String [] args) {
        LocalDate obj = LocalDate.now();
        System.out.println(obj.getHour());
    }
}
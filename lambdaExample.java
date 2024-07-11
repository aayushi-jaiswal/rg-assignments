import java.util.Arrays;
import java.util.List;

public class lambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda expression to iterate through the list
        names.forEach(name -> System.out.println(name));
    }
}

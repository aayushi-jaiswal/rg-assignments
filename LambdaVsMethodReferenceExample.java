import java.util.Arrays;
import java.util.List;

public class LambdaVsMethodReferenceExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Using Lambda Expression
        System.out.println("Using Lambda Expression:");
        strings.stream()
               .sorted((s1, s2) -> s1.compareTo(s2))
               .forEach(s -> System.out.println(s)); 

        System.out.println();

        // Using Method Reference
        System.out.println("Using Method Reference:");
        strings.stream()
               .sorted(String::compareTo)  
               .forEach(System.out::println); 
    }
}

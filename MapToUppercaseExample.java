import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToUppercaseExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("paypal", "bangalore", "aayushi", "jaiswal");

        
        List<String> uppercasedStrings = strings.stream()
                                                .map(String::toUpperCase)
                                                .collect(Collectors.toList());

        
        uppercasedStrings.forEach(System.out::println);
    }
}

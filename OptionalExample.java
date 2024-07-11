import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> optionalValue = findValue("Hello");
        Optional<String> emptyOptional = findValue(null);

        optionalValue.ifPresent(value -> System.out.println("Value is present: " + value));

        String value1 = optionalValue.orElse("Default Value");
        String value2 = emptyOptional.orElse("Default Value");
        System.out.println("Value1: " + value1);
        System.out.println("Value2: " + value2);

        Optional<Integer> length = optionalValue.map(String::length);
        System.out.println("Length: " + length.orElse(0));

        try {
            String value3 = emptyOptional.orElseThrow(() -> new IllegalArgumentException("Value not found"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Optional<String> findValue(String input) {
        return Optional.ofNullable(input);
    }
}

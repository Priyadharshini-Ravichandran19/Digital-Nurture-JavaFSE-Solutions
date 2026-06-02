import java.util.*;

public class Lambdaa {

    public static void main(String[] args) {

        List<String> names =
                Arrays.asList(
                        "Zara",
                        "Bob",
                        "Alice"
                );

        Collections.sort(
                names,
                (a,b) -> a.compareTo(b)
        );

        System.out.println(names);
    }
}
import java.util.List;

record Person(String name, int age) {}

public class Records {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Priya", 21),
                new Person("Rahul", 17),
                new Person("Sam", 25)
        );

        people.stream()
                .filter(p -> p.age() >= 18)
                .forEach(System.out::println);
    }
}
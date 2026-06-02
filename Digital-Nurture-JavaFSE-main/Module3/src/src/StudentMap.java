import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer,String> map =
                new HashMap<>();

        map.put(101,"Priya");
        map.put(102,"Rahul");
        map.put(103,"Sam");

        System.out.print(
                "Enter student id: "
        );

        int id = sc.nextInt();

        System.out.println(
                map.get(id)
        );
    }
}
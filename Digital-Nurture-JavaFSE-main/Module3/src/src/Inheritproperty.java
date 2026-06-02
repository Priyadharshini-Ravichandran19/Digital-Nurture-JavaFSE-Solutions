class Participant {

    String name;
    String email;

    void displayInfo() {
        System.out.println(name);
        System.out.println(email);
    }
}

class Developer extends Participant {

    String language;

    void displayDeveloper() {

        displayInfo();

        System.out.println("Language: " + language);
    }
}

public class Inheritproperty {

    public static void main(String[] args) {

        Developer dev = new Developer();

        dev.name = "PD";
        dev.email = "pd@gmail.com";
        dev.language = "Java";

        dev.displayDeveloper();
    }
}
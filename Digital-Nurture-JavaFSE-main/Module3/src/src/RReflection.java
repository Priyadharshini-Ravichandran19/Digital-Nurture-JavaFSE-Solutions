import java.lang.reflect.Method;

public class RReflection {

    public static void main(String[] args) {
        try {

            Class<?> cls =
                    Class.forName("RStudent");

            System.out.println(
                    "Class Name: " +
                            cls.getName()
            );

            Method[] methods =
                    cls.getDeclaredMethods();

            for(Method m : methods) {

                System.out.println(
                        "Method: " +
                                m.getName()
                );
            }

            Object obj =
                    cls.getDeclaredConstructor()
                            .newInstance();

            Method method =
                    cls.getMethod("display");

            method.invoke(obj);

        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }
}
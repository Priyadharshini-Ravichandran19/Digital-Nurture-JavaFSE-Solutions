public class VirtualThread {

    public static void main(String[] args)
            throws InterruptedException {

        for(int i = 1; i <= 10; i++) {

            int id = i;

            Thread.startVirtualThread(() -> {

                System.out.println(
                        "Virtual Thread " + id
                );

            });
        }

        Thread.sleep(1000);
    }
}
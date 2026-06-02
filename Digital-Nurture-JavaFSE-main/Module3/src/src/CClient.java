import java.io.*;
import java.net.*;

public class CClient {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket(
                            "localhost",
                            5000
                    );

            DataOutputStream dos =
                    new DataOutputStream(
                            socket.getOutputStream()
                    );

            dos.writeUTF(
                    "Hello Server!"
            );

            dos.close();
            socket.close();

        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }
}
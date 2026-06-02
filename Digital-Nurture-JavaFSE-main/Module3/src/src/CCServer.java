import java.io.*;
import java.net.*;

public class CCServer {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket =
                    new ServerSocket(5000);

            System.out.println("Server Started...");
            System.out.println("Waiting for Client...");

            Socket socket =
                    serverSocket.accept();

            System.out.println("Client Connected");

            DataInputStream dis =
                    new DataInputStream(
                            socket.getInputStream()
                    );

            String message =
                    dis.readUTF();

            System.out.println(
                    "Client Says: " + message
            );

            dis.close();
            socket.close();
            serverSocket.close();

        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }
}
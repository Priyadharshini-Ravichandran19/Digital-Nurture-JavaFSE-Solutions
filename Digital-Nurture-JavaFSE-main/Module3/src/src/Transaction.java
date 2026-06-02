import java.sql.*;

public class Transaction {

    static final String URL =
            "jdbc:mysql://localhost:3306/event_db";

    static final String USER =
            "root";

    static final String PASSWORD =
            "your password";//due to password security conncerns it is not added here

    public static void main(String[] args) {

        try {

            Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance - 300 WHERE id = 1"
                    );

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts SET balance = balance + 300 WHERE id = 2"
                    );

            debit.executeUpdate();

            credit.executeUpdate();

            con.commit();

            System.out.println(
                    "Transaction Successful"
            );

            con.close();

        }
        catch(Exception e) {

            e.printStackTrace();
        }

    }
}
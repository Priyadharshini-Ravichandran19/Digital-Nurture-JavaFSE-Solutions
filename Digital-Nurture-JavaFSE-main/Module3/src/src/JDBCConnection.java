import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/event_db";

        String user = "root";

        String password = "<Replace with your own db password>";

        try {

            Connection con =
                    DriverManager.getConnection(
                            url,
                            user,
                            password
                    );

            System.out.println(
                    "Connected Successfully!"
            );

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery(
                            "SELECT * FROM students"
                    );

            while(rs.next()) {

                System.out.println(
                        rs.getInt("id")
                                + " "
                                + rs.getString("name")
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
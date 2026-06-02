import java.sql.*;

public class StudentDAO {

    static final String URL =
            "jdbc:mysql://localhost:3306/event_db";

    static final String USER = "root";

    static final String PASSWORD =
            "own password DB";

    public static Connection getConnection()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }

    public static void main(String[] args)
            throws Exception {

        insertStudent(4, "Alex");

        updateStudent(4, "Alex Updated");

        displayStudents();
    }

    static void insertStudent(
            int id,
            String name
    ) throws Exception {

        Connection con =
                getConnection();

        String query =
                "INSERT INTO students VALUES (?, ?)";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, id);

        ps.setString(2, name);

        int rows =
                ps.executeUpdate();

        System.out.println(
                rows + " row inserted"
        );

        con.close();
    }

    static void updateStudent(
            int id,
            String name
    ) throws Exception {

        Connection con =
                getConnection();

        String query =
                "UPDATE students SET name=? WHERE id=?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, name);

        ps.setInt(2, id);

        int rows =
                ps.executeUpdate();

        System.out.println(
                rows + " row updated"
        );

        con.close();
    }

    static void displayStudents()
            throws Exception {

        Connection con =
                getConnection();

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
    }
}
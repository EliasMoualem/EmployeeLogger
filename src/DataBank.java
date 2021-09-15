import java.sql.*;

public class DataBank {

    private final String url = "jdbc:postgresql://localhost:5432/EmployeeLogger";
    private final String user = "postgres";
    private final String password = "dbpassword";

    public DataBank() {
        getRows();
    }

    /**
     * Connect to the PostgreSQL database
     * @return a Connection object
     * @throws java.sql.SQLException
     */

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Get all rows in the RFIDUsers table
     */
    public void getRows() {

        String SQL = "SELECT * FROM \"Employees\"";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
             System.out.println("Opened DB Successfully");
             // display user information
            printColumns(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printColumns(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("UID") + "\t"
                    + rs.getString("Name") + "\t");
        }
    }

    private void printUserName(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("Name") + "\t");
        }
    }

    public void findUserByID(String UID) {
        String SQL = "SELECT \"Name\" FROM \"Employees\" WHERE \"UID\" = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, UID);
            ResultSet rs = pstmt.executeQuery();
            printUserName(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
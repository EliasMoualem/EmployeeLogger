import java.sql.*;

public class DataBank {

    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "germany224";

    public DataBank() {
        getRows();
    }

    /**
     * Connect to the PostgreSQL database
     *
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

        String SQL = "SELECT * FROM \"RFIDUsers\"";

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
                    + rs.getString("UserName") + "\t");

        }
    }

    public void findUserByID(String UID) {
        String SQL = "SELECT RFIDUsers.UserName FROM \"RFIDUsers\" WHERE UID = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, UID);
            ResultSet rs = pstmt.executeQuery();
            printColumns(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
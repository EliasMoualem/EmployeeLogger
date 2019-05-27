import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public DB(){
        try {
            Connection connect = null;
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" ,"postgres","germany224");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened DB Successfully");
    }
}
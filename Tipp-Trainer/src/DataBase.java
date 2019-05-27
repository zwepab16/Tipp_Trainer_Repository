
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for accessing the Database implemented as Singleton
 *
 * @author Zwetti Patrick
 */
public class DataBase {

    /**
     * The one and only instance of the DataBase class.
     */
    private static DataBase theInstance;

    private final Connection conn;

    /**
     * Constructor is private for singleton implementation.
     */
    public DataBase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        conn = DriverManager.getConnection("jdbc:postgresql://localhost/petDB", "postgres", "postgres");
    }

    /**
     * If the instance hasn't been created before, it gets created.
     *
     * @return Returns the DataBase instance.
     */
    public synchronized static DataBase getInstance() throws SQLException {
        if (theInstance == null) {
            theInstance = new DataBase();
        }
        return theInstance;
    }

    public void createTableUsers() throws Exception {
        
        /**
         * User Table gets created
         * Columns: Username, Password, Level
         */
         
        String sql = "CREATE TABLE IF NOT EXISTS Users"
                + "("
                + "    Username character varying NOT NULL PRIMARY KEY,"
                + "    Password character varying,"
                + "    Level integer"
                + ")";

        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);

    }

    public void insertTestData(String username, String pw, int level) throws Exception {
        
        /**
         * Data gets inserted 
         * When sigin
         */
        
        User u = new User(username, pw, level);
        String s = "'" + u.getUsername() + "', '" + pw + "', '" + level + "'";

        String sql = "INSERT INTO Users VALUES(" + s + ");";

        Statement stat = conn.createStatement();
        stat.executeUpdate(sql);
    }

    public boolean checkLogin(User loginuser) throws Exception {
        
        /**
         * User input gets checked in Database
         * @return Returns true when User is saved in Database
         */
                
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM Users";

        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while (rs.next()) {
            User s = new User(rs.getString("Username"),
                    rs.getString("Password"), rs.getInt("Level"));
            users.add(s);

        }
        for (User user : users) {
            if (user.getUsername().equals(loginuser.getUsername())
                    && user.getPassword().equals(loginuser.getPassword())) {

                return true;
            }
        }
        return false;

    }


}

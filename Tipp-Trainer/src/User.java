
public class User {

    private String username;
    private String password;
    private int level;
/**
 * Constructor
 * @param username
 * @param password
 * @param level 
 */
    public User(String username, String password, int level) {
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * To String
     * Only needed to test program
     * @return 
     */
    @Override
    public String toString() {
        return "User{" + "name=" + username + ", password=" + password + '}';
    }

}

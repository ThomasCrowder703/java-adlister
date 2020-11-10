import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;


public class MySQLAdsDao implements Ads {
    private Connection connection = null; //create a connection with the value of null
    private Config config = new Config(); //create an instance of the config class
    private List<Ad> ads; //uninitialized list of type Ad object

    public MySQLAdsDao(){
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection( // connecting to the mysql database
                config.getUrl(), //choosing the database to connect to
                config.getUsername(), //user that will connect to database
                config.getPassword() //password of that user
            );
        }catch (SQLException throwables){
            throwables.printStackTrace(); //catch possible errors
        }
   }

    public List<Ad> all(){
        Statement statement = null; //creating statement will a null value
        List<Ad> ads = new ArrayList<>(); //creating new array list called ads of List<Ad> type object
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from ads"); // unclear
            while (rs.next()){
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    public Long insert(Ad ad){
        String sql = String.format("insert into ads (user_id, title, description)values('%d', '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
           return rs.getLong(1);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return 0L;
    }

}

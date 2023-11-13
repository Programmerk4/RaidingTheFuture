  /*Class: DBconnection
   * Extends - null
   * Purpose - Establishes connection for database
   */

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.SQLException;

  public class DBconnection {
      public static Connection connect() {
          Connection con = null;
          try {
              Class.forName("org.sqlite.JDBC");
              con = DriverManager.getConnection("jdbc:sqlite:RaidingTheFutureDatabase.db"); //connect to database
              System.out.println("Connected!");
          } catch (ClassNotFoundException | SQLException e) {
              //Checks if database is located, If not an error string will be shown, instead of the code crashing
              System.out.println(e + "");
          }
          return con;
      }
  }
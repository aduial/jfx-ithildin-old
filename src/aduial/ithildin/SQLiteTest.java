package aduial.ithildin;

import java.sql.*;

/**
 * Created by luthien on 30/06/2017.
 */
public class SQLiteTest {
    private static Connection con;
    private static boolean hasData = false;

    public ResultSet displayUsers() throws SQLException, ClassNotFoundException {
        if(con == null) {
            // get connection
            getConnection();
        }
        Statement state = con.createStatement();
        ResultSet res = state.executeQuery("select firstname, lastname from user");
        return res;
    }

    private void getConnection() throws ClassNotFoundException, SQLException {
        // sqlite driver
        Class.forName("org.sqlite.JDBC");
        // database path, if it's new database, it will be created in the project folder
        con = DriverManager.getConnection("jdbc:sqlite:db/eldamo.sqlite");
        initialise();
    }

    private void initialise() throws SQLException {
        if( !hasData ) {
            hasData = true;
            // check for database table
            Statement state = con.createStatement();
            ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
            if( !res.next()) {
                System.out.println("Building the User table with prepopulated values.");
                // need to build the table
                Statement state2 = con.createStatement();
                state2.executeUpdate("create table user(id integer,"
                        + "fName varchar(60)," + "lname varchar(60)," + "primary key (id));");

                // inserting some sample data
                PreparedStatement prep = con.prepareStatement("insert into user values(?,?,?);");
                prep.setString(2, "Knerpje");
                prep.setString(3, "Krikjoeck");
                prep.execute();

                PreparedStatement prep2 = con.prepareStatement("insert into user values(?,?,?);");
                prep2.setString(2, "Krentstra");
                prep2.setString(3, "Krajiceck");
                prep2.execute();
            }

        }
    }



}

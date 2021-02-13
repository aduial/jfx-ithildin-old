package aduial.ithildin.util;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.CachedRowSet;
import java.sql.*;

/**
 * Created by luthien on 30/06/2017
 */

public class DBUtil{

    private static final String     JDBC_DRIVER = "org.sqlite.JDBC";
    private static       Connection conn        = null;
    private static final String     connStr     = "jdbc:sqlite:./eldamo.sqlite";

    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC driver registered");

        try {
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.out.println("Connection failed, console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && ! conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement    stmt      = null;
        ResultSet    resultSet = null;
        CachedRowSet crs       = RowSetProvider.newFactory().createCachedRowSet();
        try {
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt      = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs.populate(resultSet);

            //            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("ExecuteQuery method throw exception: " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("ExecuteUpdate method throw exception: " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
}

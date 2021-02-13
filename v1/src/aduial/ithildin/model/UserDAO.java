package aduial.ithildin.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import aduial.ithildin.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by luthien on 02/07/2017.
 */
public class UserDAO{
    public static User searchUser(Integer id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM user WHERE id=" + id.toString();

        try {
            ResultSet rsUser = DBUtil.dbExecuteQuery(selectStmt);
            User      user   = getUserFromResultSet(rsUser);
            return user;
        } catch (SQLException e) {
            System.out.println("While searching an user with " + id + " id, an error occurred: " + e);
            throw e;
        }
    }

    private static User getUserFromResultSet(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
        }
        return user;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<User> searchUsers() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM user";
        try {
            ResultSet            rsUsers  = DBUtil.dbExecuteQuery(selectStmt);
            ObservableList<User> userList = getUserList(rsUsers);
            return userList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    private static ObservableList<User> getUserList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<User> userList = FXCollections.observableArrayList();
        User                 user     = null;
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            userList.add(user);
        }
        return userList;
    }

    //*************************************
    //UPDATE an user's first name
    //*************************************
    public static void updateFirstname(Integer id, String firstname) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE user SET firstname = '" + firstname + "' WHERE id = " + id.toString() + ";";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //DELETE a user
    //*************************************
    public static void deleteUserWithId(Integer userId) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM user WHERE id =" + userId.toString() + ";\n COMMIT;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT a user
    //*************************************
    public static void insertUser(String firstName, String lastName) throws SQLException, ClassNotFoundException {
        String updateStmt = "INSERT INTO user (firstname, lastname) VALUES ('" + firstName + "', '" + lastName + "');";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}


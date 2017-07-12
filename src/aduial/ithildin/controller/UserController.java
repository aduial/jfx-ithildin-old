/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tuserlate file, choose Tools | Tuserlates
 * and open the tuserlate in the editor.
 */
package aduial.ithildin.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import aduial.ithildin.model.User;
import aduial.ithildin.model.UserDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author luthien
 */
public class UserController {

    @FXML
    private TextField idText;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextField newFirstnameText;
    @FXML
    private TextField firstnameText;
    @FXML
    private TextField lastnameText;
    @FXML
    private TableView userTable;
    @FXML
    private TableColumn<User, Integer>  idColumn;
    @FXML
    private TableColumn<User, String>  firstnameColumn;
    @FXML
    private TableColumn<User, String> lastnameColumn;

    //For MultiThreading
    private Executor exec;

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.

    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the User objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe
        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        firstnameColumn.setCellValueFactory(cellData -> cellData.getValue().firstnameProperty());
        lastnameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
    }


    //Search an user
    @FXML
    private void searchUser (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get User information
            User user = UserDAO.searchUser(Integer.parseInt(idText.getText()));
            //Populate User on TableView and Display on TextArea
            populateAndShowUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error occurred while getting user information from DB.\n" + e);
            throw e;
        }
    }

    //Search all users
    @FXML
    private void searchUsers(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Users information
            ObservableList<User> userData = UserDAO.searchUsers();
            //Populate Users on TableView
            populateUsers(userData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting users information from DB.\n" + e);
            throw e;
        }
    }

    //Populate Users for TableView with MultiThreading (This is for example usage)
    private void fillUserTable(ActionEvent event) throws SQLException, ClassNotFoundException {
        Task<List<User>> task = new Task<List<User>>(){
            @Override
            public ObservableList<User> call() throws Exception{
                return UserDAO.searchUsers();
            }
        };

        task.setOnFailed(e-> task.getException().printStackTrace());
        task.setOnSucceeded(e-> userTable.setItems((ObservableList<User>) task.getValue()));
        exec.execute(task);
    }

    //Populate User
    @FXML
    private void populateUser (User user) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<User> userData = FXCollections.observableArrayList();
        //Add user to the ObservableList
        userData.add(user);
        //Set items to the userTable
        userTable.setItems(userData);
    }

    //Set User information to Text Area
    @FXML
    private void setUserInfoToTextArea ( User user) {
        resultArea.setText("First Name: " + user.getFirstname() + "\n" +
                "Last Name: " + user.getLastname());
    }

    @FXML
    private void populateAndShowUser(User user) throws ClassNotFoundException {
        if (user != null) {
            populateUser(user);
            setUserInfoToTextArea(user);
        } else {
            resultArea.setText("This user does not exist!\n");
        }
    }

    @FXML
    private void populateUsers (ObservableList<User> userData) throws ClassNotFoundException {
        //Set items to the userTable
        userTable.setItems(userData);
    }

    @FXML
    private void updateFirstname (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            UserDAO.updateFirstname(Integer.parseInt(idText.getText()), newFirstnameText.getText());
            resultArea.setText("Name has been updated for user id: " + idText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating name: " + e);
        }
    }
    
    @FXML
    private void insertUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            UserDAO.insertUser(firstnameText.getText(),lastnameText.getText());
            resultArea.setText("User inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting user " + e);
            throw e;
        }
    }

    @FXML
    private void deleteUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            UserDAO.deleteUserWithId(Integer.parseInt(idText.getText()));
            resultArea.setText("User deleted! User id: " + idText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while deleting user " + e);
            throw e;
        }
    }
}

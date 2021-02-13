package aduial.ithildin.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import aduial.ithildin.Main;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

/**
 * Created by luthien on 02/07/2017.
 */
public class RootLayoutController{

    @FXML private MenuItem searchMenuItem;

    @FXML private MenuItem editMenuItem;


    //Reference to the main application
    private Main main;
    //Is called by the main application to give a reference back to itself.

    public void setMain(Main main) {
        this.main = main;
    }

    //Exit the program
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void handleEditAction(ActionEvent event) {
        main.swapViews();
        editMenuItem.setDisable(true);
        searchMenuItem.setDisable(false);
    }

    @FXML
    public void handleSearchAction(ActionEvent event) {
        main.swapViews();
        editMenuItem.setDisable(false);
        searchMenuItem.setDisable(true);
    }

    //Help Menu button behavior
    public void handleHelp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kwakkojakko");
        alert.setHeaderText("Gnuif gnuif harf harf harfharfharf");
        alert.setContentText("You can search, delete, update, insert a new user with this tweezer.");
        alert.show();
    }
}

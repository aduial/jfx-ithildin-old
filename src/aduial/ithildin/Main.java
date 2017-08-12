package aduial.ithildin;

import aduial.ithildin.controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;
  private StackPane stackPane;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;

    //Optional: Set a title for primary stage
    this.primaryStage.setTitle("Eldamo Ithildin");

    initRootLayout();
//    initSimplexiconView();
  }

  public void initRootLayout() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
      rootLayout = (BorderPane) loader.load();
      
      this.stackPane = (StackPane) rootLayout.getCenter();
      Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
      primaryStage.setScene(scene); //Set the scene in primary stage.

      //Give the controller access to the main.
      RootLayoutController controller = loader.getController();
      controller.setMain(this);
      primaryStage.show(); //Display the primary stage
      
      initEditView();
      initSearchView();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Shows the edit view inside the root layout.
  public void initEditView() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/EditView.fxml"));
      VBox editView = (VBox) loader.load();
      stackPane.getChildren().add(editView);
//      for (Node node: stackPane.getChildren()){
//        node.setVisible(false);
//      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Shows the search view inside the root layout.
  public void initSearchView() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/SearchView.fxml"));
      VBox searchView = (VBox) loader.load();
      stackPane.getChildren().add(searchView);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void swapViews(){
    ObservableList<Node> nodes = this.stackPane.getChildren();
    nodes.get(nodes.size()-2).toFront();
  }

  //Shows the simplexicon view inside the root layout.
  public void initSimplexiconView() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/SimplexiconView.fxml"));
      AnchorPane simplexiconQueryView = (AnchorPane) loader.load();

      rootLayout.setCenter(simplexiconQueryView);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

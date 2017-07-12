package aduial.ithildin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

  private Stage primaryStage;
  private BorderPane rootLayout;

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;

    //Optional: Set a title for primary stage
    this.primaryStage.setTitle("Eldamo Ithildin");

    initRootLayout();
    showSimplexiconView();
  }

  public void initRootLayout() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
      rootLayout = (BorderPane) loader.load();

      Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
      primaryStage.setScene(scene); //Set the scene in primary stage.

      /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/
      primaryStage.show(); //Display the primary stage
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Shows the simplexicon view inside the root layout.
  public void showSimplexiconView() {
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

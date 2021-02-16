package aduial.ithildin.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;


/**
 * DialogController.
 *
 * @author Luthien
 * @noinspection WeakerAccess
 */
@Component  // equal to: @FxmlView("Athrabeth.fxml")
@FxmlView
public class Athrabeth {

    private Stage stage;

    @FXML
    private Button closeButton;
    @FXML
    private VBox dialog;

    @FXML
    public void initialize() {
        this.stage = new Stage();
        stage.setScene(new Scene(dialog));

        closeButton.setOnAction(
                actionEvent -> stage.close()
                               );
    }

    public void show() {
        stage.show();
    }

}

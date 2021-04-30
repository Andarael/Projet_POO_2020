package view.ui;

import controller.ExecutionController;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.stage.HelpGameScreen;

import java.util.List;

public class TopButtonsController extends AbstractController {
    @FXML public Button lookPlaceButtonButton;
    @FXML public Button lootPlaceButton;
    @FXML public Button quitButton;
    @FXML public Button resetButton;

    @Override
    public void initThis() {
    }

    @Override
    public void updateThis() {
    }

    @Override
    public List<AbstractController> getChildrenControllers() {
        return null;
    }

    @FXML
    public void lookPlaceAction(ActionEvent actionEvent) {
        ExecutionController.executeLookForPlace();
    }

    @FXML
    public void lootPlaceAction(ActionEvent actionEvent) {
        MainController.lootPlace();
    }

    @FXML
    public void quitAction(ActionEvent actionEvent) {
        ExecutionController.quitGame();
    }

    @FXML
    public void helpAction(ActionEvent actionEvent) {

        HelpGameScreen helpGameScreen = new HelpGameScreen();
        helpGameScreen.show();

    }
}

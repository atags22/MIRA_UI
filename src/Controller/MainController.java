package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;

import java.io.IOException;

public class MainController {

    @FXML AnchorPane anchorViz;

//    public MainController() {
//
//    }

    public AnchorPane getAnchorViz() {
        return anchorViz;
    }
}


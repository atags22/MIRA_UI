package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import util.MagicNumbers;

import java.io.IOException;

public class MainController {

    @FXML AnchorPane anchorViz;

    @FXML Slider jointCtrl1;
    @FXML Slider jointCtrl2;
    @FXML Slider jointCtrl3;

    @FXML Slider jointCtrl4;
    @FXML Slider jointCtrl5;
    @FXML Slider jointCtrl6;


    @FXML Label jointVal1;
    @FXML Label jointVal2;
    @FXML Label jointVal3;

    @FXML Label jointVal4;
    @FXML Label jointVal5;
    @FXML Label jointVal6;
//    public MainController() {
//
//    }

    public void initialize(){
        jointCtrl1.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider1(newValue.doubleValue());
        });

        jointCtrl2.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider2(newValue.doubleValue());
        });

        jointCtrl3.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider3(newValue.doubleValue());
        });

        jointCtrl4.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider4(newValue.doubleValue());
        });

        jointCtrl5.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider5(newValue.doubleValue());
        });

        jointCtrl6.valueProperty().addListener((obs, oldValue, newValue) -> {
            slider6(newValue.doubleValue());
        });

    }
    public AnchorPane getAnchorViz() {

        return anchorViz;
    }

    public void slider1(double newValue){
        jointVal1.setText(String.format("%.2f",newValue* MagicNumbers.HUNDRED_TO_360));
    }
    public void slider2(double newValue){
        jointVal2.setText(String.format("%.2f",newValue*MagicNumbers.HUNDRED_TO_360));
    }
    public void slider3(double newValue){
        jointVal3.setText(String.format("%.2f",newValue*MagicNumbers.HUNDRED_TO_360));
    }
    public void slider4(double newValue){
        jointVal4.setText(String.format("%.2f",newValue*MagicNumbers.HUNDRED_TO_360));
    }
    public void slider5(double newValue){
        jointVal5.setText(String.format("%.2f",newValue*MagicNumbers.HUNDRED_TO_360));
    }
    public void slider6(double newValue){
        jointVal6.setText(String.format("%.2f",newValue*MagicNumbers.HUNDRED_TO_360));
    }

}


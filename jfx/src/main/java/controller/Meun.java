package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Meun {
    public void item021Clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/zhuce.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item021Click(MouseEvent mouseEvent) {
    }
}

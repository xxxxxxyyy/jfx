package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class leftmeun {

    public void item01Clicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/hello-view.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),320,240);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }//弹窗

   /*public void item02Clicked(MouseEvent mouseEvent) throws IOException {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/dangl.fxml"));
            Pane cmdPane=(Pane) fxmlLoader.load();
            mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
            mainController.mainpane.setCenter(cmdPane);
    }//整个界面

    */

    public void item021Clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/zhuce.fxml" ));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }//整个界面

    public void item002Clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/dangl.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item022Clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/glymsg.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
      /*  Scene scene=new Scene(fxmlLoader.load(),1000,800);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();*/
    }
}

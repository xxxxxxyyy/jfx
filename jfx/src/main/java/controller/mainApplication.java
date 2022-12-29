package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class mainApplication extends Application implements Initializable{

    public BorderPane mainpane;

    @Override

   public void start(Stage stage) throws IOException {
       FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("/com/example/jfx/view/fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
    public Label sysexit;
    public void exitsys(MouseEvent mouseEvent) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText("你确定要退出吗？");
        Optional<ButtonType> result=a.showAndWait();
        if(result.get()==ButtonType.OK){
            Stage st=(Stage) sysexit.getScene().getWindow();
            st.close();
        }
    }

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerManger.controllerMap.put("mainController",this);
    }

    public void Click04(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/dangl.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }
}
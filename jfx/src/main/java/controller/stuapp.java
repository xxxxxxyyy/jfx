package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class stuapp extends Application implements Initializable {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(stuapp.class.getResource("/com/example/jfx/view/fxml/studentMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello123");
        stage.setScene(scene);
       // stage.setMaximized(true);
       // stage.initStyle(StageStyle.TRANSPARENT);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerManger.controllerMap.put("stuController",this);
    }
}

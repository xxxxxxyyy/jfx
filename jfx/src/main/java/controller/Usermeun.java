package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Usermeun {
    public void Click01(MouseEvent mouseEvent) throws IOException {//选择床位
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/uRoomMeun.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);

    }

    public void Click02(MouseEvent mouseEvent) throws IOException {//宿舍报修
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/baoxiu.fxml"));
       /* Scene scene=new Scene(fxmlLoader.load(),600,600);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

        */
        Scene scene=new Scene(fxmlLoader.load(),600,500);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/picture/添加.png"))));
        stage.setTitle("报修");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }

    public void Click03(MouseEvent mouseEvent) throws IOException {//个人信息查看/修改
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/usermsg1.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void Click04(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/dangl.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }
}

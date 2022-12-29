package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Glymeun {


    public HBox gl;

    public void item01Clicked(MouseEvent mouseEvent) throws IOException {//学生管理
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/studentMain.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item02Clicked(MouseEvent mouseEvent) throws IOException {//数据统计
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/tj.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item04Clicked(MouseEvent mouseEvent) throws IOException {//个人信息查看
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/glymsg.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item03Clicked(MouseEvent mouseEvent) throws IOException {//报修查看
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/RoomMeun.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    public void item05Clicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/addmanger.fxml"));
        Pane cmdPane=(Pane) fxmlLoader.load();
        mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
        mainController.mainpane.setCenter(cmdPane);
    }

    /*public void Click05(MouseEvent mouseEvent) throws IOException {


    }

     */
}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.Room;
import pojo.student;
import pojo.studentSevers;
import pojo.userSevers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class glymsg implements Initializable {
    public TextField id;
    public Button cx;
    public Label err;
    public boolean isadd=true;
    userSevers s=new userSevers();
    studentSevers ss=new studentSevers();
    String sid;
    public void cxok(ActionEvent actionEvent) throws IOException {

        sid=id.getText();
        if (isadd) {
            String i = id.getText();
            if (ss.findBystuno(i)!=null) {
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/msgck.fxml"));
                Scene scene=new Scene(fxmlLoader.load(),580,670);
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } else {
                err.setText("系统中没有该人！查询失败！");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerManger.controllerMap.put("glymsgController",this);
    }
}

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.Room;
import pojo.roomSevers;
import pojo.studentSevers;

import java.io.IOException;
import java.sql.SQLException;

public class Baoxiu {
    public TextField txtroom;
    public TextField txtbx;
    public Label baoxmsg;
    public Label roommsg;
    public Label bxcg;
    boolean isadd = true;
    roomSevers rs = new roomSevers();
    studentSevers service = new studentSevers();

    public void bxok(MouseEvent actionEvent) throws SQLException, IOException {

      /*  if (isadd) {
            String roomid = txtroom.getText();
           // String msg = txtbx.getText();
            if (rs.pd(roomid) == true) {
                Room r = rs.findbyrid(roomid);
               // rs.updateroom(r, msg);//还没写
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
               // Stage stage = (Stage) txtroom.getScene().getWindow();
                //stage.close();
                //RoomMeun sc=(RoomMeun) ControllerManger.controllerMap.get("roomController");
                //sc
                RoomMeun rm = new RoomMeun();
                rm.initTable(rs.getRlist());
            } else {
                roommsg.setText("宿舍不存在！无法报修！");
            }

       */
        if (isadd) {
            String roomid = txtroom.getText();
            String ms = txtbx.getText();
            if (rs.pd(roomid) == true) {
                Room r = rs.findbyrid(roomid);
                rs.updateroom(r, ms);//还没写
                Stage stage=(Stage) txtroom.getScene().getWindow();
                stage.close();
                RoomMeun sc=(RoomMeun) ControllerManger.controllerMap.get("stuController");
                sc.initTable(rs.getRlist());
            } else {
                roommsg.setText("宿舍不存在！无法报修！");
            }

        }
    }

    public void qr(ActionEvent actionEvent) {
    }
}



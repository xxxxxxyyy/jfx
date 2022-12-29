package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.Room;
import pojo.roomSevers;
import pojo.student;
import pojo.studentSevers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Baoxadd  implements Initializable {
    public  boolean isadd=true;
    public Label roommsg;
    public Button qr;
    public Label bxmsg;
    public TextField id;
    public TextField msg;
    Room r=new Room();
    roomSevers rs = new roomSevers();
    studentSevers service = new studentSevers();
    public void addbx(ActionEvent actionEvent) throws SQLException {


        if (isadd) {
            String roomid = id.getText();
            String ms = msg.getText();
            if (rs.pd(roomid) == true) {
                Room r = rs.findbyrid(roomid);
                rs.updateroom(r, ms);//还没写
                Stage stage=(Stage) id.getScene().getWindow();
                stage.close();
                RoomMeun sc=(RoomMeun) ControllerManger.controllerMap.get("stuController");
                sc.initTable(rs.getRlist());
            } else {
                roommsg.setText("宿舍不存在！无法报修！");
            }
    }
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoomMeun sc=(RoomMeun) ControllerManger.controllerMap.get("roomController");
        Room seletSutdent=sc.r;
        id.setText(seletSutdent.getRoomid());
        msg.setText(seletSutdent.getBmsg());
    }
}

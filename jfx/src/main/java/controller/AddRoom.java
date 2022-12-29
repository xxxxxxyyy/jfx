package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.Room;
import pojo.roomSevers;
import pojo.student;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddRoom implements Initializable {

    public TextField txtrwz;
    public Label msgid;
    public TextField txtroomid;
    public Button tj;
    public  boolean isadd=true;
    roomSevers rs=new roomSevers();
    public void tjok(ActionEvent actionEvent) throws SQLException {
        if(isadd){
            String s=txtroomid.getText();
            String n=txtrwz.getText();
            if(!rs.pd(s)){
                   // student stu=new student(s,n,sex,room,Integer.parseInt(age),bed);
                    Room r=new Room(s,0,n,"","123456");
                    rs.addRoom(r);//还没写
                    Stage stage=(Stage) txtroomid.getScene().getWindow();
                    stage.close();
                    RoomMeun sc=(RoomMeun) ControllerManger.controllerMap.get("roomController");
                    sc.initTable(rs.getRlist());
            }
            else {
                msgid.setText("宿舍已经存在！添加失败！");
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //宿舍号文本框失去焦点事件
        txtroomid.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String stuno=txtroomid.getText();
                    if(stuno.length()==0){
                        msgid.setText("宿舍号不能为空！");
                        txtroomid.requestFocus();
                        isadd=false;
                    }else if(rs.findbyrid(stuno)!=null){
                        msgid.setText("宿舍已经存在！");
                        txtroomid.requestFocus();
                        isadd=false;
                    }else {
                        msgid.setText("");
                        isadd=true;
                    }
                }
            }
        });
    }
}

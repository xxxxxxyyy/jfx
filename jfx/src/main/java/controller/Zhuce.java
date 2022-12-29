package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pojo.Room;
import pojo.studentSevers;
import pojo.user;
import pojo.userSevers;

import java.io.IOException;
import java.sql.SQLException;

public class Zhuce {
    public TextField zname;
    public TextField zpassword;
    public Label msgzh;
    public boolean isadd=true;
    userSevers us=new userSevers();
    studentSevers ss=new studentSevers();
    public void zc(ActionEvent actionEvent) throws SQLException, IOException {

        if(isadd){
            String name=zname.getText();
            String p=zpassword.getText();
            if(!us.pd(name)){
                if(ss.findBystuno(name)!=null){
                    user u=new user(name,p);
                    us.addUser(u);//还没写
                    us.getUsers();
                    msgzh.setText("注册成功，请切换登录");
                    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/jfx/view/fxml/leftmeun.fxml"));
                    Pane cmdPane=(Pane) fxmlLoader.load();
                    mainApplication mainController=(mainApplication) ControllerManger.controllerMap.get("mainController");
                    mainController.mainpane.setCenter(cmdPane);
                }else {
                    msgzh.setText("该学号在系统中不存在！注册失败！");
                }


            }
            else {
                msgzh.setText("账号已经被注册！注册失败！");
            }

    }
    }
}

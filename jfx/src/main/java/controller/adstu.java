package controller;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.roomSevers;
import pojo.student;
import pojo.studentSevers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adstu implements Initializable  {
    public Button addOk;
    public TextField txtStuno;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtBed;
    public TextField txtSex;
    public TextField txtRoom;
    public Label msgStuno;
    public Label msgName;
    public Label msgAge;
    public Label msgSex;
    public Label msgBed;
    public Label msgRoom;

    roomSevers rs=new roomSevers();
    public  boolean isadd=true;
    studentSevers service=new studentSevers();
    public void btnOK(ActionEvent actionEvent) throws SQLException {//确认添加按钮
        if(isadd){
            String s=txtStuno.getText();
            String n=txtName.getText();
            String age = txtAge.getText();
            String sex=txtSex.getText();
            String room=txtRoom.getText();
            String bed=txtBed.getText();
            if(rs.pd(room)==true&&rs.findbyrid(room).getRs()<6){
                if(rs.findbyrid(room).getKw().contains(bed)){
                    student stu=new student(s,n,sex,room,Integer.parseInt(age),bed);
                    service.updateStudent(s,stu);//还没写
                    Stage stage=(Stage) txtStuno.getScene().getWindow();
                    stage.close();
                    StudentMain sc=(StudentMain) ControllerManger.controllerMap.get("stuController");
                    sc.initTable(service.getStudentArrayList());
                }else {
                    msgRoom.setText("床位已经有人！添加失败！");
                }
            }
            else {
                msgRoom.setText("宿舍人数已经达到上限或者宿舍不存在！添加失败！");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //学号文本框失去焦点事件
        txtStuno.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String stuno=txtStuno.getText();
                    if(stuno.length()==0){
                        msgStuno.setText("学号不能为空！");
                        txtStuno.requestFocus();
                        isadd=false;
                    }else if(service.findBystuno(stuno)!=null&&service.findBystuno(stuno).getRoom().length()!=0){
                        msgStuno.setText("该用户已经选择过宿舍！");
                        txtStuno.requestFocus();
                        isadd=false;
                    }else {
                        msgStuno.setText("");
                        isadd=true;
                    }
                }
            }
        });
        txtSex.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String sex=txtSex.getText();
                    if(sex.length()==0){
                        msgSex.setText("性别不能为空！");
                        txtSex.requestFocus();
                        isadd=false;
                    }else if(sex.equals("男")==false&&sex.equals("女")==false&&sex.equals("男生")==false&&sex.equals("女生")==false){
                        msgSex.setText("请正确输入性别！");
                        txtSex.requestFocus();
                        isadd=false;
                    }else {
                        msgStuno.setText("");
                        isadd=true;
                    }
                }
            }
        });
        txtName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String name=txtName.getText();
                    if(name.length()==0){
                        msgName.setText("姓名不能为空！");
                        txtName.requestFocus();
                        isadd=false;
                    }else {
                        msgName.setText("");
                        isadd=true;
                    }
                }
            }
        });  txtBed.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String name=txtBed.getText();
                    if(name.length()==0){
                        msgBed.setText("床位不能为空！");
                        txtBed.requestFocus();
                        isadd=false;
                    }else if(name.length()!=1&& !"123456".contains(name)){
                        msgBed.setText("请输入正确的空床位！");
                        txtBed.requestFocus();
                        isadd=false;
                    }else {
                        msgBed.setText("");
                        isadd=true;
                    }
                }
            }
        });
    }
}

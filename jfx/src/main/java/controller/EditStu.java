package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pojo.roomSevers;
import pojo.student;
import pojo.studentSevers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditStu implements Initializable {


    public TextField txtStuno;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtBed;
    public TextField txtSex;
    public TextField txtRoom;
    public Label msgStuno;
    public Label msgName;
    public Label msgAge;
    public Label msgBed;
    public Label msgSex;
    public Label msgRoom;
    public Button edit;
    studentSevers ss=new studentSevers();
    public boolean isedit=true;
    roomSevers rs=new roomSevers();
    studentSevers service=new studentSevers();
    public void btnedit(ActionEvent actionEvent) throws IOException, SQLException {
      if(isedit){
            String s=txtStuno.getText();
            String n=txtName.getText();
            int age = Integer.parseInt(txtAge.getText());
            String sex=txtSex.getText();
            String room=txtRoom.getText();
            String bed=txtBed.getText();
            student w=new studentSevers().findBystuno(s);
            student stu1=new student(s,n,sex,room,age,bed);
            if(w.getRoom().equals(room)&&w.getBed().equals(bed)){
                service.updateStudent(s,stu1);//还没写
                Stage stage=(Stage) txtStuno.getScene().getWindow();
                stage.close();
                StudentMain sc=(StudentMain) ControllerManger.controllerMap.get("stuController");
                sc.initTable(service.getStudentArrayList());
            }else {
                if(rs.pd(room)==true&&rs.findbyrid(room).getRs()<6){
                if(rs.findbyrid(room).getKw().contains(bed)){
                    service.updateStudent(s,stu1);//还没写
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
            }}
        }

    }
    boolean isadd=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentMain sc=(StudentMain) ControllerManger.controllerMap.get("stuController");
        student seletSutdent=sc.stu;
        txtStuno.setText(seletSutdent.getStuno());
        txtName.setText(seletSutdent.getName());
        txtSex.setText(seletSutdent.getSex());
        txtRoom.setText(seletSutdent.getRoom());
        txtBed.setText(seletSutdent.getBed());
        txtAge.setText(String.valueOf(seletSutdent.getAge()));

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
        });
    }
}

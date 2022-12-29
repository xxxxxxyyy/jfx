package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojo.roomSevers;
import pojo.student;
import pojo.studentSevers;

import java.sql.SQLException;

public class xzRoom {
    public  boolean isadd=true;
    public TextField txtroomStuno;
    public TextField txtxh;
    public TextField txtname;
    public TextField txtStuno;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtSex;
    public TextField txtRoom;
    public Label msgRoom1;
    studentSevers severs=new studentSevers();
   roomSevers rs=new roomSevers();
    public void btnOK(ActionEvent actionEvent) throws SQLException {
        if(isadd){
            String s=txtStuno.getText();
            String n=txtName.getText();
            String age = txtAge.getText();
            String sex=txtSex.getText();
            String room=txtRoom.getText();
            if(rs.findbyrid(room).getRs()<6){
            student stu=new student(s,n,sex,room,Integer.parseInt(age));
            severs.addStudent(stu);//还没写
            Stage stage=(Stage) txtStuno.getScene().getWindow();
            stage.close();
            StudentMain sc=(StudentMain) ControllerManger.controllerMap.get("stuController");
            sc.initTable(severs.getStudentArrayList());
                }
            else{
                msgRoom1.setText("宿舍人数已经达到上限！添加失败！");
            }
       }
    }
}

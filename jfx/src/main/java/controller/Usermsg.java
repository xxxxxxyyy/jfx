package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pojo.student;
import pojo.studentSevers;
import pojo.user;
import pojo.userSevers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Usermsg implements Initializable {
    public TextField txtsid;
    public TextField txtpassword;
    public TextField txtname;
    public Label errpassword;
    public TextField txtsex;
    public TextField txtage;
    public TextField txtdh;
    public TextField txtrid;
    public TextField txtbed;
    public Label errmsg;
    public Label errdh;
    public Label errage;
    public Label errsex;
    public Label errname;
    studentSevers ss=new studentSevers();
    userSevers us=new userSevers();
    public boolean isadd=true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dangl sc=(dangl) ControllerManger.controllerMap.get("stunomsgController");
        String sid=sc.stuno;
        String password=sc.mima;
        txtsid.setText(sid);
        txtpassword.setText(password);
       /* student s1=new student(sid,"","","",0,"");
        try {
            ss.addStudent(s1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        student stu=ss.findBystuno(sid);
        user u=us.findByusername(sid);

        txtname.setText(stu.getName());
        txtage.setText(String.valueOf(stu.getAge()));
        txtsex.setText(stu.getSex());
        txtdh.setText(u.getZhuz());
        txtrid.setText(stu.getRoom());
        txtbed.setText(stu.getBed());
        txtname.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String stuno=txtname.getText();

                    if(stuno.length()==0){
                        errname.setText("?????????????????????");
                        txtname.requestFocus();
                        isadd=false;
                    }else {
                        errname.setText("");
                        isadd=true;
                    }
                }
            }
        });
        txtsex.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String sex=txtsex.getText();
                    if(sex.length()==0){
                        errsex.setText("?????????????????????");
                        txtsex.requestFocus();
                        isadd=false;
                    }else if(sex.equals("???")==false&&sex.equals("???")==false&&sex.equals("??????")==false&&sex.equals("??????")==false){
                        errsex.setText("????????????????????????");
                        txtsex.requestFocus();
                        isadd=false;
                    }else {
                        errsex.setText("");
                        isadd=true;
                    }
                }
            }
        });
        txtage.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String name=txtage.getText();
                    if(name.length()==0){
                        errage.setText("?????????????????????");
                        txtage.requestFocus();
                        isadd=false;
                    }else {
                        errage.setText("");
                        isadd=true;
                    }
                }
            }
        });
        txtdh.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String name=txtdh.getText();
                    if(name.length()==0){
                        errdh.setText("?????????????????????");
                        txtdh.requestFocus();
                        isadd=false;
                    }else if(name.length()!=11){
                        errdh.setText("????????????????????????");
                        txtdh.requestFocus();
                        isadd=false;
                    }else {
                        errdh.setText("");
                        isadd=true;
                    }
                }
            }
        });txtpassword.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(oldValue&&!newValue){
                    String name=txtpassword.getText();
                    if(name.length()==0){
                        errpassword.setText("?????????????????????");
                        txtpassword.requestFocus();
                        isadd=false;
                    }else if(name.length()!=6){
                        errpassword.setText("????????????????????????");
                        txtpassword.requestFocus();
                        isadd=false;
                    }else {
                        errpassword.setText("");
                        isadd=true;
                    }
                }
            }
        });

   }

    public void qrxg(ActionEvent actionEvent) throws SQLException {
        String stuno=txtsid.getText();
        String pass=txtpassword.getText();
        String name= txtname.getText();
        int age= Integer.parseInt(txtage.getText());
        String a=txtage.getText();
        String sex=txtsex.getText();
        String dh=txtdh.getText();
        String room=txtrid.getText();
        String bed=txtbed.getText();
        if(name.length()==0&&a.length()==0&&sex.length()==0&&dh.length()==0) {
            errmsg.setText("?????????????????????");
        }
        else
        {
            student s=new student(stuno,name,sex,room,age,bed);
            user u=new user(stuno,pass,dh);
            ss.updateStudent(stuno,s);
            us.updateUser(stuno,u);
            errmsg.setText("????????????");
        }
    }
}

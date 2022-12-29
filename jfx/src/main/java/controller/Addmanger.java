package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Set;

public class Addmanger {
    public TextField txtstuno;
    public TextField txtpassword;
    public Label errstuno;
    public Label errpassword;

    public void addmanger(ActionEvent actionEvent) throws IOException {
        String zh=txtstuno.getText();
        String mima=txtpassword.getText();
        if(zh.length()==7&&mima.length()==6){
        StringBuilder sb=new StringBuilder();
        File f=new File("d:"+File.separator+"用户账号密码.txt");
         OutputStream out=new FileOutputStream(f,true);
            sb.append("\r\n");
            sb.append(zh);
            sb.append("：");
            sb.append(mima);
            byte b[]=sb.toString().getBytes();
        out.write(b);
        out.close();
            errpassword.setText("添加成功");
        }
        else {
            errpassword.setText("账号或者密码格式不正确，添加失败！");
        }
    }
}

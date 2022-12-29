package com.example.jfx;

import javafx.fxml.Initializable;
import pojo.student;
import pojo.studentSevers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class erw implements Initializable {
    public static void main(String[] args) throws SQLException {
        studentSevers service=new studentSevers();
        for (int i = 2021130,n=130; i <=2021300 ; i++) {
            String s= String.valueOf(i);
            String d= String.valueOf(n);
            String name="学生"+d;
            int age = 18;
            String sex="男";
            String room="空";
            String bed="空";
            student stu=new student(s,name,sex,room,age,bed);
            service.addStudent(stu);//还没写
        }

       /* final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        if(conn==null){
            System.out.println("失败");
        } //保存连接对象
        else {
            System.out.println("成功连接");
            Statement statement=conn.createStatement();

        */
       /* String name="'"+stu.getName()+"'";
        String id="'"+stu.getStuno()+"'";
        String age= String.valueOf(stu.getAge());
        String sex="'"+stu.getSex()+"'";
        String room="'"+stu.getRoom()+"'";

        */

           /* String a="'"+"a"+"'";
            String b="'"+"b"+"'";
            String c="'"+"c"+"'";
            String sql="INSERT INTO student VALUES ("+a+","+b+","+c+") ;update room set rs= 3 where rid= '10-2-1'"; //"+id+","+name+","+age+","+sex+","+room;
            if(statement.executeUpdate(sql)>1){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
            conn.close();*/
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    //studentArrayList.add(stu);
    }


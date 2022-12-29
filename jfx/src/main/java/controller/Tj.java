package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
//import lombok.SneakyThrows;
import pojo.Room;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Tj implements Initializable {
    public TextField txtp;
    public TextField txtroom;
    public TextField txtbed;
    public TextField txtkw;
    public TextField txtxtp;
    public TextField txtboyp;
    public TextField txtgril;

    public int mysqlConnects() throws ClassNotFoundException, SQLException {//返回统计的房间数量
        //基本配置信息
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = null; //保存连接对象
//1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//2.连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        //3.向数据库发送SQL的对象statement:CRUD
        Statement statement = conn.createStatement();
        //4.编写sql
        String sql = "select * from room";
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet res = statement.executeQuery(sql);
        int i=0;
        while (res.next()) {//循环输入对象，必须要在循环内 new
          i++;
        }

//6.关闭连接释放资源（一定要做），先开后关
        res.close();
        statement.close();
        conn.close();
        return i;
    }
    public int mysqlConnects2() throws ClassNotFoundException, SQLException {//返回统计的已经选择房间的人的数量
        //基本配置信息
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = null; //保存连接对象
//1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//2.连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        //3.向数据库发送SQL的对象statement:CRUD
        Statement statement = conn.createStatement();
        //4.编写sql
        String sql = "select * from sturoom where room is not null ";
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet res = statement.executeQuery(sql);
        int i=0;
        while (res.next()) {//循环输入对象，必须要在循环内 new
            i++;
        }

//6.关闭连接释放资源（一定要做），先开后关
        res.close();
        statement.close();
        conn.close();
        return i;
    }
    public int mysqlConnects3() throws ClassNotFoundException, SQLException {//返回统计的系统中人的数量
        //基本配置信息
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = null; //保存连接对象
//1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//2.连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        //3.向数据库发送SQL的对象statement:CRUD
        Statement statement = conn.createStatement();
        //4.编写sql
        String sql = "select * from sturoom";
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet res = statement.executeQuery(sql);
        int i=0;
        while (res.next()) {//循环输入对象，必须要在循环内 new
            i++;
        }

//6.关闭连接释放资源（一定要做），先开后关
        res.close();
        statement.close();
        conn.close();
        return i;
    }
    public int mysqlConnects4() throws ClassNotFoundException, SQLException {//返回统计的男生的数量
        //基本配置信息
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = null; //保存连接对象
//1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//2.连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
        //3.向数据库发送SQL的对象statement:CRUD
        Statement statement = conn.createStatement();
        //4.编写sql
        String sql = "select * from sturoom where sex in ('男')";
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet res = statement.executeQuery(sql);
        int i=0;
        while (res.next()) {//循环输入对象，必须要在循环内 new
            i++;
        }

//6.关闭连接释放资源（一定要做），先开后关
        res.close();
        statement.close();
        conn.close();
        return i;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String i = String.valueOf(mysqlConnects());
            String i2 = String.valueOf(mysqlConnects()*6);
            String i3 = String.valueOf(mysqlConnects2());//选择了的人
            String i5 = String.valueOf(mysqlConnects3());//系统人数
            String i4 = String.valueOf(mysqlConnects()*6-mysqlConnects2());//空床位
            String i6 = String.valueOf(mysqlConnects4());//男生
            String i7 = String.valueOf(mysqlConnects3()-mysqlConnects4());//女生
            txtkw.setText(i4);
            txtbed.setText(i2);
            txtroom.setText(i);
            txtp.setText(i3);
            txtxtp.setText(i5);
            txtboyp.setText(i6);
            txtgril.setText(i7);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

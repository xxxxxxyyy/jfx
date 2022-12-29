package connect;

import pojo.student;
import pojo.user;

import java.sql.*;
import java.util.ArrayList;

public class Stuconnect {
    public static ArrayList<student> stus =new ArrayList<>();
    public  ArrayList<student> mysqlConnects() throws ClassNotFoundException, SQLException {
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
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {//循环输入对象，必须要在循环内 new
            student s=new student();
            s.setStuno(rs.getString("stuno"));
            s.setName((String) rs.getObject("name"));
            s.setAge((Integer) rs.getObject("age"));
            s.setSex((String) rs.getObject("sex"));
            s.setRoom(rs.getString("room"));
            s.setBed(rs.getString("bed"));
            stus.add(s);
        }
        System.out.println(stus.size());
//6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        statement.close();
        conn.close();
        return stus;
    }
}

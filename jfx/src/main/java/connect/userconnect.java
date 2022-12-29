package connect;

import pojo.student;
import pojo.user;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.*;
import java.util.ArrayList;

public class userconnect {
    public static ArrayList<user> us =new ArrayList<>();
    public  ArrayList<user> mysqlConnects() throws ClassNotFoundException, SQLException {
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
        String sql = "select * from userzh";
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {//循环输入对象，必须要在循环内 new
            user u=new user();

            u.setName(rs.getString("zhname"));
            u.setPassword(rs.getString("password"));
            u.setZhuz(rs.getString("zhuz"));
            us.add(u);
        }
        System.out.println(us.size());
//6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        statement.close();
        conn.close();
        return us;
    }
}

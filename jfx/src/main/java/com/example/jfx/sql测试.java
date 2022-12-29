package com.example.jfx;
import java.sql.*;

public class sql测试 {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException
    {
         //基本配置信息
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";//MySQL数据库连接用户名
        final String PASSWORD = "123456";//MySQL数据库连接密码
        Connection conn = null; //保存连接对象
         //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
         //3.向数据库发送SQL的对象
        //statement:CRUD;
        String sql = "select * from student ";
        PreparedStatement statement =conn.prepareStatement(sql);
        //4.编写sql
        //5.执行查询sql，返回一个resultSet：结果集
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            String name1=rs.getString("name");
            System.out.println("user_name    " +name1);
        }
         //6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        statement.close();
        conn.close();
    }
}

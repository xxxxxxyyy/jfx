package pojo;

import connect.Stuconnect;
import connect.userconnect;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class userSevers {
    public userSevers() {
    }

    public static ArrayList<user> getUsers() {
        return users;
    }

    private static ArrayList<user> users=new ArrayList<>();
    static {
       /* userconnect uc=new userconnect();
        try {
            users=uc.duqu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        userconnect conn=new userconnect();
        try {
            users=conn.mysqlConnects();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      /*  users.add(new user("0001","2002"));
        users.add(new user("0002","2002"));
        users.add(new user("0003","2002"));


       */

    }
  /*  public void zhuc() throws IOException {
        File f=new File("d:"+File.separator+"用户账号密码.txt");
        Writer w=new FileWriter(f,true);
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        String Line1=null;
        String Line2=null;
            System.out.println("输入学生数据，结束输入over");
            System.out.println("请输入账号");
            Line1=sc.nextLine();
            System.out.println("请输入密码");
            Line1=sc.nextLine();
            sb.append(Line1);
            sb.append(":");
            sb.append(Line2);
            sb.append("\r\n");
        String s=sb.toString();
        w.write(s);
        w.close();
    }

   */

  /*  public static ArrayList<user>  duqu() throws IOException {
        ArrayList<user> ulist=new ArrayList<>();
        File f=new File("d:"+File.separator+"用户账号密码.txt");
        FileReader filereader=new FileReader(f);
        LineNumberReader reader=new LineNumberReader(filereader);
        String txt=" ";
        String zh;
        String pw;
        int lines=0;
        while (txt!=null){
            lines++;
            txt =reader.readLine();
           zh=txt.substring(0,6);
           pw=txt.substring(8,13);
           user u=new user(zh,pw);
           ulist.add(u);
        }
        return ulist;
    }

   */
    public user findByusername(String username) {
        userconnect conn=new userconnect();
        try {
            users=conn.mysqlConnects();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<user> ulist=users;
        for (user u:ulist) {
            if(username.equals(u.getName())){
                return u;
            }
        }
        return null;
    }

    public void addUser(user u) throws SQLException {
        userSevers roomSevers=new userSevers();
        user r=roomSevers.findByusername(u.getName());
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String name="'"+u.getName()+"'";
        String id="'"+u.getPassword()+"'";
        String zz="'"+u.getZhuz()+"'";
        String sql="insert into userzh values("+name+","+id+","+zz+")";
        statement.executeUpdate(sql);
    }

    public boolean pd(String name) {
        boolean b=false;
        userconnect conn=new userconnect();
        try {
            users=conn.mysqlConnects();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ArrayList<user> ulist=users;
        for (user r:ulist) {
            if(r.getName().equals(name)){
                b=true;
            }
        }
        System.out.println(b);
        return b;
    }

    public void show(String i) {

    }

    public boolean updateUser(String stuno, user u) throws SQLException {
        userSevers us=new userSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
       // String name="'"+r.getName()+"'";
        String id="'"+stuno+"'";
        //String age= String.valueOf(stu.getAge());
        //String sex="'"+stu.getSex()+"'";
        String dh="'"+u.getZhuz()+"'";
        String pass="'"+u.getPassword()+"'";
        user uo=us.findByusername(stuno);
        //student st=new studentSevers().findBystuno(sno);
       // roomSevers.kwzj(st.getRoom(),st.getBed());
        String sql="update userzh set password= "+pass+", zhuz= "+dh+" where zhname= "+id;
        statement.executeUpdate(sql);
       // student s1=new student(sno,stu.getName(),stu.getSex(),stu.getRoom(),stu.getAge(),stu.getBed());
       // roomSevers.rsdelete(st.getRoom());
       // roomSevers.rsadd(s1.getRoom());//增加数据库房间人数
       // roomSevers.kwjs(stu.getRoom(),stu.getBed());//改变数据库房间空位
        int i=users.indexOf(uo);
        if(users.set(i,u)!=null){
            return true;
        }
        return false;
    }
}

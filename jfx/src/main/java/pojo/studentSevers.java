package pojo;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import connect.Stuconnect;
import controller.ControllerManger;
import controller.StudentMain;

public class studentSevers {
    private static ArrayList<student> studentArrayList=new ArrayList<>();
    static {
        Stuconnect conn=new Stuconnect();
        try {
            studentArrayList=conn.mysqlConnects();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<student> getStudentArrayList() {
        return studentArrayList;
    }
    public ArrayList<student> findStu(String key){
        ArrayList<student> results=new ArrayList<>();
        for (student s:studentArrayList) {
            if(s.getStuno().contains(key)||s.getName().contains(key)||s.getRoom().contains(key)){
                results.add(s);
            }
        }
        return results;
    }


    public boolean delStudent(student stu) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        Room r=roomSevers.findbyrid(stu.getRoom());
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String name="'"+stu.getName()+"'";
        String id="'"+stu.getStuno()+"'";
        String age= String.valueOf(stu.getAge());
        String sex="'"+stu.getSex()+"'";
        String room="'"+stu.getRoom()+"'";
        String sql="delete from sturoom where stuno="+id;
        statement.executeUpdate(sql);
        roomSevers.rsdelete(stu.getRoom());//减少数据库房间人数
      //student s=findBystuno(stuno);
        roomSevers.kwzj(stu.getRoom(),stu.getBed());
        return studentArrayList.remove(stu);

    }

    public<E> student findBystuno(E stuno) { //泛型方法
        for (student s:studentArrayList) {
            if(stuno.equals(s.getStuno())){
                return s;
            }
        }
        return null;
    }

    public void addStudent(student stu) throws SQLException {
        roomSevers roomSevers=new roomSevers();
       // Room r=roomSevers.findbyrid(stu.getRoom());
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String name="'"+stu.getName()+"'";
        String id="'"+stu.getStuno()+"'";
        String age= String.valueOf(stu.getAge());
        String sex="'"+stu.getSex()+"'";
        String room="'"+stu.getRoom()+"'";
        String bed="'"+stu.getBed()+"'";
        String sql="insert into sturoom values("+id+","+name+","+age+","+sex+","+room+","+bed+")";
        statement.executeUpdate(sql);
        student s=new student(stu.getStuno(),stu.getName(),stu.getSex(),stu.getRoom(),stu.getAge(),stu.getBed());
        studentArrayList.add(s);
        roomSevers.rsadd(stu.getRoom());//增加数据库房间人数
        roomSevers.kwjs(stu.getRoom(),stu.getBed());//改变数据库房间空位
    }

    public boolean updateStudent(String sno, student stu) throws SQLException {
        roomSevers roomSevers=new roomSevers();
       // Room r=roomSevers.findbyrid(stu.getRoom());
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String name="'"+stu.getName()+"'";
        String id="'"+sno+"'";
        String age= String.valueOf(stu.getAge());
        String sex="'"+stu.getSex()+"'";
        String room="'"+stu.getRoom()+"'";
        String bed="'"+stu.getBed()+"'";
        student st=new studentSevers().findBystuno(sno);
        roomSevers.kwzj(st.getRoom(),st.getBed());
        String sql="update sturoom set name= "+name+", age= "+age+", sex= "+sex+", room= "+room+", bed= "+bed+" where stuno= "+id;
        statement.executeUpdate(sql);
        student s1=new student(sno,stu.getName(),stu.getSex(),stu.getRoom(),stu.getAge(),stu.getBed());
        roomSevers.rsdelete(st.getRoom());
        roomSevers.rsadd(s1.getRoom());//增加数据库房间人数
        roomSevers.kwjs(stu.getRoom(),stu.getBed());//改变数据库房间空位
       int i=studentArrayList.indexOf(st);
       if(studentArrayList.set(i,stu)!=null){
           return true;
       }
       return false;
    }

}

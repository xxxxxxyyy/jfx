package pojo;

import connect.roomconnect;

import java.sql.*;
import java.util.ArrayList;

public class roomSevers  {
    private static ArrayList<Room> rlist=new ArrayList<>();
    static {
      roomconnect conn=new roomconnect();
        try {
            rlist=conn.mysqlConnects();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       // rlist.add(new Room("10-1-1",12,"sqqw"));
        //rlist.add(new Room("10-1-2",12,"tytry"));
    }

    public static ArrayList<Room> getRlist() {
        return rlist;
    }


    public ArrayList<Room> findRoom(String text) {
        ArrayList<Room> results=new ArrayList<>();
        for (Room r:rlist) {
            String d= String.valueOf(r.getRs());
            if(r.getRoomid().contains(text)||d.contains(text)){
                results.add(r);
            }
        }
        return results;
    }

    public Room findbyrid(String text) {

        for (Room r:rlist) {
            if(r.getRoomid().contains(text)){
                return r;
            }
        }
        return null;
    }
    public void rsadd(String rid) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        Room r=roomSevers.findbyrid(rid);
        String rid1="'"+r.getRoomid()+"'";
        //String wz="'"+r.getWz()+"'";
        String ps= String.valueOf(r.getRs()+1);
        // String bmsg="'"+r.getBmsg()+"'";
        String sql="update room set rs="+ps+" where rid="+rid1;
        statement.executeUpdate(sql);
        rlist.remove(r);
        Room r2=new Room(r.getRoomid(),r.getRs()+1,r.getWz(),r.getBmsg());
        rlist.add(r2);
    }
    public void rsdelete(String rid) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        Room r=roomSevers.findbyrid(rid);
        String rid1="'"+r.getRoomid()+"'";
        String wz="'"+r.getWz()+"'";
        String ps= String.valueOf(r.getRs()-1);
        String bmsg="'"+r.getBmsg()+"'";
        String sql="update room set rs="+ps+" where rid="+rid1;
        statement.executeUpdate(sql);
        rlist.remove(r);
        Room r2=new Room(r.getRoomid(),r.getRs()-1,r.getWz(),r.getBmsg());
        rlist.add(r2);
    }

    public boolean pd(String room) {
        boolean b=false;
        for (Room r:rlist) {
            if(r.getRoomid().equals(room)){
                b=true;
            }
        }
        System.out.println(b);
        return b;
    }

 /*   public void addroom(Room r) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String rid="'"+r.getRoomid()+"'";
        String wz="'"+r.getWz()+"'";
        String rs= String.valueOf(r.getRs());
        String bx="'"+r.getBmsg()+"'";
        String sql="insert into sturoom values("+rid+","+wz+","+rs+","+bx+")";
        statement.executeUpdate(sql);
        student s=new student(stu.getStuno(),stu.getName(),stu.getSex(),stu.getRoom(),stu.getAge());
        rlist.add(s);
      //  roomSevers.rsadd(stu.getRoom());//增加数据库房间人数
    }


  */
    public boolean updateroom(Room r, String msg) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String rid1="'"+r.getRoomid()+"'";
        String wz="'"+r.getWz()+"'";
        String ps= String.valueOf(r.getRs());
        String bmsg="'"+msg+"'";
        String sql="update room set bmsg="+bmsg+" where rid="+rid1;
        statement.executeUpdate(sql);
       // rlist.remove(r);
       // Room r2=new Room(r.getRoomid(),r.getRs(),r.getWz(),r.getBmsg());
       // rlist.add(r2);
       // Room s=findbyrid(rid1);
        Room r2=new Room(r.getRoomid(),r.getRs(),r.getWz(),msg,r.getKw());
        int i=rlist.indexOf(r);
        if(rlist.set(i,r2)!=null){
            return true;
        }
        return false;
    }

    public void kwjs(String rid, String bed) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        Room r=roomSevers.findbyrid(rid);
        String rid1="'"+r.getRoomid()+"'";
        String wz="'"+r.getWz()+"'";
        String ps= String.valueOf(r.getRs());
        String sql2 = "select * from room where rid="+rid1;
        ResultSet res = statement.executeQuery(sql2);
        Room s=new Room();
        while (res.next()) {//循环输入对象，必须要在循环内 new
            s.setRoomid(res.getString("rid"));
            s.setBmsg(res.getString("bmsg"));
            s.setWz(res.getString("wz"));
            s.setRs(Integer.parseInt(res.getString("rs")));
            s.setKw(res.getString("kw"));
        }
        String d=s.getKw().replace(bed,"");
       //  String d=r.getKw().replace(bed,"");
       // r.setKw(d);
        String bmsg="'"+r.getBmsg()+"'";
        String kw="'"+d+"'";
        String sql="update room set kw="+kw+" where rid="+rid1;
        statement.executeUpdate(sql);
        rlist.remove(r);
        Room r2=new Room(r.getRoomid(),r.getRs(),r.getWz(),r.getBmsg(),d);
        rlist.add(r2);
    }
    public void kwzj(String rid, String bed) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        Room r=roomSevers.findbyrid(rid);
        String rid1="'"+r.getRoomid()+"'";
        String wz="'"+r.getWz()+"'";
        String ps= String.valueOf(r.getRs());
        String sql2 = "select * from room where rid="+rid1;
        ResultSet res = statement.executeQuery(sql2);
        Room s=new Room();
        while (res.next()) {//循环输入对象，必须要在循环内 new
            s.setRoomid(res.getString("rid"));
            s.setBmsg(res.getString("bmsg"));
            s.setWz(res.getString("wz"));
            s.setRs(Integer.parseInt(res.getString("rs")));
            s.setKw(res.getString("kw"));
        }
        String d=s.getKw()+bed;
        String bmsg="'"+r.getBmsg()+"'";
        String kw="'"+d+"'";
        String sql="update room set kw="+kw+" where rid="+rid1;
        statement.executeUpdate(sql);
        Room r2=new Room(r.getRoomid(),r.getRs(),r.getWz(),r.getBmsg(),d);
        rlist.remove(r);
        rlist.add(r2);

    }

    public boolean delRoom(Room s1) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String name="'"+s1.getRoomid()+"'";
        String sql="delete from room where rid="+name;
        statement.executeUpdate(sql);
        return rlist.remove(s1);
    }

    public void addRoom(Room r) throws SQLException {
        roomSevers roomSevers=new roomSevers();
        final String DBURL = "jdbc:mysql://localhost:3306/zy"; //定义MySQL数据库连接地址
        final String DBUSER = "root";
        //MySQL数据库连接用户名
        final String PASSWORD = "123456";
        //MySQL数据库连接密码
        Connection conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); ; //保存连接对象
        Statement statement=conn.createStatement();
        String id="'"+r.getRoomid()+"'";
        String rs= String.valueOf(r.getRs());
        String wz="'"+r.getWz()+"'";
        String kw="'"+r.getKw()+"'";
        String bmsg="'"+r.getBmsg()+"'";
        String sql="insert into room values("+id+","+wz+","+rs+","+bmsg+","+kw+")";
        statement.executeUpdate(sql);
        rlist.add(r);
    }
}

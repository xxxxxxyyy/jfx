package com.example.jfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//public class rtet {

   /* private static final String DRIVER_CLASS_NAME = "";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/zy";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        int count = 10; // 插入记录的数目
        Object[][] params = new Object[count][];
        for (int i = 0; i < count; i++)
            // 将每条记录的数据插入数组
            params[i] = new Object[] { "", "", "" };
        batch(params);
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }

    public static void batch(Object[][] params) {
        QueryRunner queryRunner = new QueryRunner(true);
        String sql = "INSERT INTO TABLE_NAME VALUES (?,?,?)";
        try {
            queryRunner.batch(getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    */
  //public class IntoDataBase {
      /* private static double[] a = new double[]{100,200,300,400,500};
       private static double[] b = new double[]{10,20,30,40,50};
       private static double[] c = new double[]{1,2,3,4,5};

       private static String sql = "insert into into_test values (?,?,?,?,?)";

       private static List<double[]> list = new ArrayList<double[]>(1024);

       private static Connection conn;
       private static PreparedStatement pstm;

       public static int intoData() throws SQLException {
           list.add(a);
           list.add(b);
           list.add(c);

           int count = 0;

           conn = PgDataSource.getPgConn();
           pstm = conn.prepareStatement(sql);

           // 使用两个for循环，外层控制list，内层控制数组
           for(int len = 0;len < list.size();len++) {
               for(int index = 0; index<a.length; index++) {
                   pstm.setDouble(index+1, list.get(len)[index]);
               }
               count = pstm.executeUpdate();
           }
           return count;
       }

}

       */
package dbc;

import java.sql.*;

public class DBUtil{
    public static final String url ="jdbc:mysql://127.0.0.1:3306/test1";
    public static final String user ="root";
    public static final String password ="Admuryou1";
    private static Connection conn=null;
    static{
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    public static Connection getConnection() throws SQLException, ClassNotFoundException {


        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Statement stmt = conn.createStatement();
//        ResultSet rs=stmt.executeQuery("select name, sex from goddess");
//        while(rs.next()){
//            System.out.println(rs.getString("name")+" "+rs.getInt("sex"));
//        }
    }
}

package dbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Util {
//    private static ComboPooledDataSource ds = new ComboPooledDataSource();
//    public static Connection getConn() throws SQLException {
//        return ds.getConnection();
//    }
static ComboPooledDataSource cpds=null;
    static{
        cpds = new ComboPooledDataSource();//这是mysql数据库
    }
    public static Connection getConnection(){
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
            return null;
        }
    }
}

package dbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPUtil {

    private static final String configFile = "dbcp.properties";
    public static Connection getConn() {
        Connection con;
        try {
            BasicDataSource DS = initD();
            con = DS.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }


    private static BasicDataSource  initD() throws Exception {
        Properties p = new Properties();
        p.load(DBCPUtil.class.getClassLoader().getResourceAsStream(configFile));
        BasicDataSource DS = BasicDataSourceFactory.createDataSource(p);
        return DS;
    }

//    private static BasicDataSource bilderDataSource(){
//        Properties p = new Properties();
//        String driver;
//        String url;
//        String username;
//        String password;
//
//        try{
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return DS;
//    }

}

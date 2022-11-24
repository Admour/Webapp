import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Account;
import model.Goddess;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
public class MainApp {
        static final String DB_URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";

        static final String USER = "root";
        static final String PASSWORD = "Admuryou1";

        public static void main(String[] args) throws SQLException {
            Connection conn ;
            QueryRunner queryRunner = new QueryRunner();
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            ResultSetHandler<Goddess> resultHandler = new BeanHandler<>(Goddess.class);
            try {
                Goddess g = queryRunner.query(conn, "SELECT * FROM acount WHERE id=?", resultHandler, "1");
                // Display values
                System.out.print("ID: " + g.getId() + ", acount: " + g.getAcount() + ", Amount: " + g.getAmount());
            } finally {
                DbUtils.close(conn);
            }
        }
    }


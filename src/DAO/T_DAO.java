package DAO;

import dbc.DBUtil;
import model.Trans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class T_DAO {
    public void addT(Trans a) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into trans (id, source_id, source_account, destination_id, destination_acount, amount) values(?,?,?,?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
//        ptmt.setInt(1, a.getId());
        ptmt.setString(3, a.getSource_account());
        ptmt.setInt(2,a.getSource_id());
        ptmt.setInt(1, a.getId());
        ptmt.setInt(4,a.getDestination_id());
        ptmt.setString(5,a.getDestination_account());
        ptmt.setDouble(6, a.getAmount());
        ptmt.execute();
    }

    public void updateT(Trans a) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "update trans set amount = ? where id=?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        ptst.setDouble(1, a.getAmount());
        ptst.setInt(2, a.getId());
        ptst.execute();
    }

    public void delA(Trans g) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from trans where id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, g.getId());
        ptmt.execute();
    }

    public ResultSet query(List<Map<String, String>> pa) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from trans where 1=1");
        for (Map<String, String> map : pa) {
            sb.append(" and ").append(map.get("id")).append(" ").append(map.get("relation")).append(" ").append(map.get("value"));
        }
        PreparedStatement ptst = conn.prepareStatement(sb.toString());
        return ptst.executeQuery();
    }
}

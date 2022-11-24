package DAO;

import dbc.DBCPUtil;
import dbc.DBUtil;
import model.Account;
import dbc.c3p0Util;
import model.Goddess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class A_DAO {
    public void addA(Account a) throws SQLException, ClassNotFoundException {
        Connection conn = c3p0Util.getConnection();
        String sql = "insert into acount ( acount, amount) values(?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, a.getAcount());
        ptmt.setDouble(2, a.getAmount());
        ptmt.execute();
        ptmt.execute();
    }

    public void updateA(Account a) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "update acount set amount = ? where id=?";
        PreparedStatement ptst = conn.prepareStatement(sql);
        ptst.setDouble(1, a.getAmount());
        ptst.setInt(2, a.getId());
        ptst.execute();
    }

    public void delA(Account g) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from acount where id = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, g.getId());
        ptmt.execute();
    }

    public ResultSet query(List<Map<String, String>> pa) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from acount where 1=1");
        for (Map<String, String> map : pa) {
            sb.append(" and ").append(map.get("acount")).append(" ").append(map.get("relation")).append(" ").append(map.get("value"));
        }
        PreparedStatement ptst = conn.prepareStatement(sb.toString());
        return ptst.executeQuery();
    }
    public Account get(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from acount where id =?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Account g = new Account();
        while (rs.next()) {
            g.setId(id);
            g.setAmount(rs.getDouble("amount"));
            g.setAcount(rs.getString("acount"));
            g.setCreate_at(LocalDateTime.parse(rs.getString("create_at")));
        }
        return g;
    }
}

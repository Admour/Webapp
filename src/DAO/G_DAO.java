package DAO;

import dbc.DBUtil;
import model.Goddess;
import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class G_DAO {
    public void addG(Goddess g ) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "insert into acount (id, acount ,age,amount) values(?,?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,g.getId());
//        ptmt.setString(2,g.getName());
//        ptmt.setInt(3,g.getAge());
        ptmt.execute();
//        "insert into goddess(name,sex) values("+"Zoe"+",2);"
    }



    public void updateG(Goddess g) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql ="update goddess set name = ? where id=?";
        PreparedStatement ptst = conn.prepareStatement(sql);
//        ptst.setString(1,g.getName());
        ptst.setInt(2,g.getId());
        ptst.execute();
    }
    public void delG(Goddess g) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from goddess where name = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
//        ptmt.setString(1,g.getName());
        ptmt.execute();
    }
    public ResultSet query(List<Map<String, String>> pa) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        StringBuilder sb =new StringBuilder();
        sb.append("select * from goddess where 1=1");
        for (Map<String, String> map : pa) {
            sb.append(" and ").append(map.get("name")).append(" ").append(map.get("relation")).append(" ").append(map.get("value"));
        }
        PreparedStatement ptst = conn.prepareStatement(sb.toString());
        //        List<Goddess> gs = new ArrayList<Goddess>();
//        Goddess g = null;
//        while (rs.next()) {
//            g = new Goddess();
//            g.setName(rs.getString("name"));
//            g.setId(rs.getInt("id"));
//            g.setAge(rs.getInt("age"));
//            g.setSex(rs.getInt("sex"));
//            g.setEmail(rs.getString("email"));
//            gs.add(g);
//        }
        return ptst.executeQuery();
    }
    public Goddess get(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from goddess where id =?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();
        Goddess g = null;
        while(rs.next()){
            g = new Goddess();
            g.setName(rs.getString("name"));
            g.setEmail(rs.getString("email"));
            g.setSex(rs.getInt("sex"));
        }
        return g;
    }

}

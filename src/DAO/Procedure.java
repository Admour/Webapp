package DAO;

import dbc.DBUtil;

import java.sql.*;

public class Procedure {
    public void select_n() throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        CallableStatement callableStatement = conn.prepareCall("call select_n");
        callableStatement.execute();
        ResultSet resultSet =callableStatement.getResultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name")+resultSet.getInt("id"));
        }
    }
    public void select_f(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        CallableStatement callableStatement = conn.prepareCall("call select_g(?)");
        callableStatement.setString(1,name);
        callableStatement.execute();
        ResultSet resultSet = callableStatement.getResultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name")+resultSet.getInt("id"));
        }
    }
    public int select_x() throws SQLException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        CallableStatement callableStatement = conn.prepareCall("call select_x(?)");
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.execute();
        int cou = callableStatement.getInt(1);
        return cou;
    }
}

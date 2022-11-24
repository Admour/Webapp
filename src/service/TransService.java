package service;

import DAO.A_DAO;
import DAO.T_DAO;
import dbc.DBUtil;
import model.Account;
import model.Trans;

import java.sql.Connection;
import java.sql.SQLException;

public class TransService {
    public String trans(Account from, Account to, Double amount) throws SQLException, ClassNotFoundException {

        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        try{
            A_DAO a_dao = new A_DAO();
            T_DAO t_dao = new T_DAO();
            from.setAmount(from.getAmount()-amount);
            a_dao.updateA(from);
            to.setAmount(to.getAmount()+amount);
            a_dao.updateA(to);
            Trans info = new Trans();
            info.setSource_id(from.getId());
            info.setSource_account(from.getAcount());
            info.setDestination_account(to.getAcount());
            info.setDestination_id(to.getId());
            info.setAmount(amount);
            t_dao.addT(info);
            conn.commit();
            return "success";
        }catch (Exception e){
            conn.rollback();
            return "fail";
        }

    }
}

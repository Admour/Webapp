import Action.GACtion;
import DAO.A_DAO;
import DAO.G_DAO;
import DAO.Procedure;
import DAO.T_DAO;
import model.Account;
import model.Goddess;
import service.TransService;

import java.sql.SQLException;
import java.util.*;

public class TestAction {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Procedure procedure = new Procedure();
//        int cou = 0;
//        try {
//            cou = procedure.select_x();
//            System.out.println(cou);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("tro");
//        }
//        Date a = new Date();
        Account account = new Account();
        A_DAO a_dao = new A_DAO();
        account.setAcount("Jap");
        account.setAmount(50.00);
        a_dao.addA(account);
        Date b = new Date();
//        System.out.println(b.getTime()-a.getTime());
//        A_DAO a_dao = new A_DAO();
//        TransService transService = new TransService();
//        Account from = a_dao.get(1);
//        Account to = a_dao.get(2);
//        String ret = transService.trans(from,to,100.00);
//        System.out.println(ret);

    }
}
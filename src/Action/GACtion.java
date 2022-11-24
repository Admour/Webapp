package Action;

import DAO.G_DAO;
import model.Goddess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class GACtion {
    public void add(Goddess g)throws Exception{
        G_DAO g_dao = new G_DAO();
        g_dao.addG(g);
    }
    public void  update(Goddess g)throws Exception{
        G_DAO g_dao = new G_DAO();
        g_dao.updateG(g);
    }
    public void del(Goddess g)throws Exception{
        G_DAO g_dao = new G_DAO();
        g_dao.delG(g);
    }
    public ResultSet query(List<Map<String,String>> pa) throws SQLException, ClassNotFoundException {
        G_DAO g_dao = new G_DAO();
        return g_dao.query(pa);
    }
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        G_DAO g_dao = new G_DAO();
//        Goddess g1 = new Goddess();
//        List<Map<String, String>> pa = new ArrayList<>();
//        Map<String,String > par = new HashMap<>();
//        par.put("name", "name");
//        par.put("relation", "like");
//        par.put("value","'%a%'");
//        pa.add(par);
//        ResultSet qs = g_dao.query(pa);
////        for(Goddess g:qs){
//            System.out.println(g.getName());
//            System.out.println(g.getSex());
//            System.out.println(g.getEmail());
//        }
//        while (qs.next()){
//            System.out.println(qs.getString("name")+" "+qs.getInt("id")
//                    +" "+qs.getInt("age")+" "+qs.getInt("sex")+" "+qs.getString("email"));
//        }

//        g.setName("zoe");
//        g.setSex(2);
//        g_dao.addG();
//    }
}

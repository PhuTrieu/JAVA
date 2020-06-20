package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;
import uti.ConnectManager;

public class CustomerDAO {
    public List<Customer> findAll(){
        List<Customer> list = new ArrayList<>();
        Connection conn = ConnectManager.getConnection();
        try {
            Statement st = conn.createStatement();
            String sql = "select * from customer";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setAge(rs.getInt(3));
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public boolean insert (Customer c){
        Connection conn = ConnectManager.getConnection();
        try {
            String sql = "insert into customer(name,age) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.NO_GENERATED_KEYS);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getAge());
            
            int i = ps.executeUpdate();
            if (i!=0) {
                ResultSet keyResultSet = ps.getGeneratedKeys();
                int newCustomerID = 0;
                if (keyResultSet.next()) {
                    newCustomerID = keyResultSet.getInt(1);
                    c.setId(newCustomerID);
                }
                return true;
            }
            else return false;
        } catch (SQLException e) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        return false;
    }
    
    public boolean delete (int id){
        Connection conn = ConnectManager.getConnection();
        boolean result = true;
        try {
            PreparedStatement ps = conn.prepareStatement("delete from customer where id=?");
            ps.setInt(1, id);
            result = ps.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
        return result;
    }
    
    public boolean update (Customer c){
        boolean result = true;
        Connection conn = ConnectManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("update customer set name=?,age=? where id=?");
            ps.setString(1, c.getName());
            ps.setInt(2, c.getAge());
            ps.setInt(3, c.getId());
            result = ps.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
        return result;
    }
    
    public Customer findbyID(int id){
        Customer c = null;
        Connection conn = ConnectManager.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            return null;
        }
        return c;
    }
}

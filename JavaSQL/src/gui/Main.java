package gui;

import dao.CustomerDAO;
import java.util.List;
import model.Customer;

public class Main {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        List<Customer> list = dao.findAll();
        for(Customer c : list){
                System.out.println(c);
        }
    }
}

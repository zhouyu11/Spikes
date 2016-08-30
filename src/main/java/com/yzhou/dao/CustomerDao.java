package com.yzhou.dao;

import com.yzhou.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public List<Customer> getCustomers() {
        String sql = "Select * from customer";

        List<Customer> customers = new ArrayList<Customer>();
        try{
            PreparedStatement stmt = DBConnector.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customers.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return customers;
    }
}

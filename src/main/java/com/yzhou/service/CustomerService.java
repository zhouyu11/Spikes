package com.yzhou.service;

import com.yzhou.Customer;
import com.yzhou.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static final String DRIVER;

    private static final String URL;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        try {
            Class .forName(DRIVER);
        }catch (ClassNotFoundException e){
            LOGGER.error("not found driver", e);
        }
    }


    public List<Customer> list() {
        Connection conn;
        String sql = "Select * from customer";

        List<Customer> customers = new ArrayList<Customer>();
        try{
            conn = DriverManager.getConnection(URL);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customers.add(customer);
            }
        }catch (Exception e){
            LOGGER.error("list customer failed", e);
        }
        return customers;
    }

    public Customer getCustomer(long id) {
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMaps) {
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMaps) {
        return false;
    }

    public boolean deleteCustomer(long id) {
        return false;
    }

}

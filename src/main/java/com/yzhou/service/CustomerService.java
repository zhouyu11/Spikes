package com.yzhou.service;

import com.yzhou.dao.CustomerDao;
import com.yzhou.model.Customer;

import java.util.List;
import java.util.Map;

public class CustomerService {
    private CustomerDao customerDao= new CustomerDao();

    public List<Customer> list() {
        return customerDao.getCustomers();
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

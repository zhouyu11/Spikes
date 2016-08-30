package com.yzhou.service;

import com.yzhou.model.Customer;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerServiceTest {
    @Test
    public void shouldListCustomers() throws Exception {
        CustomerService customerService = new CustomerService();

        List<Customer> list = customerService.list();
        assertThat(2,is(list.size()));
    }
}
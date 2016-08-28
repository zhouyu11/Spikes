package com.yzhou.servlet;

import com.yzhou.model.Customer;
import com.yzhou.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService;
    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> list = customerService.list();
        req.setAttribute("customerList", list);
        req.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(req,resp);
    }
}

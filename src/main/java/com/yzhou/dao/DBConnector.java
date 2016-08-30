package com.yzhou.dao;

import com.yzhou.service.CustomerService;
import com.yzhou.utils.DBConfigLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static DBConnector dbConnector;
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private DBConnector() {
    }

    public static DBConnector getInstance() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }

        return dbConnector;
    }


    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBConfigLoadUtil.getUrl());
        } catch (SQLException e) {
            LOGGER.error("get connection error", e);
            e.printStackTrace();
        }
        return connection;
    }

}

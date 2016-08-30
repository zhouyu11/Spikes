package com.yzhou.utils;

import com.yzhou.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class DBConfigLoadUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static final String DRIVER;

    private static final String URL;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        try {
            //loader driver
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("not found driver", e);
        }
    }

    public static String getUrl(){
        return URL;
    }
}

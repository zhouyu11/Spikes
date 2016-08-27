package com.yzhou.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public final class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName) {
        Properties props = null;
        InputStream is = null;

        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

            if (is == null) {
                throw new FileNotFoundException(fileName + " file not found");
            }
            props = new Properties();

            props.load(is);

        } catch (Exception e) {
            LOGGER.error("load properties file failed", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failed", e);
                }
            }
        }

        return props;
    }

    public static String getString(Properties props, String key) {
        return getString(props, key, "");
    }

    public static String getString(Properties props, String key, String defaultvalue) {
        String value = defaultvalue;
        if (props.containsKey(key)) {
            value = props.getProperty(key);
        }
        return value;
    }

    public static int getInt(Properties props, String key) {
        return getInt(props, key,0);
    }

    public static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)){
            value = Integer.valueOf(props.getProperty(key));
        }
        return value;
    }

    public static boolean getBool(Properties props, String key) {
        return getBool(props, key, false);
    }

    public static boolean getBool(Properties props, String key, Boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)){
            value = Boolean.valueOf(props.getProperty(key));
        }
        return value;
    }

}


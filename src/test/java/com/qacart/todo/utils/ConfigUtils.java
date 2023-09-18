package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;
    public ConfigUtils(){
        properties=PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
    }

    public static ConfigUtils getInstance(){
        if (configUtils==null){
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }
    public String getBaseurl(){
        String prop = properties.getProperty("baseUrl");
        if(prop!=null)return prop;
        throw new RuntimeException("Could not find the base Url in th property file");
    }

    public String getEmail(){
        String prop = properties.getProperty("email");
        if(prop!=null)return prop;
        throw new RuntimeException("Could not find the email in th property file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop!=null)return prop;
        throw new RuntimeException("Could not find the password in th property file");
    }

}

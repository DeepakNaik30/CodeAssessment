package com.project.utility;

import com.project.constants.FrameworkConstants;
import com.project.constants.PropertiesConstants;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//Load values from the properties file.
public class Property {
    public static Map<String, String> configDetails = new HashMap<>();
    public static Properties prop = new Properties();

    //Load properties from properties file based on the environment
    public static Map<String, String> getProperties(){
        String env = System.getProperty(FrameworkConstants.ENV);
        try{
            FileInputStream fis = new FileInputStream(
                    System.getProperty(FrameworkConstants.USER_DIR) + FrameworkConstants.CONFIG + env + FrameworkConstants.PROPERTIES);
            prop.load(fis);
            configDetails.put(PropertiesConstants.SERVER_URL, prop.getProperty(PropertiesConstants.SERVER_URL));
            configDetails.put(PropertiesConstants.PORT, prop.getProperty(PropertiesConstants.PORT));
            configDetails.put(PropertiesConstants.USERNAME, prop.getProperty(PropertiesConstants.USERNAME));
            configDetails.put(PropertiesConstants.PASSWORD, prop.getProperty(PropertiesConstants.PASSWORD));
        } catch (Exception ex){
            //TODO: Check with Emtec team on the standard they follow to catch the exception.
            // throw v/s throws
        }
        return configDetails;
    }
}

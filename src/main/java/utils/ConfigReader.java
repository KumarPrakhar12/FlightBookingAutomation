package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

static Properties prop;

public static void loadConfig(){

try{

prop=new Properties();

FileInputStream file=new FileInputStream("config.properties");

prop.load(file);

}

catch(Exception e){

}

}

public static String getProperty(String key){

return prop.getProperty(key);

}

}
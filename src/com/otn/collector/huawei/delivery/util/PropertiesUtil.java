package com.otn.collector.huawei.delivery.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**
 * 资源文件解析工具
 * @author xuquan
 * 2014-6-3
 */
public class PropertiesUtil {  
  
    private Properties props;  
    
    public PropertiesUtil(String fileName){  
        loadProperties(fileName);  
    }  
    private void loadProperties(String fileName) {  
        try {  
            props = new Properties();  
            InputStream is = new BufferedInputStream(new FileInputStream(fileName));
            props.load(is);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * 获取某个属性 
     */  
    public String getProperty(String key){  
        return props.getProperty(key);  
    }  

    public static void main(String[] args) {  
        PropertiesUtil util=new PropertiesUtil("conf/collector/U2000.properties");  
        String username = util.getProperty("username");
        System.out.println(username);
    }      
}  
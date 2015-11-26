package com.xingmei.codeengine.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置文件加载工具
 *@author JiangZhiYong
 *@date 2015年6月19日11:27:50
 */
public class ConfigUtil {
	private static final Logger log=LoggerFactory.getLogger(ConfigUtil.class);
	
	/**加载用户ustom.properties 配置*/
	public static void loadProperties(){
		Properties prop=new Properties();
		
		InputStream resourceAsStream = ConfigUtil.class.getResourceAsStream("/custom.properties");
		
		try {
			//prop.load(new FileInputStream(file));
		    prop.load(resourceAsStream);
			prop.putAll(System.getProperties());
			System.setProperties(prop);
			log.info("load config[{custom.properties}] success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

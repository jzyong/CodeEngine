package com.xingmei.codeengine.util.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *数据库工具类
 *@author JiangZhiYong
 *@version 2015年6月19日12:13:57
 */
public class DBUtil {
	private static final Logger log=LoggerFactory.getLogger(DBUtil.class);
	private volatile static DBUtil dbUtil=null;
	
	
	
	
	private DBUtil() {
	}
	
	public static DBUtil getInstance(){
		if(dbUtil==null){
			synchronized (DBUtil.class) {
				dbUtil=new DBUtil();
			}
		}
		return dbUtil;
	}
	
	/**��ȡ���ݿ�����*/
	public Connection getDBConnection(){
		Properties properties = System.getProperties();
		String url=properties.getProperty("db.url")+""+properties.getProperty("db.name")+""+"?useUnicode=true&characterEncoding=UTF-8";
		String usr = properties.getProperty("db.user");
		String password = properties.getProperty("db.password");
		Connection connection=null;
		log.info("connect database url[{}]",url);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection(url,usr,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**获取数据库表名集合*/
	public static List<String> getTableName(Connection conn) throws SQLException{
		ResultSet tableRet = conn.getMetaData().getTables(null, null,null,null);
		List<String> tablenames=new ArrayList<String>();
		while(tableRet.next()) {
			tablenames.add(tableRet.getString("TABLE_NAME").toLowerCase());
		}
		return tablenames;
	}
	
	
	/**获取表的列信息*/
	public static List<Column> getColumnDefine(Connection conn,String tableName) throws SQLException{
		DatabaseMetaData metaData = conn.getMetaData();
		ResultSet columns =metaData.getColumns(null,"%", tableName,"%");
		ResultSet primaryKey = metaData.getPrimaryKeys(null,"%", tableName);
		primaryKey.next();
		List<Column> infos=new ArrayList<Column>();
		while (columns.next()) {
			Column info=new Column();
			info.setName(columns.getString("COLUMN_NAME"));  
            info.setType(columns.getString("TYPE_NAME").toLowerCase());  
            info.setSize(columns.getInt("COLUMN_SIZE"));  
            info.setNullable(columns.getBoolean("IS_NULLABLE"));
            info.setDescription(columns.getString("REMARKS"));
            info.setPrimary(primaryKey.getString(4));
            if(info.getType().equalsIgnoreCase("blob")){	
            	continue;
            }
			infos.add(info);
		}
		return infos;
	}
	
}

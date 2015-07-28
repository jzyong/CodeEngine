package com.xingmei.codeengine.util;

/**
 * 常量
 * 
 * @author JiangZhiYong
 * @version 2014年10月30日 上午10:32:58
 */
public class ConstantUtil {
	/**类名*/
	public static final String CLASS_NAME="className";
	/**包名*/
	public static final String PACKAGE="package";
	/**属性类型*/
	public static final String PRO_TYPE="proType";
	/**属性名称*/
	public static final String PRO_NAME="proName";
	/**属性注释*/
	public static final String PRO_DESCRIPTION="description";
	/**属性集合*/
	public static final String PRO_LIST="properties";
	/**时间属性*/
	public static final String DATE="date";
	
	

	/**模板文件名常量
	 * @author JiangZhiYong
	 * */
	public static enum TemplateConstant {

		JavaBean("javabean.ftl", 1),
		ExcelBean("excelBean.ftl",2),
		MinaMessage("mina_message.ftl",3),
		MinaMessagePool("mina_message_pool.ftl",4),
		MinaTcpOpCode("mina_opcode.ftl",5),
		HibernateBean("HibernateBean.ftl",6);

		private String name;
		private int index;
		
		private TemplateConstant(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public int getIndex() {
			return index;
		}
	}
	
	/**消息类型枚举
	 * @author JiangZhiYong
	 * @date 2014年11月18日11:52:35
	 * */
	public static enum MessageType{
		/**前端向游戏服发送*/
		ClientServer("CS", 1),
		
		/**游戏服-->世界服*/
		ServerWorld("SW",2),
		
		/**游戏服-->前端*/
		ServerClient("SC",3),
		
		/**世界服-->游戏服*/
		WorldServer("WS",4),
		
		/**世界服-->前端*/
		WorldClient("WC",5);

		private String name;
		private int index;
		
		private MessageType(String name, int index) {
			this.name = name;
			this.index = index;
		}

		public String getName() {
			return name;
		}

		public int getIndex() {
			return index;
		}
	}

}

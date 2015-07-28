package com.xingmei.codeengine.util.db;


/**
 *数据库字段信息
 *@author JiangZhiYong
 *@version 2015年6月19日12:13:38
 */
public class Column {
		private String primary;		//主键
		private String name;		//名称
		private String type;		//类型
		private Integer size;		//大小
		private Boolean nullable;   //是否可为空
		private String description;			//字段描述信息
		
		/**�����ֶζ���*/
		public static Column createColumn(String name, String type, Integer size, Boolean nullable, String description, String primary) {
			Column info=new Column();
			info.setName(name);
			info.setType(type);
			info.setSize(size);
			info.setNullable(nullable);
			info.setDescription(description);
			info.setPrimary(primary);
			return info;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			if("varchar".equalsIgnoreCase(type)||"char".equalsIgnoreCase(type)||"mediumtext".equalsIgnoreCase(type)||"longtext".equalsIgnoreCase(type)){
				return String.class.getSimpleName();
			}
			if("datetime".equalsIgnoreCase(type)){
				return "Date";
			}
			if("bit".equalsIgnoreCase(type)||"int unsigned".equalsIgnoreCase(type)){
				return "int";
			}
			if("bigint".equalsIgnoreCase(type)||"bigint unsigned".equalsIgnoreCase(type)){
				return "long";
			}
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		public Boolean getNullable() {
			return nullable;
		}
		public void setNullable(Boolean nullable) {
			this.nullable = nullable;
		}
		
		public String getPrimary() {
			return primary;
		}
		public void setPrimary(String primary) {
			this.primary = primary;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		@Override
		public String toString() {
			return "Column [name=" + name + ", type=" + type + ", size=" + size
					+ ", nullable=" + nullable + ", description=" + description
					+ ", primary=" + primary + "]";
		}
		
		
		
		
}

package com.xingmei.codeengine.util;

/**
 * 常量
 * 
 * @author JiangZhiYong
 * @version 2014年10月30日 上午10:32:58
 */
public class ConstantUtil {
    /** 类名 */
    public static final String CLASS_NAME = "className";
    /** 包名 */
    public static final String PACKAGE = "package";
    /** 属性类型 */
    public static final String PRO_TYPE = "proType";
    /** 属性名称 */
    public static final String PRO_NAME = "proName";
    /** 属性注释 */
    public static final String PRO_DESCRIPTION = "description";
    /** 属性集合 */
    public static final String PRO_LIST = "properties";
    /** 时间属性 */
    public static final String DATE = "date";


    /**
     * 模板文件名常量
     * 
     * @author JiangZhiYong
     */
    public static enum TemplateConstant {
        /**领域对象*/
        DomainBean("DomainBean.ftl", 4),
        /**数据层*/
        Dao("dao.ftl", 5),
        /**Hibernate 对象*/
        HibernateBean("HibernateBean.ftl", 6);

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


}

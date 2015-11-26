package com.xingmei.codeengine.util.freemarker;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;

/**
 * FreeMarker 工具
 *
 * @author JiangZhiYong
 * @version 2014年10月30日 上午10:05:01
 */
public class FreeMarkerUtil {
    private static final Logger log = LoggerFactory.getLogger(FreeMarkerUtil.class);
    private static volatile FreeMarkerUtil freeMarkerUtil = null;
    private Configuration cfg;

    private FreeMarkerUtil() {
    }

    public static FreeMarkerUtil getInstance() {
        if (freeMarkerUtil == null) {
            synchronized (FreeMarkerUtil.class) {
                freeMarkerUtil = new FreeMarkerUtil();
            }
        }
        return freeMarkerUtil;
    }

    /**
     * 初始化模板
     * 
     * @author JiangZhiYong
     */
    public void initConfiguration() {
        cfg = new Configuration(new Version(2, 3, 22));
        String path = System.getProperty("user.dir");
        String templatePath = path + "\\src\\main\\resources\\ftl";
        try {
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            cfg.setObjectWrapper(new DefaultObjectWrapper(new Version(2, 3, 21)));
            cfg.setSharedVariable("upperFC", new UpperFirstCharacterDirective());// 首字母大写指令
            cfg.setSharedVariable("lowerFC", new LowerFirstCharacterDirective());// 首字母小写指令
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取模板
     * 
     * @author JiangZhiYong
     */
    public Template getTemplate(String templateName) throws IOException {
        if (cfg != null) {
            return cfg.getTemplate(templateName);
        }
        log.error("Configuration not init");
        return null;
    }
}

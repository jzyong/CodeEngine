package com.xingmei.codeengine.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.xingmei.codeengine.util.ConstantUtil;
import com.xingmei.codeengine.util.ConstantUtil.TemplateConstant;
import com.xingmei.codeengine.util.DateUtil;
import com.xingmei.codeengine.util.FileUtil;
import com.xingmei.codeengine.util.freemarker.FreeMarkerUtil;
import freemarker.template.Template;

/**
 * 消息处理器生成工具
 * 
 * @author JiangZhiYong
 * @date 2015-11-26 18:39:05
 */
public class HandlerCodeTool {
    private static final Logger logger = LoggerFactory.getLogger(HandlerCodeTool.class);
    private volatile static HandlerCodeTool handlerCodeTool = null;

    private HandlerCodeTool() {

    }

    public static HandlerCodeTool getInstance() {
        if (handlerCodeTool == null) {
            synchronized (HandlerCodeTool.class) {
                handlerCodeTool = new HandlerCodeTool();
            }
        }
        return handlerCodeTool;
    }

    /**
     * 生成消息处理器 源代码
     * 
     * @author JiangZhiYong
     * @date 2015-11-26 18:46:52
     */
    public void generateMessageHandler() throws Exception {
        List<String> list = FileUtil.fileName(System.getProperty("proto.path"));
        if (list != null) {
            for (String fileName : list) {
                List<String> handlerNames = getHandlerName(fileName);
                for (String handlerName : handlerNames) {
                    String packageStr = fileName.substring(0, fileName.indexOf(".proto")).toLowerCase();
                    String codePath = System.getProperty("file.dir") + System.getProperty("handler.path") + "\\"+packageStr+"\\";
                    File file = new File(codePath);
                    //File parent = file.getParentFile();
                    if (file != null && !file.exists()) {
                        file.mkdirs();
                    }
                    codePath = codePath + handlerName + "Handler.java";
                    FileOutputStream fos = new FileOutputStream(new File(codePath));
                    Map<String, Object> data = new HashMap<String, Object>();
                    data.put(ConstantUtil.PACKAGE, packageStr);
                    data.put(ConstantUtil.CLASS_NAME, handlerName);
                    data.put(ConstantUtil.DATE, DateUtil.nowData(DateUtil.YYYY_MM_DD));

                    Template template = FreeMarkerUtil.getInstance().getTemplate(TemplateConstant.MessageHandler.getName());
                    if (template != null) {
                        template.process(data, new OutputStreamWriter(fos, "utf-8"));
                        fos.flush();
                        fos.close();
                        logger.info(String.format("PB[%-20s] --> %sHandler 类成功...", fileName, handlerName));
                    } else {
                        logger.error("PB[{}]生成失败,模板[{}] 未找到!!!", fileName, TemplateConstant.MessageHandler.getName());
                    }
                }
            }
        }
    }

    /**
     * 获取消息处理器名称
     * 
     * @param fileName
     *            文件名称
     */
    private List<String> getHandlerName(String fileName) throws Exception {
        List<String> lineList = FileUtil.fileLineList(System.getProperty("proto.path"), fileName);
        List<String> retList = new ArrayList<>();
        for (String line : lineList) {
            line.trim();
            if (line.startsWith("message") && line.contains("Request")) {
                retList.add(line.substring(10, line.indexOf("Request")));
            }
        }
        return retList;
    }

}

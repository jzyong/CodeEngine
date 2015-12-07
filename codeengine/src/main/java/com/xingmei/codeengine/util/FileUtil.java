package com.xingmei.codeengine.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件工具
 * 
 * @author JiangZhiYong
 * @date 2015-11-26 18:29:00
 */
public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取文件数据
     * 
     * @param path
     *            文件路径
     * @param fileName
     *            文件名称
     * @return 文本行列表
     */
    public static List<String> fileLineList(String path, String fileName) throws Exception {
        File file = new File(path, fileName);
        BufferedReader reader = null;
        BufferedInputStream fis = null;
        String line = null;
        List<String> texts = new ArrayList<String>();
        try {
            fis = new BufferedInputStream(new FileInputStream(file));
            reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 1024 * 512);
            while ((line = reader.readLine()) != null) {
                texts.add(line);
            }
        } catch (Exception e) {
            log.error("Log read error", e);
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException e) {
                log.error("Log read error", e);
            }
        }
        return texts;
    }

    /**
     * 获取目录下的所有文件名
     * 
     * @param path
     *            目录路径
     */
    public static List<String> fileName(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        List<String> retList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                retList.add(files[i].getName());
            }
        }
        return retList;
    }
}

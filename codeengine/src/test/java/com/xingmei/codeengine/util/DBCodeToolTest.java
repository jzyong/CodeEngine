package com.xingmei.codeengine.util;

import org.junit.Test;
import com.xingmei.codeengine.code.DBCodeTool;

/**
 * DBCodeTool 类测试
 * 
 * @author JiangZhiYong
 * @date 2015-11-26 17:14:19
 */
public class DBCodeToolTest {

    @Test
    public void test() {
        System.err.println(DBCodeTool.getInstance().convertClassName("hero_chip"));
    }

}

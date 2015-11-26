package com.xingmei.codeengine.util.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 * 首字母小写指令实现类
 * 
 * @author JiangZhiYong
 * @version 2015-11-26 17:38:47
 */
public class LowerFirstCharacterDirective implements TemplateDirectiveModel {

    @SuppressWarnings("rawtypes")
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (!params.isEmpty()) {
            throw new TemplateModelException("此指令不允许无参数");
        }
        if (loopVars.length != 0) {
            throw new TemplateModelException("This directive doesn't allow loop variables.");
        }
        // If there is non-empty nested content:
        if (body != null) {
            // Executes the nested body. Same as <#nested> in FTL, except
            // that we use our own writer instead of the current output writer.
            body.render(new LowerCaseFilterWriter(env.getOut()));
        } else {
            throw new RuntimeException("missing body");
        }
    }

    /**
     * A {@link Writer} that transforms the character stream to lower case and
     * forwards it to another {@link Writer}.
     */
    private static class LowerCaseFilterWriter extends Writer {

        private final Writer out;

        LowerCaseFilterWriter(Writer out) {
            this.out = out;
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            cbuf[0]=Character.toLowerCase(cbuf[0]);
            out.write(String.valueOf(cbuf).trim());
        }

        public void flush() throws IOException {
            out.flush();
        }

        public void close() throws IOException {
            out.close();
        }
    }

}
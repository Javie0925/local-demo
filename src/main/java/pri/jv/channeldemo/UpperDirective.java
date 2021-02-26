//package pri.jv.channeldemo;
//
//
//import java.io.IOException;
//import java.io.Writer;
//import java.util.Map;
//
///**
// * FreeMarker user-defined directive that progressively transforms
// * the output of its nested content to upper-case.
// *
// *
// * <p>Directive info </p>
// *
// * <p>Directive parameters: None
// * <p>Loop variables: None
// * <p>Directive nested content: Yes
// */
//public class UpperDirective implements TemplateDirectiveModel {
//
//    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
//        // Check if no parameters were given:
//        if (!params.isEmpty()) {
//            throw new TemplateModelException("This directive doesn't allow parameters.");
//        }
//        if (loopVars.length != 0) {
//            throw new TemplateModelException("This directive doesn't allow loop variables.");
//        }
//
//        // If there is non-empty nested content:
//        if (body != null) {
//            // Executes the nested body. Same as <#nested> in FTL, except
//            // that we use our own writer instead of the current output writer.
//            body.render(new UpperCaseFilterWriter(env.getOut()));
//        } else {
//            throw new RuntimeException("missing body");
//        }
//    }
//
//    /**
//     * A {@link Writer} that transforms the character stream to upper case
//     * and forwards it to another {@link Writer}.
//     */
//    private static class UpperCaseFilterWriter extends Writer {
//
//        private final Writer out;
//
//        UpperCaseFilterWriter(Writer out) {
//            this.out = out;
//        }
//
//        public void write(char[] cbuf, int off, int len)
//                throws IOException {
//            char[] transformedCbuf = new char[len];
//            for (int i = 0; i < len; i++) {
//                transformedCbuf[i] = Character.toUpperCase(cbuf[i + off]);
//            }
//            out.write(transformedCbuf);
//        }
//
//        public void flush() throws IOException {
//            out.flush();
//        }
//
//        public void close() throws IOException {
//            out.close();
//        }
//    }
//
//
//}
//    /*
//        在root中添加就可以直接在模板中调用：
//        root.put("upper", new com.example.UpperDirective());
//        也可如下方法初始化后也同样可以在模板中调用：
//        <#assign upper = "com.example.UpperDirective"?new()>
//        调用方法如下：
//        <@upper>
//        bar
//        <#-- All kind of FTL is allowed here -->
//        <#list ["red", "green", "blue"] as color>
//        ${color}
//        </#list>
//        baaz
//    </@upper>*/

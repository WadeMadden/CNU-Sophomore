package InClassPrograms;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ArithmeticExpressionEvaluator {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = "41+2*2";
        System.out.println(engine.eval(foo));
    }
}

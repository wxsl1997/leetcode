package org.wxsl.leetcode.hj;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * @author wxsl1997
 */
public class Hj050ScriptEngine {


    public static void main(String[] args) throws ScriptException {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        input = input.replace("[", "(");
        input = input.replace("{", "(");
        input = input.replace("}", ")");
        input = input.replace("]", ")");

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("javascript");
        System.out.println(scriptEngine.eval(input));
    }
}

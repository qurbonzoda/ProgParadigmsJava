+-package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

import java.util.List;
import java.util.Stack;

/**
 * Created by Abduqodir on 25.03.2015.
 */

public class ExpressionParser implements Parser {
    public TripleExpression parse(String exp) throws Exception {
        PPNConverter converter = new PPNConverter();
        converter.convert(exp);
        List<String>list = converter.getOutput();
        /*for (String s : list) {
            System.out.println(s);
        }
*/
        Stack<TripleExpression>stack = new Stack<>();
        nextS: for (String s : list) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(new Const(Integer.parseUnsignedInt(s)));
                continue;
            }
            if (s.charAt(0) >= 'x' && s.charAt(0) <= 'z') {
                stack.push(new Variable(s));
                continue;
            }
            TripleExpression b = stack.pop();
            switch (s) {
                case "Negate":
                    stack.push( new Negative(b) );
                    continue nextS;
            }
            TripleExpression a = stack.pop();
            switch (s) {
                case "+":
                    stack.push( new Add(a, b) );
                    break;
                case "-":
                    stack.push(new Subtract(a, b));
                    break;
                case "*":
                    stack.push(new Multiply(a, b));
                    break;
                case "/":
                    stack.push(new Divide(a, b));
                    break;
                case "mod":
                    stack.push(new Mod(a, b));
                    break;
                case ">>":
                    stack.push(new ShiftRight(a, b));
                    break;
                case "<<":
                    stack.push(new ShiftLeft(a, b));
                    break;
            }
        }
        return stack.pop();
    }
}

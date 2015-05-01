package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

import java.util.List;
import java.util.Stack;

/**
 * Created by Abduqodir on 25.03.2015.
 */

public class CheckedParser implements Parser {
    public TripleExpression parse(String exp) throws Exception {
        PPNConverter converter = new PPNConverter();
        converter.convert(exp);

        List<String> list = converter.getOutput();
        return calculate(list);
    }

    private TripleExpression calculate(List<String> list) throws Exception {
        Stack<TripleExpression>stack = new Stack<>();
        nextS: for (String s : list) {
            if (Character.isDigit(s.charAt(0))) {
                try {
                    stack.push(new Const(Integer.parseUnsignedInt(s)));
                } catch (Exception e) {
                    throw new InvalidExpression("Const overflow at " + s);
                }
                continue;
            }
            if (s.charAt(0) >= 'x' && s.charAt(0) <= 'z') {
                stack.push(new Variable(s));
                continue;
            }

            TripleExpression b = stack.pop();
            switch (s) {
                case "Negate":
                    stack.push( new CheckedNegate(b) );
                    continue nextS;
                case "abs":
                    stack.push( new Abs(b) );
                    continue nextS;
                case "sqrt":
                    stack.push( new Sqrt(b) );
                    continue nextS;
            }

            TripleExpression a = stack.pop();
            switch (s) {
                case "+":
                    stack.push( new CheckedAdd(a, b) );
                    break;
                case "-":
                    stack.push(new CheckedSubtract(a, b));
                    break;
                case "*":
                    stack.push(new CheckedMultiply(a, b));
                    break;
                case "/":
                    stack.push(new CheckedDivide(a, b));
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
                default:
                    throw new InvalidExpression("Unexpected operator " + s);
            }
        }
        return stack.pop();
    }
}

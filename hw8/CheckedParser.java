package info.kgeorgiy.courses.java_intro.homeworks.hw8;

import java.util.List;
import java.util.Stack;

/**
 * Created by Abduqodir on 25.03.2015.
 */

class CheckedParser<T extends Number> implements Parser<T> {
    Mode<T> mode;
    CheckedParser (Mode<T> mode) {
        this.mode = mode;
    }
    public TripleExpression<T> parse(String exp) throws Exception {
        PPNConverter converter = new PPNConverter();
        converter.convert(exp);

        List<String> list = converter.getOutput();
        return calculate(list);
    }

    private TripleExpression<T> calculate(List<String> list) throws Exception {
        Stack< TripleExpression<T> >stack = new Stack<>();
        nextS: for (String s : list) {
            if (Character.isDigit(s.charAt(0))) {
                try {
                    stack.push(new Const<T>(s, mode));
                } catch (Exception e) {
                    throw new InvalidExpression("Const overflow at " + s);
                }
                continue;
            }
            if (s.charAt(0) >= 'x' && s.charAt(0) <= 'z') {
                stack.push(new Variable<T>(s, mode));
                continue;
            }

            TripleExpression<T> b = stack.pop();
            switch (s) {
                case "negate":
                    stack.push( new CheckedNegate<T>(b, mode) );
                    continue nextS;
                case "abs":
                    stack.push( new Abs<T>(b, mode) );
                    continue nextS;
                case "square":
                    stack.push( new Square<T>(b, mode) );
                    continue nextS;
            }

            TripleExpression<T> a = stack.pop();
            switch (s) {
                case "+":
                    stack.push( new CheckedAdd<T>(a, b, mode) );
                    break;
                case "-":
                    stack.push(new CheckedSubtract<T>(a, b, mode));
                    break;
                case "*":
                    stack.push(new CheckedMultiply<T>(a, b, mode));
                    break;
                case "/":
                    stack.push(new CheckedDivide<T>(a, b, mode));
                    break;
                case "mod":
                    stack.push(new Mod<T>(a, b, mode));
                    break;
                default:
                    throw new InvalidExpression("Unexpected operator " + s);
            }
        }
        return stack.pop();
    }

}

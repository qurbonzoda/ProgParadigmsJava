package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abduqodir on 05.04.2015.
 */
public class PPNConverter {
    char curc;
    String input, curN;
    List<String> output;
    int ind;
    public void convert(String expression) throws Exception {
        input = expression;
        output = new ArrayList<>();
        ind  = 0;
        curc = '\0';
        curN = "";

        nextChar();
        begin();
        if (curc != '\0') {
            throw new InvalidExpression("Unexpected operator " + curc + " at " + ind);
        }
    }
    public int getInd() {
        return ind;
    }
    public List<String> getOutput() {
        return output;
    }

    boolean nextChar() {
        while (ind < input.length() && Character.isWhitespace(input.charAt(ind))) {
            ind++;
        }
        if (ind < input.length()) {
            curc = input.charAt(ind++);
        }
        else {
            curc = '\0';
        }
        if (!Character.isDigit(curc) && !curN.equals("") ) {
            output.add(curN);
            curN = "";
        }
        return curc != '\0';
    }
    void begin() throws Exception {
        addSub();
        while (curc == '<' || curc == '>') {
            char tmp = curc;
            nextChar();
            if (curc != tmp) {
                throw new InvalidExpression(tmp + curc + " is invalid operator");
            }
            nextChar();
            addSub();
            output.add(Character.toString(tmp) + tmp);
        }
    }
    void addSub() throws Exception {
        mulDivMod();
        while (curc == '+' || curc == '-') {
            char tmp = curc;
            nextChar();
            mulDivMod();
            output.add(Character.toString(tmp));
        }
    }
    void mulDivMod() throws Exception {
        symbol();
        while (curc == '*' || curc == '/' || curc == 'm') {
            char tmp = curc;
            if(tmp == 'm') {
                int pos = getInd();
                if (!nextChar() || curc != 'o' || !nextChar() || curc != 'd') {
                    throw new InvalidExpression("invalid operator at " + pos + "th position");
                }
            }
            nextChar();
            symbol();
            if (tmp == 'm') {
                output.add("mod");
            }
            else {
                output.add(Character.toString(tmp));
            }
        }
    }
    void symbol() throws Exception {
        int pos = getInd();
        switch (curc) {
            case '(':
                nextChar();
                begin();
                if (curc != ')') {
                    throw new InvalidExpression("Bracket opened at " + pos + " is not closed");
                }
                nextChar();
                break;
            case ')':
                throw new InvalidExpression("Closing unopened bracket at " + pos);
            case 'x':
            case 'y':
            case 'z':
                output.add(Character.toString(curc));
                nextChar();
                break;
            case '-':
                nextChar();
                symbol();
                output.add("Negate");
                break;
            case 'a':
                if (!nextChar() || curc != 'b' || !nextChar() || curc != 's') {
                    throw new InvalidExpression("invalid operator at " + pos + "th position");
                }
                nextChar();
                symbol();
                output.add("abs");
                break;
            case 's':
                if (!nextChar() || curc != 'q' || !nextChar() || curc != 'r' || !nextChar() || curc != 't') {
                    throw new InvalidExpression("invalid operator at " + pos + "th position");
                }
                nextChar();
                symbol();
                output.add("sqrt");
                break;
            default:
                if (!Character.isDigit(curc)) {
                    if (curc == '\0') {
                        throw new InvalidExpression("Operand is missing at " + getInd());
                    }
                    throw new InvalidExpression("Unexpected operator " + curc + " at " + getInd());
                }
        }
        while (Character.isDigit(curc)) {
            curN += Character.toString(curc);
            nextChar();
        }
    }
}
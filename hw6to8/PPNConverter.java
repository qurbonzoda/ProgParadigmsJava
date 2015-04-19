package info.kgeorgiy.courses.java_intro.homeworks.hw6;

import java.io.IOException;
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
    public void convert(String expression) {
        input = expression;
        output = new ArrayList<>();
        ind  = 0;
        curc = '\0';
        curN = "";

        nextChar();
        begin();
    }

    public List<String> getOutput() {
        return output;
    }

    void nextChar() {
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
    }
    void begin() {
        addSub();
        while (curc == '<' || curc == '>') {
            char tmp = curc;
            nextChar();
            nextChar();
            addSub();
            output.add(Character.toString(tmp));
        }
    }
    void addSub() {
        mulDivMod();
        while (curc == '+' || curc == '-') {
            char tmp = curc;
            nextChar();
            mulDivMod();
            output.add(Character.toString(tmp));
        }
    }
    void mulDivMod() {
        symbol();
        while (curc == '*' || curc == '/' || curc == 'm') {
            char tmp = curc;
            if(curc == 'm') {
                nextChar();
                nextChar();
            }
            nextChar();
            symbol();
            output.add(Character.toString(tmp));
        }
    }
    void symbol(){
        switch (curc) {
            case '(':
                nextChar();
                begin();
                if (curc != ')') {
                    try {
                        throw new IOException("Error: wrong number of brackets");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    nextChar();
                }
                break;
            case 'x':
            case 'y':
            case 'z':
                output.add(Character.toString(curc));
                nextChar();
                break;
            case '-':
                nextChar();
                symbol();
                output.add("Negative");
                break;

        }
        while (Character.isDigit(curc)) {
            curN += Character.toString(curc);
            nextChar();
        }
    }
}
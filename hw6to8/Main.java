package info.kgeorgiy.courses.java_intro.homeworks.hw6to8;


/**
 * Created by Abduqodir on 22.03.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new CheckedParser();
        String s = "x*y+(z-1   )/10";
        try {
            TripleExpression exp = parser.parse(s);
            int res = exp.evaluate(1, 1, 1);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

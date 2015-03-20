package info.kgeorgiy.courses.java_intro.homeworks.hw2;

import java.util.ArrayList;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class BinarySearchMissing {
    public static void main(String[] args) {
        assert args.length > 0;
        int x = Integer.parseInt(args[0]);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 1; i < args.length; i++) {
            a.add(Integer.parseInt(args[i]));
        }
        int l = 0, r = a.size();
        while(l < r) {
            int m = (l + r) / 2;
            if(a.get(m) >  x)
                l = m + 1;
            else
                r = m;
        }
        if(l == a.size() || a.get(l) != x) {
            System.out.println(- l - 1);
        }
        else {
            System.out.println(l);
        }
    }
}

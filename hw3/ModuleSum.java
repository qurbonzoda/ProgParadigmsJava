package info.kgeorgiy.courses.java_intro.homeworks.hw3;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class ModuleSum {
    public static void main(String[] args) {
        Long sum = 0L;
        for (int i = 0; i < args.length; i++) {
            String cur = args[i];
            String curNumb = "";
            for(int j = 0; j < cur.length(); j++) {
                char ch = cur.charAt(j);
                if(Character.isDigit(ch) || ch == '-') {
                    curNumb += ch;
                }
                else {
                    if(!"".equals(curNumb)) {
                        ArrayQueueModule.enqueue(Long.parseLong(curNumb));
                        curNumb = "";
                    }
                }
            }
            if(!"".equals(curNumb)) {
                ArrayQueueModule.enqueue(Long.parseLong(curNumb));
            }
        }
        while(!ArrayQueueModule.isEmpty()) {
            sum += (Long) ArrayQueueModule.dequeue();
        }
        System.out.println(sum);
    }
}

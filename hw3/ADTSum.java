package info.kgeorgiy.courses.java_intro.homeworks.hw3;

/**
 * Created by Abduqodir on 03.03.2015.
 */
public class ADTSum {
    public static void main(String[] args) {
        Long sum = 0L;
        ArrayQueueADT queueADT = new ArrayQueueADT();
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
                        ArrayQueueADT.enqueue(queueADT, Long.parseLong(curNumb));
                        curNumb = "";
                    }
                }
            }
            if(!"".equals(curNumb)) {
                ArrayQueueADT.enqueue(queueADT, Long.parseLong(curNumb));
            }
        }
        while(!ArrayQueueADT.isEmpty(queueADT)) {
            sum += (Long) ArrayQueueADT.dequeue(queueADT);
        }
        System.out.println(sum);
    }
}

import java.util.LinkedList;

/**
 * Created by longtran on 2/21/17.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Add2Numbers {

    public static void main(String[] args){
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        LinkedList<Integer> l3 = new LinkedList<Integer>();

        l1.add(9);
        l1.add(9);
        //l1.add(3);

        l2.add(1);
        //l2.add(6);
        //l2.add(4);
        //l2.add(9);

        int overflow = 0;
        int i = 0;
        boolean isL1Longer = false;

        while (i < l1.size() && i <l2.size()) {
            l3.add((l1.get(i) + l2.get(i) + overflow) %10);
            overflow = (l1.get(i) + l2.get(i) + overflow) /10;

            i++;
        }

        while (i < l1.size()){
            l3.add((l1.get(i) + overflow) %10);
            overflow = (l1.get(i) + overflow) /10;
            i++;
        }

        while (i < l2.size()){
            l3.add((l2.get(i) + overflow) %10);
            overflow = (l2.get(i) + overflow) /10;
            i++;
        }

        if (overflow == 1){
            l3.add(overflow);
        }

        System.out.print("Output is :" + l3.toString() );
    }
}

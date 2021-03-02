package lesson6;

import java.util.Random;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Test6 {
        private static final int AMOUT = 20;
        private static final int MAX_LEVEL = 3;

        private static ArrayList<Tree<Integer>> rows = new ArrayList<>();

        public static void makeRandomTree() {

            for (int i = 0; i < AMOUT; i++) {

                rows.add(new TreeImpl<>());

                for (int j = 0; j < (Math.pow(2, MAX_LEVEL) - 1); j++) {
                    int rand;

                    do {
                        rand = (int) (Math.random() * (50)) - 25;
                    } while (rows.get(i).contains(rand));

                    rows.get(i).add(rand);
                }

            }
        }

    public static void main(String[] args) {

         makeRandomTree();
        double count=0;
        for (int i = 0; i < AMOUT; i++) {
            System.out.print(rows.get(i).isBalanced(rows.get(i).getRoot()));
            System.out.println("  Max Level:  "+ rows.get(i).getCurrentLevel(rows.get(i).getRoot()));
            if(rows.get(i).isBalanced(rows.get(i).getRoot())) count++;
        }
        System.out.println("% of balanced is " + (count/AMOUT)*100);

        //System.out.println("Tree is balansed? : " + tree.isBalanced(tree.getRoot()));
        //System.out.println("Max level is:" + tree.getCurrentLevel(tree.getRoot()));

    }


}

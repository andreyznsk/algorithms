package lesson6;

import java.util.ArrayList;

public class Test6 {
        private static final int MAX_LEVEL = 4;
        private static final int AMOUNT = 20;


        private static ArrayList<Tree<Integer>> rows = new ArrayList<>();

        public static void makeRandomTree() {

            for (int i = 0; i < AMOUNT; i++) {

                rows.add(new TreeImpl<>());

                for (int j = 0; j < (Math.pow(2, MAX_LEVEL) - 1); j++) {
                    int rand;

                    do {
                        rand = (int) (Math.random() * (50)) - 25;
                    } while (rows.get(i).contains(rand));

                    rows.get(i).add(rand);
                    if(rows.get(i).getCurrentLevel()>MAX_LEVEL) rows.get(i).remove(rand);
                }

            }
        }

    public static void main(String[] args) {

         makeRandomTree();
        double count=0;
        for (int i = 0; i < AMOUNT; i++) {
            System.out.print(rows.get(i).isBalanced());
            System.out.println("  Max Level:  "+ rows.get(i).getCurrentLevel());
            if(rows.get(i).isBalanced()) count++;
        }
        System.out.println("% of balanced is " + (count/ AMOUNT)*100);

        //System.out.println("Tree is balansed? : " + tree.isBalanced(tree.getRoot()));
        //System.out.println("Max level is:" + tree.getCurrentLevel(tree.getRoot()));

    }


}

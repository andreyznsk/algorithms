package Lesson2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class TestArr {

private static final int ARRAY_SIZE = 100_000;
private static final Logger logger = Logger.getLogger(TestArr.class.getName());

    public static void main(String[] args) {

        LogManager manager = LogManager.getLogManager();
        try {
            manager.readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

         int[] arrMain = new int[ARRAY_SIZE];

        Array<Integer> arrCopy = new ArrayImpl<>(ARRAY_SIZE);
        Array<Integer> arrCopy1 = new ArrayImpl<>(ARRAY_SIZE);
        Array<Integer> arrCopy2 = new ArrayImpl<>(ARRAY_SIZE);

        Random rnd = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
           arrMain[i] = rnd.nextInt();
           arrCopy.add(arrMain[i]);
           arrCopy1.add(arrMain[i]);
           arrCopy2.add(arrMain[i]);

        }

        long a = System.currentTimeMillis();
        arrCopy.sortBubble();
        //System.out.println("Сортировка пузыьком" + arrCopy);
        logger.log(Level.SEVERE,"Время работы пузырьковой сортировки = " + (System.currentTimeMillis() - a) + " ms");
        //System.out.println("Время работы пузырьковой сортировки = " + (System.currentTimeMillis() - a) + " ms");

        a = System.currentTimeMillis();
        arrCopy1.sortSelect();
      // System.out.println("Сортировка выбором" + arrCopy1);
        logger.log(Level.SEVERE,"Время работы методом выбора = " + (System.currentTimeMillis() - a) + " ms");
       // System.out.println("Время работы методом выбора = " + (System.currentTimeMillis() - a) + " ms");


        a = System.currentTimeMillis();
        arrCopy2.sortSelect();
        //System.out.println("Сортировка вставкой" + arrCopy2);
        logger.log(Level.SEVERE,"Время работы мтод вставки = " + (System.currentTimeMillis() - a) + " ms");
       // System.out.println("Время работы мтод вставки = " + (System.currentTimeMillis() - a) + " ms");


    }
}

package lesson3;

import Lesson2.TestArr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class StringInverter {

    private static final Logger logger = Logger.getLogger(StringInverter.class.getName());

    public static String inverter(String str){

        IStack<Character> tmpStack = new StackImpl<>(str.length());
        StringBuilder tmpstr = new StringBuilder();


        for (int i = 0; i < str.length(); i++) {
            tmpStack.push(str.charAt(i));
        }

        while (!tmpStack.isEmpty()) {
              tmpstr.append(tmpStack.pop());
        }

        return tmpstr.toString();

    }

    public static void main(String[] args) {

        LogManager manager = LogManager.getLogManager();
        try {
            manager.readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "Hello World!!!";
        logger.log(Level.FINE, str);
        logger.log(Level.FINE, inverter(str));



    }




}

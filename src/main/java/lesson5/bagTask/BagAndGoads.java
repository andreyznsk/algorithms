package lesson5.bagTask;

import java.util.*;

public class BagAndGoads {
    private static final int MAX_CAPACITY = 11;
    private static Map<String,int[]> goads = new LinkedHashMap<>();//Мап: Название вещи -> {вес, стоимость}
    private static String[] strKeys;//Последовательность возможных вещей
    private static List<String> anagrams = new LinkedList<>();//Итоговая последовательность
    private static int curCoast = 0;//Текущий максимальная стоимость
    private static int curWeight = 0;//Текущий максимальны вес

    static void initialise(){
        goads.put("TV-set",new int[]{1,10});
        goads.put("NoteBook",new int[]{1,100});
        goads.put("Stone",new int[]{10,1});
        goads.put("SmartPhone",new int[]{1,50});
        goads.put("Jewel",new int[]{1,1000});
        goads.put("Wheel",new int[]{10,5});
        strKeys = new String[goads.size()];// создаем массив под все ключи
    }

    static void displayMap(){ //вывести весю карту вещей
        System.out.println(goads.size());
        for (String key : goads.keySet()) {
            System.out.printf("Item:%10s - weight:%3d, cost:%3d\n",key, goads.get(key)[0],goads.get(key)[1]);
        }
    }

    public static void setStrArrByKeys(){//Стартуем с начальной последовательности
        int i =0;
        for (String s : goads.keySet()) {
            strKeys[i++] = s;
        }
    }

    /**
    В этой функции после каждой ротации происходит проверка
     последовательно достаются все элементы суммируется вес и если он не больше максимальной вместительности
     то достается следующий.
     Далее если получившийся вес максимальный, запоминаем вес, последовательность и стоимость

     */
    public static void rotate(int length){
        int pos = strKeys.length - length;
        String temp = strKeys[pos];
        List<String> stringtempArr = new LinkedList<>();

        for (int i = pos + 1; i < strKeys.length; i++) {
            strKeys[i - 1] = strKeys[i];
        }
        strKeys[strKeys.length - 1] = temp;

        int maxCurWeight = 0;
        int maxCurCoast = 0;
        for (String s : strKeys) {
            if(maxCurWeight + goads.get(s)[0]<=MAX_CAPACITY) {
                maxCurWeight += goads.get(s)[0];
                maxCurCoast += goads.get(s)[1];
                stringtempArr.add(s);
            }}
        if(maxCurCoast>curCoast) {
            curCoast = maxCurCoast;
            curWeight = maxCurWeight;
            anagrams = stringtempArr;
            }
        }
    //Рекурсивный вызов ротации ключей
    private static void processAnagramStr(int length) {
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            processAnagramStr(length - 1);
            rotate(length);
        }
    }



    public static void main(String[] args) {
        initialise();
        displayMap();
        setStrArrByKeys();
        //System.out.println(Arrays.toString(strKeys));
        processAnagramStr(strKeys.length);
        System.out.println("Max capacity of bag: " + MAX_CAPACITY);
        System.out.println("Items with MAX coast:" + anagrams);
        System.out.println("Max coast: " + curCoast);
        System.out.println("Max weight: " + curWeight);
    }
}
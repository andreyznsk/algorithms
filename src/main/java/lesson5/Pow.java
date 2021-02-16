package lesson5;

public class Pow {
    public static long powCalc(int x, int y){
        if (y < 0) throw new ArithmeticException("Ошибка: возведение в отрицательную стпепнь");
        if (y==0) return 1;
        return x*powCalc(x,--y);
    }

    public static void powTest(int x,int y){
        System.out.printf("Example: %d ^ %d = %d\n", x, y, powCalc(x,y));
        System.out.println("Test: " + ((Math.pow(x,y)-powCalc(x,y) <= 0.004)));
        System.out.println("----------");

    }

    public static void main(String[] args) {
       powTest(1,1);
        powTest(2,0);
        powTest(2,1);
        powTest(2,2);
        powTest(-2,2);
        powTest(-2,3);
        try {
            powTest(2,-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Math.pow(0.5,-1));
    }
}

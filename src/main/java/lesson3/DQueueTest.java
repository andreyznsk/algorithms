package lesson3;

public class DQueueTest {
    private static final int MAX_SIZE = 10;
    private static DQueue<Integer> dQueue = new DQueueImpl<>(MAX_SIZE);

    public static void main(String[] args) {


        System.out.println("Вставляем в пусой список слева: " + dQueue.insertLeft(-1));
        System.out.println(" "+dQueue.peekHead());

        for (int i = 0; i < MAX_SIZE-5; i++) {
            System.out.println("Вставляем элемент: " + i + " Результат: " + dQueue.insertRight(i));
        }

        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));


        dQueue.display();

        System.out.println("Извлекаем элемент слева: " + dQueue.removeLeft());
        dQueue.display();

        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));
        dQueue.display();
        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));
        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));
        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));
        System.out.println("Вставляем в дек слева: " + dQueue.insertLeft(-2));
        dQueue.display();

        System.out.println("Удалем элмент справа: " + dQueue.removeRight());
        dQueue.display();

        System.out.println("Удалем элмент справа: " + dQueue.removeRight());
        dQueue.display();

        System.out.println("Удалем элмент справа: " + dQueue.removeRight());
        dQueue.display();


        System.out.print("Вывод вссего ДЕК справа налево: ");
        while (!dQueue.isEmpty())
        System.out.print(dQueue.removeRight() + " ");

      /*
        while (!dQueue.isEmpty())
            System.out.print(dQueue.removeLeft() + " ");*/
    }

}

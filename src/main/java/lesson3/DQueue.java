package lesson3;

public interface DQueue<E> extends IQueue<E>{

    boolean insertLeft(E value);

    boolean insertRight(E value);

    E removeRight();

    E removeLeft();


    void display();
}

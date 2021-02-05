package Lesson2;

public interface Array<E> {

    void add(E value);

    E get(int index);

    E remove(int index);

    boolean remove(E value);

    int indexOf(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();

    void sortBubble();
    void sortSelect();
    void sortInsert();

}

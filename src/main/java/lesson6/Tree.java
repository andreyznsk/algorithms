package lesson6;

public interface Tree<E extends Comparable<? super E>> {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    void add(E value);

    boolean contains(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraverseMode mode);

    boolean isBalanced(Node<E> node);

    boolean isBalanced();

    Node<E> getRoot();

    int getCurrentLevel(Node<E> current);

    int getCurrentLevel();

}

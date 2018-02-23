public interface DequeAPI<Item> extends Iterable<Item> {
    Deque Deque();
    boolean isEmpty();
    int size();
    void pushLeft(Item item);
    void pushRight(Item item);
    Item popLeft();
    Item popRight();
}
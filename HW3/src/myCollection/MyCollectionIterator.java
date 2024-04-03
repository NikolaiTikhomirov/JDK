package myCollection;

import java.util.NoSuchElementException;

public class MyCollectionIterator<T> {
    private T[] array;
    private int currentIndex = 0;

    public MyCollectionIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        if (currentIndex < array.length && array[currentIndex] != null) {
            return true;
        }
        return false;
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        return array[currentIndex++];
    }
}

package org.example;

import java.util.Comparator;
import java.util.List;

/**
 * InsertionSort should be able to sort any type
 * so it should be defined as a generic class:
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">doc</a>
 */
public class InsertionSort<T> {
    public void sorting(List<T> data, Comparator<T> comparator) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i; j > 0; j--) {
                T item = data.get(j);
                T prev = data.get(j-1);
                if (comparator.compare(item, prev) > 0) {
                    // item is bigger, so not switching
                } else {
                    // switching
                    data.set(j, prev);
                    data.set(j-1, item);
                }
            }
        }
    }
}
